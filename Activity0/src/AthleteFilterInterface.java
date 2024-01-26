import views.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AthleteFilterInterface extends JFrame {

    private String selectFileID = "selectFile_ID";
    private final String chooseFileID = "chooseFile_id";
    private final String mainID = "main_id";
    private final String playerInformationID = "playerInformation_id";
    private final String countryParticipationID = "countryParticipation_id";
    private final String sportsCategoryID = "sports_id";
    private final String medalsID = "medals_id";
    private final String totalGoldMedalsID = "gold_medals_id";
    private final String totalSilverMedalsID = "silver_medals_id";
    private final String totalBronzeMedalsID = "bronze_medals_id";
    private final String totalNoMedalsID = "no_medals_id";
    private SelectFile selectFile;
    private JPanel cardPanel;
    private ChooseFile chooseFile;
    private MainMenu mainMenu;
    private PlayerInformationPanel playerInformationPanel;
    private CountryParticipationPanel countryParticipationPanel;
    private SportsCategoryPanel sportsCategoryPanel;
    private MedalsPanel medalsPanel;

    public AthleteFilterInterface() {
        this.selectFile = new SelectFile();

        JButton select_file_btn = selectFile.getSelectFileButton();
        select_file_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseFile = new ChooseFile();
                boolean valid = chooseFile.displayJFileExplorer();

                if (valid) {
                    initComponents();
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

    private void initComponents() {
        mainMenu = new MainMenu();

        initPanels();
        initButtons();

    }

    private void initPanels() {
        playerInformationPanel = new PlayerInformationPanel();
        countryParticipationPanel = new CountryParticipationPanel();
        sportsCategoryPanel = new SportsCategoryPanel();
        medalsPanel = new MedalsPanel();
    }

    private void initButtons() {
        String mainMenuOptions[] = mainMenu.getOptions();
        mainMenu.getM_dropdown().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (e.getItem().toString().equals(mainMenuOptions[0]))
                        changeScreen(playerInformationID);
                    if (e.getItem().toString().equals(mainMenuOptions[1]))
                        changeScreen(countryParticipationID);
                    if (e.getItem().toString().equals(mainMenuOptions[2]))
                        changeScreen(sportsCategoryID);
                    if (e.getItem().toString().equals(mainMenuOptions[3]))
                        changeScreen(medalsID);
                }
//                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
//                    // Item deselected
//                    System.out.println("Deselected Item: " + e.getItem());
//                }
            }
        });
        String medalsOption[] = medalsPanel.getOptions();
        medalsPanel.getMedal_dropdown().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    if (e.getItem().toString().equals(medalsOption[0]))
                        changeScreen(totalGoldMedalsID);
                    if (e.getItem().toString().equals(medalsOption[1]))
                        changeScreen(totalSilverMedalsID);
                    if (e.getItem().toString().equals(medalsOption[2]))
                        changeScreen(totalBronzeMedalsID);
                    if (e.getItem().toString().equals(medalsOption[3]))
                        changeScreen(totalNoMedalsID);
                }
            }
        });
        playerInformationPanel.getPI_backbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(mainID);
            }
        });
        countryParticipationPanel.getCP_backbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(mainID);
            }
        });
        sportsCategoryPanel.getSC_backbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(mainID);
            }
        });
        medalsPanel.getM_backbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(mainID);
            }
        });
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
        cardPanel.add(playerInformationID, playerInformationPanel.getMainPanel());
        cardPanel.add(countryParticipationID, countryParticipationPanel.getMainPanel());
        cardPanel.add(sportsCategoryID, sportsCategoryPanel.getMainPanel());
        cardPanel.add(medalsID, medalsPanel.getMainPanel());
    }
}
