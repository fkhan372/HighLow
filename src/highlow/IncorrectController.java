package highlow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Faisal, Franklyn, Akhil
 */
public class IncorrectController implements Initializable {

    //Loading FXML fields
    @FXML
    public TextField highScore;
    public TextField score;
    public Button retryBtn;
    public Button mainMenuBtn;
    
    //Opens up the new game screen when the retry button is cliked
    public void retryBtnOnAction(ActionEvent event) throws IOException{
        //Closing current stage
        Stage stage = (Stage) retryBtn.getScene().getWindow();
        stage.close();
        //Opening the new game screen
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/highlow/NewGame.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage1 = new Stage();
        stage1.setTitle("New Game");
        stage1.setScene(new Scene(root));  
        stage1.show();
    }
    
    //Opens up the menu screen when the main menu button is clicked
    public void MainMenuBtnOnAction(ActionEvent event) throws IOException{
        //Closing current stage
        Stage stage = (Stage) mainMenuBtn.getScene().getWindow();
        stage.close();
        //Opening the menu screen
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/highlow/Menu.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage1 = new Stage();
        stage1.setTitle("Menu");
        stage1.setScene(new Scene(root));  
        stage1.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Reading data from highscore file and saving to the highscore textbox
        try {
            File myObj = new File("highscore.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              highScore.setText(data);
            }
        myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        
        //Reading data from score file and saving to the score textbox
        try {
            File myObj = new File("score.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              score.setText(data);
            }
        myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }    
    
}
