package models;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class AthleteFileHandler implements FileHandlerInterface<AthleteModel> {
    private Scanner scanner = null;

    public AthleteFileHandler(){

    }


    public ArrayList<AthleteModel> readCSVFile(String filePath){
        try {
            File file = new File(filePath);
            scanner = new Scanner(file);

            scanner.nextLine();

            ArrayList<AthleteModel> athletes = new ArrayList<>();
            while(scanner.hasNext()){
                String[] rawData = scanner.nextLine().split(",");
                int id = Integer.parseInt(rawData[0]);
                String name = rawData[1];
                char sex = rawData[2].charAt(0);
                int age = Integer.parseInt(rawData[3]);
                int height = Integer.parseInt(rawData[4]);
                int weight = Integer.parseInt(rawData[5]);
                String team = rawData[6];
                String games = rawData[8];
                String city = rawData[11];
                String sport = rawData[12];
                String medal = rawData[14];
                athletes.add(new AthleteModel(id, name, sex, age, height, weight, team, games, city, sport, medal));
            }
            return null;
        }catch(FileNotFoundException fileNotFound){
            fileNotFound.printStackTrace();
        }
        return null;
    }

    public void saveToExcel(ArrayList<AthleteModel> arrayOfObject){
        // insert logic to save file using library that utilizes excel files
    }
}
