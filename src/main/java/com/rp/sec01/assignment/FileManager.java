package com.rp.sec01.assignment;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class FileManager {

  public static void main(String[] args) {
    Mono<String> read = FileService.read("File1.txt");
    read.subscribe(
            content -> System.out.println("File content read: " + content),
            Util.onError(),
            () -> System.out.println("File read completed!"));

    Mono<Void> write = FileService.write("File2.txt", "Text from file2.");
    write.subscribe(
            Util.onNext(),
            Util.onError(),
            () -> System.out.println("File write completed!"));

    Mono<Void> delete = FileService.delete("File2.txt");
    delete.subscribe(
            Util.onNext(),
            Util.onError(),
            () -> System.out.println("File delete completed!"));
  }
}
