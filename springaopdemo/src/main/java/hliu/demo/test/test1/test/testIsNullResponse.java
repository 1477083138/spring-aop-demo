package hliu.demo.test.test1.test;

import hliu.demo.test.test1.util.BeanUtil;

import java.util.ArrayList;
import java.util.HashMap;


public class testIsNullResponse {
    public static void main(String args[]){
        boolean bool = BeanUtil.isNullResponse(new ArrayList<>());
        System.out.println(bool);
    }
}
