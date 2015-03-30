package de.awenger.krispa.controller.impl;

import de.awenger.krispa.controller.IKriSpaController;
import de.awenger.krispa.controller.ILearningSessionState;


/**
 *
 * @author Adrian Wenger
 */
    public final class StateFinish implements ILearningSessionState {

    /**
     * KriSpa Controller.
     */
    private final IKriSpaController controller;

    /**
     * Public Constructor.
     *
     * @param cont KriSpaController
     */
    public StateFinish(final IKriSpaController cont) {
        this.controller = cont;
    }

    /**
     * now other State available.
     */
    @Override
    public void change() {
		
       

    }

}
