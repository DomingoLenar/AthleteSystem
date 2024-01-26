package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AthleteFilter {

    /**
     * This method filters an array list of AthleteModel by the athletes name
     * @param arrayList     ArrayList of AthleteModel
     * @param playerName    Name of the player to be used as a filter in the ArrayList
     * @return              Returns a filtered List of AthleteModel
     */
    public List<AthleteModel> filterByName(ArrayList<AthleteModel> arrayList, String playerName){
        List<AthleteModel> filtered = null;
        filtered = arrayList.stream()
                .filter(athleteModel -> athleteModel.getName().equals(playerName))
                .collect(Collectors.toList());

        return filtered;
    }

    /**
     * This method filters an array list of AthleteModel by the name of a Team
     * @param arrayList     ArrayList of AthleteModel to be filtered
     * @param teamName      String of team name to be used to filter the ArrayList
     * @return              Returns a List of AthleteModel that has been filtered using teamName
     */
    public List<AthleteModel> filterByTeam(ArrayList<AthleteModel> arrayList, String teamName){
        List<AthleteModel> filtered = null;
        filtered = arrayList.stream()
                .filter(athleteModel -> athleteModel.getTeam().equals(teamName))
                .collect(Collectors.toList());
        return filtered;
    }

    /**
     * This method filters an ArrayList of AthleteModel by games
     * @param arrayList     ArrayList of AthleteModel to be filtered
     * @param game          String game to be used as a filter for the ArrayList
     * @return              Returns a List of AthleteModel that has been filtered using game
     */
    public List<AthleteModel> filterByGames(ArrayList<AthleteModel> arrayList, String game){
        List<AthleteModel> filtered = null;
        filtered = arrayList.stream()
                .filter(athleteModel -> athleteModel.getGames().equals(game))
                .collect(Collectors.toList());
        return filtered;
    }

    /**
     *This method filters an ArrayList of AthleteModel by sport
     * @param arrayList     ArrayList of AthleteModel to be filtered
     * @param sport         String of sport to be used as a filter for the ArrayList
     * @return              Returns a List of AthleteModel that has been filtered using sport
     */
    public List<AthleteModel> filterBySport(ArrayList<AthleteModel> arrayList, String sport){
        List<AthleteModel> filtered = null;
        filtered = arrayList.stream()
                .filter(athleteModel -> athleteModel.getSport().equals(sport))
                .collect(Collectors.toList());
        return filtered;
    }

    /**
     *This method filters an ArrayList of AthleteModel and takes all the medal winners
     * @param arrayList     ArrayList of AthleteModel to be filtered
     * @return              Returns a List of List that with the index being List of Gold winners, followed by Silver and Bronze
     */
    public List<List<AthleteModel>> filterByMedal(ArrayList<AthleteModel> arrayList){
        ArrayList<List<AthleteModel>> listOfMedals = new ArrayList<>();

        List<AthleteModel> goldMedals = arrayList.stream()
                .filter(athleteModel -> athleteModel.getMedal().equalsIgnoreCase("gold"))
                .collect(Collectors.toList());
        listOfMedals.add(goldMedals);

        List<AthleteModel> silverMedals = arrayList.stream()
                .filter(athleteModel -> athleteModel.getMedal().equalsIgnoreCase("silver"))
                .collect(Collectors.toList());
        listOfMedals.add(silverMedals);

        List<AthleteModel> bronzeMedals = arrayList.stream()
                .filter(athleteModel -> athleteModel.getMedal().equalsIgnoreCase("bronze"))
                .collect(Collectors.toList());
        listOfMedals.add(bronzeMedals);

        return listOfMedals.stream().toList();
    }

    /**
     *A method that filters an ArrayList of AthleteModel by the medal given
     * @param arrayList     ArrayList of AthleteModel to be filtered
     * @param medalType     String of medal to be used as a filter (Gold, Silver, Bronze)
     * @return              Returns a List of AthleteModel that has a given medal won
     */
    public List<AthleteModel> filterByMedal(ArrayList<AthleteModel> arrayList, String medalType){
        List<AthleteModel> filtered = null;

        filtered = arrayList.stream()
                .filter(athleteModel -> athleteModel.getMedal().equalsIgnoreCase(medalType))
                .collect(Collectors.toList());

        return filtered;
    }

}
