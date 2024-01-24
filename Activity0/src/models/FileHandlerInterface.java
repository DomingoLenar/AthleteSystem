package models;

import java.util.ArrayList;

public interface FileHandlerInterface<T> {
    public ArrayList<T> readCSVFile(String filePath);
    public void saveToExcel(ArrayList<T> arrayOfObject);
}
