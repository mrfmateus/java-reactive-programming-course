package com.rp.sec04.helper;

import com.rp.courseutil.Util;
import lombok.Data;

@Data
public class User {

  private final int userId;
  private final String name;

  public User(int userId) {
    this.userId = userId;
    this.name = Util.faker().name().fullName();
  }
}
