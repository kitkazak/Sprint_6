package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test(expected = Exception.class)
    public void constructorNoSexThrowsException() throws Exception {
        Lion lion = new Lion("No sex", feline);
    }

    @Test
    public void getKittensFelineGetKittensCalled() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void doesHaveManeСамецReturnsTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Assert.assertTrue("Самец doesHaveMane() должен вернуть true", lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeСамкаReturnsFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Assert.assertFalse("Самка doesHaveMane() должен вернуть false", lion.doesHaveMane());
    }

    @Test
    public void getFoodFelineGetFoodCalledWithХищник() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }
}
