package microphone;

import java.util.Random;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import microphone.MicrophoneResponse;
import microphone.MicrophoneRequest;
import io.grpc.stub.StreamObserver;
import microphone.MicrophoneClient;

public class MicrophoneClient {
	
	private static  Logger logger = Logger.getLogger(MicrophoneClient.class.getName());
	
	private static MicrophoneServiceGrpc.MicrophoneServiceBlockingStub blockingStub;
	private static MicrophoneServiceGrpc.MicrophoneServiceStub asyncStub;
	private static MicrophoneServiceGrpc.MicrophoneServiceFutureStub futureStub;
	
	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 40041).usePlaintext().build();

		blockingStub = MicrophoneServiceGrpc.newBlockingStub(channel);
		asyncStub = MicrophoneServiceGrpc.newStub(channel);
		futureStub =  MicrophoneServiceGrpc.newFutureStub(channel);

		powerOn();
		microphoneRecording();

	}
	
	public static void powerOn() {

		PowerRequest request = PowerRequest.newBuilder().setState(true).build();

		PowerResponse response = blockingStub.powerOn(request);

        System.out.println("Power = " + response.getState());

    }
	
	public static void microphoneRecording() throws InterruptedException {

		StreamObserver<MicrophoneResponse> responseObserver = new StreamObserver<MicrophoneResponse>() {

			@Override
			public void onNext(MicrophoneResponse value) {
				System.out.println(value.getAudio());


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

		StreamObserver<MicrophoneRequest> requestObserver = asyncStub.microphoneRecording(responseObserver);
		try {

			requestObserver.onNext(MicrophoneRequest.newBuilder().setAudio("One").build());
			requestObserver.onNext(MicrophoneRequest.newBuilder().setAudio("Two").build());
			requestObserver.onNext(MicrophoneRequest.newBuilder().setAudio("Three").build());
			requestObserver.onNext(MicrophoneRequest.newBuilder().setAudio("Four").build());

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