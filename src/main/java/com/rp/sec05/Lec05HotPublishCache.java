package com.rp.sec05;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec05HotPublishCache {

  public static void main(String[] args) {

    Flux<String> flux = Flux.fromStream(Lec05HotPublishCache::getMovie)
            .delayElements(Duration.ofSeconds(1))
            .cache(2); // cache = publish().replay()

    Util.sleepSeconds(2);

    System.out.println("sam is about to join");
    flux.subscribe(Util.subscriber("sam"));

    Util.sleepSeconds(10);

    System.out.println("mike is about to join");
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
