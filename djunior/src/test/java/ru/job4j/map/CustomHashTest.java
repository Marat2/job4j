package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
public class CustomHashTest {
    SecondCustomHash<String,String> custom;
    @Before
    public void setUp(){
        custom = new SecondCustomHash<String,String>();
        custom.put("first","a");
        custom.put("first","a");
        custom.put("second","b");
        custom.put("third","c");
        custom.put("fourth","d");
        custom.put("fifth","d");
        custom.put("sd","cc");
        custom.put("fg","dg");
        custom.put("df","dj");
    }


    @Test
    public void testMap(){
        //custom.remove("df");
        Iterator<String> iterator = custom.iterator();
        while(iterator.hasNext()){
            String value = iterator.next();
            if(value!=null){
                System.out.println(value);
            }

        }
    }
}
