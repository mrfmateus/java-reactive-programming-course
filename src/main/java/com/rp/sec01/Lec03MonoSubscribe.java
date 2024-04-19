package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

  public static void main(String[] args) {

    // publisher
    Mono<Integer> mono = Mono.just("ball")
            .map(String::length)
            .map(length -> length / 1);

    // option 1
//    mono.subscribe();

    // option 2
    mono.subscribe(
            Util.onNext(),
            Util.onError(),
            Util.onComplete()
    );
  }
}
