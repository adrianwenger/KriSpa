package de.awenger.krispa.controller.impl;

import de.awenger.krispa.controller.IKriSpaController;
import de.awenger.krispa.controller.ILearningSessionState;
import de.awenger.krispa.model.IDataBasis;
import de.awenger.krispa.model.impl.DataBasis;
import de.awenger.krispa.util.observer.Observable;
import java.io.File;
import java.util.Map;
import java.util.Properties;


/**
 *
 * @author Adrian Wenger
 */
/**
 * Der Controller muss beide die View und das Model kennen. da dieser für die
 * Kommunikation zwischen den Beiden sorgt
 */
public final class KriSpaController extends Observable
        implements IKriSpaController {


    /**
     * saves current Game state of BlackJack.
     */
    private ILearningSessionState currentState;

    /**
     *
     */
    private IDataBasis dataBasis = new DataBasis();

    /**
     *
     */
    private Map<String, String> vocabularyMap;

    @Override
    public void setCurrentState(final ILearningSessionState state) {
        this.currentState = state;
        notifyObservers();
    }

    @Override
    public ILearningSessionState getCurrentState() {
        return currentState;
    }

    @Override
    public void createNewLearningSession() {
        Properties prop = new Properties();
        String dir = System.getProperty("user.dir");
        dataBasis.read(new File(dir + "/KriSpaData.txt"));
    }

    @Override
    public void checkLearningSessionState() {
        // new Game. Initialize with StateInGame
        if (this.currentState == null) {
            //this.setCurrentState(new StateInGame(this, calcController));
            this.currentState.change();
        } else {
            // check if GameState will change
            this.currentState.change();
        }
    }

    @Override
    public void endLearningSession() {
//        if (this.currentState instanceof StateInGame) {
//            this.currentState.change();
//        }
        saveData("/KriSpaData.txt");
    }
    
    /**
     * saves data to File.
     * @param fileName FileName in Directory
     */
    private void saveData(String fileName) {
        Properties prop = new Properties();
        String dir = System.getProperty("user.dir");
        dataBasis.save(new File(dir + fileName));
    }

}
