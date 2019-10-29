package hliu.demo.lambda;

import hliu.demo.test.test1.bean.Person;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * lambda与stream的用法实践
 * **/
public class testLambda {
    public static void main(String args[]){
        Person person = new Person();
        person.setId("1111");
        person.setAge(24);
        person.setName("liuhao");
        person.setSex("male");

        Person person1 = new Person();
        person1.setId("1112");
        person1.setAge(24);
        person1.setName("liuhao");
        person1.setSex("male");

        Person person2 = new Person();
        person2.setId("1113");
        person2.setAge(24);
        person2.setName("liuhao1");
        person2.setSex("female");

        List<Person> mapList = new ArrayList<>();
        mapList.add(person);
        mapList.add(person1);
        mapList.add(person2);


        System.out.println(mapList);

        mapList.forEach(p->p.setAge(99));

        System.out.println(mapList);
        /**
         * filter collector.toList()
         * */

        List<Person> nameLiuHaoList = mapList.stream().filter(p->p.getName().equals("liuhao")).collect(Collectors.toList());

        System.out.println(nameLiuHaoList);

        nameLiuHaoList.forEach(p->p.setName("liuhao1"));

        System.out.println(nameLiuHaoList);

        /**
         * filter collector.toSet()
         * */
        Set<Person> personSet = mapList.stream().filter(p->p.getName().equals("liuhao1")).collect(Collectors.toSet());

        System.out.println(personSet);

        /**
         * filter mapToInt() sum()
         * */
        int sum = mapList.stream().filter(p->p.getName().equals("liuhao1")).mapToInt(p->p.getAge()).sum();

        System.out.println(sum);

        System.out.println(mapList);

        /**
         * Collectors.groupingBy() 按照某种属性分组
         * */
        Map<String,List<Person>> map = mapList.stream().collect(Collectors.groupingBy(p->p.getId()));

        System.out.println(map);


        String [] array = new String [] {"1","2","3","0","-1","A","C"};

        /**
         * 其他集合如数组也可以使用Stream进行操作 Arrays.stream()
         * */

        List<String> stringList = Arrays.stream(array).sorted().collect(Collectors.toList());

        System.out.println(stringList);

        /**
         *
         * sorted() Comparator.comparing() 按照某种属性进行排序
         * */

        List<Person> sortList = mapList.stream().sorted(Comparator.comparing(p->p.getSex())).collect(Collectors.toList());

        System.out.println(sortList);

        List<String> list = Stream.of(array).collect(Collectors.toList());

        System.out.println(list);

        /**
         * map() 对流中的元素进行操作
         * */
        System.out.println(list.stream().map(String::toLowerCase).collect(Collectors.toList()));

        System.out.println(list.stream().map(s->s.toLowerCase()).collect(Collectors.toList()));

        /**
         * flatmap() 合并流
         * */

        Arrays.stream(array).map(s->s.split("")).flatMap(Arrays::stream).forEach(System.out::println);

        System.out.println("-----------------------------------");

        /**
         * limit 操作 ，数字代表从起始位置开始截取几个元素
         * */

        list.stream().limit(3).forEach(System.out::println);

        System.out.println("-----------------------------------");

        /**
         * skip 操作，数字代表从起始位置开始跳过几个元素，
         * */
        list.stream().skip(1).forEach(System.out::println);

    }
}
