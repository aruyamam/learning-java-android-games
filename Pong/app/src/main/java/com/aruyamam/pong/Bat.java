package com.aruyamam.pong;

import android.graphics.RectF;

class Bat {

    // Tese are the member variables (fields)
    // They all have the m prefix
    // They are all private
    // because direct access is not requried
    private RectF mRect;
    private float mLength;
    private float mXCoord;
    private float mBatSpeed;
    private int mScreenX;

    // These variables are public and final
    // They can be directly accessed by
    // the instance (in PongGame)
    // because they are part of the same
    // package but cannot be changed
    final int STOPPED = 0;
    final int LEFT = 1;
    final int RIGHT = 2;

    // Keeps track of if and how the ball is moving
    // Starting with STOPPED
    private int mBatMoving = STOPPED;

    Bat(int sx, int sy) {
        // Bat needs to know the screen
        // horizontal resolution
        // Outside of this method
        mScreenX  = sx;

        // Configure the size of the bat based on
        // the screen resolution
        // One eight the screen width
        mLength = mScreenX / 8;
        // One fortieth the screen height;
        float height = sy / 40;

        // Configure the starting location of the bat
        // Roughly the middle horizontallly
        mXCoord = mScreenX / 2;
        // The height of the bat
        // off the bottom of the screen
        float mYCoord = sy - height;

        // Initialize mRect based on the size and position
        mRect = new RectF(
            mXCoord,
            mYCoord,
        mXCoord + mLength,
        mYCoord + height
        );

        // Configure the speed of te bat
        // This code means the bat can cover the
        // width of the screen in 1 second
        mBatSpeed = mScreenX;
    }

    // Return a reference to the mRect object
    RectF getRect() {
        return mRect;
    }

    // Update the movement state passed
    // in by the onTouchEvent method
    void setMovementState(int state) {
        mBatMoving = state;
    }

    // Update the bat - Called each frame/loop
    void update(long fps) {
        // Move the bat based on the mBatMoving variable
        // and the speed of the previous frame
        if (mBatMoving == LEFT) {
            mXCoord = mXCoord - mBatSpeed / fps;
        }

        if (mBatMoving == RIGHT) {
            mXCoord = mXCoord + mBatSpeed / fps;
        }

        // Stop the bat going off the screen
        if (mXCoord < 0) {
            mXCoord = 0;
        }
        else if (mXCoord + mLength > mScreenX) {
            mXCoord = mScreenX - mLength;
        }

        // Update mRect based on the result from
        // the previous code in update
        mRect.left = mXCoord;
        mRect.right = mXCoord + mLength;
    }
}
