package com.test;

import org.junit.Test;

import java.io.PrintStream;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class LambdaTest {
    // 匿名内部类
    @Test
    public void test(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return Integer.compare(x,y);
            }

        };
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    @Test
    public void test2(){
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    List<Employee>  employees = Arrays.asList(
            new Employee("aa",18,99990),
            new Employee("bb",19,99999),
            new Employee("cc",28,99999),
            new Employee("dd",38,99999),
            new Employee("dd",38,99999),
            new Employee("dd",38,99999),
            new Employee("dd",38,99999),
            new Employee("ee",18,99999)
    );

    @Test
    public  void tes79(){
        List<String> aa = Arrays.asList("aa","pp","dd");
        Stream<Character> ss = aa.stream().flatMap(LambdaTest::filterCha);
        ss.forEach(System.out::println);
        String name = employees.stream().findFirst().orElseGet(Employee::new).getName();
        System.out.println(name);
        System.out.println("----------------");

        Optional<Double> mmm = employees.stream().map(Employee::getMoneg).min(Double::compareTo);
        System.out.println(mmm);

    }

    public static Stream<Character> filterCha(String str){
        List list = new ArrayList();
        for (Character ch : str.toCharArray()){
            list.add(ch);
        }
        return list.stream();

    }

    @Test
    public  void tes78(){
        employees.stream().filter((x) ->x.getAge()>18).skip(2).distinct().forEach(System.out::println);
    }



    @Test
    public void test3(){
        employees.stream()
                 .filter((e) -> e.getAge()>18)
                .limit(2)
                .forEach(System.out::println);



        employees.stream().map(Employee::getName)
                .forEach(System.out::println);
    }

    @Test
    public void test4(){
        PrintStream st = System.out;
        Consumer<String> con = System.out::println;
        con.accept("abcd");
    }

    @Test
    public  void test5(){
        Employee emp = new Employee();
        Supplier<String> sup = () -> emp.getName();
        String str = sup.get();
        System.out.println(str);

        Supplier<Integer> sup2 = () -> emp.getAge();
    }

    @Test
    public  void test6(){
        Comparator<Integer> com = Integer::compare;
        Integer in = com.compare(1,2);
        System.out.println(in);

    }

    @Test
    public  void tes76(){
        BiPredicate<String,String> bb = (x,y) -> x.equals(y);

        BiPredicate<String,String> bpp = String::equals;
        System.out.println(bpp.test("1" ,"2"));
    }

    @Test
    public  void tes77(){
        Supplier<Employee> sup = () -> new Employee();
        Employee ee1 = sup.get();
        System.out.println(ee1);

        Function<Integer,Employee> fun = Employee::new;
        Employee ee = fun.apply(110);
        System.out.println(ee);
    }



}
