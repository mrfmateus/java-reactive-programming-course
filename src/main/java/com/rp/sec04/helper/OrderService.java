package com.rp.sec04.helper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

  private static final Map<Integer, List<PurchaseOrder>> db = new HashMap<>();

  static {
    final List<PurchaseOrder> ordersList1 = List.of(
            new PurchaseOrder(1),
            new PurchaseOrder(1),
            new PurchaseOrder(1));

    db.put(1, ordersList1);

    final List<PurchaseOrder> ordersList2 = List.of(
            new PurchaseOrder(2),
            new PurchaseOrder(2));

    db.put(2, ordersList2);
  }

  public static Flux<PurchaseOrder> getOrders(final int userId) {
    return Flux.create((FluxSink<PurchaseOrder> purchaseOrderFluxSink) -> {
      db.get(userId).forEach(purchaseOrderFluxSink::next);
      purchaseOrderFluxSink.complete();
    })
    .delayElements(Duration.ofSeconds(1));
  }
}
