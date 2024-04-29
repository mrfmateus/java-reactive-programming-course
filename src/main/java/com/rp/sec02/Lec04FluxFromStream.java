package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec04FluxFromStream {

  public static void main(String[] args) {

    List<Integer> integers = List.of(1, 2, 3, 4, 5);

    Flux<Integer> integerFlux = Flux.fromStream(() -> integers.stream());

    integerFlux.subscribe(
            Util.onNext(),
            Util.onError(),
            Util.onComplete());

    integerFlux.subscribe(
            Util.onNext(),
            Util.onError(),
            Util.onComplete());
  }
}
