package de.awenger.krispa.model.impl;

import de.awenger.krispa.model.IVocabularyKey;


/**
 * class to create VocabularyKey Objects.
 */
public class VocabularyKey implements IVocabularyKey{
    private final int count;
    private final String spanVal;

    public VocabularyKey(int count, String spanVal) {
        this.count = count;
        this.spanVal = spanVal;
    }

    public int getCount() {
        return count;
    }

    public String getSpanVal() {
        return spanVal;
    }
    
}
