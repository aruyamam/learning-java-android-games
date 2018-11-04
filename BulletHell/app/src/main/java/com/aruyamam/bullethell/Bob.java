package com.aruyamam.bullethell;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;

class Bob {

    RectF mRect;
    float mBogHeight;
    float mBobWidth;
    boolean mTeleportting = false;

    Bitmap mBitmap;

    public Bob(Context context, float screenX, float screenY) {
        mBogHeight = screenY / 10;
        mBobWidth = mBogHeight / 2;

        mRect = new RectF(
            screenX / 2,
            screenY / 2,
            (screenX / 2) + mBobWidth,
            (screenY / 2) + mBogHeight
        );

        // Prepare the bitmap
        // Load Bob fro mhis .png file
        mBitmap = BitmapFactory.decodeResource(
                context.getResources(), R.drawable.bob
        );

    }

    boolean teleport(float newX, float newY) {
        // Did Bob manage to teleport?
        boolean success = false;

        // Move Bob to the neew position
        // If not already teleporting
        if (!mTeleportting) {
            // Make him roughly central to the touch
            mRect.left = newX - mBobWidth / 2;
            mRect.top = newY - mBogHeight / 2;
            mRect.bottom = mRect.top + mBogHeight;
            mRect.right = mRect.left + mBobWidth;

            mTeleportting  = true;

            // Notify BulletHellGame that teleport
            // attempt was successful
            success = true;
        }

        return success;
    }

    void setTeleportAvaiable() {
        mTeleportting = false;
    }

    // Return reference to mRect
    RectF getRect() {
        return mRect;
    }

    // Return a reference to bitmap
    Bitmap getBitmap() {
        return mBitmap;
    }
}
