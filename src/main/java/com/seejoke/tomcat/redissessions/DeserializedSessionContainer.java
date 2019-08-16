package com.seejoke.tomcat.redissessions;

/**
 * @author yangzhongying
 * @date 2019/8/15 15:43
 */
public class DeserializedSessionContainer {
  public final RedisSession session;
  public final SessionSerializationMetadata metadata;

  public DeserializedSessionContainer(RedisSession session, SessionSerializationMetadata metadata) {
    this.session = session;
    this.metadata = metadata;
  }
}
