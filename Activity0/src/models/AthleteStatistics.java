package models;

import java.util.ArrayList;
import java.util.List;


public class AthleteStatistics {

    /**
     *
     * @param filteredArrayList
     * @return
     */
    public ArrayList<String> getPlayerStatistics(List<AthleteModel> filteredArrayList){
        ArrayList<String> statistics = new ArrayList<>();
        long gamesPlayed = filteredArrayList.stream()
                .map(AthleteModel::getGames)
                .distinct()
                .count();

        long goldMedals = filteredArrayList.stream()
                .filter(athleteModel -> athleteModel.getMedal().equalsIgnoreCase("gold"))
                .count();

        long silverMedals = filteredArrayList.stream()
                .filter(athleteModel -> athleteModel.getMedal().equalsIgnoreCase("silver"))
                .count();

        long bronzeMedals = filteredArrayList.stream()
                .filter(athleteModel -> athleteModel.getMedal().equalsIgnoreCase("bronze"))
                .count();

        statistics.add(String.valueOf(gamesPlayed));
        statistics.add(String.valueOf(goldMedals));
        statistics.add(String.valueOf(silverMedals));
        statistics.add(String.valueOf(bronzeMedals));

        return statistics;
    }

    //Should filter the List first using AthleteFilter
    public ArrayList<Long> teamStatistics(List<AthleteModel> filteredList){
        ArrayList<Long> statistics = new ArrayList<>();

        long players = filteredList.stream()
                .map(AthleteModel::getId)
                .distinct()
                .count();

        long goldMedals = filteredList.stream()
                .filter(athleteModel -> athleteModel.getMedal().equalsIgnoreCase("gold"))
                .count();

        long silverMedals = filteredList.stream()
                .filter(athleteModel -> athleteModel.getMedal().equalsIgnoreCase("silver"))
                .count();

        long bronzeMedals = filteredList.stream()
                .filter(athleteModel -> athleteModel.getMedal().equalsIgnoreCase("bronze"))
                .count();

        long sports = filteredList.stream()
                .map(AthleteModel::getSport)
                .distinct()
                .count();

        long games = filteredList.stream()
                .map(AthleteModel::getGames)
                .distinct()
                .count();

        statistics.add(players);
        statistics.add(sports);
        statistics.add(games);
        statistics.add(goldMedals);
        statistics.add(silverMedals);
        statistics.add(bronzeMedals);

        return statistics;
    }

    public ArrayList<Long> sportsStatistics(List<AthleteModel> filteredList){
        ArrayList<Long> statistics = new ArrayList<>();
        long teamCount = filteredList.stream()
                .map(AthleteModel::getTeam)
                .distinct()
                .count();
        long playerCount = filteredList.stream()
                .map(AthleteModel::getId)
                .distinct()
                .count();
        long goldMedals = filteredList.stream()
                .filter(athleteModel -> athleteModel.getMedal().equalsIgnoreCase("gold"))
                .count();

        long silverMedals = filteredList.stream()
                .filter(athleteModel -> athleteModel.getMedal().equalsIgnoreCase("silver"))
                .count();

        long bronzeMedals = filteredList.stream()
                .filter(athleteModel -> athleteModel.getMedal().equalsIgnoreCase("bronze"))
                .count();

        long sports = filteredList.stream()
                .map(AthleteModel::getSport)
                .distinct()
                .count();

        statistics.add(teamCount);
        statistics.add(playerCount);
        statistics.add(sports);
        statistics.add(goldMedals);
        statistics.add(silverMedals);
        statistics.add(bronzeMedals);

        return statistics;
    }

    public ArrayList<Long> medalStatistics(List<AthleteModel> filteredList){
        ArrayList<Long> statistics = new ArrayList<>();

        long goldMedals = filteredList.stream()
                .filter(athleteModel -> athleteModel.getMedal().equalsIgnoreCase("gold"))
                .count();

        long silverMedals = filteredList.stream()
                .filter(athleteModel -> athleteModel.getMedal().equalsIgnoreCase("silver"))
                .count();

        long bronzeMedals = filteredList.stream()
                .filter(athleteModel -> athleteModel.getMedal().equalsIgnoreCase("bronze"))
                .count();

        statistics.add(goldMedals);
        statistics.add(silverMedals);
        statistics.add(bronzeMedals);

        return statistics;
    }
}
