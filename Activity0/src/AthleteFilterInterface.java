import views.ChooseFile;
import views.MainMenu;
import views.SelectFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AthleteFilterInterface extends JFrame {

    private String selectFileID = "selectFile_ID";
    private final String chooseFileID = "chooseFile_id";
    private final String mainID = "main_id";
    private SelectFile selectFile;
    private JPanel cardPanel;
    private ChooseFile chooseFile;
    private MainMenu mainMenu;

    public AthleteFilterInterface() {
        this.selectFile = new SelectFile();
        JButton select_file_btn = selectFile.getSelectFileButton();
        select_file_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseFile = new ChooseFile();
                boolean valid = chooseFile.displayJFileExplorer();

                if (valid) {
                    mainMenu = new MainMenu();
                    setUpSubFrame();
                    changeScreen(mainID);
                } else {
                    // display error prompt
                }

            }
        });

        CardLayout cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        setUpMainFrame();
        add(cardPanel);

        // show select panel as main view
        ((CardLayout)cardPanel.getLayout()).show(cardPanel, selectFileID);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setVisible(true);
    }

    private void changeScreen(String screen) {
        ((CardLayout)cardPanel.getLayout()).show(cardPanel, screen);
    }

    private void setUpMainFrame() {
        cardPanel.add(selectFileID, selectFile.getMainPanel());
    }

    private void setUpSubFrame() {
        cardPanel.add(chooseFileID, chooseFile);
        cardPanel.add(mainID, mainMenu.getMainPanel());
    }
}
