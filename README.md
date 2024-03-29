# Citizenjournalist Grpc Client Library

This is a client library for the citizenjournalist transcription Project.

## Usage

Maven Project add this dependency to your pom.xml:

```
<dependency>
    <groupId>io.citizenjournalist.speech</groupId>
    <artifactId>transcription-lib-grpc</artifactId>
    <version>1.3</version>
</dependency>
```

For gradle add this line to your build.gradle:
```
implementation 'io.citizenjournalist.speech:transcription-lib-grpc:1.3'
```

## Sample

To use the project you will need an API key. 
You can set it as environment variable or whatever makes sense for your Application.

```
        String API_KEY = System.getenv("API_KEY"); // add api key
        
        // setup connection:
        var channel = ManagedChannelBuilder.forAddress("speech.citizenjournalist.io", 443)
                .build();
        var callCredentials = new BearerToken(API_KEY);
        var stub = SubtitlingGrpc.newBlockingStub(channel).withCallCredentials(callCredentials);

        // start transcription the properties are configurable
        
        Iterator<TranscriptionReply> transcriptions = stub.transcribe(TranscriptionRequest
                .newBuilder()
                .setExternalReference("abcd")
                .setSourceUrl("https://ipfs.citizenjournalist.io/ipfs/QmPuqoid7n12tR7LkyX6db7hiYWSvXBYTnYejn4rZDJqsY")
                .addAllOutputLanguages(List.of(Language.EN, Language.DE, Language.FR, Language.IT, Language.FR, Language.ES))
                .addAllFormat(List.of(SubtitleFormat.SRT, SubtitleFormat.VTT))
                .build()
        );
        
        // handle the results. Eg store the properties that interest you in a db or print them in console.
        while (transcriptions.hasNext()) {
            TranscriptionReply next = transcriptions.next();
            System.out.println("---");
            System.out.println(next);
            System.out.println("---");
        }

        // A Channel should be shutdown before stopping the process.
        channel.shutdownNow();
```

For Async you can use this:

```
        String API_KEY = System.getenv("API_KEY");
        var channel = ManagedChannelBuilder.forAddress("speech.citizenjournalist.io", 443)
                .build();
        var callCredentials = new BearerToken(API_KEY);
        var stub = SubtitlingGrpc.newStub(channel).withCallCredentials(callCredentials);

        StreamObserver<TranscriptionReply> responseObserver = new StreamObserver<TranscriptionReply>() {
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
                        .addAllFormat(List.of(SubtitleFormat.SRT, SubtitleFormat.VTT, SubtitleFormat.MP3))
                        .build(), responseObserver
        ); // IMPORTANT this assumes that your application is running as a server or similar. If you run this code by itself it will terminate immediately as the operation is executed asyncronously
        // channel.shutdownNow(); // add this in your application after your request,session or similar to cleanup the channel
```

For Reactive use this:

```
        String API_KEY = System.getenv("API_KEY");
        var channel = ManagedChannelBuilder.forAddress("speech.citizenjournalist.io", 443)
                .build();
        var callCredentials = new BearerToken(API_KEY);
        var stub = ReactorSubtitlingGrpc.newReactorStub(channel).withCallCredentials(callCredentials);

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
                }, () -> {
                    System.out.println("done");
                } // IMPORTANT this assumes that your application is running as a server or similar. If you run this code by itself it will terminate immediately as the operation is executed asyncronously
        // channel.shutdownNow(); // add this in your application after your request,session or similar to cleanup the channel
```
## Text to Speech

In order to get a video's audio directly as audio in another language please add SubtitleFormat.MP3 to the list of formats.
This will basically create an mp3 file link that contains the spoken audio in another language.

```
...

        stub.transcribe(TranscriptionRequest
                .newBuilder()
                .setExternalReference("abcd")
                .setSourceUrl("https://ipfs.citizenjournalist.io/ipfs/QmPuqoid7n12tR7LkyX6db7hiYWSvXBYTnYejn4rZDJqsY")
                .addAllOutputLanguages(List.of(Language.EN, Language.DE, Language.FR, Language.IT, Language.ES, Language.CA))
                .addAllFormat(List.of(SubtitleFormat.SRT, SubtitleFormat.MP3))
                .build()).subscribe(

```

## Further Information
If you want to use the api with another language you can either use 
https://github.com/fullstorydev/grpcurl
and use the protobuf file in src/main/proto/subtitling.proto

or generate the stubs with protoc. More information here:
https://protobuf.dev/    

Take a look in GrpcClientTest for the sample code.

Further details about the fields, their meaning and usage can be found here:

https://github.com/The-Crocop/mediaverse-speech

