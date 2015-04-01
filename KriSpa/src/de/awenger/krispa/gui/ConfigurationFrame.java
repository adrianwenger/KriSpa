package de.awenger.krispa.gui;

import de.awenger.krispa.controller.IKriSpaController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author Adrian Wenger
 */
public class ConfigurationFrame extends JFrame implements ActionListener {


    /**
     * KriSpaController.
     */
    private final IKriSpaController controller;

    // Variables declaration - do not modify                     
    private java.awt.Panel LabelImage;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    
    public static Map<String, String> map;

    // End of variables declaration  
    
    /**
     * Creates new form ConfigurationPanel.
     * @param cont IKriSpaController
     */
    public ConfigurationFrame(IKriSpaController cont) {
        this.controller = cont;
        initComponents();
    }

    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        LabelImage = new java.awt.Panel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("In which direction do you want to learn your vocabels?");

        jRadioButton2.setText("German --> Spanish");
        jRadioButton2.setEnabled(false);
        jRadioButton2.addActionListener(this);

        jRadioButton1.setText("Spanish --> German");
        jRadioButton1.setSelected(true);
        jRadioButton1.addActionListener(this);

        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);

        // Import ImageIcon     
        JLabel jLabelObject = new JLabel();
        jLabelObject.setIcon(new ImageIcon("/images/KriSpa_Backround.png"));
        LabelImage.add(jLabelObject);

        javax.swing.GroupLayout LabelImgaeLayout = new javax.swing.GroupLayout(LabelImage);
        LabelImage.setLayout(LabelImgaeLayout);
        LabelImgaeLayout.setHorizontalGroup(
                LabelImgaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
        );
        LabelImgaeLayout.setVerticalGroup(
                LabelImgaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 58, Short.MAX_VALUE)
        );

        jButton1.setText("Start");
        jButton1.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(LabelImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jRadioButton2)
                                                        .addComponent(jRadioButton1))
                                                .addGap(142, 142, 142)))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(161, 161, 161)
                                        .addComponent(jButton1)))
                        .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        if (source == jButton1) {
            if (jRadioButton1.isEnabled()) {
                // sets learningDirection: Spanish --> German
                this.controller.setLearningDirection(true);
            } else {
                // sets learningDirection: German --> Spanish
                this.controller.setLearningDirection(false);
            }
            //map = this.controller.getWords();
        }
    }

}
