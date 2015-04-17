package de.awenger.krispa.controller.impl;

import de.awenger.krispa.controller.IKriSpaController;
import de.awenger.krispa.controller.ILearningSessionState;
import de.awenger.krispa.model.IDataBasis;
import de.awenger.krispa.model.IVocabularyKey;
import de.awenger.krispa.model.impl.DataBasis;
import de.awenger.krispa.util.observer.Observable;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
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
    private Map<String, String> vocMapCount0 = new HashMap<>();
    private Map<String, String> vocMapCount1 = new HashMap<>();
    private Map<String, String> vocMapCount2 = new HashMap<>();
    private Map<String, String> vocMapCount3 = new HashMap<>();
    private Map<String, String> vocMapCount4 = new HashMap<>();
    private final Map<IVocabularyKey, String> vocMapCount0_SaveBack = new HashMap<>();
    private final Map<IVocabularyKey, String> vocMapCount1_SaveBack = new HashMap<>();
    private final Map<IVocabularyKey, String> vocMapCount2_SaveBack = new HashMap<>();
    private final Map<IVocabularyKey, String> vocMapCount3_SaveBack = new HashMap<>();
    private final Map<IVocabularyKey, String> vocMapCount4_SaveBack = new HashMap<>();

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
        this.currentState.checkIfMapEntrys();
    }

    @Override
    public void changeCurrentState() {
        if (currentState instanceof StateFinish) {
            this.currentState.change();
        } else {
            this.currentState.change();
            this.currentState.checkIfMapEntrys();
        }
    }

    @Override
    public int endLearningSession() {
        setCurrentState(new StateFinish(this));
        this.getCurrentState().change();
        return 1;
    }

    @Override
    public void saveData(String fileName) {
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
        if (map.isEmpty()) {
            return null;
        } else {
             //initialize words for specific ILearningSessionState
            List<String> keys = new ArrayList<>(map.keySet());
            Map<String, String> map1 = new TreeMap();
            // add x words to map1 
            int x = 20;
            if (map.size() < x) {
                x = map.size();
            }
            for (int i = 0; i < x; i++) {
                String randomKey = keys.get(random.nextInt(keys.size()));
                String value = map.get(randomKey);
                map1.put(randomKey, value);
                map.remove(randomKey);
            }
            // returns map1 with x random key/value pairs
            return map1;
        }
    }

    @Override
    public void reallocateVoc() {
        // first clear actula records
        //dataBasis.getDic().clear();
        // write divided maps back to dic
        writeBackToDic(vocMapCount0_SaveBack);
        writeBackToDic(vocMapCount1_SaveBack);
        writeBackToDic(vocMapCount2_SaveBack);
        writeBackToDic(vocMapCount3_SaveBack);
        writeBackToDic(vocMapCount4_SaveBack);
    }

    private void writeBackToDic(Map<IVocabularyKey, String> map) {
        // than save data back
        for (Map.Entry<IVocabularyKey, String> entry : map.entrySet()) {
            dataBasis.insert(entry.getKey().getCount(), entry.getKey().getSpanVal(), entry.getValue());
        }
    }

    @Override
    public void setWordMaps(Map<IVocabularyKey, String> map) {
        if (!map.isEmpty()) {
            if (this.currentState instanceof StateStart) {
                this.vocMapCount0_SaveBack.putAll(map);
            } else if (this.currentState instanceof StateLearningInProgress_1) {
                this.vocMapCount1_SaveBack.putAll(map);
            } else if (this.currentState instanceof StateLearningInProgress_2) {
                this.vocMapCount2_SaveBack.putAll(map);
            } else if (this.currentState instanceof StateLearningInProgress_3) {
                this.vocMapCount3_SaveBack.putAll(map);
            } else {
                this.vocMapCount4_SaveBack.putAll(map);
            }
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
    public List<String> getListValues() {
        List<String> list = new ArrayList<>();

        if (currentState instanceof StateStart) {
            for (String val : vocMapCount0.values()) {
                list.add(val);
            }
        } else if (currentState instanceof StateLearningInProgress_1) {
            for (String val : vocMapCount1.values()) {
                list.add(val);
            }
        } else if (currentState instanceof StateLearningInProgress_2) {
            for (String val : vocMapCount2.values()) {
                list.add(val);
            }
        } else if (currentState instanceof StateLearningInProgress_3) {
            for (String val : vocMapCount3.values()) {
                list.add(val);
            }
        } else {
            for (String val : vocMapCount4.values()) {
                list.add(val);
            }
        }
        return list;

    }

    @Override
    public int removeKey(String key) {
        if (currentState instanceof StateStart) {
            this.vocMapCount0.remove(key);
            return this.vocMapCount0.size();
        } else if (currentState instanceof StateLearningInProgress_1) {
            this.vocMapCount1.remove(key);
            return this.vocMapCount1.size();
        } else if (currentState instanceof StateLearningInProgress_2) {
            this.vocMapCount2.remove(key);
            return this.vocMapCount2.size();
        } else if (currentState instanceof StateLearningInProgress_3) {
            this.vocMapCount3.remove(key);
            return this.vocMapCount3.size();
        } else {
            this.vocMapCount4.remove(key);
            return this.vocMapCount4.size();
        }
    }

    @Override
    public Map<String, String> getMap() {
        if (currentState instanceof StateStart) {
            return this.vocMapCount0;
        } else if (currentState instanceof StateLearningInProgress_1) {
            return this.vocMapCount1;
        } else if (currentState instanceof StateLearningInProgress_2) {
            return this.vocMapCount2;
        } else if (currentState instanceof StateLearningInProgress_3) {
            return this.vocMapCount3;
        } else {
            return this.vocMapCount4;
        }
    }
    
    @Override
    public void activate99ers() {
        System.out.println("not implemented at the moment");
    }

}
