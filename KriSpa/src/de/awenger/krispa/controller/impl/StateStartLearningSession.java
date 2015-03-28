package de.awenger.krispa.controller.impl;

import de.awenger.krispa.controller.IKriSpaController;
import de.awenger.krispa.controller.ILearningSessionState;


/**
 *
 * @author Adrian Wenger
 */
    public final class StateStartLearningSession implements ILearningSessionState {

    /**
     * BlackJack Controller.
     */
    private final IKriSpaController controller;

    /**
     * Public Constructor.
     *
     * @param cont KriSpaController
     */
    public StateStartLearningSession(final IKriSpaController cont) {
        this.controller = cont;
    }

    /**
     * now other State available.
     */
    @Override
    public void change() {
        // change state to StateEndGame
        //this.controller.setCurrentState(new StateEndRound(calcController));
        //this.controller.getCurrentState().change();
    }

}
