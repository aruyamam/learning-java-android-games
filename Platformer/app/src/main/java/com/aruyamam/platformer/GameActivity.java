package com.aruyamam.platformer;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

public class GameActivity extends Activity {

    GameEngine mGameEngngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);
        mGameEngngine = new GameEngine(this, size);
        setContentView(mGameEngngine);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGameEngngine.startThread();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGameEngngine.stopThread();
    }
}
