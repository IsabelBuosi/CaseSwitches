package projeto;

import java.io.IOException;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PrimeiroController1 {

    @FXML
    private ImageView portaImageView;

    @FXML
    private JFXButton voltarButton;

    @FXML
    private JFXButton infoButton;

    @FXML
    public void portaImageViewClicked(MouseEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("elevadorPrimeiroDentroInterfacePF.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) portaImageView.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }    }

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
        alert.showAndWait();    }
	}
