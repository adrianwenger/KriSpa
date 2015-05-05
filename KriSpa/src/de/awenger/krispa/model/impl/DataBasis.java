package de.awenger.krispa.model.impl;

import de.awenger.krispa.model.IDataBasis;
import de.awenger.krispa.model.IVocabularyKey;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        try {
            dic.clear();
            BufferedReader in = null;
            in = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8.name()));
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
        // First copy old KriSpaData.txt to .../temp directory, including Dat/Time Stamp
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String source = f.getPath();
        String destination = f.getParent().concat("/temp/KriSpaData_").concat(dateFormat.format(cal.getTime()).concat(".txt"));
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
                        + "\t" + eintrag.getValue()+ "\n";
                out.write(s);
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
        // is entry already existing?
        boolean valExisting = dic.values().contains(germVal);
        if (!valExisting) {
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
