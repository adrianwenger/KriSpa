package de.awenger.krispa.gui;

import de.awenger.krispa.controller.IKriSpaController;
import de.awenger.krispa.util.observer.IObserver;
import javax.swing.JFrame;
import javax.swing.JProgressBar;


/**
 *
 * @author philippschultheiss
 */
public final class Gui extends JFrame implements IObserver {


    /**
     * To save the IBlackJackController for all of the several UIs.
     */
    private final IKriSpaController controller;
    
    /**
     * progressbar 
     */
    private final ProgressBar pbar;

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
        
        this.pbar = new ProgressBar();
        this.pbar.dispose();
        new ConfigurationFrame();
        // initialize WelcomeFrame
        //activateWelcomeFrame();

    }

    /**
     * Method to activate the MenuFrame/WelcomeFrame.
     *
     * @return WelcomeFrame()
     */
    public WelcomeFrame activateWelcomeFrame() {
        return new WelcomeFrame(controller);
    }

    /**
     * Method to activate the MainFrame/PlayFrame.
     */
    public void activateMainFrame() {
        //mainFrame = new MainFrame(this, controller, calcController);
    }

    @Override
    public void update() {
//        if (controller.getCurrentState() instanceof StateInGame) {
//            mainFrame.changeText(controller.getPlayer().printPlayersHand(),
//                    controller.getDealer().printPlayersHand());
//        } else if (controller.getCurrentState() instanceof StateWon) {
//            mainFrame.changeText(DIVIDINGLINE);
//            mainFrame.changeText("Round WON!!!\n");
//            mainFrame.changeText(controller.getPlayer().printPlayersHand(),
//                    controller.getDealer().printPlayersHand());
//            mainFrame.changeText(calcController.printCurrentCreditState());
//            mainFrame.changeText(DIVIDINGLINE);
//        } else if (controller.getCurrentState() instanceof StateLost) {
//            mainFrame.changeText(DIVIDINGLINE);
//            mainFrame.changeText("Round LOST!!!\n");
//            mainFrame.changeText(controller.getPlayer().printPlayersHand(),
//                    controller.getDealer().printPlayersHand());
//            mainFrame.changeText(calcController.printCurrentCreditState());
//            mainFrame.changeText(DIVIDINGLINE);
//        } else if (controller.getCurrentState() instanceof StateBlackJack) {
//            mainFrame.changeText(DIVIDINGLINE);
//            if (this.controller.hasBlackJack(this.controller.getDealer())) {
//                mainFrame.changeText("Dealer got BlackJack!\n\n");
//            } else {
//                mainFrame.changeText("Congratulations "
//                        + this.controller.getPlayer().getName()
//                        + ", you got BlackJack!\n");
//            }
//            mainFrame.changeText(calcController.printCurrentCreditState());
//            mainFrame.changeText(DIVIDINGLINE);
//        } else if (controller.getCurrentState() instanceof StateEndRound) {
//            mainFrame.changeText("Round ended!");
//            mainFrame.changeText("To start a new round set a new RoundStake please!");
//        } else {
//            mainFrame.changeText("END!");
//        }
    }
}
