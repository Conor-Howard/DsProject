package microphone;

import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
//import light.BrightnessRequest;
//import light.BrightnessResponse;
import microphone.MicrophoneClient;

public class MicrophoneClient {
	
	private static  Logger logger = Logger.getLogger(MicrophoneClient.class.getName());
	
	private static MicrophoneServiceGrpc.MicrophoneServiceBlockingStub blockingStub;
	private static MicrophoneServiceGrpc.MicrophoneServiceStub asyncStub;
	private static MicrophoneServiceGrpc.MicrophoneServiceFutureStub futureStub;
	
	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

		blockingStub = MicrophoneServiceGrpc.newBlockingStub(channel);
		asyncStub = MicrophoneServiceGrpc.newStub(channel);
		futureStub =  MicrophoneServiceGrpc.newFutureStub(channel);

		powerOn();
		microphoneRecording();

	}
	
	public static void powerOn() {

		PowerRequest request = PowerRequest.newBuilder().setState(false).build();

		PowerResponse response = blockingStub.powerOn(request);

        System.out.println(response.getState());

    }
	
	public static void microphoneRecording(){

		StreamObserver<MicrophoneResponse> responseObserver = new StreamObserver<MicrophoneResponse>() {

			@Override
			public void onNext(MicrophoneResponse value) {
				System.out.println("receiving brightness: " + value.getAudio());
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

			requestObserver.onNext(MicrophoneRequest.newBuilder().setAudio("Hello").build());
			requestObserver.onNext(MicrophoneRequest.newBuilder().setAudio("Hello").build());
			requestObserver.onNext(MicrophoneRequest.newBuilder().setAudio("Hello").build());
			requestObserver.onNext(MicrophoneRequest.newBuilder().setAudio("Hello").build());
			requestObserver.onNext(MicrophoneRequest.newBuilder().setAudio("Hello").build());


		} catch (RuntimeException e) {
			System.out.println("Error");
		}

		// Mark the end of requests
		requestObserver.onCompleted();
	}

}