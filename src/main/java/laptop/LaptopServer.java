package laptop;

import java.io.IOException;

import java.util.Iterator;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import laptop.LaptopServiceGrpc.LaptopServiceImplBase;


public class LaptopServer extends LaptopServiceImplBase {

	private static final Logger logger = Logger.getLogger(LaptopServer.class.getName());

	
	 public static void main(String[] args) throws IOException, InterruptedException {
		    LaptopServer stringserver = new LaptopServer();
		   
		    int port = 50051;
		    Server server = ServerBuilder.forPort(port)
		        .addService(stringserver)
		        .build()
		        .start();
		    
		    logger.info("Server started, listening on " + port);
		    		    
		    server.awaitTermination();
	 }
	 
	 public void powerOn(PowerRequest request, StreamObserver<PowerResponse> responseObserver) {
		 System.out.print("Turning power on ");
		 
		 Boolean state = request.getState();
		 
		 PowerResponse response = PowerResponse.newBuilder().setState(state).build();
		 
		 System.out.println(response.getState());
		 
		 responseObserver.onNext(response);
		 
		 responseObserver.onCompleted();
	 }
	 
	 public StreamObserver<BrightnessRequest> brightness(final StreamObserver<BrightnessResponse> responseObserver) {
		 
		 
		 return new StreamObserver<BrightnessRequest>() {
			 
			 int brightness = 0;
			 
			 public void onNext(BrightnessRequest value) {
				 System.out.println("Brightness: ");
				 System.out.println("Incoming value: " + value.getBrightness() + "\n");
				 brightness = value.getBrightness();
			 }
			 
			 public void onError(Throwable t) {
				 t.printStackTrace();
			 }
			 
			 public void onCompleted() {
				 System.out.println("Brightness of the room has been changed");
				 BrightnessResponse response = BrightnessResponse.newBuilder().setBrightness(brightness).build();
				 responseObserver.onNext(response);
				 responseObserver.onCompleted();
			 }
		 };
	 }


	
	
}
