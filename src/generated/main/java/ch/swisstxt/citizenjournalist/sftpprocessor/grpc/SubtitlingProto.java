// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: subtitling.proto

package ch.swisstxt.citizenjournalist.sftpprocessor.grpc;

public final class SubtitlingProto {
  private SubtitlingProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sftpprocessor_RequestHeaders_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sftpprocessor_RequestHeaders_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sftpprocessor_RequestHeaders_HeadersEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sftpprocessor_RequestHeaders_HeadersEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sftpprocessor_TranscriptionRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sftpprocessor_TranscriptionRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sftpprocessor_TranscriptionReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sftpprocessor_TranscriptionReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020subtitling.proto\022\rsftpprocessor\"}\n\016Req" +
      "uestHeaders\022;\n\007headers\030\005 \003(\0132*.sftpproce" +
      "ssor.RequestHeaders.HeadersEntry\032.\n\014Head" +
      "ersEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001" +
      "\"\201\002\n\024TranscriptionRequest\022\036\n\021externalRef" +
      "erence\030\001 \001(\tH\000\210\001\001\022\021\n\tsourceUrl\030\002 \001(\t\022-\n\006" +
      "format\030\003 \003(\0162\035.sftpprocessor.SubtitleFor" +
      "mat\0220\n\017outputLanguages\030\004 \003(\0162\027.sftpproce" +
      "ssor.Language\0223\n\007headers\030\005 \001(\0132\035.sftppro" +
      "cessor.RequestHeadersH\001\210\001\001B\024\n\022_externalR" +
      "eferenceB\n\n\010_headers\"\355\001\n\022TranscriptionRe" +
      "ply\022\036\n\021externalReference\030\001 \001(\tH\000\210\001\001\022\030\n\020t" +
      "ranscriptionUrl\030\002 \001(\t\0222\n\006format\030\003 \001(\0162\035." +
      "sftpprocessor.SubtitleFormatH\001\210\001\001\022)\n\010lan" +
      "guage\030\004 \001(\0162\027.sftpprocessor.Language\022\020\n\010" +
      "original\030\005 \001(\010\022\013\n\003cid\030\006 \001(\tB\024\n\022_external" +
      "ReferenceB\t\n\007_format*\"\n\016SubtitleFormat\022\007" +
      "\n\003VTT\020\000\022\007\n\003SRT\020\001*<\n\010Language\022\010\n\004NONE\020\000\022\006" +
      "\n\002EN\020\001\022\006\n\002DE\020\002\022\006\n\002FR\020\003\022\006\n\002IT\020\004\022\006\n\002ES\020\0052f" +
      "\n\nSubtitling\022X\n\nTranscribe\022#.sftpprocess" +
      "or.TranscriptionRequest\032!.sftpprocessor." +
      "TranscriptionReply\"\0000\001BK\n0ch.swisstxt.ci" +
      "tizenjournalist.sftpprocessor.grpcB\017Subt" +
      "itlingProtoP\001\242\002\003STPb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_sftpprocessor_RequestHeaders_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_sftpprocessor_RequestHeaders_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sftpprocessor_RequestHeaders_descriptor,
        new java.lang.String[] { "Headers", });
    internal_static_sftpprocessor_RequestHeaders_HeadersEntry_descriptor =
      internal_static_sftpprocessor_RequestHeaders_descriptor.getNestedTypes().get(0);
    internal_static_sftpprocessor_RequestHeaders_HeadersEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sftpprocessor_RequestHeaders_HeadersEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_sftpprocessor_TranscriptionRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_sftpprocessor_TranscriptionRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sftpprocessor_TranscriptionRequest_descriptor,
        new java.lang.String[] { "ExternalReference", "SourceUrl", "Format", "OutputLanguages", "Headers", "ExternalReference", "Headers", });
    internal_static_sftpprocessor_TranscriptionReply_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_sftpprocessor_TranscriptionReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sftpprocessor_TranscriptionReply_descriptor,
        new java.lang.String[] { "ExternalReference", "TranscriptionUrl", "Format", "Language", "Original", "Cid", "ExternalReference", "Format", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}