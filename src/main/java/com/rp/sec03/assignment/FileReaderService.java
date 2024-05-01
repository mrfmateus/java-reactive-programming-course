package com.rp.sec03.assignment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FileReaderService {

  private static final Path PATH = Paths.get("src/main/resources/sec03/assignment");

  public static Flux<String> readFileLines(final String fileName) {
    return Flux.generate(
            openReader(fileName),
            emitLine(),
            closeReader());
  }

  private static Callable<BufferedReader> openReader(final String fileName) {
    return () -> {
      BufferedReader bufferedReader = Files.newBufferedReader(PATH.resolve(fileName));
      System.out.println("Reader opened.");

      return bufferedReader;
    };
  }

  private static BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> emitLine() {
    return (reader, sink) -> {
      try {
        String lineRead = reader.readLine();

        if (lineRead == null) {
          sink.complete();
        } else {
          sink.next(lineRead);
        }
      } catch (IOException e) {
        sink.error(e);
      }

      return reader;
    };
  }

  private static Consumer<BufferedReader> closeReader() {
    return reader -> {
      try {
        reader.close();
        System.out.println("Reader closed.");
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    };
  }
}
