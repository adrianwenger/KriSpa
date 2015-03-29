package de.awenger.krispa.model;

import de.awenger.krispa.model.impl.DataBasis;
import java.io.File;


/**
 *
 * @author Adrian Wenger
 */
public interface IDataBasis {


    /**
     * reads file from file system an saves key/value pairs to dic.
     *
     * @param f file
     */
    void read(File f);

    /**
     * saves dic key/value pairs to file in fileSystem.
     *
     * @param f file
     */
    void save(File f);
    
     /**
     * Inserts key/vale pair into dic.
     *
     * @param keyCount count (part of VocabularyKey)
     * @param valueSpanVal spanishValue (part of VocabularyKey)
     * @param germVal germanValue
     * @return
     */
    boolean insert(int keyCount, String valueSpanVal, String germVal);
    
    /**
     * removes key/value pairs from dic.
     *
     * @param valueSpanValue spanishValue 
     * @param keyCount 
     * @param germVal GermanValue value
     * @return
     */
    boolean remove(String valueSpanValue,int keyCount, String germVal);
}
