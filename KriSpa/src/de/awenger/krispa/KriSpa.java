package de.awenger.krispa;

import de.awenger.krispa.controller.IKriSpaController;
import de.awenger.krispa.controller.impl.KriSpaController;
import de.awenger.krispa.gui.Gui;



/**
 *
 * @author Adrian Wenger
 */
public final class KriSpa {

    /**
     * static BlackJack instance.
     */
    private static KriSpa instance = null;
    /**
     * BlackJackController.
     */
    private static IKriSpaController controller;

    /**
     * Singleton.
     *
     * @return instance
     */
    public static KriSpa getInstance() {
        if (instance == null) {
            instance = new KriSpa();
        }
        return instance;

    }

    /**
     *
     */
    private KriSpa() {
        // create Controller
        controller = new KriSpaController();
        // create GUI
        new Gui(controller);
        controller.createNewLearningSession();
        controller.endLearningSession();
    }

    /**
     *
     * @param args not used
     */
    public static void main(final String[] args) {
        //Create new KriSpa Object
        KriSpa.getInstance();
    }

}
