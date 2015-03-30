package de.awenger.krispa.model.impl;

import de.awenger.krispa.model.IDataBasis;
import de.awenger.krispa.model.IVocabularyKey;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Adrian Wenger, Philipp Schutltheiß
 */
public final class DataBasis implements IDataBasis {


    /**
     * dic saves the vocabulary key/value pairs.
     */
    private final Map<IVocabularyKey, String> dic = new HashMap<>();

    @Override
    public Map<IVocabularyKey, String> getDic() {
        return dic;
    }

    @Override
    public void read(File f) {
        LineNumberReader in = null;
        try {
            dic.clear();
            in = new LineNumberReader(new FileReader(f));
            String line;
            while ((line = in.readLine()) != null) {
                String[] sf = line.split("\t");
                if (sf.length == 2) {
                    insert(0, sf[0], sf[1]); // count = 0
                } else if (sf.length == 3) {
                    int count = Integer.parseInt(sf[0]);
                    insert(count, sf[1], sf[2]); // count from file
                }
            }
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(DataBasis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(File f) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(f);
            for (Map.Entry<IVocabularyKey, String> eintrag : dic.entrySet()) {
                String s = eintrag.getKey().getCount() + "\t" + eintrag.getKey().getSpanVal()
                        + "\t" + eintrag.getValue();
                out.println(s);
            }
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(DataBasis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean insert(int keyCount, String valueSpanValue, String germVal) {

        // Create VocabularyKey
        IVocabularyKey key = new VocabularyKey(keyCount, valueSpanValue);
        // Pruefung ob Eintrag bereits vorhanden
        if (!dic.containsKey(key)) {
            // Eintrag hinzufuegen
            dic.put(key, germVal);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String valueSpanValue, int keyCount, String germVal) {
        // build key
        IVocabularyKey key = new VocabularyKey(keyCount, valueSpanValue);
        // delete from dic
        if (dic.containsKey(key)) {
            dic.remove(valueSpanValue, germVal);
            return true;
        }
        return false;
    }

}
