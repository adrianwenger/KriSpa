package de.awenger.krispa.controller.impl;

import de.awenger.krispa.controller.IKriSpaController;
import de.awenger.krispa.controller.ILearningSessionState;
import de.awenger.krispa.model.IDataBasis;
import de.awenger.krispa.model.IVocabularyKey;
import de.awenger.krispa.model.impl.DataBasis;
import de.awenger.krispa.util.observer.Observable;
import java.io.File;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;


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
    private final IDataBasis dataBasis = new DataBasis();

    /**
     * maps to Store specific words to boxes.
     */
    private Map<String, String> vocMapCount0, vocMapCount1, vocMapCount2, vocMapCount3, vocMapCount4;

    public IDataBasis getDataBasis() {
        return this.dataBasis;
    }

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
        setCurrentState(new StateStart(this));
    }

    @Override
    public void checkLearningSessionState() {
        // new Game. Initialize with StateInGame
        if (this.currentState instanceof StateStart) {
            //this.setCurrentState(new StateInGame(this, calcController));
            this.currentState.change();
        } else {
            // check if GameState will change
            this.currentState.change();
        }
    }

    @Override
    public void endLearningSession() {
        if (this.currentState instanceof StateFinish) {
            reallocateVoc();
        }
        saveData("/KriSpaData.txt");
    }

    /**
     * saves data to File.
     *
     * @param fileName FileName in Directory
     */
    private void saveData(String fileName) {
        Properties prop = new Properties();
        String dir = System.getProperty("user.dir");
        dataBasis.save(new File(dir + fileName));
    }

    @Override
    public void allocateVoc(Map<String, String> map) {
        if (this.currentState instanceof StateStart) {
            this.vocMapCount0 = map;
        } else if (this.currentState instanceof StateLearningInProgress_1) {
            this.vocMapCount1 = map;
        } else if (this.currentState instanceof StateLearningInProgress_2) {
            this.vocMapCount2 = map;
        } else if (this.currentState instanceof StateLearningInProgress_3) {
            this.vocMapCount3 = map;
        } else {
            this.vocMapCount4 = map;
        }
    }

    @Override
    public Map<String, String> divideDic(int count) {
        Map<String, String> map = new TreeMap<>();
        for (IVocabularyKey keys : this.dataBasis.getDic().keySet()) {
            if (keys.getCount() == count) {
                map.put(keys.getSpanVal(), dataBasis.getDic().get(keys));
            }
        }
        return map;
    }

    private void reallocateVoc() {
        // write divided maps back to dic
        writeBackToDic(vocMapCount0, 0);
        writeBackToDic(vocMapCount1, 1);
        writeBackToDic(vocMapCount2, 2);
        writeBackToDic(vocMapCount3, 3);
        writeBackToDic(vocMapCount4, 4);
    }

    private void writeBackToDic(Map<String, String> map, int count) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            dataBasis.insert(count, entry.getKey(), entry.getValue());
        }
    }

}
