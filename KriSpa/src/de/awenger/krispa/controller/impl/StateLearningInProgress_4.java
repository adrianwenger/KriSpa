package de.awenger.krispa.controller.impl;

import de.awenger.krispa.controller.IKriSpaController;
import de.awenger.krispa.controller.ILearningSessionState;
import java.util.Map;


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
        checkIfMapEntrys();
    }

    @Override
    public void divideDic() {
        Map<String, String> vocMapCount4;
        vocMapCount4 = this.controller.divideDic(4);
        this.controller.allocateVoc(vocMapCount4);
    }

    /**
     * now other State available.
     */
    @Override
    public void change() {
        // change state to StateLearningFinished
        this.controller.setCurrentState(new StateFinish(controller));
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
