package de.awenger.krispa.controller.impl;

import de.awenger.krispa.controller.IKriSpaController;
import de.awenger.krispa.controller.ILearningSessionState;


/**
 *
 * @author Adrian Wenger
 */
    public final class StateLearningInProgress_1 implements ILearningSessionState {

    /**
     * KriSpa Controller.
     */
    private final IKriSpaController controller;

    /**
     * Public Constructor.
     *
     * @param cont KriSpaController
     */
    public StateLearningInProgress_1(final IKriSpaController cont) {
        this.controller = cont;
    }

    /**
     * now other State available.
     */
    @Override
    public void change() {
		
        // change state to StateLearningInProgress_2
        this.controller.setCurrentState(new StateLearningInProgress_2(controller));
		
		// passes map to allocateVoc
		this.controller.allocateVoc(this.controller.divideDic(1));
        //this.controller.getCurrentState().change();
    }

}
