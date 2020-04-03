package thermostat;

import java.io.IOException;


import java.util.Iterator;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import thermostat.ThermostatServiceGrpc.ThermostatServiceImplBase;


public class ThermostatServer extends ThermostatServiceImplBase {

	private static final Logger logger = Logger.getLogger(ThermostatServer.class.getName());

	
	 public static void main(String[] args) throws IOException, InterruptedException {
		    ThermostatServer stringserver = new ThermostatServer();
		   
		    int port = 50051;
		    Server server = ServerBuilder.forPort(port)
		        .addService(stringserver)
		        .build()
		        .start();
		    
		    logger.info("Server started, listening on " + port);
		    		    
		    server.awaitTermination();
	 }
	 
	 public void power(PowerRequest request, StreamObserver<PowerResponse> responseObserver) {
		 System.out.print("Turning power on ");
		 
		 Boolean state = request.getState();
		 
		 PowerResponse response = PowerResponse.newBuilder().setState(state).build();
		 
		 System.out.println(response.getState());
		 responseObserver.onNext(response);
		 
		 responseObserver.onCompleted();
		 
		 System.out.println("Microphone power on");
	 }
	 
	 public void changeTemperature(TemperatureRequest request, StreamObserver<TemperatureResponse> responseObserver) {
		 System.out.println("Thermostat temperature");
		 
		 int temperature = request.getTemp();
		 
		 responseObserver.onNext(TemperatureResponse.newBuilder().setTemp(temperature).build());
	 }
}
