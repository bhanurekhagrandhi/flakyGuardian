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
    public void step2(){
        Assert.assertTrue(initialized);
    }

    @Test
    public void step3() throws InterruptedException {
        Thread.sleep( new Random().nextInt(50));
        initialized=false;
    }

    @Test
    public void step4(){
        Assert.assertTrue(initialized);
    }

    @Test
    public void step5() throws InterruptedException {
        Thread.sleep( new Random().nextInt(50));
        initialized=true;
    }

    @Test
    public void step6(){
        Assert.assertTrue(initialized);
    }
}
