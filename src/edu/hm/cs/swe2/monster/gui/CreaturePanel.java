/**
 * Class to display a panel where creatures can be selected and displayed.
 * Selection is done via radio buttons. Displays live points, name and an image
 * of a creature.
 * On creation no initial creature is created.
 */
package edu.hm.cs.swe2.monster.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import edu.hm.cs.swe2.creatures.Creature;
import edu.hm.cs.swe2.creatures.Fairy;
import edu.hm.cs.swe2.creatures.Human;
import edu.hm.cs.swe2.creatures.Oger;
import edu.hm.cs.swe2.creatures.Robot;
import edu.hm.cs.swe2.creatures.UberOger;
import edu.hm.cs.swe2.creatures.Zombie;

/**
 * @author @author <a mailto:ab@cs.hm.edu>Axel B&ouml;ttcher</a>
 *
 */
@SuppressWarnings("serial")
public class CreaturePanel extends JPanel {

    // dirty hack to count robots created so far - over all panels
    private static int robotCounter = 0;

    // Radio buttons for creature selection
    private final JRadioButton[] creatureButtons= new JRadioButton[CreatureType.values().length];

    private final JLabel livePointLabel = new JLabel("Livepoints: ");
    private final JLabel nameLabel = new JLabel("Name: ");
    private final ButtonGroup group = new ButtonGroup();
    private final ImagePanel creatureImage = new ImagePanel();

    /**
     *  the currently selected creature.
     */
    private Creature creature;

    /**
     * Anonymous Action listener class that is used as callback for all
     * the radio buttons.
     * Creates a new creature (corresponding to the selected radio button.
     * Sets the image and performs an update.
     */
    private ActionListener createCreatureActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            CreatureType clickedCreature = CreatureType.valueOf(e.getActionCommand().toUpperCase());
            switch(clickedCreature) {
            case HUMAN:
                creature = new Human("Prince Charming");
                break;
            case FAIRY:
                creature = new Fairy("Fee");
                break;
            case ZOMBIE:
                creature = new Zombie();
                break;
            case ROBOT:
                creature = new Robot(++robotCounter);
                break;
            case OGER:
                creature = new Oger();
                break;
            case UBEROGER:
                creature = new UberOger();
                break;
            }
            creatureImage.setImage(clickedCreature.getImage());
            CreaturePanel.this.update();
        }
    };

    /**
     * Constructor that sets up the panel with all required components.
     */
    public CreaturePanel() {
        this.setBackground(Color.WHITE);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);


        this.livePointLabel.setBackground(Color.WHITE);
        this.livePointLabel.setOpaque(true);
        for (int i = 0; i < creatureButtons.length; i++) {
            creatureButtons[i]  = new JRadioButton(CreatureType.values()[i].getCreatureType());
            creatureButtons[i].addActionListener(createCreatureActionListener);
            creatureButtons[i].setBackground(Color.WHITE);
            group.add(creatureButtons[i]);
            this.add(creatureButtons[i], this.createGbc(0, i, 1));
        }
        this.add(livePointLabel, this.createGbc(0, creatureButtons.length, 1));
        this.add(nameLabel, this.createGbc(0, creatureButtons.length + 1, 1));

        this.add(creatureImage, this.createGbc(1, 0, 10));
        this.add(createMedipackButton(), this.createGbc(1, 10, 1));
    }

    /**
     * Create a button with medipack image on it to call {@code heal}
     * on the creature.
     * @return The button, ready with image and callback method.
     * @throws RuntimeException when medipack-image is not found.
     */
    private JButton createMedipackButton() {
        BufferedImage buttonIcon = null;
        try {
            buttonIcon = ImageIO.read(this.getClass().getResource("medipack.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JButton button = new JButton(new ImageIcon(buttonIcon));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getCreature() != null) {
                    getCreature().heal();
                }
                CreaturePanel.this.update();
            }
        });
        return button;
    }
    /**
     * Helper method to create GridbagConstraints for the layout manager.
     * @param x Grid position x where the dedicated component will be placed.
     * @param y Grid position y where the dedicated component will be placed.
     * @param height Grid height to set for the component.
     * @return Constraints for the component at grid (x, y).
     */
    private GridBagConstraints createGbc(int x, int y, int height) {
        GridBagConstraints c;
        c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = 1;
        c.gridheight = height;
        c.anchor = GridBagConstraints.WEST;
        return c;
    }

    /**
     * Updates all components that display information of a creature
     * (live points, name and image).
     */
    public void update() {
        if (creature != null) {
            this.livePointLabel.setText("Livepoints: " + creature.getHealth());
            this.nameLabel.setText("Name: " + creature.getName());
            this.livePointLabel.setBackground(this.getCreature().isAlive() ? Color.GREEN : Color.RED);

            this.repaint();
        }
    }

    /**
     * Getter for the currently selected creature.
     * @return the current creature
     */
    public Creature getCreature() {
        return creature;
    }

    /**
     * Panel component class to display an image of the creature.
     */
    private class ImagePanel extends JPanel {

        private static final int IMAGE_SIZE = 200;
        private BufferedImage image;

        public ImagePanel() {
            this.setMinimumSize(new Dimension(IMAGE_SIZE, IMAGE_SIZE));
            this.setPreferredSize(new Dimension(IMAGE_SIZE, IMAGE_SIZE));
            this.setBackground(Color.WHITE);
        }

        @Override
        public void paint(Graphics g) {
            if(image == null) {
                return;
            }

            // scale the image to fit in an area of IMAGE_SIZE * IMAGE_SIZE
            if (image.getHeight() > image.getWidth()) {
                int width = (int)(image.getWidth() * ((double)IMAGE_SIZE / image.getHeight()));
                g.drawImage(image, 0, 0, width, IMAGE_SIZE, 0, 0, image.getWidth(), image.getHeight(), null, null);
            } else {
                int height = (int)(image.getHeight() * ((double)IMAGE_SIZE / image.getWidth()));
                g.drawImage(image, 0, 0, IMAGE_SIZE, height, 0, 0, image.getWidth(), image.getHeight(), null, null);
            }
        }

        /**
         * Sets the current image to be displayed in this panel.
         * @param image Current image to be displayed.
         */
        public void setImage(BufferedImage image) {
            this.image = image;
            this.repaint();
        }

    }

    /**
     * Enum to hold all information that describes a creature.
     * @author @author <a mailto:ab@cs.hm.edu>Axel B&ouml;ttcher</a>
     *
     */
    private enum CreatureType {
        HUMAN("Human"), FAIRY("Fairy"), ZOMBIE("Zombie"), ROBOT("Robot"), OGER("Oger"), UBEROGER("Uberoger");

        private final String creatureType;
        private BufferedImage image = null;

        private CreatureType(String creatureType) {
            this.creatureType = creatureType;
        }

        /**
         * Getter for type.
         * @return the creature's type.
         */
        public String getCreatureType() {
            return creatureType;
        }

        /**
         * Getter for image that can be displayed onsceen. Reads the image for a creature
         * on first call of this method.
         * @return the creature's image.
         * @throws RuntimeException When image could not be loaded.
         */
        public BufferedImage getImage() {
            if (image == null) {
                try {
                    image = ImageIO.read(CreaturePanel.class.getResource(this.getCreatureType().toLowerCase() + ".jpg"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return image;
        }

    }

}
