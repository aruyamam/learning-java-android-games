package com.aruyamam.pong;

import android.graphics.RectF;

class Ball {

    private RectF mRect;
    private float mXVelocity;
    private float mYVelocity;
    private float mBallWidth;
    private float mBallHeight;

    // mBall = new Ball(mScreenX);
    Ball(int screenX) {
        // Make the ball square and 1% of screen width
        // of the screen width
        mBallWidth = screenX / 100;
        mBallHeight = screenX / 100;

        // Initialize the RectF with 0, 0, 0, 0
        mRect = new RectF();
    }

    RectF getRect() {
        return mRect;
    }

    // Update the ball position
    // Called each frame/loop
    void update(long fps) {
        // Move the ball based upon the
        // horizontal (mVelocity) and
        // vertical(mYVelocity) speed
        // and the current frame rate(fps)

        // Move the top left corner
        mRect.left = mRect.left + (mXVelocity / fps);
        mRect.top = mRect.top + (mYVelocity / fps);

        // Match up the bottom right corner
        // based on the size of the ball
        mRect.right = mRect.left + mBallWidth;
        mRect.bottom = mRect.top + mBallHeight;
    }

    // Reverse the vertical direction of travel
    void reverseYVelocity() {
        mYVelocity = -mYVelocity;
    }

    // Reverse the horizontal direction of travel
    void reverseXVelocity() {
        mXVelocity = -mXVelocity;
    }

    void reset(int x, int y) {
        // Initialise the four points of
        // the rectangle which defines the ball
        mRect.left = x / 2;
        mRect.top = 0;
        mRect.right = x / 2 + mBallWidth;
        mRect.bottom = mBallHeight;

        // How fast wil the ball travel
        mYVelocity = -(y / 3);
        mXVelocity = (y / 3);
    }

    void increaseVelocity() {
        // increase the speed by 10%
        mXVelocity = mXVelocity * 1.1f;
        mYVelocity = mYVelocity + 1.1f;
    }

    // Bounce the ball back based on
    // whether it hits the left or right-hand side
    void batBounce(RectF batPosition) {
        // Detect center of bat
        float batCenter = batPosition.left + (batPosition.width() / 2);
        // Detect the center of the ball
        float ballCenter = mRect.left + (mBallWidth / 2);

        // Where on the bat did thhe ball hit?
        float relativeIntersect = (batCenter - ballCenter);

        // Pick a bounce direction
        if (relativeIntersect < 0) {
            // Go right
            mXVelocity = Math.abs(mXVelocity);
        }
        else {
            // Go left
            mXVelocity = -Math.abs(mXVelocity);
        }

        // Having calculated left or right for
        // horizontal direction
        reverseXVelocity();
    }
}
