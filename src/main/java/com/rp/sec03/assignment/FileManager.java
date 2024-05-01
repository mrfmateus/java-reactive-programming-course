package com.rp.sec03.assignment;

import com.rp.courseutil.Util;

public class FileManager {

  public static void main(String[] args) {

    FileReaderService.readFileLines("File03.txt")
            .subscribe(Util.subscriber());
  }
}
