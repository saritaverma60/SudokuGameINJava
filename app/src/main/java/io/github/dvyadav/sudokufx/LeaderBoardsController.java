package io.github.dvyadav.sudokufx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class LeaderBoardsController implements Initializable{

    @FXML
    Button backButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    //    TODO: make leaderboards control felxible to screen size
        System.out.println(">>>loaded");
    }
    
}
