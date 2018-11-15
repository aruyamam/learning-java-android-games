package com.aruyamam.platformer.GOSpec;

import android.graphics.PointF;

public class MovablePlatformSpec extends GameObjectSpec {

    private static final String tag = "Movable Platform";
    private static final String bitmapName = "platform";
    private static final int framesOfAnimation = 1;
    private static final float speed = 3f;
    private static final PointF size = new PointF(2f, 1f);
    private static final String[] components = new String[] { "InanimateBlockGraphicsComponent", "MovableBlockUpdateComponent" };

    public MovablePlatformSpec() {
        super(tag, bitmapName, speed, size, components, framesOfAnimation);
    }
}
