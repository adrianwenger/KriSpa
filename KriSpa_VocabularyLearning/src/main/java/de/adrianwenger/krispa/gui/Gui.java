package de.adrianwenger.krispa.gui;

import de.adrianwenger.krispa.controller.IKriSpaController;
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
        
        //new ProgressBar();
        
        // Configuration Frame also initializes MainFrame
        new ConfigurationFrame(this.controller);
        
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
