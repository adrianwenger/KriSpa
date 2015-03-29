package de.awenger.krispa.gui;

import de.awenger.krispa.controller.IKriSpaController;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/**
 *
 * @author philippschultheiss
 */
class WelcomeFrame extends JFrame implements ActionListener {

    private JFrame menuFrame;

    private final IKriSpaController controller;

    /**
     * JButton to start or later to restart the Game.
     */
    private final JButton start = new JButton("Start Game");
    /**
     * Dimension for the menuFrame.
     */
    private static final Dimension MENU_FRAME_SIZE = new Dimension(800, 360);
    /**
     * set Bounds for menuframe startbutton.
     */
    private static final Rectangle MENU_FRAME_START_BUTTON
            = new Rectangle(300, 240, 200, 50);

    /**
     * default background for the menuframe.
     */
    private final ImageIcon backgroundMenu
            = new ImageIcon(getClass().getResource("background_menu.png"));

    public WelcomeFrame(IKriSpaController controller) {
        this.controller = controller;

        this.menuFrame = new JFrame("BlackJack");
        this.menuFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //build Buttons
        this.start.setBounds(MENU_FRAME_START_BUTTON);
        this.start.addActionListener(this);
        //Container setup
        JLabel startContainer = new JLabel(backgroundMenu);
        startContainer.setLayout(null);
        startContainer.add(start);
        //Frame setup
        this.menuFrame.add(startContainer);
        this.menuFrame.setSize(MENU_FRAME_SIZE);
        this.menuFrame.setLocationRelativeTo(null);
        this.menuFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(start)) {
            this.menuFrame.setVisible(false);
            //new ConfigurationPanel(gui, controller);
            
        }
    }

}
