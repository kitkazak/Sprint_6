package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class FelineTest {

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {1, 1},
                {2, 2},
                {3, 3}
        };
    }

    private final int kittensCount;
    private final int expectedKittensCount;

    public FelineTest(int kittensCount, int expectedKittensCount) {
        this.kittensCount = kittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Test
    public void getFamilyReturnsКошачьи() {
        Feline feline = new Feline();
        Assert.assertTrue(feline.getFamily().equals("Кошачьи"));
    }

    @Test
    public void eatMeatGetFoodCalledWithХищник() throws Exception {
        Feline spyFeline = Mockito.spy(new Feline());
        spyFeline.eatMeat();
        Mockito.verify(spyFeline).getFood("Хищник");
    }

    @Test
    public void getKittensNoArgsReturnsOne() {
        Feline feline = new Feline();
        Assert.assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithTestData() {
        Feline feline = new Feline();
        Assert.assertEquals(expectedKittensCount, feline.getKittens(kittensCount));
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

}
