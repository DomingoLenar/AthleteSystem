package views;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MainMenu {
    private JComboBox dropdown;
    private JPanel mainPanel;

    public JComboBox getDropdown() {
        return dropdown;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        String options[] = {"Individual Player Information", "Team Information", "Game Participation", "Sports Performance"};
        dropdown = new JComboBox(options);

        dropdown.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {

                    if (e.getItem().toString().equals(options[0]))
                        System.out.println("1");
                    if (e.getItem().toString().equals(options[1]))
                        System.out.println("2");
                    if (e.getItem().toString().equals(options[2]))
                        System.out.println("3");
                    if (e.getItem().toString().equals(options[3]))
                        System.out.println("4");
                }
//                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
//                    // Item deselected
//                    System.out.println("Deselected Item: " + e.getItem());
//                }
            }
        });
    }
}
