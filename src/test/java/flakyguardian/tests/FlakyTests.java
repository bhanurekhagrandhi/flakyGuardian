package flakyguardian.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class FlakyTests {

    @Test
    public void timingFlake() throws InterruptedException {
        Thread.sleep((long)(Math.random()*100));
        Assert.assertTrue(System.currentTimeMillis()%2==0);
    }

    @Test
    public void randomFlake(){
        int value = new Random().nextInt(10);
        Assert.assertTrue(value > 2);
    }

    @Test
    public void fakeNetworkFlake() {
        int latency = new Random().nextInt(300);
        Assert.assertTrue(latency < 200);
    }

}
