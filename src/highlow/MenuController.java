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
public class MenuController implements Initializable {
    
    //Loading FXML fields
    @FXML
    public TextField highScore;
    public Button newGameBtn;
    public Button rulesBtn;
    
    //Opens up the new game screen when the new game button is clicked
    public void newGameBtnOnAction(ActionEvent event) throws IOException{
        //Closing current stage
        Stage stage = (Stage) newGameBtn.getScene().getWindow();
        stage.close();
        //Opening the new game screen
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/highlow/NewGame.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage1 = new Stage();
        stage1.setTitle("New Game");
        stage1.setScene(new Scene(root));  
        stage1.show();
    }
    
    //Opens up the rules screen when the rules button is clicked
    public void rulesBtnOnAction(ActionEvent event) throws IOException{
        //Closing current stage
        Stage stage = (Stage) rulesBtn.getScene().getWindow();
        stage.close();
        //Opening the rules screen
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/highlow/Rules.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage1 = new Stage();
        stage1.setTitle("Rules");
        stage1.setScene(new Scene(root));  
        stage1.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Reading from the highscore file to display the current highest score
        try {
            File myObj = new File("highscore.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              highScore.setText(data);
            }
        myReader.close();
        System.out.println("Successfully read fom highscore.");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }    
    
}
