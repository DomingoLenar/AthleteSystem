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
//                int id = Integer.parseInt(rawData[0].replaceAll("\"", ""));
                String id1 = rawData[0];
                String name = rawData[1];
//                char sex = rawData[2].charAt(0);
                String sex1 = rawData[2];
//                int age = Integer.parseInt(rawData[3]);
                String age1 = rawData[3];
//                int height = Integer.parseInt(rawData[4]);
                String height1 =rawData[4];
//                int weight = Integer.parseInt(rawData[5]);
                String weight1 = rawData[5];
                String team = rawData[6];
                String games = rawData[8];
                String city = rawData[11];
                String sport = rawData[12];
                String medal = rawData[14];
                athletes.add(new AthleteModel(id1, name, sex1, age1, height1, weight1, team, games, city, sport, medal));
            }
            return athletes;
        }catch(FileNotFoundException fileNotFound){
            fileNotFound.printStackTrace();
        }
        return null;
    }

    public void saveToExcel(ArrayList<AthleteModel> arrayOfObject){
        // insert logic to save file using library that utilizes excel files
    }
}
