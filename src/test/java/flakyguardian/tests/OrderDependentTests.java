package flakyguardian.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class OrderDependentTests {

    static boolean initialized=false;
    @Test
    public void step1() throws InterruptedException {
        Thread.sleep( new Random().nextInt(50));
        initialized=true;
    }
    @Test
    public void step2() throws InterruptedException {
        Thread.sleep((long)(Math.random()*100));
        Assert.assertTrue(initialized);
    }

}
