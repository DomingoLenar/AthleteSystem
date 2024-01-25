package views;

import controllers.FileHandlerController;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ChooseFile extends JPanel {

    FileHandlerController controller;

    public ChooseFile() {
        this.setLayout(new FlowLayout());
        this.controller = new FileHandlerController(this);
    }

    public boolean displayJFileExplorer() {
        JFileChooser fileChooser = new JFileChooser();

        int response = fileChooser.showOpenDialog(null); //function to select a file and open it

        if (response == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            controller.submitFile(file);
            return true;
        }

        return false;
    }

}

