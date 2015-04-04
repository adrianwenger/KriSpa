package de.awenger.krispa.gui;

import de.awenger.krispa.controller.IKriSpaController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


/**
 *
 * @author philippschultheiss
 */
class MainFrame extends JFrame implements ActionListener {

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonGo;
    private javax.swing.JButton jButtonSolve;
    private javax.swing.JLabel jLabelFlagImage;
    private javax.swing.JLabel jLabelGermanWord;
    private javax.swing.JLabel jLabelLearningInProgress;
    private javax.swing.JLabel jLabelStage1;
    private javax.swing.JLabel jLabelStage2;
    private javax.swing.JLabel jLabelStage3;
    private javax.swing.JLabel jLabelStage4;
    private javax.swing.JLabel jLabelStage5;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelStage;
    private javax.swing.JTextField jTextFieldSpanishMeaning;
    // End of variables declaration
    

    private final IKriSpaController controller;

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
        jButtonGo = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KriSpa -- Vocabulary Platform");

        jLabelGermanWord.setBackground(new java.awt.Color(204, 204, 204));
        jLabelGermanWord.setBorder(javax.swing.BorderFactory.createTitledBorder("German Word"));

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

        jButtonGo.setText("go!");

        jMenuFile.setText("File");

        jMenuItemSave.setText("save...");
        jMenuFile.add(jMenuItemSave);

        jMenuItemExit.setText("exit");
        jMenuFile.add(jMenuItemExit);

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
                            .addComponent(jButtonGo))
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelFlagImage)
                        .addGap(14, 14, 14))))
        );

        pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
//        if (source.equals(start)) {
//            //this.menuFrame.setVisible(false);
//            //new ConfigurationPanel(gui, controller);
//
//        }
    }

}
