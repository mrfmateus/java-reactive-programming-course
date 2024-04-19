package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {

  public static void main(String[] args) {

    userRepository(20).subscribe(
            Util.onNext(),
            Util.onError(),
            Util.onComplete());
  }

  private static Mono<String> userRepository(final int userId) {
    return switch (userId) {
      case 1 -> Mono.just(Util.faker().name().firstName());
      case 2 -> Mono.empty();
      default -> Mono.error(new RuntimeException("Not in allowed range!"));
    };
  }
}
