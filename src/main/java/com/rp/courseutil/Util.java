package com.rp.courseutil;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

import java.util.function.Consumer;

public class Util {

  public static final Faker FAKER = Faker.instance();

  public static Consumer<Object> onNext() {
    return obj -> System.out.println("Received: " + obj);
  }

  public static Consumer<Throwable> onError() {
    return ex -> System.out.println("ERROR: " + ex.getMessage());
  }

  public static Runnable onComplete() {
    return () -> System.out.println("Completed");
  }

  public static Faker faker() {
    return FAKER;
  }

  public static void sleepSeconds(final long seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public static Subscriber<Object> subscriber() {
    return new DefaultSubscriber();
  }

  public static Subscriber<Object> subscriber(final String name) {
    return new DefaultSubscriber(name);
  }
}
