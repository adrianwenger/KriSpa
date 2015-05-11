package de.adrianwenger.krispa.controller.impl;

import de.adrianwenger.krispa.controller.IKriSpaController;
import de.adrianwenger.krispa.controller.ILearningSessionState;


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
        this.controller.reallocateVoc();
        this.controller.saveData("/KriSpaData.txt");
    }

    @Override
    public void divideDic() {
        
    }

    @Override
    public void checkIfMapEntrys() {
        
    }

}
