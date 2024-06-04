package projeto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import com.jfoenix.controls.JFXButton;

public class LexerController {

    @FXML
    private TextArea textOutput;

    @FXML
    private JFXButton infoButton;

    @FXML
    private JFXButton voltarButton;
    
    @FXML
    private JFXButton submitButton;

    @FXML
    private void selectFileButtonClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecionar Arquivo");
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            // Atualiza a TextArea para mostrar o caminho do arquivo selecionado
            textOutput.setText("Arquivo selecionado: " + selectedFile.getAbsolutePath());
        }
    }

    @FXML
    private void submitButtonClick() {
        // Verifica se um arquivo foi previamente selecionado
        if (textOutput.getText() != null && !textOutput.getText().isEmpty()) {
            // Extrai o caminho do arquivo previamente selecionado da TextArea
            String filePath = textOutput.getText().replace("Arquivo selecionado: ", "");
            analyzeFile(filePath);
        } else {
            // Caso nenhum arquivo tenha sido selecionado previamente, exibe uma mensagem de erro
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Nenhum arquivo foi selecionado. Por favor, selecione um arquivo primeiro.");
            alert.showAndWait();
        }
    }

    private void analyzeFile(String filePath) {
        try {
            // Cria uma instância do Lexer e passa o conteúdo do arquivo como parâmetro
            Lexer lexer = new Lexer(Files.readString(Paths.get(filePath)));

            // Obtém os tokens da análise léxica
            List<Token> tokens = lexer.getTokens();

            // Formata os tokens para exibição na TextArea
            StringBuilder result = new StringBuilder();
            for (Token token : tokens) {
                result.append(token).append("\n");
            }

            // Atualiza o conteúdo da TextArea com os resultados
            textOutput.setText(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
            // Exibe uma mensagem de erro se houver problemas ao ler o arquivo
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void infoButtonClick() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Instruções");
        alert.setHeaderText(null);
        alert.setContentText("Este analizador léxico foi desenvolvido para que o usuário escolha um arquivo .txt"
                + " de sua máquina para ser analizado léxicamente como Java. O analizador retornará os tokens das"
                + " palavras presentes no arquivo previamente selecionado.");
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
}
