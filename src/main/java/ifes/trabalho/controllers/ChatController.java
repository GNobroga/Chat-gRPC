package ifes.trabalho.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.squareup.okhttp.internal.Platform;

import ifes.trabalho.proto.Mensagem;
import ifes.trabalho.proto.TrabalhoGrpc;
import ifes.trabalho.proto.Usuario;
import ifes.trabalho.proto.TrabalhoGrpc.TrabalhoBlockingStub;
import ifes.trabalho.proto.TrabalhoGrpc.TrabalhoStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.internal.Stream;
import io.grpc.stub.StreamObserver;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatController {

    private final String HOST = "localhost";
    private final Integer PORT = 8080;

    @FXML
    private Label quantidadeConexao;

    @FXML
    private FlowPane areaConectados;

    @FXML
    private TextField textFieldComentario;

    @FXML
    private ScrollPane scrollPaneComentario;

    @FXML
    private VBox areaComentario;

    private Stage chatScreen;

    private TrabalhoStub stub;

    private String yourName;

    private StreamObserver<Mensagem> mensagemObserver = new StreamObserver<Mensagem>() {

        @Override
        public void onNext(Mensagem value) {
            javafx.application.Platform.runLater(() -> {
                adicionarComentarioNaTela(value.getConteudo(), value.getRementente());
            });
        }

        @Override
        public void onError(Throwable t) {}

        @Override
        public void onCompleted() {}
        
    };

    private StreamObserver<Usuario> usuarioStream;


    @FXML
    void initialize() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(HOST, PORT)
            .usePlaintext()
            .build();
            
       stub = TrabalhoGrpc.newStub(channel);
       usuarioStream = stub.conectar(mensagemObserver);
    }

    public void adicionarComentarioNaTela(String comentario, String remetente) {
        try {
            FXMLLoader carregar = new FXMLLoader(getClass().getResource("../views/chat/comentario.fxml"));
            Parent conteudo = carregar.load();
            CommentController controller = carregar.getController();
            controller.setMensagem(comentario);
            controller.setNome(remetente);
            areaComentario.getChildren().add(conteudo);
        } catch (Exception erro) {
            erro.printStackTrace();
        }
    }

    @FXML
    void apertouEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER && !getComentario().trim().isEmpty()) {
            Mensagem mensagem = Mensagem.newBuilder().setRementente(yourName).setConteudo(getComentario()).build();
            new Thread(() -> {
                stub.enviarMensagem(mensagem, null);
            }).start();
            setComentario("");
        }
    }

    @FXML
    void botaoEnviar(MouseEvent event) {
        if (!getComentario().isEmpty()) {
              Mensagem mensagem = Mensagem.newBuilder().setRementente(yourName).setConteudo(getComentario()).build();
                new Thread(() -> {
                    stub.enviarMensagem(mensagem, null);
                }).start();
            setComentario("");
        }
    }

    @FXML
    void fechar(MouseEvent event) {
        if (Objects.nonNull(chatScreen)) chatScreen.close();
    }

    @FXML
    void minimizar(MouseEvent event) {
        if (Objects.nonNull(chatScreen)) chatScreen.setIconified(true);
        
    }

    public void setChatScreen(Stage screen) {
        chatScreen = screen;
    }

    public String getComentario() {
        return textFieldComentario.getText().trim();
    }

    public void setComentario(String comentario) {
        textFieldComentario.setText(comentario);
    }

    public void setYourName(String name) {
        yourName = name;
        Usuario usuario = Usuario.newBuilder().setNome(name).build();
        usuarioStream.onNext(usuario);
    }

}
