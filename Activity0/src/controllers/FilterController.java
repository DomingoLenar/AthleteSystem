package controllers;

import models.AthleteFileHandler;
import models.AthleteFilter;
import models.AthleteModel;
import models.AthleteStatistics;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FilterController {
    protected AthleteFilter athleteFilter;
    protected AthleteFileHandler athleteFileHandler;
    protected AthleteStatistics athleteStatistics;
    protected ArrayList<AthleteModel> arr_athleteModel;


    public FilterController(){
        this.athleteFilter = new AthleteFilter();
        this.athleteFileHandler = new AthleteFileHandler();
        this.athleteStatistics = new AthleteStatistics();
    }

    public int clickedMedalType(String medalType) {
        if (Objects.equals(medalType, "NA")) return athleteFilter.filterByMedal(arr_athleteModel, medalType).size();

        return athleteFilter.filterByMedal(arr_athleteModel, "\""+medalType+"\"").size();
    }

    public List<String> displayPlayerList() {
        return athleteFilter.listOfPlayers(arr_athleteModel);
    }
@Deprecated
    public ArrayList<String> listOfPlayers() { // longer execution time alternative is the listOfPlayers in AthleteFilter
        ArrayList<String> arr_players = new ArrayList<>();
        AthleteModel athleteModel;
        for (int i=0; i< arr_athleteModel.size(); i++) {
            athleteModel = arr_athleteModel.get(i);
            if (!arr_players.contains(athleteModel.getName())) {
                arr_players.add(athleteModel.getName());
            }
            System.out.println(i);
        }
        return arr_players;

/**
 * commented code lots of duplication
 */
//        String[] arr_players = new String[arr_athleteModel.size()];
//        AthleteModel athleteModel;
//        for (int i=0; i< arr_athleteModel.size(); i++) {
//            athleteModel = arr_athleteModel.get(i);
//            arr_players[i] = athleteModel.toString();
//        }
//
//        return arr_players;
    }
    public ArrayList<String> listOfCountries() {
        ArrayList<String> arr_countries = new ArrayList<>();

        for (int i=0; i<arr_athleteModel.size(); i++) {
            /**
             * if athlete model contains numerical then exclude
             */
//            if (arr_athleteModel.get(i).getTeam().matches(""))

            if (!arr_countries.contains(arr_athleteModel.get(i).getTeam())) {
                arr_countries.add(arr_athleteModel.get(i).getTeam());
            }
        }
        return arr_countries;
    }
    public ArrayList<String> listOfSports(){
        ArrayList<String> arr_sports = new ArrayList<>();

        for (int i=0; i< arr_athleteModel.size(); i++) {
            if (!arr_sports.contains(arr_athleteModel.get(i).getSport())) {
                arr_sports.add(arr_athleteModel.get(i).getSport());
            }
        }
        return arr_sports;
    }

    //Use AthleteStatistics.teamStatistics for this
    public long countryParticipation(String country) {
        List<AthleteModel> filteredByCountry = athleteFilter.filterByTeam(arr_athleteModel, country);
        return  athleteStatistics.teamStatistics(filteredByCountry).get(0);

//        int counter = 0;
//        for (int i=0; i< arr_athleteModel.size(); i++){
//            if (arr_athleteModel.get(i).getTeam().contains(country)) {
//                counter++;
//            }
//        }
//        return counter;
    }
    public long totalSport(String sport) {
        List<AthleteModel> filteredBySport = athleteFilter.filterBySport(arr_athleteModel, sport);

        return athleteStatistics.sportsStatistics(filteredBySport).get(1);
    }
    public void submitFile(File file) {
        arr_athleteModel = athleteFileHandler.readCSVFile(file.getAbsolutePath());
    }

//    public List<String> submitName(String name) {
//        List<AthleteModel> athleteModelList = athleteFilter.filterByName(arr_athleteModel, name);
//    }

//    public void playerStatistics(String name) {
//        List<AthleteModel> filteredByName = athleteFilter.filterByName(arr_athleteModel, name);
//        ArrayList<String> strings = athleteStatistics.getPlayerStatistics(filteredByName);
//        for (String s : strings) {
//            System.out.println(s);
//        }
//    }
}
