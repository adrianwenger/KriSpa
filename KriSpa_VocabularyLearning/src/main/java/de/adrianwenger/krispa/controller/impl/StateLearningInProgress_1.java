package de.adrianwenger.krispa.controller.impl;

import de.adrianwenger.krispa.controller.IKriSpaController;
import de.adrianwenger.krispa.controller.ILearningSessionState;
import java.util.Map;


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

    @Override
    public void divideDic() {
        this.controller.allocateVoc(this.controller.divideDic(1));
    }

    /**
     * now other State available.
     */
    @Override
    public void change() {
        // change state to StateLearningInProgress_2
        this.controller.setCurrentState(new StateLearningInProgress_2(controller));
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
