package game.controller.engine;

import java.util.Optional;

import game.controller.api.GameEngine;
import game.model.api.resources.GameWorldLevel;
import game.view.api.GameDrawer;

@SuppressWarnings("unused")
public class GameEngineImpl implements GameEngine {
    private static final int DEFAULT_FRAME_DURATION = 1000 / 60;
    private final int frameDuration;
    private Optional<Thread> engineThread = Optional.empty();
    private GameEngineStatus status = GameEngineStatus.KILLED;
    private GameWorldLevel level;
    private GameDrawer drawer;

    public GameEngineImpl(final int frameDuration, final GameDrawer drawer, final GameWorldLevel level) {
        this.frameDuration = frameDuration;
        this.drawer = drawer;
        this.level = level;
    }

    public GameEngineImpl(final GameDrawer drawer, final GameWorldLevel level) {
        this(DEFAULT_FRAME_DURATION, drawer, level);
    }

    // private methods

    private synchronized void setStatus(final GameEngineStatus status) {
        this.status = status;
    }

    private synchronized GameEngineStatus getStatus() {
        return this.status;
    }

    private void startThread() {
        if (engineThread.isEmpty()) {
            engineThread = Optional.ofNullable(getGameEngineThread());
            engineThread.orElseThrow().start();
        }

    }

    private void killThread() {
        if (engineThread.isPresent()) {
            try {
                engineThread.orElseThrow().join();
            } catch (final InterruptedException e) {
                throw new IllegalStateException("joining after killing thread failed!", e);
            }
        }
    }

    private Thread getGameEngineThread() {
        return new Thread(() -> {
            long elapsedTime;
            long startTime = System.currentTimeMillis();
            long lastTime;

            while (getStatus() != GameEngineStatus.KILLED) {
                lastTime = startTime;
                startTime = System.currentTimeMillis();
                elapsedTime = startTime - lastTime;

                if (getStatus() != GameEngineStatus.PAUSED) {
                    // TODO game loop
                }

                try {
                    Thread.sleep(Long.max(0, startTime + frameDuration - System.currentTimeMillis()));
                } catch (final InterruptedException e) {
                    throw new IllegalStateException("engine sleep failed!", e);
                }
            }
        });
    }

    // inherithed methods

    @Override
    public void changeStatus(final GameEngineStatus status) {
        setStatus(status);
        if (status == GameEngineStatus.RUNNING) {
            startThread();
        } else if (status == GameEngineStatus.KILLED) {
            killThread();
        }
    }

    @Override
    public void setDrawer(final GameDrawer drawer) {
        this.drawer = drawer;
    }

    @Override
    public void setWorld(final GameWorldLevel level) {
        this.level = level;
    }
}

// TODO to test entire class working!