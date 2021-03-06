package de.adrianwenger.krispa.controller;

import de.adrianwenger.krispa.model.IVocabularyKey;
import de.adrianwenger.krispa.util.observer.IObservable;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Adrian Wenger
 */
public interface IKriSpaController extends IObservable {


    /**
     * gets learning Direction.
     *
     * @return learningDirection: true == Spanish --> German / flase == German
     * --> Spanish
     */
    boolean isLearningDirection();

    /**
     * sets Attribute learningDirection.
     *
     * @param learningDirection true == Spanish --> German / flase == German -->
     * Spanish
     */
    void setLearningDirection(boolean learningDirection);

    /**
     * set Learning Session State.
     *
     * @param state state
     */
    void setCurrentState(ILearningSessionState state);

    /**
     *
     * @return state
     */
    ILearningSessionState getCurrentState();

    /**
     * checks Learning Session state.
     */
    void changeCurrentState();

    /**
     * finish Learning Session.
     */
    int endLearningSession();

    /**
     * create new Learning Session Reads data KriSpa.txt containing Word pairs
     * into databasis HashMap. Sets currentState to StateStart();
     */
    void createNewLearningSession();

    /**
     * allocates Vocabulary words to appropriate map.
     *
     * @param map map to be allocated
     */
    void allocateVoc(Map<String, String> map);

    /**
     * Divides dic into one of five subMaps (vocMapCount0 ... vocMapCount4)
     *
     * @param count count
     * @return TreeMap (e.g. vocMapCount0)
     */
    Map<String, String> divideDic(int count);

    /**
     * Minimal number of insertions, deletions and replacements needed for
     * transforming string a into string b.
     *
     * @param a String a
     * @param b String b to be compared with a
     * @return result of Levenstein distance
     */
    int getLevensteinDistance(String a, String b);

    /**
     * generate getter for vocMapCount* to get values to gui
     *
     * @return List with values
     */
    List<String> getListValues();

    /**
     * saves data to File.
     *
     * @param fileName FileName in Directory
     */
    void saveData(String fileName);

    /**
     * reallocates key and value pairs to dic in dataBasis.
     */
    void reallocateVoc();
    
    /**
     * saves recieved map back to correspondending vocMapCount*.
     * @param map map processed in MainFrame
     */
    void setWordMaps( Map<IVocabularyKey, String> map);

    /**
     * removes key after being processed in MainFrame.
     * @param key 
     */
    int removeKey(String key);
    
    /**
     * returns vocMapsCount* maps.
     * @return vocMapCount*
     */
    Map<String, String> getMap();

    /**
     * activates already finished vocabularys and sets them to 0.
     */
    public void activate99ers();
}
