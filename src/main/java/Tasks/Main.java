package Tasks;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
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
        // 7. класс Singleton с ленивой инициализацией
        System.out.println("//--- 7. Ленивая инициализация ---");
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);

        //---------------------------------------------------
        // 8. Напишите код, который демонстрирует deadlock.

        //---------------------------------------------------
        // 9. Реализуйте интерфейс Comparable для класса Employee (с полем salary)
        System.out.println("//--- 9. Реализация интерфейса Comparable ---");

        Employee employee1 = new Employee(1, "Тимофей", 2600);
        Employee employee2 = new Employee(2, "Тимофей", 2400);

        System.out.println(employee1.compareTo(employee2));
        if (employee1.compareTo(employee2) < 0) {
            System.out.println("меньше");
        } else if (employee1.compareTo(employee2) > 0) {
            System.out.println("больше");
        } else {
            System.out.println("одинаково");
        }

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
        System.out.println("Максимальное значение = " + list.stream()
                .max(Integer::compareTo)
                .get());

        //---------------------------------------------------
        // 11. Поток, который выводит числа от 1 до 10 с задержкой в 1 секунду.
        System.out.println("//--- 11. Поток, который выводит числа от 1 до 10 с задержкой в секунду---");

        MultiThread counterThread = new MultiThread();
        counterThread.run();

        //---------------------------------------------------
        // 12. Реализуйте простой кэш на основе HashMap
        System.out.println("//--- 12. простой кэш на основе hashMap---");

        // ну пусть будет список файлов с айдишниками
        Map<Integer, String> hash = new HashMap<>();
        hash.put(1, "АООК");
        hash.put(2, "АОСР");
        hash.put(3, "Акт приёмки кровли");
        hash.put(4, "Акт об окончании пусконаладочных работ");
        hash.put(5, "Акт готовности электромонтажных работ");
        hash.put(6, "Акт осмотра открытых рвов и котлованов под фундаменты");

        System.out.println(hash);

        //---------------------------------------------------
        // 13. Напишите метод, который удаляет дубликаты из списка строк
        System.out.println("//--- 13. метод,который удаляет дубликаты из списка строк---");

        String[] stringArray = {"1", "2", "три", "4", "5", "шесть", "2", "4", "Шесть", "2", "4", "Три"};
        System.out.println("Исходный массив строк: " + Arrays.toString(stringArray));

        LocalMethods.deleteDuplicate(stringArray);

        //---------------------------------------------------
        // 14. Реализуйте класс ImmutableClass (неизменяемый класс)
        System.out.println("// --- 14 Реализация класса ImmutableClass---");
        ImmutableClass immutableValue = new ImmutableClass();
        double goldenRatioNumber = immutableValue.getGoldenRatioNumber();

        System.out.println("Золотое сечение = " + goldenRatioNumber);

        //---------------------------------------------------
        // 15. Напишите код, который демонстрирует работу try-with-resources
        System.out.println("// --- 15 демонстрация работы try-with-resources---");
        FileReader fileReader = new FileReader("files/textFile.txt");
        try(Scanner scanner1 = new Scanner(fileReader)){
            while (scanner1.hasNextLine()) {
                System.out.println(scanner1.nextLine());
            }
            throw new RuntimeException("Ошибка");
        } catch (Exception e) {
            System.out.println("Ошибка обработана");
        }

        //---------------------------------------------------
        // 16. Создайте анонимный класс, реализующий интерфейс Runnable.
        // Лямбда выражение idea сделала сама, объяснить не смогу.
        System.out.println("// --- 16. Анонимный класс, реализующий интерфейс Runnable ---");
        Runnable anonymousRunner;
        anonymousRunner = () -> System.out.println("реализовали интерфейс Runnable через анонимный класс");

        anonymousRunner.run();

        //---------------------------------------------------
        //  17.  метод, который преобразует список строк в одну строку через запятую
        System.out.println("//--- 17. Метод, который преобразует список строк в одну строку, через запятую ---");

        LocalMethods.concatArrayToString(stringArray);

        //---------------------------------------------------
        // 18. Проверка баланса BankAccount
        System.out.println("//--- 18. проверка баланса BankAccount ---");

        BankAccount onotoleAccount = new BankAccount("Онотоле");

        onotoleAccount.deposit("160.58");
        onotoleAccount.getBalance();
        onotoleAccount.withdraw("160.59");
        onotoleAccount.withdraw("160.0");
        onotoleAccount.withdraw("0.58");
        onotoleAccount.deposit("50.0");
        onotoleAccount.getBalance();

        //---------------------------------------------------
        // 19. Напишите код, который демонстрирует работу Stream API для фильтрации списка чисел
        System.out.println("//--- 19. фильтрация списка чисел с помощью Stream API ---");

        final List<Integer> listNumber = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listNumber.add((int)(Math.random() * 50));
        }
        System.out.println("Исходный массив: " + listNumber);
        System.out.println("Условие для фильтра: оставить значения < 15");
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

        if (palindrome) {
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
    public static void getMaxArrayValue(int[] array) {
        int[] newArray = Arrays.copyOf(array, array.length);
        int max = 0;
        for (int i : newArray)
            if (i > max) {
                max = i;
            }

        System.out.println("Максимальное значение = " + max);
    }

    //---------------------------------------------------
    // 13. Метод, который удаляет дубликаты из списка строк
    // Знаю, что это максимально не оптимально и медленно и лучше использовать List
    public static void deleteDuplicate(String[] array) {
        int duplicates = 0;
        String[] newTempArray = Arrays.copyOf(array, array.length);
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
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
// тут по факту idea подсказывает весь код. Практическую необходимость понял не сильно. (Вроде, Runtime это синглтон)
class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

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
        // Но idea предложила сменить на более лаконичную запись, т.к метод уже реализован и заново его писать не надо
        return Integer.compare(this.getSalary(), o.getSalary());
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
// для примера: все врапперы - это иммутабельные классы.
final class ImmutableClass {
    private final double goldenRatio = 1.618033988;

    public double getGoldenRatioNumber() { return goldenRatio; }
    // исходя из наименования и назначения, сеттеров не предполагается.
}

//---------------------------------------------------
// 18. Реализуйте класс BankAccount с методами deposit() и withdraw() (с проверкой баланса)
class BankAccount{
    String userName;
    BigDecimal balance = new BigDecimal("0.00000");

    public BankAccount(String userName) {
        this.userName = userName;
    }

    public void getBalance() {
        System.out.println(balance);
    }

    public void deposit(String input) {
        BigDecimal newInput = new BigDecimal(input);
        this.balance = this.balance.add(newInput);
        System.out.println(balance);
    }

    public void withdraw(String input) {
        BigDecimal newInput = new BigDecimal(input);
        BigDecimal result = this.balance.subtract(newInput);
        if(result.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Ошибка, нельзя снять больше, чем есть на счету");
        } else {
            System.out.println("Баланс: " + result);
        }
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


