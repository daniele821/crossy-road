package game.controller.engine.impl;

import java.util.Optional;

import game.controller.engine.api.GameEngine;
import game.controller.engine.api.GameLoop;

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
                long nextFrameTime = System.currentTimeMillis() + FRAME_DURATION;
                long timeLeft;

                while (!isThreadKilled()) {
                    if (!isPaused()) {
                        gameLoop.processInput();
                        gameLoop.update(null);
                        gameLoop.render();

                        timeLeft = Long.max(0, nextFrameTime - System.currentTimeMillis());
                        nextFrameTime += FRAME_DURATION;
                        sleepSafe(timeLeft);
                    } else {
                        sleepSafe(FRAME_DURATION);
                    }
                }
            });
        }

        private static void sleepSafe(final long duration) {
            try {
                sleep(duration);
            } catch (final InterruptedException e) {
                throw new IllegalStateException("engine sleep failed!", e);
            }
        }

    }
}
