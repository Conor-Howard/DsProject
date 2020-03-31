package laptop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import laptop.PowerRequest;
import laptop.PowerResponse;
import io.grpc.stub.StreamObserver;


public class LaptopClient {
	private static  Logger logger = Logger.getLogger(LaptopClient.class.getName());

	private static LaptopServiceGrpc.LaptopServiceBlockingStub blockingStub;
	private static LaptopServiceGrpc.LaptopServiceStub asyncStub;
	private static LaptopServiceGrpc.LaptopServiceFutureStub futureStub;

	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

		//stubs -- generate from proto
		blockingStub = LaptopServiceGrpc.newBlockingStub(channel);
		asyncStub = LaptopServiceGrpc.newStub(channel);
		futureStub =  LaptopServiceGrpc.newFutureStub(channel);

		//changeBrightness();
		powerOn();
	}


	//ok
	public static void powerOn() {

		PowerRequest req = PowerRequest.newBuilder().setState(true).build();

		PowerResponse response = blockingStub.powerOn(req);

		System.out.println(response.getState());
	}
	
	public static void changeBrightness() {

		StreamObserver<BrightnessResponse> responseObserver = new StreamObserver<BrightnessResponse>() {
			
			public void onNext(BrightnessResponse value) {
				System.out.println("receiving brightness" + value.getBrightness());
			}
			
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
			public void onCompleted() {
				
			}
		};

		StreamObserver<BrightnessRequest> requestObserver = asyncStub.changeBrightness(responseObserver);
		try {
			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(1).build());
			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(2).build());
			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(3).build());
		} catch(RuntimeException e) {
			System.out.print("Error");
		}
		
		requestObserver.onCompleted();
	}
}
