package de.awenger.krispa.controller.impl;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import de.awenger.krispa.controller.IKriSpaController;
import de.awenger.krispa.controller.ILearningSessionState;
import de.awenger.krispa.model.IDataBasis;
import de.awenger.krispa.model.IVocabularyKey;
import de.awenger.krispa.model.impl.DataBasis;
import de.awenger.krispa.util.observer.Observable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import org.apache.commons.lang3.StringUtils;


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
     * saves Databasis reference.
     */
    private final IDataBasis dataBasis = new DataBasis();

    /**
     * saves learningDirection.
     */
    private boolean learningDirection;

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
    public boolean isLearningDirection() {
        return learningDirection;
    }

    @Override
    public void setLearningDirection(boolean learningDirection) {
        this.learningDirection = learningDirection;
    }

    @Override
    public void createNewLearningSession() {
        String dir = System.getProperty("user.dir");
        dataBasis.read(new File(dir + "/KriSpaData.txt"));
        setCurrentState(new StateStart(this));
        currentState.divideDic();
    }

    @Override
    public void changeCurrentState() {
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
        Random random = new Random();
        for (IVocabularyKey keys : this.dataBasis.getDic().keySet()) {
            if (keys.getCount() == count) {
                map.put(keys.getSpanVal(), dataBasis.getDic().get(keys));
            }
        }
        // initialize words for specific ILearningSessionState
        List<String> keys = new ArrayList<>(map.keySet());
        Map<String, String> map1 = new TreeMap();
        // add x words to map1 
        int x = 20;
        for (int i = 0; i < x; i++) {
            String randomKey = keys.get(random.nextInt(keys.size()));
            String value = map.get(randomKey);
            map1.put(randomKey, value);
        }
        // returns map1 with x random key/value pairs
        return map1;
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

    @Override
    public Map<String, String> getWords() {
        if (this.currentState instanceof StateStart) {
            return this.vocMapCount0;
        } else if (this.currentState instanceof StateLearningInProgress_1) {
            return this.vocMapCount1;
        } else if (this.currentState instanceof StateLearningInProgress_2) {
            return this.vocMapCount2;
        } else if (this.currentState instanceof StateLearningInProgress_3) {
            return this.vocMapCount3;
        } else {
            return this.vocMapCount4;
        }
    }

    @Override
    public int getLevensteinDistance(String a, String b) {
        int result = StringUtils.getLevenshteinDistance(a, b);

        if (result > 2) {
            return 2;
        } else if (result > 1) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Set<String> getMapKeys() {
        if (currentState instanceof StateStart) {
            List<String> l = new ArrayList<>();
            return this.vocMapCount0.keySet();
        } else if (currentState instanceof StateLearningInProgress_1) {
            return this.vocMapCount1.keySet();
        } else if (currentState instanceof StateLearningInProgress_2) {
            return this.vocMapCount2.keySet();
        } else if (currentState instanceof StateLearningInProgress_3) {
            return this.vocMapCount3.keySet();
        } else {
            return this.vocMapCount4.keySet();
        }
    }

    
    @Override
    public List<String> getMapValues() {
        if (currentState instanceof StateStart) {
            return (List) this.vocMapCount0.values();
        } else if (currentState instanceof StateLearningInProgress_1) {
            return (List) this.vocMapCount1.values();
        } else if (currentState instanceof StateLearningInProgress_2) {
            return (List) this.vocMapCount2.values();
        } else if (currentState instanceof StateLearningInProgress_3) {
            return (List) this.vocMapCount3.values();
        } else {
            return (List)  this.vocMapCount4.values();
        }
    }

}
