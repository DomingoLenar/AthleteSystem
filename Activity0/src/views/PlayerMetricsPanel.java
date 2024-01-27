package views;

import javax.swing.*;

public class PlayerMetricsPanel {
    private JLabel playerNameLabel;
    private JLabel idValue;
    private JLabel sportValue;
    private JLabel countryValue;
    private JLabel goldValue;
    private JLabel silverValue;
    private JLabel bronzeValue;
    private JPanel mainPanel;
    private JButton PM_backbtn;

    public JButton getPM_backbtn() {
        return PM_backbtn;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JLabel getPlayerNameLabel() {
        return playerNameLabel;
    }

    public JLabel getCountryValue() {
        return countryValue;
    }

    public JLabel getBronzeValue() {
        return bronzeValue;
    }

    public JLabel getGoldValue() {
        return goldValue;
    }

    public JLabel getIdValue() {
        return idValue;
    }

    public JLabel getSilverValue() {
        return silverValue;
    }

    public JLabel getSportValue() {
        return sportValue;
    }
}
