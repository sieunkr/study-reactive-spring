package com.example.demo;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class ReactorTests {


    @Test
    public void 리액티브_스트림_구독하기(){

        Flux.just("A", "B", "C")
                .subscribe(
                        data -> System.out.println("onNext" + data),
                        err -> {},
                        () -> System.out.println("onComplete"));

    }

    @Test
    public void 리액티브_스트림_구독하기_직접_제어(){

        Flux.range(1, 100)
                .subscribe(
                        data -> System.out.println("onNext" + data),
                        err -> {},
                        () -> System.out.println("onComplete"),
                        subscription -> {
                            subscription.request(3);
                            subscription.cancel();
                        }
                );
    }
}
