package ifes.trabalho.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

                    responseObserver.onNext(mensagem);
                }
            }

            @Override
            public void onError(Throwable t) {}

            @Override
            public void onCompleted() { responseObserver.onCompleted(); }
        };
    }
    
    
    @Override public void enviarMensagem(Mensagem request,
        io.grpc.stub.StreamObserver<ifes.trabalho.proto.Empty> responseObserver) {
            for(StreamObserver<Mensagem> observer: users.values()) {
                Mensagem mensagem = Mensagem.newBuilder()
                    .setRementente(request.getRementente())
                    .setConteudo(request.getConteudo())
                    .build();
               observer.onNext(mensagem);
            }
    }
}
