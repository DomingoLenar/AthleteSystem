package views;

import javax.swing.*;
import java.util.ArrayList;

public class SportsCategoryPanel {
    private JPanel mainPanel;
    private JComboBox SC_dropdown;
    private JButton SC_backbtn;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JButton getSC_backbtn() {
        return SC_backbtn;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        SC_dropdown = new JComboBox();
    }

    public JComboBox getSC_dropdown() {
        return SC_dropdown;
    }

    public void populateSC_dropdown(ArrayList<String> sports) {
        for (String sport : sports) {
            SC_dropdown.addItem(sport);
        }
    }
}
