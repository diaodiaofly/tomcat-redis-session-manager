package com.seejoke.tomcat.redissessions;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleListener;

/**
 * @author yangzhongying
 * @date 2019/8/15 16:30
 */
public class LifecycleSupport {

  public LifecycleSupport(Lifecycle lifecycle) {
    super();
    this.lifecycle = lifecycle;
  }

  private final Lifecycle lifecycle;

  private final List<LifecycleListener> listeners = new CopyOnWriteArrayList<>();

  public void addLifecycleListener(LifecycleListener listener) {
    listeners.add(listener);
  }


  public LifecycleListener[] findLifecycleListeners() {
    return listeners.toArray(new LifecycleListener[0]);
  }

  public void fireLifecycleEvent(String type, Object data) {
    LifecycleEvent event = new LifecycleEvent(lifecycle, type, data);
    for (LifecycleListener listener : listeners) {
      listener.lifecycleEvent(event);
    }
  }

  public void removeLifecycleListener(LifecycleListener listener) {
    listeners.remove(listener);
  }
}
