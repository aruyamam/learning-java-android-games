package com.aruyamam.scrollingshooter;

import android.graphics.Rect;
import android.view.MotionEvent;

import java.util.ArrayList;

class PlayerInputComponent implements InputComponent, InputObserver {

    private Transform mTransform;
    private PlayerLaserSpawner mPLS;

    PlayerInputComponent(GameEngine ger) {

    }

    @Override
    public void setTransform(Transform transform) {

    }

    // Required method of InputObserver
    // interface called from the onTouchEvent method
    @Override
    public void handleInput(MotionEvent event, GameState gameState, ArrayList<Rect> buttons) {

    }
}
