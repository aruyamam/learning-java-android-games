package com.aruyamam.scrollingshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import java.util.Objects;

class StdGraphicsComponent implements GraphicsComponent {

    private Bitmap mBitmap;
    private Bitmap mBitmapReversed;

    @Override
    public void initialize(Context context, ObjectSpec spec, PointF objetSize) {

    }

    @Override
    public void draw(Canvas canvas, Paint paint, Transform t) {

    }
}
