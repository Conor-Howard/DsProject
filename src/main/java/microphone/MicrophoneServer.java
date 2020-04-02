package microphone;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import microphone.PowerRequest;
import microphone.PowerResponse;
import microphone.MicrophoneServiceGrpc.MicrophoneServiceImplBase;

public class MicrophoneServer extends MicrophoneServiceImplBase{
	
	private static final Logger logger = Logger.getLogger(MicrophoneServer.class.getName());
	
	public static void main(String[] args) throws IOException, InterruptedException {
		MicrophoneServer microphoneserver = new MicrophoneServer();
	   
		int port = 50051;
	    Server server = ServerBuilder.forPort(port)
	        .addService(microphoneserver)
	        .build()
	        .start();
	    
	    logger.info("Server started, listening on " + port);
	    		    
	    server.awaitTermination();
	}
	
	public void powerOn(PowerRequest request, StreamObserver<PowerResponse> responseObserver) {
        System.out.println("Receiving request...");

        System.out.println("Microphone power on");

        Boolean power = request.getState(); 
        
        PowerResponse response = PowerResponse.newBuilder().setState(power).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

	}
	
	public StreamObserver<MicrophoneRequest> microphoneRecording(final StreamObserver<MicrophoneResponse> responseObserver) {
	      return new StreamObserver<MicrophoneRequest>() {
	        public void onNext(MicrophoneRequest request) {
	            StringBuilder statement = new StringBuilder(); 
	  
	            statement.append(request.getAudio());
	            System.out.println(statement);
	        
	            MicrophoneResponse reply = MicrophoneResponse.newBuilder().setAudio(statement.toString()).build();
	      
	            responseObserver.onNext(reply);
	          }

	        public void onError(Throwable t) {
	          System.out.println("Error, service stopped");
	        }
	        public void onCompleted() {
	          responseObserver.onCompleted();
	        }
	      };
	    }

}