package com.aruyamam.scrollingshooter;

class PhysicsEngine {

    boolean update(long fps, ParticleSystem ps) {
        if (ps.mIsRunning) {
            ps.update(fps);
        }

        return false;
    }
}
