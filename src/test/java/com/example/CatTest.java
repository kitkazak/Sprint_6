package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundReturnsМяу() {
        Cat cat = new Cat(feline);
        Assert.assertEquals("getSound() должен вернуть\"Мяу\" ", "Мяу", cat.getSound());
    }

    @Test
    public void getFoodPredatorEatMeatCalled() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}
