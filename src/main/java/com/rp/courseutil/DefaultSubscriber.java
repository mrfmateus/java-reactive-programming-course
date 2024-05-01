package com.rp.courseutil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriber implements Subscriber<Object> {

  private String name = "";

  public DefaultSubscriber() {
  }

  public DefaultSubscriber(final String name) {
    this.name = name + " - ";
  }

  @Override
  public void onSubscribe(final Subscription subscription) {
    subscription.request(Long.MAX_VALUE);
  }

  @Override
  public void onNext(final Object o) {
    System.out.println(name + "Received: " + o);
  }

  @Override
  public void onError(final Throwable throwable) {
    System.out.println(name + "ERROR: " + throwable.getMessage());
  }

  @Override
  public void onComplete() {
    System.out.println(name + "Completed!");
  }
}
