package com.rp.sec01.assignment;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

  private static final Path PATH = Paths.get("src/main/resources/sec01/assignment");

  public static Mono<String> read(final String fileName) {
    return Mono.fromSupplier(() -> readFile(fileName));
  }

  public static Mono<Void> write(final String fileName, final String content) {
    return Mono.fromRunnable(() -> writeFile(fileName, content));
  }

  public static Mono<Void> delete(final String fileName) {
    return Mono.fromRunnable(() -> deleteFile(fileName));
  }

  private static String readFile(final String fileName) {
    try {
      return Files.readString(PATH.resolve(fileName));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void writeFile(final String fileName, final String content) {
    try {
      Files.writeString(PATH.resolve(fileName), content);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void deleteFile(final String fileName) {
    try {
      Files.delete(PATH.resolve(fileName));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
