package com.rp.sec02;

import com.rp.courseutil.Util;
import com.rp.sec02.helper.NameGenerator;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec07FluxVsList {

  public static void main(String[] args) {

    // from list, the process is blocked until finish all name generations
    // when the process is finished, we have all the names at once
    System.out.println("Starting list process...");
    List<String> namesList = NameGenerator.getNames(5);
    System.out.println(namesList);

    Util.sleepSeconds(3);

    // from flux, the process is not blocked. We get the names on demand
    // as soon as they are generated
    System.out.println("Starting flux process...");
    Flux<String> namesFlux = NameGenerator.getNamesFromFlux(5);
    namesFlux.subscribe(Util.onNext());
  }
}
