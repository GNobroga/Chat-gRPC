package ifes.trabalho.controllers;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Arrays;
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
    private final String[] MEMBERS = { "Gabriel Cardoso", "Lívia", "Marcelo"};

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
                if (value.getNovoNome() != null && !value.getNovoNome().isEmpty()) {
                    yourName = value.getNovoNome();
                } else {
                       adicionarComentarioNaTela(value.getConteudo(), value.getRementente());
                    quantidadeConexao.setText(String.valueOf(value.getQntUsers()));
                    areaConectados.getChildren().clear();
                    value.getConectadosList().forEach(conectado -> adicionarUsuarioConectado(conectado));
                }
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

    // Boilerplate t.t
    // confundindo mt java com C#
    public void adicionarUsuarioConectado(String nome) {
         try {
            FXMLLoader carregar = new FXMLLoader(getClass().getResource("../views/chat/conectado.fxml"));
            Parent conteudo = carregar.load();
            ConnectedController controller = carregar.getController();
            controller.setNome(nome);
            areaConectados.getChildren().add(conteudo);
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
        Mensagem mensagem = Mensagem.newBuilder().setRementente(yourName).setSair(true).build();
         new Thread(() -> {
                stub.enviarMensagem(mensagem, null);
        }).start();
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
        Usuario usuario = Usuario.newBuilder().setNome(name).build();
        usuarioStream.onNext(usuario);
        ifes.trabalho.proto.Grupo grupo = ifes.trabalho.proto.Grupo.newBuilder()
            .addAllMembro(Arrays.asList(MEMBERS)).build();
        stub.enviarGrupo(grupo, null);
    }

}
