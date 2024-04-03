package io.github.dvyadav.sudokufx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class GameGridController implements Initializable {

    @FXML
    StackPane backgroungStackPane;

    @FXML
    BorderPane baseBorderPane;

    @FXML
    AnchorPane leftAnchorPaneOnBorderPane;

    @FXML
    AnchorPane rightAnchorPaneOnBorderPane;

    @FXML
    GridPane parentNumberGridPane;

    @FXML
    GridPane numberButtonGridPane;

    @FXML
    GridPane controlButtonGridPane;



    


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Resize the anchorPane according to the main StackPane in background
        leftAnchorPaneOnBorderPane.prefWidthProperty().bind(backgroungStackPane.widthProperty().multiply(0.6));
        rightAnchorPaneOnBorderPane.prefWidthProperty().bind(backgroungStackPane.widthProperty().multiply(0.4));

        // Resize the sudoku grid according to its container size
        parentNumberGridPane.prefWidthProperty().bind(leftAnchorPaneOnBorderPane.widthProperty().multiply(0.78));/* TODO:A Find better rate-ratio of the grid with anchorpane */

        parentNumberGridPane.prefHeightProperty().bind(parentNumberGridPane.widthProperty()); //makes sure that height also increases
        
        // Resize the button grid according to the conatiner
        numberButtonGridPane.prefWidthProperty().bind(leftAnchorPaneOnBorderPane.widthProperty().multiply(0.78));
        controlButtonGridPane.prefWidthProperty().bind(rightAnchorPaneOnBorderPane.widthProperty().multiply(0.85));
        

        
    }
    
}
