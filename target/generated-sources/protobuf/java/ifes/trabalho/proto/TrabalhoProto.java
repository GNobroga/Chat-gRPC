// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: trabalho.proto

package ifes.trabalho.proto;

public final class TrabalhoProto {
  private TrabalhoProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Usuario_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Usuario_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Grupo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Grupo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Mensagem_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Mensagem_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Empty_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016trabalho.proto\"\027\n\007Usuario\022\014\n\004nome\030\002 \001(" +
      "\t\"\027\n\005Grupo\022\016\n\006membro\030\001 \003(\t\"0\n\010Mensagem\022\022" +
      "\n\nrementente\030\001 \001(\t\022\020\n\010conteudo\030\003 \001(\t\"\007\n\005" +
      "Empty2T\n\010Trabalho\022#\n\010Conectar\022\010.Usuario\032" +
      "\t.Mensagem(\0010\001\022#\n\016EnviarMensagem\022\t.Mensa" +
      "gem\032\006.EmptyB&\n\023ifes.trabalho.protoB\rTrab" +
      "alhoProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Usuario_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Usuario_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Usuario_descriptor,
        new java.lang.String[] { "Nome", });
    internal_static_Grupo_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Grupo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Grupo_descriptor,
        new java.lang.String[] { "Membro", });
    internal_static_Mensagem_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Mensagem_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Mensagem_descriptor,
        new java.lang.String[] { "Rementente", "Conteudo", });
    internal_static_Empty_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Empty_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}