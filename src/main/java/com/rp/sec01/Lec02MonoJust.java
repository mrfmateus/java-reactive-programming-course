package com.rp.sec01;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {

  public static void main(String[] args) {

    // publisher
    Mono<Integer> integerMono = Mono.just(1);

    integerMono.subscribe(integer -> System.out.println("Received: " + integer));
  }
}
