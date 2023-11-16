package ifes.trabalho.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CommentController {

    @FXML
    private Label nome;

    @FXML
    private Label mensagem;

    public void setMensagem(String mensagem) {
        this.mensagem.setText(mensagem);
    }

    public void setNome(String nome) {
        this.nome.setText(nome);
    }

}
