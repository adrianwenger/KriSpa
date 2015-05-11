package de.adrianwenger.krispa;

import de.adrianwenger.krispa.controller.IKriSpaController;
import de.adrianwenger.krispa.controller.impl.KriSpaController;
import de.adrianwenger.krispa.gui.Gui;



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
