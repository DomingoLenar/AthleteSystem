package views;

import javax.swing.*;

public class AthletesPanel {
    private JPanel mainPanel;
    private JComboBox PI_dropdown;
    private JButton PI_backbtn;
    private String options[];

    private void createUIComponents() {
        // TODO: place custom component creation code here
        PI_dropdown = new JComboBox();
    }

    public JComboBox getPI_dropdown() {
        return PI_dropdown;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JButton getPI_backbtn() {
        return PI_backbtn;
    }

    public void populatePI_dropdown(String[] listOfPlayers) {
        for (String players : listOfPlayers) {
            PI_dropdown.addItem(players);
        }
    }
}
