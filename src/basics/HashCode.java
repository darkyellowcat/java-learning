package basics;

import java.util.HashSet;
import java.util.Objects;

//public class HashCode {
//    public static void main(String[] args) {
//        //默认hashCode()行为
//        Object obj1 = new Object();
//        Object obj2 = new Object();
//        System.out.println(obj1.hashCode());
//        System.out.println(obj2.hashCode());
//        System.out.println(obj1.equals(obj2));
//        //对于String类，它重写了hashCode()方法，使得内容相同的字符串会返回相同的散列码
//        var s = "OK";
//        var t = new String("OK");
//        System.out.println(s.hashCode() + " " + t.hashCode()); // 输出相同的值
//        //
//    }
//}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public class HashCode {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();
        set.add(new Person("Alice", 30));
        set.add(new Person("Alice", 30));
        System.out.println(set.size()); // 输出1，逻辑正确
    }
}