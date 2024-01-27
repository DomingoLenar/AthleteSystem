package views;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AthletesPanel {
    private JPanel mainPanel;
    private JComboBox PI_dropdown;
    private JButton PI_backbtn;
    private JLabel athleteLabel;
    private String options[];

    private void createUIComponents() {
        // TODO: place custom component creation code here
        PI_dropdown = new JComboBox();
    }

    public JLabel getAthleteLabel() {
        return athleteLabel;
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

    public void populatePI_dropdown(List<String> listOfPlayers) {
        for (int i=0; i<listOfPlayers.size(); i++) {
            String[] arr = listOfPlayers.get(i).split(" ");
            PI_dropdown.addItem(arr[arr.length-1].replaceAll("\"", ""));
        }
//        for (String players : listOfPlayers) {
//            PI_dropdown.addItem(players);
//        }
    }
}
