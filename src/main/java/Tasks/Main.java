package Tasks;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException { // исключение на случай, когда scanner не нашёл файл

        // 1. Проверить строку на палиндром
        System.out.println("// --- 1. Проверить строку на палиндром ---");

        String str = "белиберда";
        String str2 = "sator arepo tennet opera rotas";
        LocalMethods.checkPalindrome(str);
        LocalMethods.checkPalindrome(str2);

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

        FileReader file = new FileReader("files/textFile.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close(); // нужно закрывать. чтобы освобождались ресурсы и закрывался поток.

        //---------------------------------------------------

        // 4. Создайте потокобезопасный счётчик с использованием synchronized
        System.out.println("// --- 4. потокобезопасный счётчик с использованием synchronized ---");
        LocalMethods newCounter = new LocalMethods();
        for (int i = 0; i < 5; i++) {
            newCounter.increment();
        }

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

        String[] arr = {"1", "2", "три", "4", "5", "шесть"};
        System.out.println("Исходный массив: " + Arrays.toString(arr));

        String[] newArr = LocalMethods.reverse(arr);
        System.out.println("Отсортированный массив: " + Arrays.toString(newArr));

        //---------------------------------------------------
        // 7.Создайте класс Singleton с ленивой инициализацией

        //---------------------------------------------------
        // 8. Напишите код, который демонстрирует deadlock.

        //---------------------------------------------------
        // 9. Реализуйте интерфейс Comparable для класса Employee (с полем salary)
        System.out.println("//--- 9. Реализация интерфейса Comparable ---");

        List<Employee> employeeList = new ArrayList<>();
        Employee employee1 = new Employee(1, "Тимофей", 2600);
        Employee employee2 = new Employee(2, "Тимофей", 2600);
        Employee employee3 = new Employee(3, "Тимофей", 2700);
        Employee employee4 = new Employee(4, "Тимофей", 2500);

        System.out.println(employee1.compareTo(employee2));
        if (employee1.compareTo(employee2) < 0) {
            System.out.println("меньше");
        } else if (employee1.compareTo(employee2) > 0) {
            System.out.println("больше");
        } else {
            System.out.println("одинаково");
        };

        //---------------------------------------------------
        // 10. Напишите метод, который находит максимальное значение в списке чисел.
        System.out.println("//--- 10. метод, который находит максимальное значение в списке чисел---");

        int[] array = {16,21,12,1,2,9};
        System.out.println("Исходный массив: " + Arrays.toString(array));

        LocalMethods.getMaxArrayValue(array);

        // проще, конечно, стандартными средствами через List))
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            list.add((int)(Math.random() * 30));
        }
        System.out.println("ArrayList : " + list);
        System.out.println("Максимальное значение = " + list.stream().max(Integer::compareTo).get());

        //---------------------------------------------------
        // 11. Поток, который выводит числа от 1 до 10 с задержкой в 1 секунду.
        System.out.println("//--- 11. Поток, который выводит числа от 1 до 10 с задержкой в секунду---");

        MultiThread counterThread = new MultiThread();
        counterThread.run();

        //---------------------------------------------------
        // 12. Реализуйте простой кэш на основе HashMap


        //---------------------------------------------------
        // 13. Напишите метод, который удаляет дубликаты из списка строк
        System.out.println("//--- 13. метод,который удаляет дубликаты из списка строк---");

        String[] stringArray = {"1", "2", "три", "4", "5", "шесть", "2", "4", "Шесть", "2", "4", "Три"};
        System.out.println("Исходный массив строк: " + Arrays.toString(stringArray));

        LocalMethods.deleteDuplicate(stringArray);

        //---------------------------------------------------
        // 14. Реализуйте класс ImmutableClass (неизменяемый класс)
        System.out.println("// --- 14 Реализация класса ImmutableClass---");

        //---------------------------------------------------
        // 15. Напишите код, который демонстрирует работу try-with-resources
        System.out.println("// --- 15 демонстрация работы try-with-resources---");
        FileReader fileReader = new FileReader("files/textFile.txt");
        try(Scanner scanner1 = new Scanner(fileReader);){
            while (scanner1.hasNextLine()) {
                System.out.println(scanner1.nextLine());
            }
            throw new RuntimeException("Ошибка");
        } catch (Exception e) {
            System.out.println("Ошибка обработана");
        }

        //---------------------------------------------------
        // 16. Создайте анонимный класс, реализующий интерфейс Runnable.
        System.out.println("// --- 16. Анонимный класс, реализующий интерфейс Runnable ---");
        Runnable anonymousRunner = new Runnable() {
            @Override
            public void run() {

            }
        };

        //---------------------------------------------------
        //  17.  метод, который преобразует список строк в одну строку через запятую
        System.out.println("//--- 17. Метод, который преобразует список строк в одну строку, через запятую ---");

        LocalMethods.concatArrayToString(stringArray);

        //---------------------------------------------------
        // 18. Проверка баланса BankAccount
        System.out.println("//--- 18. проверка баланса BankAccount ---");


        //---------------------------------------------------
        // 19. Напишите код, который демонстрирует работу Stream API для фильтрации списка чисел
        System.out.println("//--- 19. фильтрация списка чисел с помощью Stream API ---");

        final List<Integer> listNumber = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listNumber.add((int)(Math.random() * 50));
        }
        System.out.println("Исходный массив: " + listNumber);

        System.out.print("После фильтрации остались: ");
        listNumber.stream()
                .filter( x -> x < 15 )      // отбираем элементы, значения которых меньше 15.
                .forEach(x -> System.out.print(x + ", "));

        System.out.println();

        //---------------------------------------------------
        // 20. класс Box с дженериком (Generic), который может хранить любой тип данных.
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
// Общий класс для разных методов из задач
class LocalMethods{
    // 1. Проверка на Palindrome
    public static void checkPalindrome(String str){
        System.out.println("Входящая строка: " + str);

        boolean palindrome = true;
        for (int i = 0, j = str.length() - 1; i < j ;i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                palindrome = false;
                break;}
        }

        if (palindrome == true) {
            System.out.println("Палиндром");
        } else {
            System.out.println("Не палиндром");
        }
    }

    //---------------------------------------------------
    // 4. synchronized
    int counter = 0;
    public synchronized void increment() {
       counter++;
        System.out.println(" * " + counter + " * "); // чтобы можно было отличить выдачу из разных потоков
    }

    //---------------------------------------------------
    // 6. метод, который сортирует список строк в обратном порядке.
    public static String[] reverse(String[] array) {
        String[] newArray = new String[array.length];
        for (int i = array.length - 1, j = 0; i >= 0; i--, j++) {
            newArray[j] = array[i];
        }
        return newArray;
    }

    //---------------------------------------------------
    // 10  метод, который находит максимальное значение в списке чисел.
    public static int getMaxArrayValue(int[] array) {
        int[] newArray = Arrays.copyOf(array, array.length);
        int max = 0;
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] > max) {
                max = newArray[i];
            }
        }
        System.out.println("Максимальное значение = " + max);
        return max;
    }

    //---------------------------------------------------

    // 13. Метод, который удаляет дубликаты из списка строк
    // Знаю, что это максимально не оптимально и медленно и лучше использовать коллекцию List
    public static String[] deleteDuplicate(String[] array) {
        int duplicates = 0;
        String[] newTempArray = Arrays.copyOf(array, array.length);
        for (int i = 0; i < newTempArray.length - 1; i++) {
            for (int j = i + 1; j < newTempArray.length; j++) {
                if (array[i].equals(array[j])) {
                   duplicates++;
                    newTempArray[i] = null;
                }
            }
        }
        System.out.println("кол-во дублей: " + duplicates);
        String[] newArray = new String[array.length - duplicates];
        for (int i = 0; i < newArray.length; i++){
            if(array[i] != (null)){
                newArray[i] = array[i];
            }
        }
        System.out.println("Массив без дублей: " + Arrays.toString(newArray));
        return newArray;
    }

    //---------------------------------------------------
    // 17. Напишите метод, который преобразует список строк в одну строку через запятую
    public static void concatArrayToString (String[] arr){
        StringBuilder result = new StringBuilder();
        for(String i: arr){
            result.append(i).append(", ");
        }
        System.out.println(result);
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
                "salary=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//---------------------------------------------------
//

//---------------------------------------------------
// 7. класс Singleton с ленивой инициализацией


//---------------------------------------------------
// 9. Реализуйте интерфейс Comparable для класса Employee (с полем salary).

class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {return salary;}

    @Override
    public int compareTo(Employee o) {
        // Делаем прям как написано в документации: a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object
        if (this.getSalary() == o.getSalary()) return 0;
        else if (this.getSalary() > o.getSalary()) return 1;
        else return -1;
    }

        public String toString(){
        return "Employee id = " + id +
                " name = " + name +
                " salary = " + salary;
    }
}

//---------------------------------------------------
// 11 Создайте поток, который выводит числа от 1 до 10 с задержкой в 1 секунду
class MultiThread implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(" -- " + i + " -- ");          // пометил так, чтобы лучше было видно как выполняется в консоли, тк идёт не последовательно

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


//---------------------------------------------------
// 14 реализовать класс immutable

final class ImmutableClass {
    final String name;
    final int age;
    public ImmutableClass(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

//---------------------------------------------------
// 18. Реализуйте класс BankAccount с методами deposit() и withdraw() (с проверкой баланса)
class BankAccount {
    public static void deposit(){

    };

    public static void withdraw(){

    }
}

//---------------------------------------------------
// 20. Создайте класс Box с дженериком (Generic), который может хранить любой тип данных.
 class Box<T> {

    private T value;

    public void setValue(T value) {
        this.value = value;
    }
    public T getValue() {return value;}
}


