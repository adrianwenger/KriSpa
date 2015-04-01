package de.awenger.krispa.controller;


/**
 *
 * @author Adrian Wenger
 */
public interface ILearningSessionState {


    /**
     * changes the learning state if words are processed in currrent stage.
     */
    void change();

    /**
     * divides the dic into the seperate Boxes.
     */
    void divideDic();

}
