import ch.swisstxt.citizenjournalist.sftpprocessor.grpc.*;
import ch.swisstxt.citizenjournalist.sftpprocessor.grpc.Language;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class GrpcClientTest {

    @Test
    void testGrpcServer() {
        String API_KEY = System.getenv("API_KEY");
        var channel = ManagedChannelBuilder.forAddress("speech.citizenjournalist.io", 443)
                .build();
        var callCredentials = new BearerToken(API_KEY);
        var stub = SubtitlingGrpc.newBlockingStub(channel).withCallCredentials(callCredentials);

        Iterator<TranscriptionReply> transcriptions = stub.transcribe(TranscriptionRequest
                .newBuilder()
                .setExternalReference("abcd")
                .setSourceUrl("https://ipfs.citizenjournalist.io/ipfs/QmPuqoid7n12tR7LkyX6db7hiYWSvXBYTnYejn4rZDJqsY")
                .addAllOutputLanguages(List.of(Language.EN, Language.DE, Language.FR, Language.IT, Language.FR, Language.ES))
                .addAllFormat(List.of(SubtitleFormat.SRT, SubtitleFormat.VTT, SubtitleFormat.MP3))
                .build()
        );
        while (transcriptions.hasNext()) {
            TranscriptionReply next = transcriptions.next();
            System.out.println("---");
            System.out.println(next);
            System.out.println("---");
        }

        // A Channel should be shutdown before stopping the process.
        channel.shutdownNow();
    }

    @Test
    void testGrpcServerAsync() throws InterruptedException {
        String API_KEY = System.getenv("API_KEY");
        var channel = ManagedChannelBuilder.forAddress("speech.citizenjournalist.io", 443)
                .build();
        var callCredentials = new BearerToken(API_KEY);
        var stub = SubtitlingGrpc.newStub(channel).withCallCredentials(callCredentials);

        // this is just to keep the test running until we get the results,
        // usually the application would keep running on main thread by itself
        var countdownLatch = new CountDownLatch(1);
        StreamObserver<TranscriptionReply> responseObserver = new StreamObserver<>() {
            @Override
            public void onNext(TranscriptionReply next) {
                System.out.println("---");
                System.out.println(next);
                System.out.println("---");
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("An error happened " + t.getMessage());
                countdownLatch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("done");
                countdownLatch.countDown();
            }
        };

        stub.transcribe(TranscriptionRequest
                        .newBuilder()
                        .setExternalReference("abcd")
                        .setSourceUrl("https://ipfs.citizenjournalist.io/ipfs/QmPuqoid7n12tR7LkyX6db7hiYWSvXBYTnYejn4rZDJqsY")
                        .addAllOutputLanguages(List.of(Language.EN, Language.DE, Language.FR, Language.IT, Language.ES, Language.CA))
                        .addAllFormat(List.of(SubtitleFormat.SRT, SubtitleFormat.VTT))
                        .build(), responseObserver
        );

        // this is not necessary when running on a server but we need to keep the test runnung until results arrive.
        // on running application your server would ensure to keep running
       countdownLatch.await(10, TimeUnit.MINUTES); // set timeout according to needs for the sample we set it to 10 minutes, if you have large videos it should be higher

        // A Channel should be shutdown before stopping the process.
        channel.shutdownNow();
    }

    @Test
    void testGrpcServerReactor() throws InterruptedException {
        String API_KEY = System.getenv("API_KEY");
        var channel = ManagedChannelBuilder.forAddress("speech.citizenjournalist.io", 443)
                .build();
        var callCredentials = new BearerToken(API_KEY);
        var stub = ReactorSubtitlingGrpc.newReactorStub(channel).withCallCredentials(callCredentials);


        // this is just to keep the test running until we get the results,
        // usually the application would keep running on main thread by itself
        var countdownLatch = new CountDownLatch(1);

        stub.transcribe(TranscriptionRequest
                .newBuilder()
                .setExternalReference("abcd")
                .setSourceUrl("https://ipfs.citizenjournalist.io/ipfs/QmPuqoid7n12tR7LkyX6db7hiYWSvXBYTnYejn4rZDJqsY")
                .addAllOutputLanguages(List.of(Language.EN, Language.DE, Language.FR, Language.IT, Language.ES, Language.CA))
                .addAllFormat(List.of(SubtitleFormat.SRT, SubtitleFormat.VTT))
                .build()).subscribe(
                        next -> {
                            System.out.println("---");
                            System.out.println(next);
                            System.out.println("---");
                        }, t -> {
                    System.err.println("An error happened " + t.getMessage());
                    countdownLatch.countDown();
                }, () -> {
                    System.out.println("done");
                    countdownLatch.countDown();
                }
        );

        // this is not necessary when running on a server but we need to keep the test runnung until results arrive.
        // on running application your server would ensure to keep running
        countdownLatch.await(10, TimeUnit.MINUTES); // set timeout according to needs for the sample we set it to 10 minutes, if you have large videos it should be higher

        // A Channel should be shutdown before stopping the process.
        channel.shutdownNow();
    }
}