package flakyguardian.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StableTest {

    @Test
    public void alwaysPasses(){
        Assert.assertTrue(true);
    }
    @Test
    public void simpleMath(){
        Assert.assertEquals(2+2,4);
    }
}
