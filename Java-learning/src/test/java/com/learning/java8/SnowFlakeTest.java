package com.learning.java8;
import com.learning.java8.utils.SnowFlake;
import org.junit.Test;

public class SnowFlakeTest {

    @Test
    public void snowFlake(){

        SnowFlake snowFlake = new SnowFlake(31, 31);
        System.out.println(snowFlake.nextId());
        System.out.println(snowFlake.nextId());

    }

}
