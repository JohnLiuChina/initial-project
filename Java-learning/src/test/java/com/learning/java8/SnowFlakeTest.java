package com.learning.java8;
import com.alibaba.fastjson.JSONObject;
import com.learning.java8.utils.SnowFlake;
import lombok.Data;
import org.junit.Test;

public class SnowFlakeTest {

    @Test
    public void snowFlake(){

        SnowFlake snowFlake = new SnowFlake(31, 31);
        System.out.println(snowFlake.nextId());
        System.out.println(snowFlake.nextId());

    }

    @Data
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    @Test
    public void obj(){

        ListNode a = new ListNode(2);
        ListNode b = a;
        a.next = new ListNode(5);
        a = a.next;
        a.next = new ListNode(5);

        System.out.println(a);
        System.out.println(b);


    }

}
