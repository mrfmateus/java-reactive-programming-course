package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec03DoCallbacks {
  public static void main(String[] args) {

    Flux.create(fluxSink -> {
              System.out.println("inside create");
              for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
              }

//              fluxSink.complete();
              fluxSink.error(new RuntimeException("Oops!"));
    })
            .doOnComplete(() -> System.out.println("doOnComplete"))
            .doFirst(() -> System.out.println("doFirst"))
            .doOnNext(o -> System.out.println("doOnNext: " + o))
            .doOnSubscribe(subscription -> System.out.println("doOnSubscribe: " + subscription))
            .doOnRequest(value -> System.out.println("doOnRequest: " + value))
            .doOnError(ex -> System.out.println("doOnError: " + ex.getMessage()))
            .doOnTerminate(() -> System.out.println("doOnTerminate"))
            .doOnCancel(() -> System.out.println("doOnCancel"))
            .doFinally(signalType -> System.out.println("doFinally 1: " + signalType))
            .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard: " + o))
            .take(2)
            .doFinally(signalType -> System.out.println("doFinally 2: " + signalType))
            .subscribe(Util.subscriber());
  }
}
