package de.awenger.krispa.gui;

import de.awenger.krispa.controller.IKriSpaController;
import de.awenger.krispa.controller.impl.StateLearningInProgress_1;
import de.awenger.krispa.controller.impl.StateLearningInProgress_2;
import de.awenger.krispa.controller.impl.StateLearningInProgress_3;
import de.awenger.krispa.controller.impl.StateLearningInProgress_4;
import de.awenger.krispa.controller.impl.StateStart;
import de.awenger.krispa.model.IVocabularyKey;
import de.awenger.krispa.model.impl.VocabularyKey;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author philippschultheiss
 */
class MainFrame extends JFrame implements ActionListener {


    // import map key/value pairs to gui
    private final List<String> listKeys = new ArrayList<>();
    private final List<String> listValues = new ArrayList<>();
    private int listLength;
    private final Map<IVocabularyKey, String> mapProcessedWords = new HashMap<>();
    private String[] arrayTextAreaValues;
    private int arrayTextAreaValuesCount = 0;
    private int stageCount = 0;

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonSolve;
    private javax.swing.JLabel jLabelFlagImage;
    private javax.swing.JLabel jLabelGermanWord;
    private javax.swing.JLabel jLabelLearningInProgress;
    private javax.swing.JLabel jLabelStage1;
    private javax.swing.JLabel jLabelStage2;
    private javax.swing.JLabel jLabelStage3;
    private javax.swing.JLabel jLabelStage4;
    private javax.swing.JLabel jLabelStage5;
    private javax.swing.JTextArea jTextAreaResult;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JMenuItem jMenuItemEditSettings;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelStage;
    private javax.swing.JTextField jTextFieldSpanishMeaning;
    private javax.swing.JTextField jTextFieldProgress;
    private final IKriSpaController controller;
    private String germanMeaning;
    private String spanishMeaning;
    private int progressCount = 0;
    private int vocMapLength;
    // End of variables declaration

    public MainFrame(IKriSpaController controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {

        jLabelGermanWord = new javax.swing.JLabel();
        jTextFieldSpanishMeaning = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabelLearningInProgress = new javax.swing.JLabel();
        jPanelStage = new javax.swing.JPanel();
        jLabelStage1 = new javax.swing.JLabel();
        jLabelStage2 = new javax.swing.JLabel();
        jLabelStage3 = new javax.swing.JLabel();
        jLabelStage4 = new javax.swing.JLabel();
        jLabelStage5 = new javax.swing.JLabel();
        jLabelFlagImage = new javax.swing.JLabel();
        jButtonSolve = new javax.swing.JButton();
        jTextAreaResult = new javax.swing.JTextArea();
        jTextFieldProgress = new javax.swing.JTextField();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuEdit = new javax.swing.JMenu();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenuItemEditSettings = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KriSpa -- Vocabulary Platform");

        jLabelGermanWord.setBackground(new java.awt.Color(204, 204, 204));
        jLabelGermanWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelGermanWord.setBorder(javax.swing.BorderFactory.createTitledBorder("German Word"));

        jTextFieldSpanishMeaning.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSpanishMeaning.setText("....");
        jTextFieldSpanishMeaning.setBorder(javax.swing.BorderFactory.createTitledBorder("Spanish Meaning"));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabelLearningInProgress.setText("Learning in Progress...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelLearningInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelLearningInProgress)
                        .addGap(26, 26, 26))
        );

        jPanelStage.setBackground(new java.awt.Color(255, 255, 255));

        jLabelStage1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabelStage1.setText("       Stage1");
        jLabelStage1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //jLabelStage1.setBackground(Color.BLUE);

        jLabelStage2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabelStage2.setText("       Stage2");
        jLabelStage2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelStage3.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabelStage3.setText("       Stage3");
        jLabelStage3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelStage4.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabelStage4.setText("       Stage4");
        jLabelStage4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelStage5.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabelStage5.setText("       Stage5");
        jLabelStage5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelStageLayout = new javax.swing.GroupLayout(jPanelStage);
        jPanelStage.setLayout(jPanelStageLayout);
        jPanelStageLayout.setHorizontalGroup(
                jPanelStageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelStageLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelStageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelStage1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelStage2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelStage3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelStage4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelStage5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelStageLayout.setVerticalGroup(
                jPanelStageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelStageLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelStage1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelStage2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelStage3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelStage4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelStage5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelFlagImage.setIcon(new javax.swing.ImageIcon("/Users/Adi/NetBeansProjects/KrissisSpanischProgramm/KriSpa/images/KriSpa_Backround.png")); // NOI18N

        jButtonSolve.setText("solve");
        jButtonSolve.addActionListener(this);
        this.getRootPane().setDefaultButton(jButtonSolve);

        jTextAreaResult.setBackground(new java.awt.Color(204, 204, 204));
        jTextAreaResult.setBorder(javax.swing.BorderFactory.createTitledBorder("results"));

        jTextFieldProgress.setEditable(false);
        jTextFieldProgress.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jTextFieldProgress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldProgress.setText("0/20");
        jTextFieldProgress.setAutoscrolls(false);
        jTextFieldProgress.setBorder(javax.swing.BorderFactory.createTitledBorder("progress"));

        jMenuFile.setText("File");
        jMenuEdit.setText("Edit");

        jMenuItemSave.setText("save...");
        jMenuFile.add(jMenuItemSave);

        jMenuItemExit.setText("exit");
        jMenuFile.add(jMenuItemExit);

        jMenuEdit.add(jMenuItemEditSettings);

        jMenuBar.add(jMenuFile);
        jMenuBar.add(jMenuEdit);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(33, 33, 33)
                                                        .addComponent(jPanelStage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(55, 55, 55)
                                                        .addComponent(jTextFieldProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jTextFieldSpanishMeaning, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                                                .addComponent(jLabelGermanWord, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jButtonSolve, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(45, 45, 45)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextAreaResult, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabelFlagImage, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanelStage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(81, 81, 81))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabelGermanWord, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextFieldSpanishMeaning, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jTextAreaResult))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelFlagImage))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonSolve, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40))))
        );

        pack();
        this.jTextFieldSpanishMeaning.requestFocusInWindow();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        initialize();
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(jMenuItemSave)) {
            exit("KriSpa saved! Do you want to quit?");
        } else if (source.equals(jMenuItemExit)) {
            exit("Do you want to quit KriSpa?");
        } else if (source.equals(jMenuItemEditSettings)) {
            controller.activate99ers();
        } else if (source.equals(jButtonSolve)) {
            solve();
        }
    }

    /**
     * initializes MainFrame.
     */
    private void initialize() {
        try {
//            if (!(controller.getCurrentState() instanceof StateLearningInProgress_4) || stageCount == 1) {
//                listLength = 1;
//            }
            moveToNextWord();
        } catch (Exception ex) {
            moveStage();
            initialize();
        }
    }

    /**
     * moves to next word pair and sets values to jLabelGermanWord and
     * initializes jTextFieldSpanishMeaning .
     */
    private void moveToNextWord() {
        if (listLength > 1) {
            if (getWords()) {
                //increaseProgress();
                //filljTextAreaResult();
                jLabelGermanWord.setText(germanMeaning);
                jTextFieldSpanishMeaning.setText("...");
                jTextFieldSpanishMeaning.requestFocus();
            } else {
                moveStage();
            }
        } else {
            getMapContent();
            if (getWords()) {
                //increaseProgress();
                //filljTextAreaResult();
                jLabelGermanWord.setText(germanMeaning);
                jTextFieldSpanishMeaning.setText("...");
                jTextFieldSpanishMeaning.requestFocus();
            } else {
                moveStage();
                initialize();
            }

        }
    }

    /**
     * get MapContent move through KeySet and save Keys and Values in Lists
     */
    private void getMapContent() {
        if (!controller.getMap().isEmpty()) {
            for (String key : controller.getMap().keySet()) {
                listKeys.add(key);
                listValues.add(controller.getMap().get(key));
            }
            listLength = listKeys.size();
            this.controller.getMap().clear();
            arrayTextAreaValues = new String[listLength];
        }
    }

    /**
     * get one specific key/value pair and save them to attributes
     *
     */
    private boolean getWords() {
        if (listLength > 0) {
            int index;
            Random rand = new Random();
            if (listLength == 1) {
                index = rand.nextInt(listLength);
            } else {
                index = rand.nextInt(listLength - 1);
            }

            germanMeaning = listValues.get(index);
            listValues.remove(index);

            spanishMeaning = listKeys.get(index);
            listKeys.remove(index);

            listLength--;
            return true;
        } else {
            return false;
        }

    }

    /**
     * move stage to next level. Set different values to 0 and change
     * CurrentState.
     */
    private void moveStage() {
        // increase Stage Counter
        stageCount++;
        // show message to user
        JOptionPane.showMessageDialog(null,
                "You reached Stage" + stageCount,
                "Info",
                JOptionPane.WARNING_MESSAGE);
        progressCount = 0;
        arrayTextAreaValuesCount = 0;
        filljTextAreaResult();
        this.controller.setWordMaps(mapProcessedWords);
        mapProcessedWords.clear();
        // wordlist processed change state to new learningSession
        if (this.controller.getCurrentState() instanceof StateStart) {
            this.controller.changeCurrentState();
            this.jLabelStage1.setBackground(Color.BLUE);
        } else if (this.controller.getCurrentState() instanceof StateLearningInProgress_1) {
            this.controller.changeCurrentState();
            this.jLabelStage2.setBackground(Color.BLUE);
        } else if (this.controller.getCurrentState() instanceof StateLearningInProgress_2) {
            this.controller.changeCurrentState();
            this.jLabelStage3.setBackground(Color.BLUE);
        } else if (this.controller.getCurrentState() instanceof StateLearningInProgress_3) {
            this.controller.changeCurrentState();
            this.jLabelStage4.setBackground(Color.BLUE);
        } else if (this.controller.getCurrentState() instanceof StateLearningInProgress_4) {
            if (stageCount > 0) {
                this.jLabelStage5.setBackground(Color.BLUE);
                exit("You finished your learning session" + "\n" + "Do you now want to quit KriSpa?");
            }
            stageCount++;
        }
    }

    /**
     * solves current round
     *
     * checks if the words in spanish value is inserted correctly. To compare
     * the words the Levenstein* distance will be determined. If the return
     * value is 0 --> words matches properly 1--> words nearly matches (1 letter
     * does not match) 2--> words do not match (2 or more letters does not
     * match)
     */
    private void solve() {
        // checks if assumed result is correct
        int result = this.controller.getLevensteinDistance(this.jTextFieldSpanishMeaning.getText(), spanishMeaning);

        if (result == 0) {
            // words matches exactly
            resultCorrect();
        } else if (result == 1) {
            // words nearly matches
            resultNearlyCorrect();
        } else {
            // not match
            resultWrong();
        }
        moveToNextWord();
    }

    /**
     * increases progress.
     */
    private void increaseProgress() {
        progressCount++;
        this.jTextFieldProgress.setText(Integer.toString(progressCount) + "/" + listLength);
    }

    /**
     * saves correct Answers into temp Map.
     */
    private void resultCorrect() {
        int count;
        // increase correct answers
        arrayTextAreaValuesCount++;
        //arrayTextAreaValues[arrayTextAreaValuesCount - 1] = germanMeaning + " correct \n";
        if (controller.getCurrentState() instanceof StateStart) {
            count = 1;
        } else if (controller.getCurrentState() instanceof StateLearningInProgress_1) {
            count = 2;
        } else if (controller.getCurrentState() instanceof StateLearningInProgress_2) {
            count = 3;
        } else if (controller.getCurrentState() instanceof StateLearningInProgress_3) {
            count = 4;
        } else {
            count = 99;
        }
        mapProcessedWords.put(new VocabularyKey(count, spanishMeaning), germanMeaning);
    }

    /**
     * if result is nearly correct ask User if he want to set this word as
     * correct or wrong.
     */
    private void resultNearlyCorrect() {
        int answer = JOptionPane.showConfirmDialog(this, "correct answer: " + "\t" + spanishMeaning + "\n" + "your answer: \t\b" + this.jTextFieldSpanishMeaning.getText() + "\n\n" + "Do you want to save as correct", "nearly Correct!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (answer == JOptionPane.YES_OPTION) {
            resultCorrect();
        } else {
            resultWrong();
        }
    }

    /**
     * saves processed words back to processedWords.
     */
    private void resultWrong() {
        int count;
        arrayTextAreaValuesCount++;
        //arrayTextAreaValues[arrayTextAreaValuesCount - 1] = germanMeaning + " wrong \n";
        if (controller.getCurrentState() instanceof StateStart) {
            count = 0;
        } else if (controller.getCurrentState() instanceof StateLearningInProgress_1) {
            count = 1;
        } else if (controller.getCurrentState() instanceof StateLearningInProgress_2) {
            count = 2;
        } else if (controller.getCurrentState() instanceof StateLearningInProgress_3) {
            count = 3;
        } else {
            count = 4;
        }
        this.mapProcessedWords.put(new VocabularyKey(count, spanishMeaning), germanMeaning);
    }

    /**
     * fills TextArea with already processed results.
     */
    private void filljTextAreaResult() {
        for (int i = 0; i < arrayTextAreaValuesCount; i++) {
            this.jTextAreaResult.append(arrayTextAreaValues[i]);
        }
    }

    /**
     * exit Gui.
     */
    private void exit(String question) {
        int answer = JOptionPane.showConfirmDialog(this, question, "Quit KriSpa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (answer == JOptionPane.YES_OPTION) {
            this.controller.endLearningSession();
            System.exit(0);
        }
    }

}
