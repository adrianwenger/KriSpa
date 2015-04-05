package de.awenger.krispa.controller.impl;

import de.awenger.krispa.controller.IKriSpaController;
import de.awenger.krispa.controller.ILearningSessionState;
import java.util.Map;


/**
 *
 * @author Adrian Wenger
 */
public final class StateLearningInProgress_2 implements ILearningSessionState {


    /**
     * KriSpa Controller.
     */
    private final IKriSpaController controller;

    /**
     * Public Constructor.
     *
     * @param cont KriSpaController
     */
    public StateLearningInProgress_2(final IKriSpaController cont) {
        this.controller = cont;
        checkIfMapEntrys();
    }

    @Override
    public void divideDic() {
        Map<String, String> vocMapCount2;
        vocMapCount2 = this.controller.divideDic(2);
        this.controller.allocateVoc(vocMapCount2);
    }

    /**
     * now other State available.
     */
    @Override
    public void change() {
        // change state to StateLearningInProgress_3
        this.controller.setCurrentState(new StateLearningInProgress_3(controller));
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
