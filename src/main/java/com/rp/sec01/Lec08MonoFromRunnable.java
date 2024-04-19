package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

  public static void main(String[] args) {
    Mono<Object> monoFromRunnable = Mono.fromRunnable(timeConsumingProcess());
    monoFromRunnable.subscribe(Util.onNext(),
            Util.onError(),
            () -> System.out.println("Process is done! Sending emails..."));
  }

  private static Runnable timeConsumingProcess() {
    return () -> {
      Util.sleepSeconds(3);
      System.out.println("Operation completed!");
    };
  }
}
