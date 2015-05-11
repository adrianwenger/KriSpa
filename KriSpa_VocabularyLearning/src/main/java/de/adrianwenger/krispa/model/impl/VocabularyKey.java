package de.adrianwenger.krispa.model.impl;

import de.adrianwenger.krispa.model.IVocabularyKey;


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

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public String getSpanVal() {
        return spanVal;
    }
    
}
