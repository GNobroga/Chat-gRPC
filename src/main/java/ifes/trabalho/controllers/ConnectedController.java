package ifes.trabalho.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ConnectedController {

    @FXML
    private Label nome;

    public void setNome(String nome) { this.nome.setText(nome); }

}
