package petarran.springframework.domain_model;

import java.util.concurrent.atomic.AtomicInteger;

public class SafeCounterWithoutLock {
    private final AtomicInteger counter = new AtomicInteger(1025);

    public int getValue() {
        return counter.incrementAndGet();
    }
}