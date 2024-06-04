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
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class DocesController {

    @FXML
    private JFXButton infoButton;

    @FXML
    private JFXButton voltarButton;

    @FXML
    private ImageView kitkatImageView;

    @FXML
    private ImageView talentoImageView;

    @FXML
    private ImageView milkaImageView;

    @FXML
    public void initialize() {
        // Adicione a lógica de inicialização aqui, se necessário
    }

    @FXML
    private void infoButtonClick() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Instruções");
        alert.setHeaderText(null);
        alert.setContentText("Este sistema foi desenvolvido para que o usuário escolha entre 3 opções"
                + " de doces, com seus preços variados. Após escolher o doce desejado, o usuário pode"
                + " prosseguir com o pagamento, adicionando cada cédula de uma vez até que o valor do"
                + " doce escolhido seja atingido.");
        alert.showAndWait();
    }

    @FXML
    private void voltarButtonClick() {
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
    private void kitkatClick(MouseEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("kitkatInterface.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) kitkatImageView.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void talentoClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("talentoInterface.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) talentoImageView.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void milkaClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("milkaInterface.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) milkaImageView.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
