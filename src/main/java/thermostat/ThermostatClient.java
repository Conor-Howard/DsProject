package thermostat;

import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class ThermostatClient {
	
private static  Logger logger = Logger.getLogger(ThermostatClient.class.getName());
	
	private static ThermostatServiceGrpc.ThermostatServiceBlockingStub blockingStub;
	private static ThermostatServiceGrpc.ThermostatServiceStub asyncStub;
	private static ThermostatServiceGrpc.ThermostatServiceFutureStub futureStub;
	
	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

		blockingStub = ThermostatServiceGrpc.newBlockingStub(channel);
		asyncStub = ThermostatServiceGrpc.newStub(channel);
		futureStub =  ThermostatServiceGrpc.newFutureStub(channel);

		power();
		changeTemperature();

	}
	
	public static void power() {

		PowerRequest request = PowerRequest.newBuilder().setState(true).build();

		PowerResponse response = blockingStub.power(request);

        System.out.println("Power = " + response.getState());

    }
	
	public static void changeTemperature() {
		TemperatureRequest request = TemperatureRequest.newBuilder().setTemp(35).build();
		
		StreamObserver<TemperatureResponse> responseObserver = new StreamObserver<TemperatureResponse>() {
			
			public void onNext(TemperatureResponse value) {
				System.out.println("Requesting temperature change to " + value);
			}
			
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
			public void onCompleted() {
				System.out.println("Temperature set to: ");
			}
		};
		
		asyncStub.changeTemperature(request, responseObserver);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
