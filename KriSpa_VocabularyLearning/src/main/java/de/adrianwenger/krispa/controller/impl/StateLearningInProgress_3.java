package de.adrianwenger.krispa.controller.impl;

import de.adrianwenger.krispa.controller.IKriSpaController;
import de.adrianwenger.krispa.controller.ILearningSessionState;
import java.util.Map;


/**
 *
 * @author Adrian Wenger
 */
public final class StateLearningInProgress_3 implements ILearningSessionState {


    /**
     * KriSpa Controller.
     */
    private final IKriSpaController controller;

    /**
     * Public Constructor.
     *
     * @param cont KriSpaController
     */
    public StateLearningInProgress_3(final IKriSpaController cont) {
        this.controller = cont;
        checkIfMapEntrys();
    }

    @Override
    public void divideDic() {
        this.controller.allocateVoc(this.controller.divideDic(3));
    }

    /**
     * now other State available.
     */
    @Override
    public void change() {

        // change state to StateLearningInProgress_4
        this.controller.setCurrentState(new StateLearningInProgress_4(controller));
    }

    @Override
    public void checkIfMapEntrys() {
        try {
            divideDic();
        } catch (Exception ex) {
           change();
        }
    }
}
