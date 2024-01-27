package views;

import javax.swing.*;

public class SportResultPanel {
    private JPanel mainPanel;
    private JLabel sportsLabel;
    private JButton SR_backbtn;
    private JLabel sportsTotalGames;
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JLabel getSportsLabel() {
        return sportsLabel;
    }

    public JLabel getSportsTotalGames() {
        return sportsTotalGames;
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public JButton getSR_backbtn() {
        return SR_backbtn;
    }
}