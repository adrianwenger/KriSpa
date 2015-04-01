package de.awenger.krispa.controller.impl;

import de.awenger.krispa.controller.IKriSpaController;
import de.awenger.krispa.controller.ILearningSessionState;
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
        divideDic();
    }

    @Override
    public void divideDic() {
        Map<String, String> vocMapCount3;
        vocMapCount3 = this.controller.divideDic(3);
        this.controller.allocateVoc(vocMapCount3);
    }

    /**
     * now other State available.
     */
    @Override
    public void change() {

        // change state to StateLearningInProgress_4
        this.controller.setCurrentState(new StateLearningInProgress_4(controller));
    }

}
