package com.rp.sec04.helper;

import com.rp.courseutil.Util;
import lombok.Data;

@Data
public class Person {

  private String name;
  private int age;

  public Person() {
    this.name = Util.faker().name().fullName();
    this.age = Util.faker().random().nextInt(1, 30);
  }
}
