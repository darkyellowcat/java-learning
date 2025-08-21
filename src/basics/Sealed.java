package basics;

public class Sealed {
    // Sealed类允许定义受限的继承结构
    public sealed class Animal permits Dog, Cat {
        public void makeSound() {
        }
    }

    // final子类
    public final class Dog extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Woof");
        }
    }

    // non-sealed子类
    public non-sealed class Cat extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Meow");
        }
    }

    // 继承自Cat的子类
    public class DarkYellowCat extends Cat {
        @Override
        public void makeSound() {
            System.out.println("Dark Yellow Meow");
        }
    }

    public static void main(String[] args) {
        Sealed sealed = new Sealed();  // 先创建外部类实例

        Animal dog = sealed.new Dog();  // 通过外部类实例创建内部类实例
        dog.makeSound();

        Animal cat = sealed.new Cat();
        cat.makeSound();

        Animal darkYellowCat = sealed.new DarkYellowCat();
        darkYellowCat.makeSound();
    }
}