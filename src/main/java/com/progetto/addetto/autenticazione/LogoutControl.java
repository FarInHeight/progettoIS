package com.progetto.addetto.autenticazione;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Classe che implementa la control {@code LogoutControl}
 */
public class LogoutControl {
    /**
     * istanzia un oggetto di tipo {@code LogoutControl}
     * @param event evento di pressione del tasto logout
     * @throws IOException se il caricamento del file fxml della schermata principale non è andato a buon fine
     */
    public LogoutControl(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //ottiene stage corrente
        SchermataLoginForm schermataLoginForm = new SchermataLoginForm();
        Stage stageLogin = new Stage();
        schermataLoginForm.start(stageLogin);
        stage.close();
    }
}
