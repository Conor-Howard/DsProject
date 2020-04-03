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
//import laptop.LaptopResponse;
//import laptop.StringRequest;
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

		changeBrightness();
		powerOn();
	}


	//ok
	public static void powerOn() {

		PowerRequest req = PowerRequest.newBuilder().setState(true).build();

		PowerResponse response = blockingStub.powerOn(req);

		System.out.println(response.getState());
	}
	
	public static void changeBrightness() throws InterruptedException {

		StreamObserver<BrightnessResponse> responseObserver = new StreamObserver<BrightnessResponse>() {

			@Override
			public void onNext(BrightnessResponse value) {
				System.out.println("Brightness set to: " + value.getBrightness());


			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub

			}

		};

		StreamObserver<BrightnessRequest> requestObserver = asyncStub.changeBrightness(responseObserver);
		try {

			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(1).build());
			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(2).build());
			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(3).build());
			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(4).build());

			// Sleep for a bit before sending the next one.
			Thread.sleep(new Random().nextInt(1000) + 500);


		} catch (RuntimeException e) {
			// Cancel RPC
			requestObserver.onError(e);
			throw e;
			} catch (InterruptedException e) {

				e.printStackTrace();
		}

		// Mark the end of requests
		requestObserver.onCompleted();
	}
}
