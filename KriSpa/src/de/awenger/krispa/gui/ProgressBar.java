package de.awenger.krispa.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;


/**
 *
 * @author Adrian Wenger
 */
public class ProgressBar extends JFrame {


    static final int MY_MINIMUM = 0;

    static final int MY_MAXIMUM = 100;

    // Variables declaration - do not modify                     
    private JLabel jLabel2;
    private JProgressBar jProgressBar1;
    // End of variables declaration          

    /**
     * Creates new form ProgressBar
     */
    public ProgressBar() {
        initComponents();
        displayProgressBar();
    }

    private void initComponents() {

        jProgressBar1 = new JProgressBar();
        jProgressBar1.setMinimum(MY_MINIMUM);
        jProgressBar1.setMaximum(MY_MAXIMUM);
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
            
         pack();
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }

    private void updateBar(int newValue) {
        jProgressBar1.setValue(newValue);
    }

    private void displayProgressBar() {
        for (int i = MY_MINIMUM; i <= MY_MAXIMUM; i++) {
            final int percent = i;
            try {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        updateBar(percent);
                    }

                });
                java.lang.Thread.sleep(25);
            } catch (InterruptedException e) {
                ;
            }
        }
    }

}
