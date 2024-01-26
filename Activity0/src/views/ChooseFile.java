package views;

import controllers.FilterController;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ChooseFile extends JPanel {

    FilterController filterController;
    public ChooseFile() {
        this.setLayout(new FlowLayout());
        filterController = new FilterController();
    }

    public boolean displayJFileExplorer() {
        JFileChooser fileChooser = new JFileChooser();

        int response = fileChooser.showOpenDialog(null); //function to select a file and open it

        if (response == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            filterController.submitFile(file);
            return true;
        }

        return false;
    }

    public FilterController getFilterController() {
        return filterController;
    }
}

