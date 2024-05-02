package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.util.function.BiConsumer;

public class Lec01Handle {

  public static void main(String[] args) {

    Flux.range(1, 20)
            .handle(handleFlux())
            .subscribe(Util.subscriber());
  }

  private static BiConsumer<Integer, SynchronousSink<Object>> handleFlux() {
    return ((integer, sink) -> {
      if (integer % 2 == 0) {
        sink.next(integer);
      } else {
        sink.next(integer + "a");
      }
    });
  }
}
