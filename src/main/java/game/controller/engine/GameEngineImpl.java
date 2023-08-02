package game.controller.engine;

import java.util.Optional;

import game.shared.ProgressiveTime;

public class GameEngineImpl implements GameEngine {
    private static final int DEFAULT_FPS = 60;
    private final int frameDuration;
    private Optional<Thread> engineThread = Optional.empty();
    private boolean isPaused;
    private boolean killThread;

    public GameEngineImpl(final int fps) {
        if (fps > 0) {
            this.frameDuration = 1000 / fps;
        } else {
            this.frameDuration = 1000 / DEFAULT_FPS;
        }
    }

    public GameEngineImpl() {
        this(DEFAULT_FPS);
    }

    @Override
    public void startThread(final GameLoop gameLoop) {
        if (this.engineThread.isEmpty()) {
            this.engineThread = Optional.ofNullable(getGameEngineThread(gameLoop));
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
                    Thread.sleep(Long.max(0, startTime + frameDuration - System.currentTimeMillis()));
                } catch (final InterruptedException e) {
                    throw new IllegalStateException("engine sleep failed!", e);
                }
            }
        });
    }
}
