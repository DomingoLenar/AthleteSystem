package views;

import javax.swing.*;

public class MedalsPanel {
    private JPanel mainPanel;
    private JComboBox medal_dropdown;
    private JButton M_backbtn;
    private String options[] = {"Gold", "Silver", "Bronze", "No Medal"};

    public JPanel getMainPanel() {
        return mainPanel;
    }
    public JButton getM_backbtn() {
        return M_backbtn;
    }

    public JComboBox getMedal_dropdown() {
        return medal_dropdown;
    }

    public String[] getOptions() {
        return options;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        medal_dropdown = new JComboBox(options);
    }
}
