package com.aruyamam.platformer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import com.aruyamam.platformer.GOSpec.GameObjectSpec;

interface GraphicsComponent {

    // Added int mPixelsPerMeter to scale the bitmap to the camera
    void initialize(Context c, GameObjectSpec spec, PointF objectSize, int pixelsPerMeter);

    // Update to take a reference to a Camera
    void draw(Canvas canvas, Paint paint, Transform t, Camera cam);
}
