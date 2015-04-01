package de.awenger.krispa.controller;

import de.awenger.krispa.util.observer.IObservable;
import java.util.Map;


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
}
