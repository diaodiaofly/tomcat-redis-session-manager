package com.seejoke.tomcat.redissessions;

import java.util.Arrays;

/**
 * SessionPersistPolicy
 * @author yangzhongying
 * @date 2019/8/15 15:44
 */
public enum SessionPersistPolicy {
  DEFAULT,
  SAVE_ON_CHANGE,
  ALWAYS_SAVE_AFTER_REQUEST;

  static SessionPersistPolicy fromName(String name) {
    for (SessionPersistPolicy policy : SessionPersistPolicy.values()) {
      if (policy.name().equalsIgnoreCase(name)) {
        return policy;
      }
    }
    throw new IllegalArgumentException(
        "Invalid session persist policy ["
            + name
            + "]. Must be one of "
            + Arrays.asList(SessionPersistPolicy.values())
            + ".");
  }
}
