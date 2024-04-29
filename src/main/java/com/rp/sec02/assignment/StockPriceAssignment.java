package com.rp.sec02.assignment;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class StockPriceAssignment {

  public static void main(String[] args) throws InterruptedException {

    CountDownLatch latch = new CountDownLatch(1);

    StockPricePublisher.getPrice()
            .subscribeWith(new Subscriber<Integer>() {

              private Subscription subscription;
              @Override
              public void onSubscribe(final Subscription subscription) {
                this.subscription = subscription;
                subscription.request(Long.MAX_VALUE);
              }

              @Override
              public void onNext(final Integer price) {
                System.out.println(LocalDateTime.now() + " Current Price: US$ " + price);
                if (price < 90 || price > 110) {
                  this.subscription.cancel();
                  latch.countDown();
                }
              }

              @Override
              public void onError(final Throwable throwable) {
                latch.countDown();
              }

              @Override
              public void onComplete() {
                latch.countDown();
              }
            });

    latch.await();
  }
}
