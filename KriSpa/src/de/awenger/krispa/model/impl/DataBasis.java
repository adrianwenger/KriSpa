package de.awenger.krispa.model.impl;

import de.awenger.krispa.model.IDataBasis;
import de.awenger.krispa.model.IVocabularyKey;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
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
        return Collections.unmodifiableMap(this.dic);
    }

    @Override
    public void read(File f) {
        try {
            dic.clear();
            BufferedReader in = null;
            in = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8.name()));
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
        // First copy old KriSpaData.txt to .../temp directory, including Dat/Time Stamp
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HHmmss");
        Calendar cal = Calendar.getInstance();
        String source = f.getPath();
        String destination = f.getParent().concat(File.separator + "temp" + File.separator
                + "KriSpaData_").concat(dateFormat.format(cal.getTime()).concat(".txt"));
        try {
            Files.copy(Paths.get(source), Paths.get(destination), REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(DataBasis.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Save Data to KriSpaData.txt
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), StandardCharsets.UTF_8.name()));
            for (Map.Entry<IVocabularyKey, String> eintrag : dic.entrySet()) {
                String s = eintrag.getKey().getCount() + "\t" + eintrag.getKey().getSpanVal()
                        + "\t" + eintrag.getValue() + System.getProperty("line.separator");
                out.write(s);
            }
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(DataBasis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean update(int keyCount, String valueSpanValue, String germVal) {
        boolean valueExisting = dic.containsValue(germVal);
        // is value already existing? (update of Dic Entry needed) 
        if (valueExisting) {
            // get corresponding (old) key from value
            for (Map.Entry<IVocabularyKey, String> ent : dic.entrySet()) {
                // if key value pair found stop here to remove old content
                if (ent.getValue().equals(germVal)) {
                    // remove key and value pair from dic
                    remove(ent.getKey(), ent.getValue());
                    break;
                }
            }
            // Create new VocabularyKey
            IVocabularyKey newKey = new VocabularyKey(keyCount, valueSpanValue);
            // add new Entry to dic
            dic.put(newKey, germVal);
            return true;
        }
        return false;
    }

    @Override
    public boolean insert(int keyCount, String valueSpanValue, String germVal) {
        // Create VocabularyKey
        IVocabularyKey newKey = new VocabularyKey(keyCount, valueSpanValue);
        // add new Entry to dic
        dic.put(newKey, germVal);
        return true;
    }

    @Override
    public boolean remove(IVocabularyKey key, String value) {
        // delete from dic
        if (dic.containsKey(key)) {
            dic.remove(key, value);
            return true;
        }
        return false;
    }

}
