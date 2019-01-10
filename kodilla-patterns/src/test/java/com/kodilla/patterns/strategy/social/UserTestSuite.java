package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User frederick = new Millenials("Frederick");
        User john = new YGeneration("John");
        User ip = new ZGeneration("Ip");

        //When
        String frederikUse = frederick.getPersonName() + " use " + frederick.sharePost();
        System.out.println(frederikUse);
        String johnUse = john.getPersonName() + " use " + john.sharePost();
        System.out.println(johnUse);
        String ipUse = ip.getPersonName() + " use " + ip.sharePost();
        System.out.println(ipUse);

        //Then
        Assert.assertEquals("Frederick use F***book" , frederikUse);
        Assert.assertEquals("John use Twitter" ,johnUse);
        Assert.assertEquals("Ip use Snapchat" ,ipUse);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User frederick = new Millenials("Frederick");

        //When
        String frederikUse = frederick.getPersonName() + " use " + frederick.sharePost();
        System.out.println(frederikUse);
        frederick.setSocialPublisher(new TwitterPublisher());
        frederikUse = frederick.getPersonName() + " use " + frederick.sharePost();
        System.out.println(frederikUse);

        //Then
        Assert.assertEquals("Frederick use Twitter", frederikUse);
    }
}
