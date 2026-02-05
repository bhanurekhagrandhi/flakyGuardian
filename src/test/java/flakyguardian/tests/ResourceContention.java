package flakyguardian.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ResourceContention {

    @Test
    public void cpuSensitiveTest() {
        long start = System.nanoTime();

        double value = 0;
        for (int i = 0; i < 50_000_000; i++) {
            value += Math.sqrt(i);
        }

        long durationMs = (System.nanoTime() - start) / 1_000_000;

        Assert.assertTrue(durationMs < 100, "Took too long: " + durationMs + "ms");
    }

    @Test
    public void gcSensitiveTest() {
        long before = Runtime.getRuntime().freeMemory();

        List<byte[]> memoryHog = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            memoryHog.add(new byte[5_000_000]);
        }

        long after = Runtime.getRuntime().freeMemory();

        Assert.assertTrue(after > before / 2, "GC pressure detected");
    }
}
