package com.aruyamam.scrollingshooter;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

class GameEngine extends SurfaceView implements Runnable {

    private Thread mThread = null;
    private long mFPS;

    public GameEngine(Context context, Point size) {
        super(context);

    }

    @Override
    public void run() {
        long frameStartTime = System.currentTimeMillis();
        // Update all the game objects here
        // Draw all the game objects here

        // Measure the  frames per second in the usual way
        long timeThisFrame = System.currentTimeMillis() - frameStartTime;
        if (timeThisFrame >= 1) {
            final int MILLIS_IN_SECOND = 1000;
            mFPS = MILLIS_IN_SECOND / timeThisFrame;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        // Handle the player's input

        return true;
    }

    public void stopThread() {

        try {
            mThread.join();
        }
        catch (InterruptedException e) {
            Log.e("Exception", "stopThread()" + e.getMessage());
        }
    }

    public void startThread() {

        mThread = new Thread(this);
        mThread.start();
    }
}
