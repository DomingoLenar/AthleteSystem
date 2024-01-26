package controllers;

import models.AthleteFileHandler;
import models.AthleteFilter;
import models.AthleteModel;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class FilterController {
    protected AthleteFilter athleteFilter;
    protected AthleteFileHandler athleteFileHandler;
    protected ArrayList<AthleteModel> arr_athleteModel;


    public FilterController(){
        this.athleteFilter = new AthleteFilter();
        this.athleteFileHandler = new AthleteFileHandler();
    }

    public int clickedMedalType(String medalType) {
        if (Objects.equals(medalType, "NA")) return athleteFilter.filterByMedal(arr_athleteModel, medalType).size();

        return athleteFilter.filterByMedal(arr_athleteModel, "\""+medalType+"\"").size();
    }

    public String[] listOfPlayers() {
        String[] arr_players = new String[arr_athleteModel.size()];
        AthleteModel athleteModel;
        for (int i=0; i< arr_athleteModel.size(); i++) {
            athleteModel = arr_athleteModel.get(i);
            arr_players[i] = athleteModel.toString();
        }
        return arr_players;
    }
    public void submitFile(File file) {
        arr_athleteModel = athleteFileHandler.readCSVFile(file.getAbsolutePath());
    }

    public ArrayList<AthleteModel> getArr_athleteModel() {
        return arr_athleteModel;
    }
}
