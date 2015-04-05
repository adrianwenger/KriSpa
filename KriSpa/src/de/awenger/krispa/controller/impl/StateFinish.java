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
        change();
    }

    /**
     * now other State available.
     */
    @Override
    public void change() {
        this.controller.reallocateVoc();
        this.controller.saveData("/KriSpaData.txt");
        System.exit(0);

    }

    @Override
    public void divideDic() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void checkIfMapEntrys() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
