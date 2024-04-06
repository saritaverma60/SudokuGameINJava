package io.github.dvyadav.sudokufx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class WelcomePageUIController implements Initializable {

    @FXML
    StackPane backgroundStackPane;
    
    @FXML
    GridPane buttonsGridPane;

    @FXML
    Button newGameButton;
    @FXML
    Button loadPreviousButton;
    @FXML
    Button settingsButton;
    @FXML
    Button quitButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Resize the buttons' width according to the window(Stackpane) size
        newGameButton.prefWidthProperty().bind(backgroundStackPane.widthProperty().divide(3));
        loadPreviousButton.prefWidthProperty().bind(backgroundStackPane.widthProperty().divide(3));
        settingsButton.prefWidthProperty().bind(backgroundStackPane.widthProperty().divide(3));
        quitButton.prefWidthProperty().bind(backgroundStackPane.widthProperty().divide(3));        
        
        // Resize the buttons' height according to the window(Gridpane) size
        newGameButton.prefHeightProperty().bind(buttonsGridPane.heightProperty().divide(4.7));
        loadPreviousButton.prefHeightProperty().bind(buttonsGridPane.heightProperty().divide(4.7));
        settingsButton.prefHeightProperty().bind(buttonsGridPane.heightProperty().divide(4.7));
        quitButton.prefHeightProperty().bind(buttonsGridPane.heightProperty().divide(4.7));
    }
    
}
