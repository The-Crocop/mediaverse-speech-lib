// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: subtitling.proto

package ch.swisstxt.citizenjournalist.sftpprocessor.grpc;

public interface RequestHeadersOrBuilder extends
    // @@protoc_insertion_point(interface_extends:sftpprocessor.RequestHeaders)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>map&lt;string, string&gt; headers = 5;</code>
   */
  int getHeadersCount();
  /**
   * <code>map&lt;string, string&gt; headers = 5;</code>
   */
  boolean containsHeaders(
      java.lang.String key);
  /**
   * Use {@link #getHeadersMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, java.lang.String>
  getHeaders();
  /**
   * <code>map&lt;string, string&gt; headers = 5;</code>
   */
  java.util.Map<java.lang.String, java.lang.String>
  getHeadersMap();
  /**
   * <code>map&lt;string, string&gt; headers = 5;</code>
   */

  java.lang.String getHeadersOrDefault(
      java.lang.String key,
      java.lang.String defaultValue);
  /**
   * <code>map&lt;string, string&gt; headers = 5;</code>
   */

  java.lang.String getHeadersOrThrow(
      java.lang.String key);
}
