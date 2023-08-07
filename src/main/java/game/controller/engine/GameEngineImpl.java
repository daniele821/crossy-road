package game.controller.engine;

import java.util.Optional;

import game.model.entity.GameWorld;
import game.utility.ProgressiveTime;
import game.view.window.Window;

public class GameEngineImpl implements GameEngine {
    private static final int DEFAULT_FPS = 60;
    private final GameLoop gameLoop;
    private final int frameDuration;
    private Optional<Thread> engineThread = Optional.empty();
    private boolean isPaused;
    private boolean killThread;

    public GameEngineImpl(final int fps, final GameLoop gameLoop) {
        this.frameDuration = fps > 0 ? 1000 / fps : 1000 / DEFAULT_FPS;
        this.gameLoop = gameLoop;
    }

    public GameEngineImpl(final int fps) {
        this(fps, new GameLoopImpl());
    }

    public GameEngineImpl() {
        this(DEFAULT_FPS);
    }

    @Override
    public void startThread(final Window window, final GameWorld gameWorld) {
        if (this.engineThread.isEmpty()) {
            this.engineThread = Optional.ofNullable(getGameEngineThread(window, gameWorld));
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

    private Thread getGameEngineThread(final Window window, final GameWorld gameWorld) {
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
                    final var time = new ProgressiveTime(totalTime, elapsedTime);
                    gameLoop.processInput(time, window, gameWorld);
                    gameLoop.update(time, gameWorld);
                    gameLoop.render(time, window);
                }

                try {
                    Thread.sleep(Long.max(0, startTime + frameDuration - System.currentTimeMillis()));
                } catch (final InterruptedException e) {
                    throw new IllegalStateException("engine sleep failed!", e);
                }
            }
        });
    }

    @Override
    public String toString() {
        return "GameEngineImpl [gameLoop=" + gameLoop
                + ", frameDuration=" + frameDuration
                + ", engineThread=" + engineThread
                + ", isPaused=" + isPaused()
                + ", killThread=" + isThreadKilled() + "]";
    }

}
