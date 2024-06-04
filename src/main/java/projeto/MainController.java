package projeto;
import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private JFXButton case1Button;

    @FXML
    private JFXButton case2Button;

    @FXML
    private JFXButton case3Button;

    @FXML
    public void initialize() {
        // Adicione a lógica de inicialização aqui, se necessário
    }

    @FXML
    private void handleCase1ButtonClick(ActionEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("maquinaDocesInterface.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            
            Stage stage = (Stage) case1Button.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCase2ButtonClick(ActionEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("elevadorTerreoForaInterfacePF.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            
            Stage stage = (Stage) case1Button.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCase3ButtonClick() {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LexerInterface.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            
            Stage stage = (Stage) case1Button.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }    }
}
