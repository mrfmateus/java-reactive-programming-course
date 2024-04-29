package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec03FluxFromArrayOrList {

  public static void main(String[] args) {

    // from list
    List<String> strings = List.of("a", "b", "c");
    Flux<String> stringFlux = Flux.fromIterable(strings);
    stringFlux.subscribe(Util.onNext());

    // from array
    Integer[] integers = {2, 4, 6, 8};
    Flux<Integer> integerFlux = Flux.fromArray(integers);
    integerFlux.subscribe(Util.onNext());
  }
}
