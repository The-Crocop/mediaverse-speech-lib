package ch.swisstxt.citizenjournalist.sftpprocessor.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: subtitling.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SubtitlingGrpc {

  private SubtitlingGrpc() {}

  public static final String SERVICE_NAME = "sftpprocessor.Subtitling";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionRequest,
      ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionReply> getTranscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Transcribe",
      requestType = ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionRequest.class,
      responseType = ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionRequest,
      ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionReply> getTranscribeMethod() {
    io.grpc.MethodDescriptor<ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionRequest, ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionReply> getTranscribeMethod;
    if ((getTranscribeMethod = SubtitlingGrpc.getTranscribeMethod) == null) {
      synchronized (SubtitlingGrpc.class) {
        if ((getTranscribeMethod = SubtitlingGrpc.getTranscribeMethod) == null) {
          SubtitlingGrpc.getTranscribeMethod = getTranscribeMethod =
              io.grpc.MethodDescriptor.<ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionRequest, ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Transcribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionReply.getDefaultInstance()))
              .setSchemaDescriptor(new SubtitlingMethodDescriptorSupplier("Transcribe"))
              .build();
        }
      }
    }
    return getTranscribeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SubtitlingStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubtitlingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SubtitlingStub>() {
        @java.lang.Override
        public SubtitlingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SubtitlingStub(channel, callOptions);
        }
      };
    return SubtitlingStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SubtitlingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubtitlingBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SubtitlingBlockingStub>() {
        @java.lang.Override
        public SubtitlingBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SubtitlingBlockingStub(channel, callOptions);
        }
      };
    return SubtitlingBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SubtitlingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubtitlingFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SubtitlingFutureStub>() {
        @java.lang.Override
        public SubtitlingFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SubtitlingFutureStub(channel, callOptions);
        }
      };
    return SubtitlingFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class SubtitlingImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Starts a transcription
     * </pre>
     */
    public void transcribe(ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionRequest request,
        io.grpc.stub.StreamObserver<ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTranscribeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTranscribeMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionRequest,
                ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionReply>(
                  this, METHODID_TRANSCRIBE)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class SubtitlingStub extends io.grpc.stub.AbstractAsyncStub<SubtitlingStub> {
    private SubtitlingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubtitlingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubtitlingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Starts a transcription
     * </pre>
     */
    public void transcribe(ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionRequest request,
        io.grpc.stub.StreamObserver<ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getTranscribeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class SubtitlingBlockingStub extends io.grpc.stub.AbstractBlockingStub<SubtitlingBlockingStub> {
    private SubtitlingBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubtitlingBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubtitlingBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Starts a transcription
     * </pre>
     */
    public java.util.Iterator<ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionReply> transcribe(
        ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getTranscribeMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class SubtitlingFutureStub extends io.grpc.stub.AbstractFutureStub<SubtitlingFutureStub> {
    private SubtitlingFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubtitlingFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubtitlingFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_TRANSCRIBE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SubtitlingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SubtitlingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TRANSCRIBE:
          serviceImpl.transcribe((ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionRequest) request,
              (io.grpc.stub.StreamObserver<ch.swisstxt.citizenjournalist.sftpprocessor.grpc.TranscriptionReply>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SubtitlingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SubtitlingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ch.swisstxt.citizenjournalist.sftpprocessor.grpc.SubtitlingProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Subtitling");
    }
  }

  private static final class SubtitlingFileDescriptorSupplier
      extends SubtitlingBaseDescriptorSupplier {
    SubtitlingFileDescriptorSupplier() {}
  }

  private static final class SubtitlingMethodDescriptorSupplier
      extends SubtitlingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SubtitlingMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SubtitlingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SubtitlingFileDescriptorSupplier())
              .addMethod(getTranscribeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
