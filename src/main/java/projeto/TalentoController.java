package projeto;
import java.io.IOException;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class TalentoController {

    @FXML
    private JFXButton cancelarButton;

    @FXML
    private ImageView umRealImageView;

    @FXML
    private ImageView doisReaisImageView;

    @FXML
    private ImageView cincoReaisImageView;

    @FXML
    private TextArea saldoTotal;

    private double saldoAtual = 0.00;
    private final double precoDoce = 7.00;

    @FXML
    public void initialize() {
        // Adicione a lógica de inicialização aqui, se necessário
        atualizarSaldo();
    }

    @FXML
    private void umRealClick() {
        adicionarSaldo(1.00);
    }

    @FXML
    private void doisReaisClick() {
        adicionarSaldo(2.00);
    }

    @FXML
    private void cincoReaisClick() {
        adicionarSaldo(5.00);
    }

    @FXML
    private void cancelarButtonClick() {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Compra Cancelada");
        alert.setHeaderText("Operação cancelada. O valor acumulado será devolvido.");
        alert.setContentText(String.format("A compra do Talento foi cancelada."
        		+ " Devolução de: R$%.2f", saldoAtual));
        alert.showAndWait();
        saldoAtual = 0.00;
        atualizarSaldo();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("maquinaDocesInterface.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            
            Stage stage = (Stage) cancelarButton.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void adicionarSaldo(double valor) {
        saldoAtual += valor;
        atualizarSaldo();
        verificarCompra();
    }

    private void atualizarSaldo() {
        saldoTotal.setText(String.format("R$%.2f", saldoAtual));
    }

    private void verificarCompra() {
        if (saldoAtual >= precoDoce) {
            double troco = saldoAtual - precoDoce;
            exibirMensagemSucesso(troco);
            saldoAtual = 0.00;
            atualizarSaldo();
        }
    }

    private void exibirMensagemSucesso(double troco) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Compra Realizada");
        alert.setHeaderText("Parabéns! Compra realizada com sucesso.");
        alert.setContentText(String.format("O Talento foi comprado com sucesso! Seu troco é: R$%.2f", troco));
        alert.showAndWait();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("maquinaDocesInterface.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            
            Stage stage = (Stage) cancelarButton.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
