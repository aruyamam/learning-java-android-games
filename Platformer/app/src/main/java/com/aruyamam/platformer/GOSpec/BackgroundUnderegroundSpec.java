package com.aruyamam.platformer.GOSpec;

import android.graphics.PointF;

public class BackgroundUnderegroundSpec extends GameObjectSpec {

    // This is all the specification for the underground
    private static final String tag = "Background";
    private static final String bitmapName = "underground";
    private static final int framesOfAnimation = 1;
    private static final float speed = 3f;
    private static final PointF size = new PointF(100, 70);
    private static final String[] components = new String[] { "BackgroundGraphicsComponent", "BackgroundUpdateComponent" };

    public BackgroundUnderegroundSpec() {
        super(tag, bitmapName, speed, size, components, framesOfAnimation);
    }
}
