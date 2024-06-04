package io.github.dvyadav.sudokufx;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class WelcomePageController implements Initializable {

    private ExecutorService executorService = Executors.newCachedThreadPool();

    private GridNumbers gridNumbers = new GridNumbers();
    private int[][] gridNumbersArray = gridNumbers.getGridNumbersArray();

    private int gameDifficulty = 3;/* <--- TODO: set it to 0 */
    boolean returnValueDifficultyMethod = true; //declared here only beacuse of scope limitations

    @FXML
    StackPane backgroundStackPane;
    
    @FXML
    GridPane buttonsGridPane;

    @FXML
    Button newGameButton;
    @FXML
    Button loadPreviousButton;
    @FXML
    Button leaderboardsButton;
    @FXML
    Button settingsButton;
    @FXML
    Button quitButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Resize the buttons' width according to the window(Stackpane) size
        newGameButton.prefWidthProperty().bind(backgroundStackPane.widthProperty().divide(3));
        loadPreviousButton.prefWidthProperty().bind(backgroundStackPane.widthProperty().divide(3));
        leaderboardsButton.prefWidthProperty().bind(backgroundStackPane.widthProperty().divide(3));
        settingsButton.prefWidthProperty().bind(backgroundStackPane.widthProperty().divide(3));
        quitButton.prefWidthProperty().bind(backgroundStackPane.widthProperty().divide(3));        
        
        // Resize the buttons' height according to the window(Gridpane) size
        newGameButton.prefHeightProperty().bind(buttonsGridPane.heightProperty().divide(6));
        loadPreviousButton.prefHeightProperty().bind(buttonsGridPane.heightProperty().divide(6));
        leaderboardsButton.prefHeightProperty().bind(buttonsGridPane.heightProperty().divide(6));
        settingsButton.prefHeightProperty().bind(buttonsGridPane.heightProperty().divide(6));
        quitButton.prefHeightProperty().bind(buttonsGridPane.heightProperty().divide(6));
    }
    
    
    public void setNewGame(ActionEvent e)throws Exception{

        //sets difficulty and return false if not choosen any level

        setDifficulty();
    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameGridUI.fxml"));
        Parent root = loader.load(); //also creates controller object

        //this object helps to access the gridNumber array of sudoku at GameGridPage
        GameGridController gameGridController = loader.getController();
        gameGridController.setGameGridSolutionArray(getCloneArrayOf(gridNumbersArray));
        gameGridController.setGridNumbers(gridNumbers);
        
        if(gameDifficulty == 1){
            //easy mode
            gameGridController.setGameGridNumberArray(getGameGridArray(gameDifficulty * 3 - 1));
        }else if(gameDifficulty == 2){
            //averageMode
            gameGridController.setGameGridNumberArray(getGameGridArray(gameDifficulty * 3 - 3));
        }else if (gameDifficulty == 3){
            //hard mode
            gameGridController.setGameGridNumberArray(getGameGridArray(gameDifficulty * 3 - 4));
        }

        Stage primaryStage = (Stage)(((Node)(e.getSource())).getScene().getWindow());
        primaryStage.setScene(new Scene(root));
        primaryStage.setMaximized(false); // resolves the
        primaryStage.setMaximized(true);  // smallscreen bug
        primaryStage.show();



    }

    public void setDifficulty(){
       
        // open new window

    }

    public void loadPreviousMatch(ActionEvent e){

    }

    public void showLeaderboards(ActionEvent e){

    }

    public void showSettings(ActionEvent e){

    }

    public void quitApp(ActionEvent e){

    }

    // removes the numbers from the array according to difficulty and desired pattern
    public int[][] getGameGridArray(int numberOfElementsToHide){
        int[][] modifiedGridNumber = getCloneArrayOf(gridNumbersArray);

        // pattern in center block grid
        if((((int)(Math.random() *2) + 1) % 2) == 0){
            //even random
            modifiedGridNumber[3][4] = modifiedGridNumber[4][3] =
            modifiedGridNumber[5][4] = modifiedGridNumber[4][5] = 0;
        }
        else{
            modifiedGridNumber[3][3] = modifiedGridNumber[3][5] =
            modifiedGridNumber[4][4] = modifiedGridNumber[5][3] = 
            modifiedGridNumber[5][5] = 0;

        }

        // pattern in ret of blocks
        if(numberOfElementsToHide == 2){
            modifiedGridNumber[1][2] = modifiedGridNumber[2][1] =
            modifiedGridNumber[1][6] = modifiedGridNumber[6][1] =
            modifiedGridNumber[2][7] = modifiedGridNumber[7][2] =
            modifiedGridNumber[6][7] = modifiedGridNumber[7][6] =
            modifiedGridNumber[0][4] = modifiedGridNumber[1][4] =
            modifiedGridNumber[4][7] = modifiedGridNumber[4][8] =
            modifiedGridNumber[7][4] = modifiedGridNumber[8][4] =
            modifiedGridNumber[4][0] = modifiedGridNumber[4][1] = 0;
        }
        else if(numberOfElementsToHide == 3){
            modifiedGridNumber[0][1] = modifiedGridNumber[1][0] = modifiedGridNumber[1][1] =
            modifiedGridNumber[1][4] = modifiedGridNumber[2][3] = modifiedGridNumber[2][5] =
            modifiedGridNumber[0][7] = modifiedGridNumber[1][7] = modifiedGridNumber[1][8] =
            modifiedGridNumber[3][6] = modifiedGridNumber[5][6] = modifiedGridNumber[4][7] =
            modifiedGridNumber[7][7] = modifiedGridNumber[7][8] = modifiedGridNumber[8][7] =
            modifiedGridNumber[6][3] = modifiedGridNumber[6][5] = modifiedGridNumber[7][4] =
            modifiedGridNumber[7][0] = modifiedGridNumber[7][1] = modifiedGridNumber[8][1] =
            modifiedGridNumber[5][2] = modifiedGridNumber[4][1] = modifiedGridNumber[3][2] = 0;
        }
        else if (numberOfElementsToHide == 5){

            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                        // skip center block                        skip odd places
                    if(((i > 2 && i < 6) && (j > 3 && j < 6)) || ( (i + j) % 2 != 0 ))
                        continue;
                    else // zero to rest at even places
                        modifiedGridNumber[i][j] = 0;
                }
            }
        }

        return modifiedGridNumber;
    }

    public int[][] getCloneArrayOf(int[][] arrayTobeCloned){
        int[][] clonedArray = new int[9][9];

        for (int i = 0; i < clonedArray.length; i++) {
            for (int j = 0; j < clonedArray.length; j++) {
                clonedArray[i][j] = arrayTobeCloned[i][j];
            }
        }

        return clonedArray;
    }


}

/* 1-> welcome page
 *      new game  ----> ask for difficluty ---> GameGrid
 *      load previous --> GameGrid
 *       Leaderboards ---> leaderboardsUI
 *      settings ----> settingsUI
 *      quit ---->system.exit
 */