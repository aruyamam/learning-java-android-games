package com.aruyamam.scrollingshooter;

interface MovementComponent {

    boolean move(long fps, Transform t, Transform playerTransform);
}
