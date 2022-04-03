# Citizenjournalist Grpc Client Library

This is a client library for the citizenjournalist transcription Project.

## Usage

Maven Project add this dependency to your pom.xml:

```
<dependency>
    <groupId>io.citizenjournalist.speech</groupId>
    <artifactId>transcription-lib-grpc</artifactId>
    <version>1.1</version>
</dependency>
```

For gradle add this line to your build.gradle:
```
implementation 'io.citizenjournalist.speech:transcription-lib-grpc:1.1'
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

Take a look in GrpcClientTest for the sample code.

Further details about the fields, their meaning and usage can be found here:

https://github.com/The-Crocop/mediaverse-speech

