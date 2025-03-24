package Tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException { // исключение на случай, когда scanner не нашёл файл

        // 1. Проверить строку на палиндром
        System.out.println("// --- 1. Проверить строку на палиндром ---");

        String str = "Строка для проверки на палиндром";
        Palindrome pal = new Palindrome(str);
        pal.checkPalindrome();

        System.out.println();
        //---------------------------------------------------

        // 2. переопределить equals И hashCode
        System.out.println("// ---2.  переопределить equals И hashCode ---");

        Person person = new Person(16, "Тимофей");
        Person person1 = new Person(16, "Тимофей");

        System.out.println("person1.hashCode: " + person1.hashCode());
        System.out.println("person.hashCode: " + person.hashCode());

        System.out.println("Сравнение: " + person.equals(person1));

        //---------------------------------------------------

        // 3. Считать данные из файла
        System.out.println("// --- 3. Считать данные из файла ---");

        File file = new File("files/textFile.txt");

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        scanner.close(); // нужно закрывать. чтобы освобождались ресурсы и закрывался поток.

        //---------------------------------------------------

        // 4. Создайте потокобезопасный счётчик с использованием synchronized


        //---------------------------------------------------

        // 5. Реализуйте простой стек (Stack) на основе массива.
        System.out.println("// --- 5. простой стек на основе массива ---");

        Stack<Integer> stack = new Stack<>();
        stack.push(16);
        stack.push(21);
        stack.push(4);
        stack.push(1);

        System.out.println(stack);
        //---------------------------------------------------

        // 6. Напишите метод, который сортирует список строк в обратном порядке.
        System.out.println("//--- 6. метод возвращающий список строк в обратном порядке ---");

        //---------------------------------------------------
        // 9. Реализуйте интерфейс Comparable для класса Employee (с полем salary)
        // проверка реализации
        System.out.println("//--- 9. Реализация интерфейса Comparable ---");

        List<Employee> employeeList = new ArrayList<>();
        Employee employee1 = new Employee(1, "Тимофей", 26);
        Employee employee2 = new Employee(2, "Тимофей", 26);
        Employee employee3 = new Employee(3, "Тимофей", 26);
        Employee employee4 = new Employee(4, "Тимофей", 26);

        System.out.println(employee1.compareTo(employee2));

        //---------------------------------------------------

        // 10. Напишите метод, который находит максимальное значение в списке чисел.
        System.out.println("//--- 10. метод, который находит максимальное значение в списке чисел---");
        int[] array = {16,21,12,1,2,9};
        System.out.println("Исходный массив: " + Arrays.toString(array));
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {max = array[i];}
        }
        System.out.println("Максимальное значение = " + max);

        // проще, конечно, стандартными средствами через List))
        List<Integer> list = new ArrayList<>();
        list.add(16);
        list.add(21);
        list.add(12);
        list.add(1);
        list.add(2);
        list.add(9);
        System.out.println("ArrayList : " + list);
        System.out.println("Максимальное значение = " + list.stream().max(Integer::compareTo).get());

        //---------------------------------------------------
        // 16. Создайте анонимный класс, реализующий интерфейс Runnable.
        System.out.println("// --- 16. Анонимный класс, реализующий интерфейс Runnable ---");
        Runnable anonymousRunner = new Runnable() {
            @Override
            public void run() {

            }
        };

        //---------------------------------------------------
        // 20. Создать класс Box с дженериком (Generic), который может хранить любой тип данных.
        System.out.println("// --- 20. Класс Box, который принимает любой тип данных ---");
        Box<Integer> integer = new Box<>();
        integer.setValue(12);
        Box<String> string = new Box<>();
        string.setValue("Строковое значение");
        Box<Boolean> bool = new Box<>();
        bool.setValue(true);

        System.out.println("int: " + integer.getValue());
        System.out.println("string: " + string.getValue());
        System.out.println("boolean: " + bool.getValue());
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
// 4. Создайте потокобезопасный счётчик с использованием synchronized.
class Runner implements Runnable {

    // переопределяем метод run интерфейса Runnable
    @Override
    public void run() {
        System.out.println();
    }
}

//---------------------------------------------------
// 9. Реализуйте интерфейс Comparable для класса Employee (с полем salary).

class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private int age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {return id;}

    @Override
    public int compareTo(Employee o) {
        // Делаем прям как написано в документации: a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object
        if (this.getId() == o.getId()) return 0;
        else if (this.getId() > o.getId()) return 1;
        else return -1;
    }

        public String toString(){
        return "Employee id = " + id +
                " name = " + name +
                " age = " + age;
    }
}

//---------------------------------------------------
// 14 реализовать класс immutable

//---------------------------------------------------
// 20. Создайте класс Box с дженериком (Generic), который может хранить любой тип данных.
 class Box<T> {

    private T value;

    public void setValue(T value) {
        this.value = value;
    }
    public T getValue() {return value;}
}


