package laptop;

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
    comments = "Source: laptop.proto")
public final class LaptopServiceGrpc {

  private LaptopServiceGrpc() {}

  public static final String SERVICE_NAME = "laptop.LaptopService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<laptop.PowerRequest,
      laptop.PowerResponse> getPowerOnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "powerOn",
      requestType = laptop.PowerRequest.class,
      responseType = laptop.PowerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<laptop.PowerRequest,
      laptop.PowerResponse> getPowerOnMethod() {
    io.grpc.MethodDescriptor<laptop.PowerRequest, laptop.PowerResponse> getPowerOnMethod;
    if ((getPowerOnMethod = LaptopServiceGrpc.getPowerOnMethod) == null) {
      synchronized (LaptopServiceGrpc.class) {
        if ((getPowerOnMethod = LaptopServiceGrpc.getPowerOnMethod) == null) {
          LaptopServiceGrpc.getPowerOnMethod = getPowerOnMethod = 
              io.grpc.MethodDescriptor.<laptop.PowerRequest, laptop.PowerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "laptop.LaptopService", "powerOn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  laptop.PowerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  laptop.PowerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LaptopServiceMethodDescriptorSupplier("powerOn"))
                  .build();
          }
        }
     }
     return getPowerOnMethod;
  }

  private static volatile io.grpc.MethodDescriptor<laptop.BrightnessRequest,
      laptop.BrightnessResponse> getChangeBrightnessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "changeBrightness",
      requestType = laptop.BrightnessRequest.class,
      responseType = laptop.BrightnessResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<laptop.BrightnessRequest,
      laptop.BrightnessResponse> getChangeBrightnessMethod() {
    io.grpc.MethodDescriptor<laptop.BrightnessRequest, laptop.BrightnessResponse> getChangeBrightnessMethod;
    if ((getChangeBrightnessMethod = LaptopServiceGrpc.getChangeBrightnessMethod) == null) {
      synchronized (LaptopServiceGrpc.class) {
        if ((getChangeBrightnessMethod = LaptopServiceGrpc.getChangeBrightnessMethod) == null) {
          LaptopServiceGrpc.getChangeBrightnessMethod = getChangeBrightnessMethod = 
              io.grpc.MethodDescriptor.<laptop.BrightnessRequest, laptop.BrightnessResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "laptop.LaptopService", "changeBrightness"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  laptop.BrightnessRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  laptop.BrightnessResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LaptopServiceMethodDescriptorSupplier("changeBrightness"))
                  .build();
          }
        }
     }
     return getChangeBrightnessMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LaptopServiceStub newStub(io.grpc.Channel channel) {
    return new LaptopServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LaptopServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LaptopServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LaptopServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LaptopServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class LaptopServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void powerOn(laptop.PowerRequest request,
        io.grpc.stub.StreamObserver<laptop.PowerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPowerOnMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<laptop.BrightnessRequest> changeBrightness(
        io.grpc.stub.StreamObserver<laptop.BrightnessResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getChangeBrightnessMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPowerOnMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                laptop.PowerRequest,
                laptop.PowerResponse>(
                  this, METHODID_POWER_ON)))
          .addMethod(
            getChangeBrightnessMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                laptop.BrightnessRequest,
                laptop.BrightnessResponse>(
                  this, METHODID_CHANGE_BRIGHTNESS)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class LaptopServiceStub extends io.grpc.stub.AbstractStub<LaptopServiceStub> {
    private LaptopServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LaptopServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LaptopServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LaptopServiceStub(channel, callOptions);
    }

    /**
     */
    public void powerOn(laptop.PowerRequest request,
        io.grpc.stub.StreamObserver<laptop.PowerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPowerOnMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<laptop.BrightnessRequest> changeBrightness(
        io.grpc.stub.StreamObserver<laptop.BrightnessResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getChangeBrightnessMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class LaptopServiceBlockingStub extends io.grpc.stub.AbstractStub<LaptopServiceBlockingStub> {
    private LaptopServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LaptopServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LaptopServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LaptopServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public laptop.PowerResponse powerOn(laptop.PowerRequest request) {
      return blockingUnaryCall(
          getChannel(), getPowerOnMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class LaptopServiceFutureStub extends io.grpc.stub.AbstractStub<LaptopServiceFutureStub> {
    private LaptopServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LaptopServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LaptopServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LaptopServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<laptop.PowerResponse> powerOn(
        laptop.PowerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPowerOnMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_POWER_ON = 0;
  private static final int METHODID_CHANGE_BRIGHTNESS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LaptopServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LaptopServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_POWER_ON:
          serviceImpl.powerOn((laptop.PowerRequest) request,
              (io.grpc.stub.StreamObserver<laptop.PowerResponse>) responseObserver);
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
        case METHODID_CHANGE_BRIGHTNESS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.changeBrightness(
              (io.grpc.stub.StreamObserver<laptop.BrightnessResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LaptopServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LaptopServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return laptop.LaptopServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LaptopService");
    }
  }

  private static final class LaptopServiceFileDescriptorSupplier
      extends LaptopServiceBaseDescriptorSupplier {
    LaptopServiceFileDescriptorSupplier() {}
  }

  private static final class LaptopServiceMethodDescriptorSupplier
      extends LaptopServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LaptopServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LaptopServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LaptopServiceFileDescriptorSupplier())
              .addMethod(getPowerOnMethod())
              .addMethod(getChangeBrightnessMethod())
              .build();
        }
      }
    }
    return result;
  }
}
