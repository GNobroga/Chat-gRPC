package ifes.trabalho.proto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: trabalho.proto")
public final class TrabalhoGrpc {

  private TrabalhoGrpc() {}

  public static final String SERVICE_NAME = "Trabalho";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ifes.trabalho.proto.Usuario,
      ifes.trabalho.proto.Mensagem> METHOD_CONECTAR =
      io.grpc.MethodDescriptor.<ifes.trabalho.proto.Usuario, ifes.trabalho.proto.Mensagem>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "Trabalho", "Conectar"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ifes.trabalho.proto.Usuario.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ifes.trabalho.proto.Mensagem.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ifes.trabalho.proto.Mensagem,
      ifes.trabalho.proto.Empty> METHOD_ENVIAR_MENSAGEM =
      io.grpc.MethodDescriptor.<ifes.trabalho.proto.Mensagem, ifes.trabalho.proto.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Trabalho", "EnviarMensagem"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ifes.trabalho.proto.Mensagem.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ifes.trabalho.proto.Empty.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TrabalhoStub newStub(io.grpc.Channel channel) {
    return new TrabalhoStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TrabalhoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TrabalhoBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TrabalhoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TrabalhoFutureStub(channel);
  }

  /**
   */
  public static abstract class TrabalhoImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<ifes.trabalho.proto.Usuario> conectar(
        io.grpc.stub.StreamObserver<ifes.trabalho.proto.Mensagem> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_CONECTAR, responseObserver);
    }

    /**
     */
    public void enviarMensagem(ifes.trabalho.proto.Mensagem request,
        io.grpc.stub.StreamObserver<ifes.trabalho.proto.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ENVIAR_MENSAGEM, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CONECTAR,
            asyncBidiStreamingCall(
              new MethodHandlers<
                ifes.trabalho.proto.Usuario,
                ifes.trabalho.proto.Mensagem>(
                  this, METHODID_CONECTAR)))
          .addMethod(
            METHOD_ENVIAR_MENSAGEM,
            asyncUnaryCall(
              new MethodHandlers<
                ifes.trabalho.proto.Mensagem,
                ifes.trabalho.proto.Empty>(
                  this, METHODID_ENVIAR_MENSAGEM)))
          .build();
    }
  }

  /**
   */
  public static final class TrabalhoStub extends io.grpc.stub.AbstractStub<TrabalhoStub> {
    private TrabalhoStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrabalhoStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrabalhoStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrabalhoStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ifes.trabalho.proto.Usuario> conectar(
        io.grpc.stub.StreamObserver<ifes.trabalho.proto.Mensagem> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_CONECTAR, getCallOptions()), responseObserver);
    }

    /**
     */
    public void enviarMensagem(ifes.trabalho.proto.Mensagem request,
        io.grpc.stub.StreamObserver<ifes.trabalho.proto.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ENVIAR_MENSAGEM, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TrabalhoBlockingStub extends io.grpc.stub.AbstractStub<TrabalhoBlockingStub> {
    private TrabalhoBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrabalhoBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrabalhoBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrabalhoBlockingStub(channel, callOptions);
    }

    /**
     */
    public ifes.trabalho.proto.Empty enviarMensagem(ifes.trabalho.proto.Mensagem request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ENVIAR_MENSAGEM, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TrabalhoFutureStub extends io.grpc.stub.AbstractStub<TrabalhoFutureStub> {
    private TrabalhoFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrabalhoFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrabalhoFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrabalhoFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ifes.trabalho.proto.Empty> enviarMensagem(
        ifes.trabalho.proto.Mensagem request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ENVIAR_MENSAGEM, getCallOptions()), request);
    }
  }

  private static final int METHODID_ENVIAR_MENSAGEM = 0;
  private static final int METHODID_CONECTAR = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TrabalhoImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TrabalhoImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ENVIAR_MENSAGEM:
          serviceImpl.enviarMensagem((ifes.trabalho.proto.Mensagem) request,
              (io.grpc.stub.StreamObserver<ifes.trabalho.proto.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONECTAR:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.conectar(
              (io.grpc.stub.StreamObserver<ifes.trabalho.proto.Mensagem>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class TrabalhoDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ifes.trabalho.proto.TrabalhoProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TrabalhoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TrabalhoDescriptorSupplier())
              .addMethod(METHOD_CONECTAR)
              .addMethod(METHOD_ENVIAR_MENSAGEM)
              .build();
        }
      }
    }
    return result;
  }
}
