package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
public class CustomHashTest {
    CustomHash<String,String> custom;
    @Before
    public void setUp(){
        custom = new CustomHash();
        custom.put("first","a");
        custom.put("first","a");
        custom.put("second","b");
        custom.put("third","c");
        custom.put("fourth","d");
        custom.put("fifth","d");
    }


    @Test
    public void testMap(){
        System.out.println(custom.get("first").getValue());

    }
}
