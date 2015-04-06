package de.awenger.krispa.controller.impl;

import de.awenger.krispa.controller.IKriSpaController;
import de.awenger.krispa.controller.ILearningSessionState;
import java.io.IOException;
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
        Map<String, String> vocMapCount1;
        vocMapCount1 = this.controller.divideDic(1);
        this.controller.allocateVoc(vocMapCount1);
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
