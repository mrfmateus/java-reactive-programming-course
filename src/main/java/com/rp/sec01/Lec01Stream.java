package com.rp.sec01;

import java.util.stream.Stream;

public class Lec01Stream {
  public static void main(String[] args) {

    Stream<Integer> integerStream = Stream.of(1)
            .map(integer -> {
              try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }

              return integer * 2;
            });

    integerStream.forEach(System.out::println);
  }
}
