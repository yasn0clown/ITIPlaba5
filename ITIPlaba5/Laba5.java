import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Laba5 {

    public static void main(String[] args) {
        System.out.println("Задание 1:");
        findNumbers("Этот хлеб стоит 54.90 рублей и скидка на него 5%");

        System.out.println("\nЗадание 2:");
        validatePassword("Password123");

        System.out.println("\nЗадание 3:");
        findCapitalAfterLowercase("аХахахаа ччЧел ты рил крИнж");

        System.out.println("\nЗадание 4:");
        validateIPAddress("192.168.1.1");

        System.out.println("\nЗадание 5:");
        findWordsStartingWith("A etot tekst dlya testa Avatar aerobika arbuz", 'A');
    }

    //задание 1
    public static void findNumbers(String text) {
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(text);
        System.out.println("Найденные числа:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    //задание 2
    public static void validatePassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            System.out.println("Пароль корректный!");
        } else {
            System.out.println("Некорректный пароль. Пароль должен содержать от 8 до 16 символов, хотя бы одну заглавную букву и одну цифру.");
        }
    }

    //задание 3
    public static void findCapitalAfterLowercase(String text) {
        Pattern pattern = Pattern.compile("([а-я])([А-Я])");
        Matcher matcher = pattern.matcher(text);
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(result, matcher.group(1) + "!" + matcher.group(2) + "!");
        }
        matcher.appendTail(result);
        System.out.println("Текст с выделением заглавных букв после строчных:");
        System.out.println(result.toString());
    }

    //задание 4
    public static void validateIPAddress(String ipAddress) {
        Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$");
        Matcher matcher = pattern.matcher(ipAddress);
        if (matcher.matches()) {
            System.out.println("IP-адрес корректный!");
        } else {
            System.out.println("Некорректный IP-адрес.");
        }
    }

    //задание 5
    public static void findWordsStartingWith(String text, char letter) {
        Pattern pattern = Pattern.compile("\\b" + letter + "\\w*\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Слова, начинающиеся с буквы '" + letter + "':");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
