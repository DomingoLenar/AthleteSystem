package views;

import javax.swing.*;


public class MainMenu {
    private JComboBox M_dropdown;
    private JPanel mainPanel;
    private String options[] = {"Individual Player Information", "Country Participation", "Sports Category", "Medals"};

    public JComboBox getM_dropdown() {
        return M_dropdown;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        M_dropdown = new JComboBox(options);

    }

    public String[] getOptions() {
        return options;
    }
}
