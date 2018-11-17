package com.aruyamam.platformer;

import android.content.Context;
import android.graphics.PointF;

import com.aruyamam.platformer.GOSpec.GameObjectSpec;

class GameObjectFactory {

    private Context mContext;
    private GameEngine mGameEngineReference;
    private int mPixelsPerMeter;

    GameObjectFactory(Context context, GameEngine gameEngine, int pixelsPerMeter) {
        mContext = context;
        mGameEngineReference = gameEngine;
        mPixelsPerMeter = pixelsPerMeter;
    }

    GameObject create(GameObjectSpec spec, PointF location) {
        GameObject object = new GameObject();

        int mNumComponents = spec.getComponents().length;
        object.setTag(spec.getTag());

        // First give the game object the right kind of transform
        switch (object.getTag()) {
            case "Background":

                break;

            case "Player":

                break;

            default:
                object.setTransform(new Transform(
                        spec.getSpeed(),
                        spec.getSize().x,
                        spec.getSize().y,
                        location
                ));
                break;
        }

        // Loop through and add/initialize all the components
        for (int i = 0; i < mNumComponents; i++) {
            switch (spec.getComponents()[i]) {
                case "PlayerInputComponent":

                    break;

                case "AnimateGraphicsComponent":

                    break;

                case "PlayerUpdateComponent":

                    break;

                case "InanimateBlockGraphicsComponent":
                    object.setGraphics(
                            new InanimateBlockGraphicsComponent(),
                            mContext,
                            spec,
                            spec.getSize(),
                            mPixelsPerMeter
                            );
                    break;

                case "InanimateBlockUpdateComponent":
                    object.setMovement(new InanimateBlockUpdateComponent());
                    break;

                case "MovableBlockUpdateComponent":

                    break;

                case "DecorativeBlockUpdateComponent":
                    object.setMovement(new DecorativeBlockUpdateComponent());
                    break;

                case "BackgroundGraphicsComponent":

                    break;

                case "BackgroundUpdateComponent":

                    break;

                default:
                    // Error unidentified component
                    break;
            }
        }

        // Return the completed GameObject
        // to the LevelManager class
        return object;
    }
}