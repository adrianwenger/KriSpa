package de.awenger.krispa.controller;

import de.awenger.krispa.util.observer.IObservable;


/**
 *
 * @author Adrian Wenger
 */
public interface IKriSpaController extends IObservable {


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
    void checkLearningSessionState();

    /**
     * finish Learning Session.
     */
    void endLearningSession();

    /**
     * create new Learning Session.
     */
    void createNewLearningSession();

}
