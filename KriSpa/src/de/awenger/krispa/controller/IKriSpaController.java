package de.awenger.krispa.controller;

import de.awenger.krispa.util.observer.IObservable;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 *
 * @author Adrian Wenger
 */
public interface IKriSpaController extends IObservable {

    /**
     * gets learning Direction.
     * @return learningDirection: true == Spanish --> German / flase == German --> Spanish
     */
    boolean isLearningDirection();
    
    /**
     * sets Attribute learningDirection.
     * @param learningDirection true == Spanish --> German / flase == German --> Spanish
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
    void endLearningSession();

    /**
     * create new Learning Session.
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
     * @param count count
     * @return TreeMap (e.g. vocMapCount0)
     */
    Map<String, String> divideDic(int count);
    
    /**
     * return subset of the specific maps.
     * @return map containing x word pairs
     */
    Map<String, String> getWords();
    
    /**
     * Minimal number of insertions, deletions and replacements needed for
     * transforming string a into string b.
     * @param a String a
     * @param b String b to be compared with a
     * @return result of Levenstein distance
     */
    int getLevensteinDistance(String a, String b);
    
    /**
     * generate getter for vocMapCount* to get keyset to gui
     * @return Set
     */
    Set<String> getMapKeys();
    
    /**
     * generate getter for vocMapCount* to get values to gui
     * @return List with values 
     */
    List<String> getMapValues();
}
