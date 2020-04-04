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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: lights.proto")
public final class LightServiceGrpc {

  private LightServiceGrpc() {}

  public static final String SERVICE_NAME = "LightService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Lights.PowerRequest,
      Lights.PowerResponse> getPowerOnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "powerOn",
      requestType = Lights.PowerRequest.class,
      responseType = Lights.PowerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Lights.PowerRequest,
      Lights.PowerResponse> getPowerOnMethod() {
    io.grpc.MethodDescriptor<Lights.PowerRequest, Lights.PowerResponse> getPowerOnMethod;
    if ((getPowerOnMethod = LightServiceGrpc.getPowerOnMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getPowerOnMethod = LightServiceGrpc.getPowerOnMethod) == null) {
          LightServiceGrpc.getPowerOnMethod = getPowerOnMethod = 
              io.grpc.MethodDescriptor.<Lights.PowerRequest, Lights.PowerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "LightService", "powerOn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Lights.PowerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Lights.PowerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("powerOn"))
                  .build();
          }
        }
     }
     return getPowerOnMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Lights.ColourRequest,
      Lights.ColourResponse> getChangeColourMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "changeColour",
      requestType = Lights.ColourRequest.class,
      responseType = Lights.ColourResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Lights.ColourRequest,
      Lights.ColourResponse> getChangeColourMethod() {
    io.grpc.MethodDescriptor<Lights.ColourRequest, Lights.ColourResponse> getChangeColourMethod;
    if ((getChangeColourMethod = LightServiceGrpc.getChangeColourMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getChangeColourMethod = LightServiceGrpc.getChangeColourMethod) == null) {
          LightServiceGrpc.getChangeColourMethod = getChangeColourMethod = 
              io.grpc.MethodDescriptor.<Lights.ColourRequest, Lights.ColourResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "LightService", "changeColour"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Lights.ColourRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Lights.ColourResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("changeColour"))
                  .build();
          }
        }
     }
     return getChangeColourMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightServiceStub newStub(io.grpc.Channel channel) {
    return new LightServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LightServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LightServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class LightServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void powerOn(Lights.PowerRequest request,
        io.grpc.stub.StreamObserver<Lights.PowerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPowerOnMethod(), responseObserver);
    }

    /**
     */
    public void changeColour(Lights.ColourRequest request,
        io.grpc.stub.StreamObserver<Lights.ColourResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getChangeColourMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPowerOnMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Lights.PowerRequest,
                Lights.PowerResponse>(
                  this, METHODID_POWER_ON)))
          .addMethod(
            getChangeColourMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Lights.ColourRequest,
                Lights.ColourResponse>(
                  this, METHODID_CHANGE_COLOUR)))
          .build();
    }
  }

  /**
   */
  public static final class LightServiceStub extends io.grpc.stub.AbstractStub<LightServiceStub> {
    private LightServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceStub(channel, callOptions);
    }

    /**
     */
    public void powerOn(Lights.PowerRequest request,
        io.grpc.stub.StreamObserver<Lights.PowerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPowerOnMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeColour(Lights.ColourRequest request,
        io.grpc.stub.StreamObserver<Lights.ColourResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getChangeColourMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LightServiceBlockingStub extends io.grpc.stub.AbstractStub<LightServiceBlockingStub> {
    private LightServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Lights.PowerResponse powerOn(Lights.PowerRequest request) {
      return blockingUnaryCall(
          getChannel(), getPowerOnMethod(), getCallOptions(), request);
    }

    /**
     */
    public Lights.ColourResponse changeColour(Lights.ColourRequest request) {
      return blockingUnaryCall(
          getChannel(), getChangeColourMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LightServiceFutureStub extends io.grpc.stub.AbstractStub<LightServiceFutureStub> {
    private LightServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Lights.PowerResponse> powerOn(
        Lights.PowerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPowerOnMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Lights.ColourResponse> changeColour(
        Lights.ColourRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getChangeColourMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_POWER_ON = 0;
  private static final int METHODID_CHANGE_COLOUR = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LightServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LightServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_POWER_ON:
          serviceImpl.powerOn((Lights.PowerRequest) request,
              (io.grpc.stub.StreamObserver<Lights.PowerResponse>) responseObserver);
          break;
        case METHODID_CHANGE_COLOUR:
          serviceImpl.changeColour((Lights.ColourRequest) request,
              (io.grpc.stub.StreamObserver<Lights.ColourResponse>) responseObserver);
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

  private static abstract class LightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Lights.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LightService");
    }
  }

  private static final class LightServiceFileDescriptorSupplier
      extends LightServiceBaseDescriptorSupplier {
    LightServiceFileDescriptorSupplier() {}
  }

  private static final class LightServiceMethodDescriptorSupplier
      extends LightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LightServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LightServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightServiceFileDescriptorSupplier())
              .addMethod(getPowerOnMethod())
              .addMethod(getChangeColourMethod())
              .build();
        }
      }
    }
    return result;
  }
}
