package de.awenger.krispa.controller.impl;

import de.awenger.krispa.controller.IKriSpaController;
import de.awenger.krispa.controller.ILearningSessionState;


/**
 *
 * @author Adrian Wenger
 */
    public final class StateStart implements ILearningSessionState {

    /**
     * KriSpa Controller.
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
        	
        // change state to StateLearningInProgress_1
        this.controller.setCurrentState(new StateLearningInProgress_1(controller));
		
		// passes map to allocateVoc
		this.controller.allocateVoc(this.controller.divideDic(0));
        //this.controller.getCurrentState().change();
    }

}
