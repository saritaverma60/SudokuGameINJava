package io.github.dvyadav.sudokufx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class GameGridController implements Initializable {

    GridNumbers gridNumbers;

    //values already set from Weclome Page controller
    int[][] gameGridNumberArray;
    int[][] gameGridSolutionArray;

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

    @FXML
    Button printButton;


    public void setGridNumbers(GridNumbers gridNumbers){
        this.gridNumbers = gridNumbers;
    }

    public void setGameGridNumberArray(int[][] gameGridNumber){
        this.gameGridNumberArray = gameGridNumber;
    }

    public void setGameGridSolutionArray(int[][] gameGridSolution){
        this.gameGridSolutionArray = gameGridSolution;
    }


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

    
    public void print(){
        for (int i = 0; i < gameGridNumberArray.length; i++) {
            for (int j = 0; j < gameGridNumberArray.length; j++) {
                System.out.print(gameGridNumberArray[i][j] +", ");
            }
        }

        System.out.println("\n\n");

        for (int i = 0; i < gameGridSolutionArray.length; i++) {
            for (int j = 0; j < gameGridSolutionArray.length; j++) {
                System.out.print(gameGridSolutionArray[i][j] +", ");
            }
        }
    }
    
}
