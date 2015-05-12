package edu.hm.cs.swe2.monster;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.hm.cs.swe2.creatures.Creature;
import edu.hm.cs.swe2.monster.gui.CreaturePanel;

/**
 * Application for the Creature exercise.
 * Creates a GUI for selection of 2 creatures (left and right). Allows them
 * to attack each other via button clicks - or to heal them.
 * @author <a mailto:ab@cs.hm.edu>Axel B&ouml;ttcher</a>
 *
 */
@SuppressWarnings("serial")
public class Main  extends JFrame {

    private final CreaturePanel leftMonsterPanel = new CreaturePanel();
    private final CreaturePanel rightMonsterPanel = new CreaturePanel();
    private final JButton attackLeftToRightButton = new JButton("==> attack ==>");
    private final JButton attackRightToLeftButton = new JButton("<== attack <==");

    /**
     * Initializes the Application:
     */
    public Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.getContentPane().setBackground(Color.WHITE);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        this.add(leftMonsterPanel,c);
        c.gridx = 1;
        c.weighty = 1.;
        this.add(this.createButtonPanel(), c);
        c.gridx = 2;
        c.weighty = 0;
        this.add(rightMonsterPanel, c);

        this.pack();
        this.setVisible(true);
        this.setTitle("Creatures ....");
    }

    /**
     * Helper method that creates a panel with the two buttons
     * to perform attacks between two creatures (left and right).
     * Also binds callbackers to the buttons.
     */
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();

        attackLeftToRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.this.attack(leftMonsterPanel.getCreature(), rightMonsterPanel.getCreature());
            }
        });
        attackRightToLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.this.attack(rightMonsterPanel.getCreature(), leftMonsterPanel.getCreature());
            }

        });
        buttonPanel.setLayout(new GridLayout(6, 1));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(Box.createGlue());
        buttonPanel.add(attackLeftToRightButton);
        buttonPanel.add(Box.createGlue());
        buttonPanel.add(attackRightToLeftButton);
        buttonPanel.add(Box.createGlue());
        return buttonPanel;
    }

    /**
     * helper method called to make creatures attack each other.
     * Updates the GUI afterwards since life points might change.
     * @param attacker Attacking creature.
     * @param victim Attacked creature.
     */
    private void attack(Creature attacker, Creature victim) {
        if (attacker != null && victim != null) {
            attacker.attack(victim);
            leftMonsterPanel.update();
            rightMonsterPanel.update();
        }
    }

    /**
     * Main method that does nothing else than fire up the window.
     * @param args Commandline args. None used here.
     */
    public static void main(String... args) {
        new Main();
    }

}
