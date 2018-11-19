package com.aruyamam.platformer;

import android.graphics.Rect;

class Animator {

    private Rect mSourceRect;
    private int mFrameCount;
    private int mCurrentFrame;
    private long mFrameTicker;
    private int mFramePeriod;
    private int mFrameWidth;

    Animator(float frameHeight, float frameWidth,
             int frameCount, int pixelsPerMeter) {

        final int ANIM_FPS = 10;

        this.mCurrentFrame = 0;
        this.mFrameCount = frameCount;
        this.mFrameWidth = (int) frameWidth * pixelsPerMeter;

        frameHeight = frameHeight * pixelsPerMeter;

        mSourceRect = new Rect(
                0, 0,
                this.mFrameWidth,
                (int) frameHeight
        );

        mFramePeriod = 1000 / ANIM_FPS;
        mFrameTicker = 0L;
    }

    Rect getCurrentFrame(long time) {
        if (time > mFrameTicker + mFramePeriod) {
            mFrameTicker = time;
            mCurrentFrame++;
            if (mCurrentFrame >= mFrameCount) {
                mCurrentFrame = 0;
            }
        }

        // Update the left and right values of the source of
        // the next frame on the sprite sheet
        this.mSourceRect.left = mCurrentFrame * mFrameWidth;
        this.mSourceRect.right = this.mSourceRect.left + mFrameWidth;

        return mSourceRect;
    }
}
