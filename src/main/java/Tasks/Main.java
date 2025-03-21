package Tasks;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // переопределить equals И hashCode
        Person person = new Person(16, "Тимофей");
        Person person1 = new Person(16, "Тимофей");

        //---------------------------------------------------

        // Проверить строку на палиндром

        String str = "Строка для проверки на палиндром";
        Palindrome pal = new Palindrome(str);
        pal.checkPalindrome();
    }
}

//---------------------------------------------------

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

