package com.aruyamam.platformer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;

import com.aruyamam.platformer.GOSpec.GameObjectSpec;

class BackgroundGraphicsComponent implements GraphicsComponent {

    private String mBitmapName;

    @Override
    public void initialize(Context context,
                           GameObjectSpec spec,
                           PointF objectSize,
                           int pixelsPerMeter) {

        mBitmapName = spec.getBitmapName();

        BitmapStore.addBitmap(
                context,
                mBitmapName,
                objectSize,
                pixelsPerMeter,
                true
        );
    }

    @Override
    public void draw(Canvas canvas, Paint paint, Transform t, Camera cam) {
        BackgroundTransform bt = (BackgroundTransform) t;

        Bitmap bitmap = BitmapStore.getBitmap(mBitmapName);
        Bitmap bitmapReversed = BitmapStore.getBitmapReversed(mBitmapName);

        int scaledXClip = (int) (bt.getXClip() * cam.getPixelsPerMeter());
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        PointF position = t.getLocation();

        float floatStartY = (
                (cam.getyCenter() - (
                        cam.getCameraWorldCenterY() - position.y
                    ) * cam.getPixelsPerMeterY()
                )
        );
        int startY = (int) floatStartY;

        float floatEndY = (
                cam.getyCenter() - (
                        (cam.getCameraWorldCenterY() - position.y - t.getSize().y)
                                * cam.getPixelsPerMeterY()
                )

        );
        int endY = (int) floatEndY;

        // Position the regular bitmap
        Rect fromRect1 = new Rect(0, 0, width - scaledXClip, height);
        Rect toRect1 = new Rect(scaledXClip, startY, width, endY);

        // Position the reserved bitmap
        Rect fromRect2 = new Rect(width - scaledXClip, 0, width, height);
        Rect toRect2 = new Rect(0, startY, scaledXClip, endY);

        // Draw the two bitmaps
        if (!bt.getReversedFirst()) {
            canvas.drawBitmap(bitmap, fromRect1, toRect1, paint);
            canvas.drawBitmap(bitmapReversed, fromRect2, toRect2, paint);
        }
        else {
            canvas.drawBitmap(bitmap, fromRect2, toRect2, paint);
            canvas.drawBitmap(bitmapReversed, fromRect1, toRect1, paint);
        }
    }
}
