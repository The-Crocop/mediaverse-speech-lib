import ch.swisstxt.citizenjournalist.sftpprocessor.grpc.*;
import ch.swisstxt.citizenjournalist.sftpprocessor.grpc.Language;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

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
                .addAllFormat(List.of(SubtitleFormat.SRT, SubtitleFormat.VTT))
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
}