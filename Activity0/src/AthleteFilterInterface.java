import controllers.FilterController;
import models.AthleteModel;
import views.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Objects;

public class AthleteFilterInterface extends JFrame {

    private FilterController filterController;
    private String selectFileID = "selectFile_ID";
    private final String chooseFileID = "chooseFile_id";
    private final String mainID = "main_id";
    private final String playerInformationID = "playerInformation_id";
    private final String playerMetricID = "playerMetric_id";
    private final String countryParticipationID = "countryParticipation_id";
    private final String sportsCategoryID = "sports_id";
    private final String medalsID = "medals_id";
    private final String medalMetricsID = "medal_metrics_id";
    private JPanel cardPanel;
    private SelectFile selectFile;
    private ChooseFile chooseFile;
    private MainMenu mainMenu;
    private AthletesPanel playerInformationPanel;
    private PlayerMetricsPanel playerMetricsPanel;
    private CountryParticipationPanel countryParticipationPanel;
    private SportsCategoryPanel sportsCategoryPanel;
    private MedalsPanel medalsPanel;
    private MedalMetricsPanel medalMetricsPanel;

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
        setSize(800, 400);
        setVisible(true);
    }

    private void initComponents() {
        mainMenu = new MainMenu();

        initPanels();
        initButtons();

    }

    private void initPanels() {
        filterController = chooseFile.getFilterController();

        playerInformationPanel = new AthletesPanel();
        playerMetricsPanel = new PlayerMetricsPanel();
        countryParticipationPanel = new CountryParticipationPanel();
        sportsCategoryPanel = new SportsCategoryPanel();
        medalsPanel = new MedalsPanel();
        medalMetricsPanel = new MedalMetricsPanel();
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
        String[] PI_options = filterController.listOfPlayers();
        playerInformationPanel.populatePI_dropdown(filterController.listOfPlayers());
        playerInformationPanel.getPI_dropdown().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    for (String option : PI_options) {
                        if (e.getItem().toString().equals(option)){
                            String[] temp_arr = option.split(",");
                            playerMetricsPanel.getIdValue().setText(temp_arr[0]);
                            playerMetricsPanel.getPlayerNameLabel().setText(temp_arr[5]);
                            playerMetricsPanel.getSportValue().setText(temp_arr[9]);
                            playerMetricsPanel.getCountryValue().setText(temp_arr[6]);

                            if (!Objects.equals(temp_arr[10], "NA")){
                                switch (temp_arr[10]){
                                    case "Gold":
                                        playerMetricsPanel.getGoldValue().setText(String.valueOf(1));
                                        break;
                                    case "Silver":
                                        playerMetricsPanel.getSilverValue().setText(String.valueOf(1));
                                        break;
                                    case "Bronze":
                                        playerMetricsPanel.getBronzeValue().setText(String.valueOf(1));
                                        break;
                                }
                            }

                            changeScreen(playerMetricID);
                            break;
                        }
                    }
                }
            }
        });

        String medalsOption[] = medalsPanel.getOptions();
        medalsPanel.getMedal_dropdown().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    changeScreen(medalMetricsID);
                    if (e.getItem().toString().equals(medalsOption[0])) {
                        medalMetricsPanel.getTotalMedalLabel().setText("Total Gold:");
                        int value = filterController.clickedMedalType(medalsOption[0]);
                        medalMetricsPanel.getTotalMedalValue().setText(String.valueOf(value));
                    }
                    if (e.getItem().toString().equals(medalsOption[1])) {
                        medalMetricsPanel.getTotalMedalLabel().setText("Total Silver:");
                        int value = filterController.clickedMedalType(medalsOption[1]);
                        medalMetricsPanel.getTotalMedalValue().setText(String.valueOf(value));
                    }
                    if (e.getItem().toString().equals(medalsOption[2])) {
                        medalMetricsPanel.getTotalMedalLabel().setText("Total Bronze:");
                        int value = filterController.clickedMedalType(medalsOption[2]);
                        medalMetricsPanel.getTotalMedalValue().setText(String.valueOf(value));
                    }
                    if (e.getItem().toString().equals(medalsOption[3])) {
                        medalMetricsPanel.getTotalMedalLabel().setText("Total No Medals:");
                        int value = filterController.clickedMedalType("NA");
                        medalMetricsPanel.getTotalMedalValue().setText(String.valueOf(value));
                    }
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

    private void displayPlayerMetricsPanel() {

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
        cardPanel.add(medalMetricsID, medalMetricsPanel.getMainPanel());
        cardPanel.add(playerMetricID, playerMetricsPanel.getMainPanel());

    }
}
