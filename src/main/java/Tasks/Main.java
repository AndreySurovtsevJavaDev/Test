package Tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException { // исключение на случай, когда scanner не нашёл файл

        // 1. Проверить строку на палиндром
        System.out.println("// --- Проверить строку на палиндром ---");

        String str = "Строка для проверки на палиндром";
        Palindrome pal = new Palindrome(str);
        pal.checkPalindrome();

        System.out.println();
        //---------------------------------------------------

        // 2. переопределить equals И hashCode
        System.out.println("// --- переопределить equals И hashCode ---");

        Person person = new Person(16, "Тимофей");
        Person person1 = new Person(16, "Тимофей");

        System.out.println("person1.hashCode: " + person1.hashCode());
        System.out.println("person.hashCode: " + person.hashCode());

        System.out.println("Сравнение: " + person.equals(person1));

        //---------------------------------------------------

        // 3. Считать данные из файла
        System.out.println("// --- Считать данные из файла ---");

        File file = new File("files/textFile.txt");

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        scanner.close(); // нужно закрывать. чтобы освобождались ресурсы и закрывался поток.
        //---------------------------------------------------

        // 4. Реализуйте простой стек (Stack) на основе массива.
        System.out.println("// --- реализация простого стека на основе массива ---");



    }
}

//---------------------------------------------------
// класс Palindrome для задачи 1

class Palindrome{
    public String str;

    public Palindrome(String str){
        this.str = str;
    }

    public void checkPalindrome(){
        System.out.print(str);
        System.out.println();

        for (int i = 0, j = str.length() - 1; i < j ;i++, j--) {
            System.out.print(str.charAt(i));
            System.out.print(str.charAt(j));
        }
    }
}

//---------------------------------------------------
// класс Person для задачи 2

class Person {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//---------------------------------------------------
// класс Stack для задачи 4 (Реализуйте простой стек (Stack) на основе массива.)

class StackEx {

}

//---------------------------------------------------
// 14 реализовать класс immutable


