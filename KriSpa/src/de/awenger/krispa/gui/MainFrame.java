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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


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
    private int result;
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

		/* default settings for this frame */
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KriSpa -- Vocabulary Platform");

		/* create field for german words (questions) */
        jLabelGermanWord.setBackground(new java.awt.Color(204, 204, 204));
        jLabelGermanWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelGermanWord.setBorder(javax.swing.BorderFactory.createTitledBorder("German Word"));

		/* Create Field for spanish Words (answers)*/
        jTextFieldSpanishMeaning.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSpanishMeaning.setBorder(javax.swing.BorderFactory.createTitledBorder("Spanish Meaning"));

		/* Create Panel1 */
        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabelLearningInProgress.setText("Learning in Progress...");

		/* Create Stage Panel */
        jPanelStage.setBackground(new java.awt.Color(255, 255, 255));

        jLabelStage1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabelStage1.setText("       Stage1");
        jLabelStage1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
	
			/* Create Flag Icon */
        jLabelFlagImage.setIcon(new javax.swing.ImageIcon("/Users/Adi/NetBeansProjects/KrissisSpanischProgramm/KriSpa/images/KriSpa_Backround.png")); // NOI18N

		/* Crate SolveButton */
        jButtonSolve.setText("solve");
        jButtonSolve.addActionListener(this);
        this.getRootPane().setDefaultButton(jButtonSolve);

		/* Create Result Text Area */
        jTextAreaResult.setBackground(new java.awt.Color(204, 204, 204));
        jTextAreaResult.setBorder(javax.swing.BorderFactory.createTitledBorder("results"));
        jTextAreaResult.setEditable(false);
        jTextAreaResult.setRows(12);
        JScrollPane scrollPanel = new JScrollPane(jTextAreaResult);
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		/* create Progress Field */
        jTextFieldProgress.setEditable(false);
        jTextFieldProgress.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jTextFieldProgress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldProgress.setText("0/20");
        jTextFieldProgress.setAutoscrolls(false);
        jTextFieldProgress.setBorder(javax.swing.BorderFactory.createTitledBorder("progress"));

		/* Create Menu Items*/
        jMenuFile.setText("File");
        jMenuEdit.setText("Edit");
        
		jMenuItemSave.setText("save...");
        jMenuFile.add(jMenuItemSave);
        jMenuItemExit.setText("exit");
        jMenuFile.add(jMenuItemExit);
		
		jMenuItemEditSettings.setText("activate Finished Words");
		jMenuEdit.add(jMenuItemEditSettings);
		
        jMenuBar.add(jMenuFile);
        jMenuBar.add(jMenuEdit);

        this.setJMenuBar(jMenuBar);

		
		/* Create Layout (GridBagLayout) */
		JPanel pane = new JPanel(new GridBagLayout());

					
		/* Add component jPanel1 */
		GridBagConstraints constraintsjLabel1 = new GridBagConstraints();
		// Column number
		constraintsjLabel1.gridx = 0;
		// Row number
		constraintsjLabel1.gridy = 0;
		// number of columns ( number of columns the component uses)
		constraintsjLabel1.gridwidth = 3;
		// number of rows ( number of rows the component uses)
		constraintsjLabel1.gridheight = 1;
		// if display area is larger than the component's requested size, fill horizontal and vertical
		constraintsjLabel1.fill = GridBagConstraints.BOTH;
		// puts any extra space between its grid of cells and the edges of the Label
		constraintsjLabel1.weightx = 1;
		constraintsjLabel1.weighty = 1;
		pane.add(jPanel1, constraintsjLabel1);
		
		
		/* Add Component jPanelStage */
		GridBagConstraints constraintsjPanelStage = new GridBagConstraints();
		constraintsjPanelStage.gridx = 0;
		constraintsjPanelStage.gridy = 1;
		constraintsjPanelStage.gridwidth = 1;
		constraintsjPanelStage.gridheight = 2;
		constraintsjPanelStage.fill = GridBagConstraints.BOTH;
		// Specifies the internal padding: how much to add to the size of the component
		constraintsjPanelStage.insets = 20;
		// determine where (within the area) to place the component, if smaller than cell
		constraintsjPanelStage.anchor = GridBagConstraints.CENTER;
		constraintsjPanelStage.weightx = 1;
		constraintsjPanelStage.weighty = 1;
		pane.add(jPanelStage, constraintsjPanelStage);
		
		
		/* Add Component jLabelGermanWord */
		GridBagConstraints constraintsjLabelGermanWord = new GridBagConstraints(); 
		constraintsjLabelGermanWord.gridx = 1;
		constraintsjLabelGermanWord.gridy = 1;
		constraintsjLabelGermanWord.gridwidth = 1;
		constraintsjLabelGermanWord.gridheight = 1;
		constraintsjLabelGermanWord.fill = GridBagConstraints.BOTH;
		constraintsjLabelGermanWord.insets = 20;
		constraintsjLabelGermanWord.anchor = GridBagConstraints.CENTER;
		constraintsjLabelGermanWord.weightx = 1;
		constraintsjLabelGermanWord.weighty = 1;
		pane.add(jLabelGermanWord, constraintsjLabelGermanWord);
		
		/* Add Component jTextFieldSpanishMeaning */
		GridBagConstraints constraintsjTextFieldSpanishMeaning = new GridBagConstraints(); 
		constraintsjTextFieldSpanishMeaning.gridx = 1;
		constraintsjTextFieldSpanishMeaning.gridy = 2;
		constraintsjTextFieldSpanishMeaning.gridwidth = 1;
		constraintsjTextFieldSpanishMeaning.gridheight = 1;
		constraintsjTextFieldSpanishMeaning.fill = GridBagConstraints.BOTH;
		constraintsjTextFieldSpanishMeaning.insets = 20;
		constraintsjTextFieldSpanishMeaning.anchor = GridBagConstraints.CENTER;
		constraintsjTextFieldSpanishMeaning.weightx = 1;
		constraintsjTextFieldSpanishMeaning.weighty = 1;
		pane.add(jTextFieldSpanishMeaning, constraintsjTextFieldSpanishMeaning);
		
		
		/* Add Component jTextAreaResult */
		GridBagConstraints constraintsjTextAreaResult = new GridBagConstraints(); 
		constraintsjTextAreaResult.gridx = 2;
		constraintsjTextAreaResult.gridy = 1;
		constraintsjTextAreaResult.gridwidth = 1;
		constraintsjTextAreaResult.gridheight = 2;
		constraintsjTextAreaResult.fill = GridBagConstraints.BOTH;
		constraintsjTextAreaResult.insets = 20;
		constraintsjTextAreaResult.anchor = GridBagConstraints.CENTER;
		constraintsjTextAreaResult.weightx = 1;
		constraintsjTextAreaResult.weighty = 1;
		pane.add(jTextAreaResult, constraintsjTextAreaResult);
		
		
		/* Add Component jTextFieldProgress */
		GridBagConstraints constraintsjTextFieldProgress = new GridBagConstraints(); 
		constraintsjTextFieldProgress.gridx = 0;
		constraintsjTextFieldProgress.gridy = 3;
		constraintsjTextFieldProgress.gridwidth = 1;
		constraintsjTextFieldProgress.gridheight = 1;
		constraintsjTextFieldProgress.fill = GridBagConstraints.BOTH;
		constraintsjTextFieldProgress.insets = 20;
		constraintsjTextFieldProgress.anchor = GridBagConstraints.CENTER;
		constraintsjTextFieldProgress.weightx = 1;
		constraintsjTextFieldProgress.weighty = 1;
		pane.add(jTextFieldProgress, constraintsjTextFieldProgress);
		
		
		/* Add Component jButtonSolve */
		GridBagConstraints constraintsjButtonSolve = new GridBagConstraints(); 
		constraintsjButtonSolve.gridx = 1;
		constraintsjButtonSolve.gridy = 3;
		constraintsjButtonSolve.gridwidth = 1;
		constraintsjButtonSolve.gridheight = 1;
		constraintsjButtonSolve.fill = GridBagConstraints.BOTH;
		constraintsjButtonSolve.insets = 20;
		constraintsjButtonSolve.anchor = GridBagConstraints.CENTER;
		constraintsjButtonSolve.weightx = 1;
		constraintsjButtonSolve.weighty = 1;
		pane.add(jButtonSolve, constraintsjButtonSolve);
		
		
		/* Add Component jLabelFlagImage*/
		GridBagConstraints constraintsjLabelFlagImage = new GridBagConstraints();
		constraintsjLabelFlagImage.gridx = 2;
		constraintsjLabelFlagImage.gridy = 3;
		constraintsjLabelFlagImage.gridwidth = 1;
		constraintsjLabelFlagImage.gridheight = 1;
		constraintsjLabelFlagImage.fill = GridBagConstraints.BOTH;
		constraintsjLabelFlagImage.insets = 20;
		constraintsjLabelFlagImage.anchor = GridBagConstraints.CENTER;
		constraintsjLabelFlagImage.weightx = 1;
		constraintsjLabelFlagImage.weighty = 1;
		pane.add(jLabelFlagImage, constraintsjLabelFlagImage);

		
		this.add(pane);
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
                increaseProgress();
                filljTextAreaResult();
                jLabelGermanWord.setText(germanMeaning);
                jTextFieldSpanishMeaning.requestFocus();
            } else {
                moveStage();
            }
        } else {
            getMapContent();
            if (getWords()) {
                increaseProgress();
                filljTextAreaResult();
                jLabelGermanWord.setText(germanMeaning);
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
        this.jTextFieldProgress.setText(Integer.toString(progressCount) + "/" + "20");
    }

    /**
     * saves correct Answers into temp Map.
     */
    private void resultCorrect() {
        int count;
        // increase correct answers
        arrayTextAreaValuesCount++;
        arrayTextAreaValues[arrayTextAreaValuesCount - 1] = germanMeaning + " - correct";
        result = 1;
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
        int answer = JOptionPane.showConfirmDialog(this, "correct answer: " + "\t" + spanishMeaning + "\n" + "your answer: \t\b" + this.jTextFieldSpanishMeaning.getText() + "\n\n" + "Do you want to save as correct", "Answer nearly Correct!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        result = 0;
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
        arrayTextAreaValues[arrayTextAreaValuesCount - 1] = germanMeaning + " - wrong";
        result = 2;
        // show message to user
        JOptionPane.showMessageDialog(null,
                "Correct answer: \n" + spanishMeaning, "Answer wrong!!!", JOptionPane.WARNING_MESSAGE);
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
        // clears TextArea 
        jTextAreaResult.setText("");
        // fill TextArea
        for (int i = 0; i < arrayTextAreaValuesCount; i++) {
            this.jTextAreaResult.append(arrayTextAreaValues[i] + "\n");
            if (result == 0) {
                jTextAreaResult.setForeground(Color.ORANGE);
            } else if (result == 1) {
                jTextAreaResult.setForeground(Color.GREEN);
            } else {
                jTextAreaResult.setForeground(Color.RED);
            }
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
