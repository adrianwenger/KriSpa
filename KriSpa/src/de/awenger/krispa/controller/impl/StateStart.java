package de.awenger.krispa.controller.impl;

import de.awenger.krispa.controller.IKriSpaController;
import de.awenger.krispa.controller.ILearningSessionState;
import java.util.Map;


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
    public StateStart(final IKriSpaController cont) {
        this.controller = cont;
    }

    @Override
    public void divideDic() {
        Map<String, String> vocMapCount0;
        vocMapCount0 = this.controller.divideDic(0);
        this.controller.allocateVoc(vocMapCount0);
    }

    /**
     * now other State available.
     */
    @Override
    public void change() {
        // change state to StateLearningInProgress_1
        this.controller.setCurrentState(new StateLearningInProgress_1(controller));
        // passes map to allocateVoc
        //this.controller.allocateVoc(this.controller.divideDic(0));
    }

    @Override
    public void checkIfMapEntrys() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
