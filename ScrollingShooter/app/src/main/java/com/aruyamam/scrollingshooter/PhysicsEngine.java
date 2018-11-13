package com.aruyamam.scrollingshooter;

import java.util.ArrayList;

class PhysicsEngine {

    boolean update(long fps, ArrayList<GameObject> objects, GameState gs, SoundEngine se, ParticleSystem ps) {
        // Update all the GameObjects
        for (GameObject object : objects) {
            if (object.checkActive()) {
                object.update(fps, objects.get(Level.PLAYER_INDEX).getTransform());
            }
        }

        if (ps.mIsRunning) {
            ps.update(fps);
        }

        return false;
    }
}
