package game.controller;

import java.util.Optional;

import game.model.world.GameWorld;
import game.shared.ProgressiveTime;

public class GameEngineImpl implements GameEngine {
    private static final int FPS = 60;
    private static final int FRAME_DURATION = 1000 / FPS;
    private Optional<Thread> engineThread = Optional.empty();
    private boolean isPaused;
    private boolean killThread;

    @Override
    public void startThread(final GameWorld gameWorld) {
        if (this.engineThread.isEmpty()) {
            this.engineThread = Optional.ofNullable(getGameEngineThread(new GameLoopImpl(gameWorld)));
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

    private Thread getGameEngineThread(final GameLoop gameLoop) {
        return new Thread(() -> {
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
                    Thread.sleep(Long.max(0, startTime + FRAME_DURATION - System.currentTimeMillis()));
                } catch (final InterruptedException e) {
                    throw new IllegalStateException("engine sleep failed!", e);
                }
            }
        });
    }
}
