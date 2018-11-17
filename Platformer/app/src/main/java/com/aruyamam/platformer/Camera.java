package com.aruyamam.platformer;

import android.graphics.PointF;
import android.graphics.Rect;

class Camera {

    private PointF mCurrentCameraWorldCenter;
    private Rect mConvertRect;
    private int mPixelsPerMter;
    private int mScreenCenterX;
    private int mScreenCenterY;

    Camera(int screenXResolution, int screenYResolutioon) {
        // Locate the center of the screen
        mScreenCenterX = screenXResolution / 2;
        mScreenCenterY = screenYResolutioon / 2;

        // How many meters of world space does
        // the screen width show
        final int pixelsPerMeterToResolutionRatio = 48;
        mPixelsPerMter = screenXResolution / pixelsPerMeterToResolutionRatio;

        mConvertRect = new Rect();
        mCurrentCameraWorldCenter = new PointF();
    }

    int getPixelsPerMterY() {
        return mPixelsPerMter;
    }

    int getyCenter() {
        return mScreenCenterY;
    }

    float getCameraWorldCenterY() {
        return mCurrentCameraWorldCenter.y;
    }

    // Set the camera to the player. Called each frame
    void setWorldCenter(PointF worldCenter) {
        mCurrentCameraWorldCenter.x = worldCenter.x;
        mCurrentCameraWorldCenter.y = worldCenter.y;
    }

    int getPixelsPerMter() {
        return mPixelsPerMter;
    }

    // Return a Rect of the screen coordinates
    // relative to a world location
    Rect worldToScreen(float objetX,
                       float objetY,
                       float objectWidth,
                       float objectHeight) {

        int left = (int) (mScreenCenterX - ((mCurrentCameraWorldCenter.x - objetX) * mPixelsPerMter));
        int top = (int) (mScreenCenterY - ((mCurrentCameraWorldCenter.y - objetY) * mPixelsPerMter));
        int right = (int) (left + (objectWidth * mPixelsPerMter));
        int bottom = (int) (top + (objectHeight * mPixelsPerMter));

        mConvertRect.set(left, top, right, bottom);

        return mConvertRect;
    }
}
