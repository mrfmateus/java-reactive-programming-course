package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplierOrCallable {

  public static void main(String[] args) {

    // use Mono.just only when you have the data already
//    Mono<String> mono = Mono.just(getName());

    // from supplier
    Supplier<String> supplier = Lec05MonoFromSupplierOrCallable::getName;
    Mono<String> monoFromSupplier = Mono.fromSupplier(supplier);
    monoFromSupplier.subscribe(Util.onNext());

    // from callable
    Callable<String> callable = Lec05MonoFromSupplierOrCallable::getName;
    Mono<String> monoFromCallable = Mono.fromCallable(callable);
    monoFromCallable.subscribe(Util.onNext());
  }

  private static String getName() {
    System.out.println("Generating name...");
    return Util.faker().name().fullName();
  }
}
