package com.aruyamam.scrollingshooter;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

class GameEngine extends SurfaceView implements Runnable, GameStarter {

    private Thread mThread = null;
    private long mFPS;

    private GameState mGameState;
    private SoundEngine mSoundEngine;

    public GameEngine(Context context, Point size) {
        super(context);

        mGameState = new GameState(this, context);
        mSoundEngine = new SoundEngine(context);
    }

    @Override
    public void run() {
        while (mGameState.getThreadRunning()) {
            long frameStartTime = System.currentTimeMillis();

            if (!mGameState.getPaused()) {
                // Update all the game objects here
            }

            // Draw all the game objects here

            // Measure the frames per second
            long timeThisFrame = System.currentTimeMillis() - frameStartTime;
            if (timeThisFrame >= 1) {
                final int MILLIS_IN_SECOND = 1000;
                mFPS = MILLIS_IN_SECOND / timeThisFrame;
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        // Handle the player's input

        // testing
        mSoundEngine.playShoot();

        return true;
    }

    public void stopThread() {

        mGameState.stopEverything();

        try {
            mThread.join();
        }
        catch (InterruptedException e) {
            Log.e("Exception", "stopThread()" + e.getMessage());
        }
    }

    public void startThread() {

        mGameState.startThread();

        mThread = new Thread(this);
        mThread.start();
    }

    public void deSpawnReSpawn() {
        // Eventually this will despawn
        // and then respawn all the game objects

    }
}
