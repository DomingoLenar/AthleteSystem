package views;

import javax.swing.*;
import java.util.ArrayList;

public class CountryParticipationPanel {
    private JPanel mainPanel;
    private JComboBox CP_dropdown;
    private JButton CP_backbtn;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JButton getCP_backbtn() {
        return CP_backbtn;
    }

    public JComboBox getCP_dropdown() {
        return CP_dropdown;
    }

    public void populateCP_dropdown(ArrayList<String> countries) {
        for (String country : countries) {
            CP_dropdown.addItem(country);
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        CP_dropdown = new JComboBox();
    }
}
