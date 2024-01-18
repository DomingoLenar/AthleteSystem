package backend;

import java.io.*;
import java.util.Scanner;

public class FileHandler<T> {
    private Scanner scanner = null;

    public FileHandler(){

    }

    public T[] readCSVFile(File file){
        //insert logic of reading csv files

        return null;
    }

    public T[] readCSVFile(String filePath){
        try {
            File file = new File(filePath);
            scanner = new Scanner(file);


        }catch(FileNotFoundException fileNotFound){
            fileNotFound.printStackTrace();
        }
        return null;
    }

    public void saveToExcel(T[] arrayOfObject){
        // insert logic to save file using library that utilizes excel files
    }


}
