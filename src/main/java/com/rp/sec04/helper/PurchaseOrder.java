package com.rp.sec04.helper;

import com.rp.courseutil.Util;
import lombok.Data;

@Data
public class PurchaseOrder {

  private final int userId;
  private final String item;
  private final String price;

  public PurchaseOrder(int userId) {
    this.userId = userId;
    this.item = Util.faker().commerce().productName();
    this.price = Util.faker().commerce().price();
  }
}
