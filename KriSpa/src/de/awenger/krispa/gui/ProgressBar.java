package de.awenger.krispa.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;



/**
 *
 * @author Adrian Wenger
 */
public class ProgressBar extends JFrame{


    // Variables declaration - do not modify                     
    private JLabel jLabel2;
    private JProgressBar jProgressBar1;
    // End of variables declaration          

    /**
     * Creates new form ProgressBar
     */
    public ProgressBar() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jProgressBar1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "loading KriSpa...", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));

        jLabel2.setText("KriSpa wird gestartet");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
        );

        displayProgressBar();
        pack();
    }  
   public void displayProgressBar() {
     /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProgressBar().setVisible(true);
            }

        });
   }
}
