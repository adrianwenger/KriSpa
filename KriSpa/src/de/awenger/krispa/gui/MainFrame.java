package de.awenger.krispa.gui;

import de.awenger.krispa.controller.IKriSpaController;
import de.awenger.krispa.controller.impl.StateLearningInProgress_1;
import de.awenger.krispa.controller.impl.StateLearningInProgress_2;
import de.awenger.krispa.controller.impl.StateLearningInProgress_3;
import de.awenger.krispa.controller.impl.StateLearningInProgress_4;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author philippschultheiss
 */
class MainFrame extends JFrame implements ActionListener {


    // import map key/value pairs to gui
    private List<String> listKeys = new ArrayList<>();
    private List<String> listValues = new ArrayList<>();
    private static int listLength;

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonGo;
    private javax.swing.JButton jButtonSolve;
    private javax.swing.JButton jButtonQuestionNo;
    private javax.swing.JButton jButtonQuestionYes;
    private javax.swing.JLabel jLabelFlagImage;
    private javax.swing.JLabel jLabelGermanWord;
    private javax.swing.JLabel jLabelLearningInProgress;
    private javax.swing.JLabel jLabelStage1;
    private javax.swing.JLabel jLabelStage2;
    private javax.swing.JLabel jLabelStage3;
    private javax.swing.JLabel jLabelStage4;
    private javax.swing.JLabel jLabelStage5;
    private javax.swing.JLabel jLabelResult;
    private javax.swing.JLabel JLabelInfoCorrectWord;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelStage;
    private javax.swing.JTextField jTextFieldSpanishMeaning;
    private javax.swing.JLabel jLabelQuestionMoveOnCorrectly;

    // End of variables declaration
    private final IKriSpaController controller;
    private String germanMeaning;
    private String spanishMeaning;

    public MainFrame(IKriSpaController controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {

        jLabelGermanWord = new javax.swing.JLabel();
        jTextFieldSpanishMeaning = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabelLearningInProgress = new javax.swing.JLabel();
        jLabelResult = new javax.swing.JLabel();
        jPanelStage = new javax.swing.JPanel();
        jLabelStage1 = new javax.swing.JLabel();
        jLabelStage2 = new javax.swing.JLabel();
        jLabelStage3 = new javax.swing.JLabel();
        jLabelStage4 = new javax.swing.JLabel();
        jLabelStage5 = new javax.swing.JLabel();
        JLabelInfoCorrectWord = new javax.swing.JLabel();
        jLabelQuestionMoveOnCorrectly = new javax.swing.JLabel();
        jLabelFlagImage = new javax.swing.JLabel();
        jButtonSolve = new javax.swing.JButton();
        jButtonGo = new javax.swing.JButton();
        jButtonQuestionNo = new javax.swing.JButton();
        jButtonQuestionYes = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("KriSpa -- Vocabulary Platform");

        jLabelGermanWord.setBackground(new java.awt.Color(204, 204, 204));
        jLabelGermanWord.setBorder(javax.swing.BorderFactory.createTitledBorder("German Word"));
        jLabelGermanWord.setText("test");

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
                        .addContainerGap(14, Short.MAX_VALUE))
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
        jLabelStage1.setBackground(Color.BLUE);

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

        jButtonGo.setText("Go!");
        jButtonGo.addActionListener(this);
        jButtonGo.setVisible(false);

        jButtonQuestionNo.setText("No");
        jButtonQuestionNo.setVisible(false);
        jButtonQuestionNo.addActionListener(this);

        jButtonQuestionYes.setText("Yes");
        jButtonQuestionYes.setVisible(false);
        jButtonQuestionYes.addActionListener(this);

        jMenuFile.setText("File");

        jMenuItemSave.setText("save...");
        jMenuItemSave.addActionListener(this);
        jMenuFile.add(jMenuItemSave);

        jMenuItemExit.setText("exit");
        jMenuItemExit.addActionListener(this);
        jMenuFile.add(jMenuItemExit);

        jLabelQuestionMoveOnCorrectly.setText("Do you want to move on and commit as correct?");
        jLabelQuestionMoveOnCorrectly.setVisible(false);

        jMenuBar.add(jMenuFile);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jPanelStage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelGermanWord, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jTextFieldSpanishMeaning, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(53, 53, 53)
                                                                        .addComponent(jButtonSolve)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jButtonGo)))
                                                        .addComponent(jButtonQuestionNo)
                                                        .addComponent(jButtonQuestionYes)
                                                        .addComponent(jLabelQuestionMoveOnCorrectly)
                                                        .addComponent(JLabelInfoCorrectWord)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabelFlagImage)))
                                        .addGap(34, 34, 34))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(53, 53, 53)
                                                        .addComponent(jLabelGermanWord, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTextFieldSpanishMeaning, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(45, 45, 45)
                                                        .addComponent(jPanelStage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(14, 14, 14)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButtonSolve)
                                                .addComponent(jLabelQuestionMoveOnCorrectly)
                                                .addComponent(JLabelInfoCorrectWord)
                                                .addComponent(jButtonGo))
                                        .addComponent(jButtonQuestionNo)
                                        .addComponent(jButtonQuestionYes)
                                        .addContainerGap(45, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelFlagImage)
                                        .addGap(14, 14, 14))))
        );

        pack();
        this.jTextFieldSpanishMeaning.requestFocusInWindow();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(jMenuItemSave)) {
            this.controller.endLearningSession();
        } else if (source.equals(jMenuItemExit)) {
            exit();
        } else if (source.equals(jButtonSolve)) {
            solve();
            clearScreen();
        } else if (source.equals(jButtonGo)) {
            clearScreen();

        } else if (source.equals(jButtonQuestionNo)) {

        } else if (source.equals(jButtonQuestionYes)) {

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
            resultNearlyCorrect();
            // words nearly matches
            this.jButtonSolve.setVisible(false);
            this.jButtonGo.setVisible(true);
        } else {
            resultWrong();
            // not match 

        }
        moveToNextWord();
    }

    private void exit() {
        int answer = JOptionPane.showConfirmDialog(this, "You want to quit?", "Quit KriSpa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (answer == JOptionPane.YES_OPTION) {
            this.controller.endLearningSession();
            System.exit(0);
        }
    }

    private void resultCorrect() {
        this.jLabelResult.setText("correct");
        this.jLabelResult.setBackground(Color.GREEN);
        this.jLabelResult.setVisible(true);
        this.jButtonGo.setVisible(true);
    }

    private void resultNearlyCorrect() {
        this.jLabelResult.setText("nearly...");
        this.jLabelResult.setBackground(Color.ORANGE);
        this.jLabelResult.setVisible(true);
        this.jLabelQuestionMoveOnCorrectly.setVisible(true);
        this.jButtonSolve.setVisible(false);
        this.jButtonQuestionNo.setVisible(true);
        this.jButtonQuestionYes.setVisible(true);
    }

    private void resultWrong() {
        this.jLabelResult.setText("wrong");
        this.jLabelResult.setBackground(Color.RED);
        this.jButtonGo.setVisible(true);
        this.JLabelInfoCorrectWord.setVisible(true);
    }

    /**
     * get MapContent and save it to lokal static attributes.
     */
    private void getMapContent() {
        for (String key : controller.getSetKeys()) {
            listKeys.add(key);
        }

        listValues = controller.getListValues();
        listLength = listKeys.size() - 1;
    }

    /**
     * moves to next word pair and sets values to Label and textfield.
     */
    private void moveToNextWord() {
        clearScreen();
        getWords();
        jLabelGermanWord.setText(germanMeaning);
        jTextFieldSpanishMeaning.setText("...");
        jTextFieldSpanishMeaning.requestFocus();
    }

    /**
     * get one specific key/value pair and save them to attributes
     *
     */
    private void getWords() {
        if (listLength > 0) {
            Random rand = new Random();
            int index = rand.nextInt(listLength);
            germanMeaning = listValues.get(index);
            listValues.remove(index);

            spanishMeaning = listKeys.get(index);
            listKeys.remove(index);

            listLength--;
        } else {
            // wordlist processed change state to new learningSession
            this.controller.changeCurrentState();
            if (this.controller.getCurrentState() instanceof StateLearningInProgress_1) {
                this.jLabelStage2.setBackground(Color.BLUE);
                this.jLabelStage1.setBackground(Color.GRAY);
            } else if (this.controller.getCurrentState() instanceof StateLearningInProgress_2) {
                this.jLabelStage3.setBackground(Color.BLUE);
                this.jLabelStage2.setBackground(Color.GRAY);
            } else if (this.controller.getCurrentState() instanceof StateLearningInProgress_3) {
                this.jLabelStage4.setBackground(Color.BLUE);
                this.jLabelStage3.setBackground(Color.GRAY);
            } else if (this.controller.getCurrentState() instanceof StateLearningInProgress_4) {
                this.jLabelStage5.setBackground(Color.BLUE);
                this.jLabelStage4.setBackground(Color.GRAY);
            }
        }

    }

    /**
     * clears the screen to process new word.
     */
    private void clearScreen() {
        this.JLabelInfoCorrectWord.setVisible(false);
        this.jButtonGo.setVisible(false);
        this.jButtonQuestionNo.setVisible(false);
        this.jButtonQuestionYes.setVisible(false);
        this.jLabelQuestionMoveOnCorrectly.setVisible(false);

        this.jButtonSolve.setVisible(true);
    }

    private void start() {
        getMapContent();
        getWords();
        this.jLabelGermanWord.setText(germanMeaning);
    }

}
