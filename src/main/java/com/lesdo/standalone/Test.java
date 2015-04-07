package com.lesdo.standalone;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiangshan on 15/4/2.
 */
public class Test {
    public static void main(String[] args){
        new Test().test1();
    }

    private void test1(){
        Map<String, A> map = new HashMap<String, A>();
        A a1 = new A();
        A a2 = new A();

        map.put("a1", a1);

        A a = map.get("a1");
        System.out.println(a);

        A aa = map.get("a1");
        aa = a2;
        map.put("a1", a2);
        System.out.println(a);
        System.out.println(a1);
        System.out.println(aa);
        System.out.println(a2);
    }

    class A{
        public int id = 0;
    }

}


