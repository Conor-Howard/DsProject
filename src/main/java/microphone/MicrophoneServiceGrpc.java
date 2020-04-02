package microphone;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: microphone.proto")
public final class MicrophoneServiceGrpc {

  private MicrophoneServiceGrpc() {}

  public static final String SERVICE_NAME = "microphone.MicrophoneService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<microphone.PowerRequest,
      microphone.PowerResponse> getPowerOnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "powerOn",
      requestType = microphone.PowerRequest.class,
      responseType = microphone.PowerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<microphone.PowerRequest,
      microphone.PowerResponse> getPowerOnMethod() {
    io.grpc.MethodDescriptor<microphone.PowerRequest, microphone.PowerResponse> getPowerOnMethod;
    if ((getPowerOnMethod = MicrophoneServiceGrpc.getPowerOnMethod) == null) {
      synchronized (MicrophoneServiceGrpc.class) {
        if ((getPowerOnMethod = MicrophoneServiceGrpc.getPowerOnMethod) == null) {
          MicrophoneServiceGrpc.getPowerOnMethod = getPowerOnMethod = 
              io.grpc.MethodDescriptor.<microphone.PowerRequest, microphone.PowerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "microphone.MicrophoneService", "powerOn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  microphone.PowerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  microphone.PowerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MicrophoneServiceMethodDescriptorSupplier("powerOn"))
                  .build();
          }
        }
     }
     return getPowerOnMethod;
  }

  private static volatile io.grpc.MethodDescriptor<microphone.MicrophoneRequest,
      microphone.MicrophoneResponse> getMicrophoneRecordingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "microphoneRecording",
      requestType = microphone.MicrophoneRequest.class,
      responseType = microphone.MicrophoneResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<microphone.MicrophoneRequest,
      microphone.MicrophoneResponse> getMicrophoneRecordingMethod() {
    io.grpc.MethodDescriptor<microphone.MicrophoneRequest, microphone.MicrophoneResponse> getMicrophoneRecordingMethod;
    if ((getMicrophoneRecordingMethod = MicrophoneServiceGrpc.getMicrophoneRecordingMethod) == null) {
      synchronized (MicrophoneServiceGrpc.class) {
        if ((getMicrophoneRecordingMethod = MicrophoneServiceGrpc.getMicrophoneRecordingMethod) == null) {
          MicrophoneServiceGrpc.getMicrophoneRecordingMethod = getMicrophoneRecordingMethod = 
              io.grpc.MethodDescriptor.<microphone.MicrophoneRequest, microphone.MicrophoneResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "microphone.MicrophoneService", "microphoneRecording"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  microphone.MicrophoneRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  microphone.MicrophoneResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MicrophoneServiceMethodDescriptorSupplier("microphoneRecording"))
                  .build();
          }
        }
     }
     return getMicrophoneRecordingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MicrophoneServiceStub newStub(io.grpc.Channel channel) {
    return new MicrophoneServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MicrophoneServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MicrophoneServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MicrophoneServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MicrophoneServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class MicrophoneServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void powerOn(microphone.PowerRequest request,
        io.grpc.stub.StreamObserver<microphone.PowerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPowerOnMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<microphone.MicrophoneRequest> microphoneRecording(
        io.grpc.stub.StreamObserver<microphone.MicrophoneResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getMicrophoneRecordingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPowerOnMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                microphone.PowerRequest,
                microphone.PowerResponse>(
                  this, METHODID_POWER_ON)))
          .addMethod(
            getMicrophoneRecordingMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                microphone.MicrophoneRequest,
                microphone.MicrophoneResponse>(
                  this, METHODID_MICROPHONE_RECORDING)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class MicrophoneServiceStub extends io.grpc.stub.AbstractStub<MicrophoneServiceStub> {
    private MicrophoneServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MicrophoneServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MicrophoneServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MicrophoneServiceStub(channel, callOptions);
    }

    /**
     */
    public void powerOn(microphone.PowerRequest request,
        io.grpc.stub.StreamObserver<microphone.PowerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPowerOnMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<microphone.MicrophoneRequest> microphoneRecording(
        io.grpc.stub.StreamObserver<microphone.MicrophoneResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getMicrophoneRecordingMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class MicrophoneServiceBlockingStub extends io.grpc.stub.AbstractStub<MicrophoneServiceBlockingStub> {
    private MicrophoneServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MicrophoneServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MicrophoneServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MicrophoneServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public microphone.PowerResponse powerOn(microphone.PowerRequest request) {
      return blockingUnaryCall(
          getChannel(), getPowerOnMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class MicrophoneServiceFutureStub extends io.grpc.stub.AbstractStub<MicrophoneServiceFutureStub> {
    private MicrophoneServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MicrophoneServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MicrophoneServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MicrophoneServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<microphone.PowerResponse> powerOn(
        microphone.PowerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPowerOnMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_POWER_ON = 0;
  private static final int METHODID_MICROPHONE_RECORDING = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MicrophoneServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MicrophoneServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_POWER_ON:
          serviceImpl.powerOn((microphone.PowerRequest) request,
              (io.grpc.stub.StreamObserver<microphone.PowerResponse>) responseObserver);
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
        case METHODID_MICROPHONE_RECORDING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.microphoneRecording(
              (io.grpc.stub.StreamObserver<microphone.MicrophoneResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MicrophoneServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MicrophoneServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return microphone.MicrophoneServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MicrophoneService");
    }
  }

  private static final class MicrophoneServiceFileDescriptorSupplier
      extends MicrophoneServiceBaseDescriptorSupplier {
    MicrophoneServiceFileDescriptorSupplier() {}
  }

  private static final class MicrophoneServiceMethodDescriptorSupplier
      extends MicrophoneServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MicrophoneServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MicrophoneServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MicrophoneServiceFileDescriptorSupplier())
              .addMethod(getPowerOnMethod())
              .addMethod(getMicrophoneRecordingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
