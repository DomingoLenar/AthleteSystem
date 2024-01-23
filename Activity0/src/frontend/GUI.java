package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.io.File;

public class GUI extends JFrame {

    GUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        JButton button = new JButton("Select File");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button) {

                    JFileChooser fileChooser = new JFileChooser();

                    int response = fileChooser.showOpenDialog(null); //function to select a file and open it

                    if (response == JFileChooser.APPROVE_OPTION) {
                        File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                        System.out.println(file);
                    }
                }
            }
        });
        this.add(button);
        this.pack();
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new GUI();
    }
}

