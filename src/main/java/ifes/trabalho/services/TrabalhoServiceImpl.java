package ifes.trabalho.services;

import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JOptionPane;

import com.google.protobuf.ProtocolStringList;

import ifes.trabalho.proto.*;
import ifes.trabalho.proto.TrabalhoGrpc.TrabalhoImplBase;
import io.grpc.stub.StreamObserver;

public class TrabalhoServiceImpl extends TrabalhoImplBase {

    private Map<String, StreamObserver<Mensagem>> users = new ConcurrentHashMap<>();

    @Override
    public StreamObserver<Usuario> conectar(StreamObserver<Mensagem> responseObserver) {
        return new StreamObserver<Usuario>() {
            @Override
            public void onNext(Usuario request) {
                String nome = request.getNome();

                if (!users.containsKey(nome)) {
                    users.put(nome, responseObserver);

                    Mensagem mensagem = Mensagem.newBuilder()
                            .setConteudo("Bem-vindo, " + nome + "!")
                            .build();

                    enviarMensagem(mensagem, null);
                }
            }

            @Override
            public void onError(Throwable t) {}

            @Override
            public void onCompleted() { responseObserver.onCompleted(); }
        };
    }
    
    @Override
    public void enviarMensagem(Mensagem request,
        io.grpc.stub.StreamObserver<ifes.trabalho.proto.Empty> responseObserver) {
            for(StreamObserver<Mensagem> observer: users.values()) {
                Mensagem mensagem = Mensagem.newBuilder()
                    .setRementente(request.getRementente())
                    .setConteudo(request.getConteudo())
                    .setQntUsers(users.size())
                    .addAllConectados(users.keySet())
                    .build();
            
               observer.onNext(mensagem);
            }
    }

    @Override
    public void enviarGrupo(Grupo request,
        io.grpc.stub.StreamObserver<ifes.trabalho.proto.Empty> responseObserver) {
       new Thread(() -> {
            for(String grupo: request.getMembroList()) {
                JOptionPane.showMessageDialog(null, String.format("BEM-VINDO(A) %s, OBRIGADO POR ME CRIAR! <3", grupo));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
       }).start();
    }
}
