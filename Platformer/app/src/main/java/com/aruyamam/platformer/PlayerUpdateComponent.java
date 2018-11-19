package com.aruyamam.platformer;

import android.graphics.PointF;

class PlayerUpdateComponent implements UpdateComponent {

    private boolean mIsJumping = false;
    private long mJumpStartTime;

    // How long a jump lasts
    // Further subdivided into up time
    // and down time, later
    private final long MAX_JUMP_TIME = 400;
    private final float GRAVITY = 6;

    public void update(long fps, Transform t, Transform playerTransform) {
        // cast to player transform
        PlayerTransform pt = (PlayerTransform) t;

        // Where is the player?
        PointF location = t.getLocation();
        // How fast is it going
        float speed = t.getSpeed();

        if (t.headingLeft()) {
            location.x -= speed / fps;
        }
        else if (t.headingLeft()) {
            location.x += speed / fps;
        }

        // Has the player bumped their head
        if (pt.bumpedHead()) {
            mIsJumping = false;
            pt.handlingBumpedHead();
        }

        // Check if jump was triggered by the player
        // and if player is NOT ALREADY jumping or falling
        if (pt.jumpTriggered() && !mIsJumping && pt.isGrounded()) {
            SoundEngine.playJump();
            mIsJumping = true;
            pt.handlingJump();
            //
            mJumpStartTime = System.currentTimeMillis();
        }

        // Gravity
        if (!mIsJumping) {
            // Player is not jumping apply GRAVITY
            location.y += GRAVITY / fps;
        }
        else if (mIsJumping) {
            // Player is jumping
            pt.setNotGrounded();

            // Still in upward (first part) phase of the jump
            if (System.currentTimeMillis() < mJumpStartTime + (MAX_JUMP_TIME / 1.5)) {
                // keep going up
                location.y -= (GRAVITY * 1.8) /fps;
            }
            // In second (downward) phase of jump
            else if (System.currentTimeMillis() < mJumpStartTime + MAX_JUMP_TIME) {
                // Come back down
                location.y += GRAVITY / fps;
            }
            // Has the jump ended
            else if (System.currentTimeMillis() > mJumpStartTime + MAX_JUMP_TIME) {
                mIsJumping = false;
            }
        }

        // Let the coliders know the new position
        t.updateCollider();
    }
}