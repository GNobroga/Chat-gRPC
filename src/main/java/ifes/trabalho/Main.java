package ifes.trabalho;

import java.io.IOException;

import javax.swing.JOptionPane;

import ifes.trabalho.controllers.ChatController;
import ifes.trabalho.services.TrabalhoServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private final Integer SERVER_PORT = 8080;

    public void start(Stage primaryStage) throws Exception {
        startServer();   // So um deve executar esse metodo para conversar
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("./views/chat/tela.fxml"));
        Parent root = loader.load();
        ChatController controller = loader.getController();
        String yourName = JOptionPane.showInputDialog(null, "Insira o seu nome: ");
        controller.setYourName(yourName);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        controller.setChatScreen(primaryStage);

        final double[] eixos = new double[2];

        scene.setOnMousePressed(event -> {
            eixos[0] = event.getSceneX();
            eixos[1] = event.getSceneY();
        });

        scene.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - eixos[0]);
            primaryStage.setY(event.getScreenY() - eixos[1]);
        });
        
        primaryStage.show();
    }

    public void startServer() {
         new Thread(() -> {
            Server server = ServerBuilder.forPort(SERVER_PORT)
            .addService(new TrabalhoServiceImpl())
            .build();
        
            try {
                server.start();
                server.awaitTermination();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String ...args) {
        launch(args);
    }


    // public static void main(String[] args)  {
        // new Thread(() -> {
        //     Server server = ServerBuilder.forPort(8080)
        //     .addService(new TrabalhoServiceImpl())
        //     .build();
        
        //     try {
        //         server.start();
        //          server.awaitTermination();
        //     } catch (IOException | InterruptedException e) {
        //         e.printStackTrace();
        //     }
           
    //     }).start();

    //     new Thread(() -> {
   
    //         Main.client();
            
    //     }).start();


    // }

    // public static void client() {
    //     ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
    //         .usePlaintext()
    //         .build();

    //     TrabalhoBlockingStub stub = TrabalhoGrpc.newBlockingStub(channel);

    //     Scanner sc = new Scanner(System.in);

    //     while(true) {
    //         System.out.println("Digite uma mensagem: ");
    //         String escrito = sc.nextLine();

    //         Mensagem mensagem = Mensagem.newBuilder().setConteudo(escrito).build();

    //         stub.enviarMensagem(mensagem);
    //     }
    // }

}

   

