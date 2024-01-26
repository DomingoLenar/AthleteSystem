package backend;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AthleteFilter {

    public List<AthleteModel> filterByName(ArrayList<AthleteModel> arrayList, String playerName){
        List<AthleteModel> filtered = null;
        filtered = arrayList.stream()
                .filter(athleteModel -> athleteModel.getName().equals(playerName))
                .collect(Collectors.toList());

        return filtered;
    }

    public List<AthleteModel> filterByTeam(ArrayList<AthleteModel> arrayList, String teamName){
        List<AthleteModel> filtered = null;
        filtered = arrayList.stream()
                .filter(athleteModel -> athleteModel.getTeam().equals(teamName))
                .collect(Collectors.toList());
        return filtered;
    }

    public List<AthleteModel> filterByGames(ArrayList<AthleteModel> arrayList, String game){
        List<AthleteModel> filtered = null;
        filtered = arrayList.stream()
                .filter(athleteModel -> athleteModel.getGames().equals(game))
                .collect(Collectors.toList());
        return filtered;
    }

    public List<AthleteModel> filterBySport(ArrayList<AthleteModel> arrayList, String sport){
        List<AthleteModel> filtered = null;
        filtered = arrayList.stream()
                .filter(athleteModel -> athleteModel.getSport().equals(sport))
                .collect(Collectors.toList());
        return filtered;
    }

    public List<List<AthleteModel>> filterByMedal(ArrayList<AthleteModel> arrayList){
        ArrayList<List<AthleteModel>> listOfMedals = new ArrayList<>();

        List<AthleteModel> goldMedals = arrayList.stream()
                .filter(athleteModel -> athleteModel.getMedal().equalsIgnoreCase("gold"))
                .collect(Collectors.toList());
        listOfMedals.add(goldMedals);

        return listOfMedals.stream().toList();
    }

    public List<AthleteModel> filterByMedal(ArrayList<AthleteModel> arrayList, String medalType){
        List<AthleteModel> filtered = null;

        filtered = arrayList.stream()
                .filter(athleteModel -> athleteModel.getMedal().equalsIgnoreCase(medalType))
                .collect(Collectors.toList());

        return filtered;
    }

}
