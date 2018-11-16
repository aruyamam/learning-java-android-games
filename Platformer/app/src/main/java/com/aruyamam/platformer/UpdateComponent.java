package com.aruyamam.platformer;

interface UpdateComponent {

    void update(long fps, Transform t, Transform playerTransform);
}
