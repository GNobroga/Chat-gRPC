// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: trabalho.proto

package ifes.trabalho.proto;

/**
 * Protobuf type {@code Grupo}
 */
public  final class Grupo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Grupo)
    GrupoOrBuilder {
  // Use Grupo.newBuilder() to construct.
  private Grupo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Grupo() {
    membro_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private Grupo(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              membro_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            membro_.add(s);
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        membro_ = membro_.getUnmodifiableView();
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ifes.trabalho.proto.TrabalhoProto.internal_static_Grupo_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ifes.trabalho.proto.TrabalhoProto.internal_static_Grupo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ifes.trabalho.proto.Grupo.class, ifes.trabalho.proto.Grupo.Builder.class);
  }

  public static final int MEMBRO_FIELD_NUMBER = 1;
  private com.google.protobuf.LazyStringList membro_;
  /**
   * <code>repeated string membro = 1;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getMembroList() {
    return membro_;
  }
  /**
   * <code>repeated string membro = 1;</code>
   */
  public int getMembroCount() {
    return membro_.size();
  }
  /**
   * <code>repeated string membro = 1;</code>
   */
  public java.lang.String getMembro(int index) {
    return membro_.get(index);
  }
  /**
   * <code>repeated string membro = 1;</code>
   */
  public com.google.protobuf.ByteString
      getMembroBytes(int index) {
    return membro_.getByteString(index);
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < membro_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, membro_.getRaw(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < membro_.size(); i++) {
        dataSize += computeStringSizeNoTag(membro_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getMembroList().size();
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ifes.trabalho.proto.Grupo)) {
      return super.equals(obj);
    }
    ifes.trabalho.proto.Grupo other = (ifes.trabalho.proto.Grupo) obj;

    boolean result = true;
    result = result && getMembroList()
        .equals(other.getMembroList());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getMembroCount() > 0) {
      hash = (37 * hash) + MEMBRO_FIELD_NUMBER;
      hash = (53 * hash) + getMembroList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ifes.trabalho.proto.Grupo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ifes.trabalho.proto.Grupo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ifes.trabalho.proto.Grupo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ifes.trabalho.proto.Grupo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ifes.trabalho.proto.Grupo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ifes.trabalho.proto.Grupo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ifes.trabalho.proto.Grupo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ifes.trabalho.proto.Grupo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ifes.trabalho.proto.Grupo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ifes.trabalho.proto.Grupo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ifes.trabalho.proto.Grupo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ifes.trabalho.proto.Grupo parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ifes.trabalho.proto.Grupo prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code Grupo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Grupo)
      ifes.trabalho.proto.GrupoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ifes.trabalho.proto.TrabalhoProto.internal_static_Grupo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ifes.trabalho.proto.TrabalhoProto.internal_static_Grupo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ifes.trabalho.proto.Grupo.class, ifes.trabalho.proto.Grupo.Builder.class);
    }

    // Construct using ifes.trabalho.proto.Grupo.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      membro_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ifes.trabalho.proto.TrabalhoProto.internal_static_Grupo_descriptor;
    }

    public ifes.trabalho.proto.Grupo getDefaultInstanceForType() {
      return ifes.trabalho.proto.Grupo.getDefaultInstance();
    }

    public ifes.trabalho.proto.Grupo build() {
      ifes.trabalho.proto.Grupo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public ifes.trabalho.proto.Grupo buildPartial() {
      ifes.trabalho.proto.Grupo result = new ifes.trabalho.proto.Grupo(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        membro_ = membro_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.membro_ = membro_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ifes.trabalho.proto.Grupo) {
        return mergeFrom((ifes.trabalho.proto.Grupo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ifes.trabalho.proto.Grupo other) {
      if (other == ifes.trabalho.proto.Grupo.getDefaultInstance()) return this;
      if (!other.membro_.isEmpty()) {
        if (membro_.isEmpty()) {
          membro_ = other.membro_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureMembroIsMutable();
          membro_.addAll(other.membro_);
        }
        onChanged();
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ifes.trabalho.proto.Grupo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ifes.trabalho.proto.Grupo) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.LazyStringList membro_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureMembroIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        membro_ = new com.google.protobuf.LazyStringArrayList(membro_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string membro = 1;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getMembroList() {
      return membro_.getUnmodifiableView();
    }
    /**
     * <code>repeated string membro = 1;</code>
     */
    public int getMembroCount() {
      return membro_.size();
    }
    /**
     * <code>repeated string membro = 1;</code>
     */
    public java.lang.String getMembro(int index) {
      return membro_.get(index);
    }
    /**
     * <code>repeated string membro = 1;</code>
     */
    public com.google.protobuf.ByteString
        getMembroBytes(int index) {
      return membro_.getByteString(index);
    }
    /**
     * <code>repeated string membro = 1;</code>
     */
    public Builder setMembro(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureMembroIsMutable();
      membro_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string membro = 1;</code>
     */
    public Builder addMembro(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureMembroIsMutable();
      membro_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string membro = 1;</code>
     */
    public Builder addAllMembro(
        java.lang.Iterable<java.lang.String> values) {
      ensureMembroIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, membro_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string membro = 1;</code>
     */
    public Builder clearMembro() {
      membro_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string membro = 1;</code>
     */
    public Builder addMembroBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureMembroIsMutable();
      membro_.add(value);
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:Grupo)
  }

  // @@protoc_insertion_point(class_scope:Grupo)
  private static final ifes.trabalho.proto.Grupo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ifes.trabalho.proto.Grupo();
  }

  public static ifes.trabalho.proto.Grupo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Grupo>
      PARSER = new com.google.protobuf.AbstractParser<Grupo>() {
    public Grupo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new Grupo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Grupo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Grupo> getParserForType() {
    return PARSER;
  }

  public ifes.trabalho.proto.Grupo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
