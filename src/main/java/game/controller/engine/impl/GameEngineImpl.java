package game.controller.engine.impl;

import java.util.Optional;

import game.controller.engine.api.GameEngine;
import game.controller.engine.api.GameLoop;
import game.utility.ProgressiveTime;

public class GameEngineImpl implements GameEngine {
    private final GameLoop gameLoop;
    private boolean isPaused;
    private boolean killThread;
    private Optional<Thread> engineThread = Optional.empty();

    public GameEngineImpl(final GameLoop gameLoop) {
        this.gameLoop = gameLoop;
    }

    @Override
    public void startThread() {
        if (this.engineThread.isEmpty()) {
            this.engineThread = Optional.ofNullable(new GameEngineThread());
            this.engineThread.get().start();
        }
    }

    @Override
    public void killThread() {
        if (this.engineThread.isPresent()) {
            setKillThread(true);
            try {
                this.engineThread.get().join();
            } catch (InterruptedException e) {
                throw new IllegalStateException("joining after killing thread failed!", e);
            }
            setKillThread(false);
        }
    }

    @Override
    public void pauseThread() {
        setPaused(true);
    }

    @Override
    public void unpauseThread() {
        setPaused(false);
    }

    private synchronized boolean isPaused() {
        return this.isPaused;
    }

    private synchronized void setPaused(final boolean isPaused) {
        this.isPaused = isPaused;
    }

    private synchronized boolean isThreadKilled() {
        return this.killThread;
    }

    private synchronized void setKillThread(final boolean killThread) {
        this.killThread = killThread;
    }

    private class GameEngineThread extends Thread {
        private static final int FPS = 60;
        private static final int FRAME_DURATION = 1000 / FPS;

        private GameEngineThread() {
            super(() -> {
                long totalTime = 0;
                long elapsedTime;
                long startTime = System.currentTimeMillis();
                long lastTime;

                while (!isThreadKilled()) {
                    lastTime = startTime;
                    startTime = System.currentTimeMillis();
                    elapsedTime = startTime - lastTime;

                    if (!isPaused()) {
                        totalTime += elapsedTime;
                        gameLoop.processInput();
                        gameLoop.update(new ProgressiveTime(totalTime, elapsedTime));
                        gameLoop.render();
                    }

                    try {
                        sleep(Long.max(0, startTime + FRAME_DURATION - System.currentTimeMillis()));
                    } catch (final InterruptedException e) {
                        throw new IllegalStateException("engine sleep failed!", e);
                    }
                }
            });
        }
    }
}
