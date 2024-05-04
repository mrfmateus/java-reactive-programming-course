package com.rp.sec04;

import com.rp.courseutil.Util;
import com.rp.sec04.helper.OrderService;
import com.rp.sec04.helper.UserService;

import java.util.Map;

public class Lec12FlatMap {

  public static void main(String[] args) {

    UserService.getUsers()
            .flatMap(user -> OrderService.getOrders(user.getUserId()))
            .subscribe(Util.subscriber());

    Util.sleepSeconds(60);
  }
}
