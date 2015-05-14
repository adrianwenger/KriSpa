package de.adrianwenger.krispa.gui;

import de.adrianwenger.krispa.controller.IKriSpaController;
import de.adrianwenger.krispa.controller.impl.StateLearningInProgress_1;
import de.adrianwenger.krispa.util.observer.IObserver;
import javax.swing.JFrame;


/**
 *
 * @author philippschultheiss
 */
public final class Gui extends JFrame implements IObserver {


    /**
     * To save the IBlackJackController for all of the several UIs.
     */
    private final IKriSpaController controller;
    

    //private MainFrame mainFrame;
    /**
     * Public Contructor to create a GUI.
     *
     * @param controller
     */
    public Gui(final IKriSpaController controller) {
        this.controller = controller;
        controller.addObserver(this);

        controller.createNewLearningSession();
        
        // Configuration Frame also initializes MainFrame
        new ConfigurationFrame(this.controller);
        
    }


    @Override
    public void update() {
        
    }
}
