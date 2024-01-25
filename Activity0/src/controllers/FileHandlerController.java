package controllers;

import models.AthleteModel;
import views.ChooseFile;

import java.io.File;

public class FileHandlerController {
    protected ChooseFile gui;
    protected AthleteModel model;

    /**
     * Established a connection of views and models through controller
     * @param gui
     */
    public FileHandlerController(ChooseFile gui) {
        this.gui = gui;
        this.model = new AthleteModel();
    }

    public void submitFile(File file) {
        // checks if it is an excel file otherwise prompt an error message
        // model process the submitted file
    }
}
