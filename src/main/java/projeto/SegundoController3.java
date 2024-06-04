package projeto;
import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SegundoController3 {

    @FXML
    private JFXButton voltarButton;

    @FXML
    private JFXButton infoButton;

    @FXML
    private JFXButton thirdFloorButton;

    @FXML
    private JFXButton secondFloorButton;

    @FXML
    private JFXButton firstFloorButton;

    @FXML
    private JFXButton groundFloorButton;

    @FXML
    private JFXTextArea statusTextArea;

    @FXML
    private ImageView portaImageView;

    @FXML
    public void voltarButtonClick() {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainInterface.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) voltarButton.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void infoButtonClick() {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Instruções");
        alert.setHeaderText(null);
        alert.setContentText("Este sistema foi desenvolvido como um simulador do funcionamento de um elevador"
        		+ " tradicional, onde o usuário dispoe de todas as funcionalidades que ele normalmente teria"
        		+ " ao usar um elevador, como chamar para o andar atual e se locomover entre os 3 andares"
        		+ " disponíveis.");
        alert.showAndWait();    
        }
	

    @FXML
    private void thirdFloorButtonClick() {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Trajetória");
        alert.setHeaderText(null);
        alert.setContentText("Você escolheu o 3° andar como destino:\n"
        		+ " >o elevador chega no terceiro andar.");
        alert.showAndWait();  
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("elevadorTerceiroDentroInterfacePA.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) voltarButton.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    @FXML
    private void secondFloorButtonClick() {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Você está no 2° andar");
        alert.setHeaderText(null);
        alert.setContentText("Erro: você já está no andar escolhido como destino.");
        alert.showAndWait(); 
    }

    @FXML
    private void firstFloorButtonClick() {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Trajetória");
        alert.setHeaderText(null);
        alert.setContentText("Você escolheu o 1° andar como destino:\n"
        		+ " >o elevador chega no primeiro andar.");
        alert.showAndWait();  
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("elevadorPrimeiroDentroInterfacePA.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) voltarButton.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @FXML
    private void groundFloorButtonClick() {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Trajetória");
        alert.setHeaderText(null);
        alert.setContentText("Você escolheu o Térreo como destino:\n"
        		+ " >o elevador passa pelo primeiro andar\n"
        		+ " >o elevador chega no térreo.");
        alert.showAndWait();  
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("elevadorTerreoDentroInterfacePA.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) voltarButton.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    @FXML
    private void portaImageViewClicked(MouseEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("elevadorSegundoForaInterfacePF.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) voltarButton.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}

