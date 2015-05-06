package de.awenger.krispa.model;

import java.io.File;
import java.util.Map;


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
     * Inserts key/vale pair into dic. If a Entry has changed due to learning progress it first has to be deleted
     * before getting stored again.
     *
     * @param keyCount count (part of VocabularyKey)
     * @param valueSpanVal spanishValue (part of VocabularyKey)
     * @param germVal germanValue
     * @return
     */
    boolean insert(int keyCount, String valueSpanVal, String germVal);
    
    /**
     * Inserts key/vale pair into dic. If a Entry has changed due to learning progress it first has to be deleted
     * before getting stored again.
     *
     * @param keyCount count (part of VocabularyKey)
     * @param valueSpanVal spanishValue (part of VocabularyKey)
     * @param germVal germanValue
     * @return
     */
    boolean update(int keyCount, String valueSpanVal, String germVal);

      /**
     * removes key/value pairs from dic. 
     *
     * @param key key
     * @param value value
     * @return
     */
    boolean remove(IVocabularyKey key, String value);

    /**
     * returns created VocabularyMap dic.
     * @return HashMap containing vocabulary key/value pairs
     */
    Map<IVocabularyKey, String> getDic();

}
