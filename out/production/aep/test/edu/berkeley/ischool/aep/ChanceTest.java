package edu.berkeley.ischool.aep;

import junit.framework.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Charles on 2014/1/31.
 */
public class ChanceTest {

    @Test
    public void chanceOfEqualHappening() {
        Chance chance1 = new Chance(0.6);
        Chance chance2 = new Chance(0.8);
        Assert.assertTrue(new Chance(0.6).equals(chance1));
        Assert.assertEquals(chance1, chance1);
        Assert.assertFalse(chance2.equals(chance1));
        Assert.assertEquals(new Chance(0.6), chance1);
    }
    @Test
    public void  chanceOfContractHappening() {
        Chance coinToss = new Chance(0.5);
        Assert.assertFalse(coinToss.equals(null));
        Map<Chance, String> map = new HashMap<Chance, String>();
        map.put(new Chance(0.5), "Coin Toss");
        Assert.assertEquals("Coin Toss", map.get(new Chance(0.5)));
        Assert.assertTrue(new Chance(0.5).equals(new Chance(0.5).not()));
    }
    @Test
    public void chanceOfAndHappening() {
        Chance chanceA = new Chance(0.6);
        Chance chanceB = new Chance(0.8);
        Chance chanceC = new Chance();
        //chanceA = chance(B*C) = chanceB * chanceC
        chanceC = chanceC.and(chanceA, chanceB);
        Assert.assertEquals(chanceC, new Chance(0.48));
    }

    @Test
    public void chanceOfOrHappening() {
        Chance chanceA = new Chance(0.2);
        Chance chanceB = new Chance(0.3);
        Chance chanceC = new Chance();
        //chanceA = chance(B|C) = chanceB | chanceC
        chanceC = chanceC.or(chanceA, chanceB);
        Assert.assertEquals(chanceC, new Chance(0.44)); //correct: 0.2+0.3-0.06=0.44
    }
    @Test
    public void chanceOfNewOrHappening() {
        Chance chanceA = new Chance(0.2);
        Chance chanceB = new Chance(0.3);
        Chance chanceC = new Chance();
        //chanceA = chance(B|C) = chanceB | chanceC
        chanceC = chanceC.or_new(chanceA, chanceB);
        Assert.assertEquals(chanceC, new Chance(0.44)); //correct: 0.2+0.3-0.06=0.44
    }

    @Test
    public void testBestChance(){
        Chance chanceA = new Chance(0.2);
        Chance chanceB = new Chance(0.3);
        Chance chanceC = new Chance(0.4);
        Assert.assertEquals(new Bester(chanceA, chanceB, chanceC).best(), chanceC);
    }

}
