import java.io.IOException;
import java.util.Scanner;


public class Main {

    /*Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
    Фамилия Имя Отчество дата рождения номер телефона пол
    Форматы данных: фамилия, имя, отчество - строки
                    дата_рождения - строка формата dd.mm.yyyy
                    номер_телефона - целое беззнаковое число без форматирования
                    пол - символ латиницей f или m.
    Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки,
    обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
    Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
    Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
    Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
    пользователю выведено сообщение с информацией, что именно неверно.
    Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные,
    вида
            <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
    Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
    Не забудьте закрыть соединение с файлом.
    При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.*/

    public static void main(String[] args) {
        System.out.println();
        System.out.println("\tДобро пожаловать!");

        String secondName = NameMessage("Введите Фамилию: ");
        String firstName = NameMessage("Введите Имя: ");
        String lastName = NameMessage("Введите Отчество: ");
        String date = DateMessage("Введите дату рождения dd.mm.yyyy: ");
        long phoneNumber = NumMessage("Введите номер телефона: ");
        String gender = GenderMessage("Укажите ваш пол латиницей f или m: ");

        System.out.println(secondName + " " + firstName + " " + lastName + " " + date + " " + "tel.:" + phoneNumber + " " + "sex:" + gender);

    }
    public static String NameMessage(String message) {
        String mes = null;

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println(message);

            try {
                mes = in.nextLine();

                boolean hasDigits = false;
                for (int i = 0; i < mes.length() && !hasDigits; i++) {
                    if (Character.isDigit(mes.charAt(i))) {
                        hasDigits = true;
                    }
                }

                int countSpase = 0;
                for (int i = 0; i < mes.length(); i++) {
                    if (mes.charAt(i) == ' ') {
                        countSpase += 1;
                    }
                }

                if (mes.isEmpty() || hasDigits || countSpase != 0) {
                    throw new IOException();
                }
                break;
            } catch (Exception e) {
                System.out.println("Пожалуйств, введите данные корректно!");
            }
        }
        return mes;
    }     // ФИО проверяется на пустую строку, пробел и цифры.
    public static String DateMessage(String message) {
        String date = null;

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println(message);

            try {
                date = in.nextLine();

                int sumChar = 0;
                for (int i = 0; i < date.length(); i++) {
                    sumChar += 1;
                }
                // Проверка на количество символов

                int sumDigit = 0;
                for (int i = 0; i < date.length(); i++) {
                    if (Character.isDigit(date.charAt(i))) {
                        sumDigit += 1;
                    }
                }
                if (sumChar != 10 || sumDigit != 8) {
                    throw new IOException();
                }
                break;
            } catch (Exception e) {
                System.out.println("Пожалуйств, введите данные корректно!");
            }

            // Проверка на 8 цифр
        }

        return date;
    }     // Дата проверяется на количество символов и цифр.
    public static long NumMessage(String message) {
        long number = 0;

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println(message);

            try {
                number = in.nextLong();
                var length = String.valueOf(number).length();
                if (length != 11) {
                    throw new IOException();
                }
                break;
            } catch (Exception e) {
                System.out.println("Номер должен состоять из 11 цифр!");
            }
        }
        return number;
    }        // Номер проверяется на отсутствие букв и количество цифр.
    public static String GenderMessage(String message) {
        Scanner in = new Scanner(System.in);
        String gender = null;

        while (true) {
            try {
                System.out.println(message);
                gender = in.nextLine();
                if (gender.charAt(0) != 'f' && gender.charAt(0) != 'm' || gender.length() != 1) {
                    throw new IOException();
                }
                break;
            } catch (Exception e) {
                System.out.println("Пожалуйств, введите данные корректно!");
            }
        }
        return gender;
    }   // Проверяется на количество символов и тип символа.


}