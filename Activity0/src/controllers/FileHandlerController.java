package controllers;

import models.AthleteModel;
import views.GUI;

import java.io.File;

public class FileHandlerController {
    protected GUI gui;
    protected AthleteModel model;

    /**
     * Established a connection of views and models through controller
     * @param gui
     */
    public FileHandlerController(GUI gui) {
        this.gui = gui;
        this.model = new AthleteModel();
    }

    public void submitFile(File file) {
        // checks if it is an excel file otherwise prompt an error message
        // model process the submitted file
    }
}
