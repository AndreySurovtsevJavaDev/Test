package Tasks;

// Реализуйте класс Person с полями name и age. Переопределите equals() и hashCode()

public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

     
}