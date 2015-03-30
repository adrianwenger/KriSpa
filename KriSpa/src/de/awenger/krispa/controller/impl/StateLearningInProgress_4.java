package de.awenger.krispa.controller.impl;

import de.awenger.krispa.controller.IKriSpaController;
import de.awenger.krispa.controller.ILearningSessionState;


/**
 *
 * @author Adrian Wenger
 */
    public final class StateLearningInProgress_4 implements ILearningSessionState {

    /**
     * KriSpa Controller.
     */
    private final IKriSpaController controller;

    /**
     * Public Constructor.
     *
     * @param cont KriSpaController
     */
    public StateLearningInProgress_4(final IKriSpaController cont) {
        this.controller = cont;
    }

    /**
     * now other State available.
     */
    @Override
    public void change() {
		
        // change state to StateLearningFinished
        this.controller.setCurrentState(new StateFinish(controller));

		// passes map to allocateVoc
		this.controller.allocateVoc(this.controller.divideDic(4));
        //this.controller.getCurrentState().change();
    }

}
