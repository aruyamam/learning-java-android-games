package com.aruyamam.platformer;

interface GameEngineBroadcaster {

    // This allows the Player and UI Controller components
    // to add themselves as listener of the GameEngine class
    void addObserver(InputObserver o);
}
