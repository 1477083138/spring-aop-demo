package hliu.demo.test.test1.test;


import com.alibaba.fastjson.JSON;
import hliu.demo.test.test1.bean.LbStatus;
import hliu.demo.test.test1.bean.Person;

public class testLbStatus {
        public static void main(String args[]){

            Person person = new Person();
            person.setStatus(LbStatus.unavailable);
            System.out.println(person);

            Person person1 = JSON.parseObject(JSON.toJSONString(person),Person.class);

            System.out.println(person1);
        }
}
