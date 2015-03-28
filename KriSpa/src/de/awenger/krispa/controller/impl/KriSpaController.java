package de.awenger.krispa.controller.impl;

import de.awenger.krispa.controller.IKriSpaController;
import de.awenger.krispa.controller.ILearningSessionState;
import de.awenger.krispa.util.observer.Observable;


/**
 *
 * @author Adrian Wenger
 */
/**
 * Der Controller muss beide die View und das Model kennen. da dieser für die
 * Kommunikation zwischen den Beiden sorgt
 */
public final class KriSpaController extends Observable
        implements IKriSpaController {


    /**
     * saves current Game state of BlackJack.
     */
    private ILearningSessionState currentState;

    /**
     * change game state.
     *
     * @param state GameState
     */
    @Override
    public void setCurrentState(final ILearningSessionState state) {
        this.currentState = state;
        notifyObservers();
    }

    /**
     *
     * @return current GameState
     */
    @Override
    public ILearningSessionState getCurrentState() {
        return currentState;
    }

    /**
     * Changes the IGameState Object.
     */
    @Override
    public void checkLearningSessionState() {
        // new Game. Initialize with StateInGame
        if (this.currentState == null) {
            //this.setCurrentState(new StateInGame(this, calcController));
            this.currentState.change();
        } else {
            // check if GameState will change
            this.currentState.change();
        }
    }

    /**
     * creates a new round.
     */
    @Override
    public void createNewLearningSession() {
        this.currentState = null;
        notifyObservers();
    }

    
    /**
     * End Game.
     */
    @Override
    public void endLearningSession() {
//        if (this.currentState instanceof StateInGame) {
//            this.currentState.change();
//        }
    }

}
