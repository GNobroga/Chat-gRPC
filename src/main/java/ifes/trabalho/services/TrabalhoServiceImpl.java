package ifes.trabalho.services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ifes.trabalho.proto.*;
import ifes.trabalho.proto.TrabalhoGrpc.TrabalhoImplBase;
import io.grpc.stub.StreamObserver;

public class TrabalhoServiceImpl extends TrabalhoImplBase {

    private Map<String, StreamObserver<Mensagem>> users = new ConcurrentHashMap<>();

    private static int CURRENT_ID = 1;

    @Override
    public StreamObserver<Usuario> conectar(StreamObserver<Mensagem> responseObserver) {
        return new StreamObserver<Usuario>() {
            @Override
            public void onNext(Usuario request) {
                String nome = request.getNome();

                if (users.containsKey(nome)) {
                    nome += "-" + CURRENT_ID++;
                }

                users.put(nome, responseObserver);

                Mensagem mensagem = Mensagem.newBuilder()
                        .setConteudo("Bem-vindo, " + nome + " ao Chat GRPC")
                        .build();

                responseObserver.onNext(Mensagem.newBuilder().setNovoNome(nome).build());

                enviarMensagem(mensagem, null);

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
            String saiu = null;

            if (request.getSair()) {
                users.remove(request.getRementente());
                saiu = String.format("%s foi desconectado.", request.getRementente());
            }

            for(StreamObserver<Mensagem> observer: users.values()) {
                Mensagem mensagem = Mensagem.newBuilder()
                    .setRementente(saiu != null ? saiu : request.getRementente())
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
            String saudacoes = "Saudações para: ";
            for(String grupo: request.getMembroList()) {
                 saudacoes += " " + grupo + " ,";
            }
            saudacoes = saudacoes.substring(0, saudacoes.length() - 1);
            saudacoes += " :)";
            Mensagem mensagem = Mensagem.newBuilder().setConteudo(saudacoes).setRementente("MASTER").build();
             try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            enviarMensagem(mensagem, null);
           
       }).start();
    }
}
