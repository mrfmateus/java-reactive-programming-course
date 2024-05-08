package com.rp.sec05;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec03HotPublish {

  public static void main(String[] args) {

    Flux<String> flux = Flux.fromStream(Lec03HotPublish::getMovie)
            .delayElements(Duration.ofSeconds(1))
//            .share() share = publish().refCount(1)
            .publish()
            .refCount(1);

    flux.subscribe(Util.subscriber("sam"));

    Util.sleepSeconds(10);

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
