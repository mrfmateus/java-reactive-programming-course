package com.rp.sec05;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec01ColdPublisher {

  public static void main(String[] args) {

    Flux<String> flux = Flux.fromStream(Lec01ColdPublisher::getMovie)
            .delayElements(Duration.ofSeconds(2));

    flux.subscribe(Util.subscriber("sam"));

    Util.sleepSeconds(5);

    flux.subscribe(Util.subscriber("mike"));

    Util.sleepSeconds(60);
  }

  private static Stream<String> getMovie() {
    System.out.println("Getting movie scenes...");

    return Stream.of(
            "Scene 1",
            "Scene 2",
            "Scene 3",
            "Scene 4",
            "Scene 5",
            "Scene 6",
            "Scene 7");
  }
}
