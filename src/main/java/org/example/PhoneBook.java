package org.example;

//Задание:
//Реализуйте структуру телефонной книги с помощью HashMap.
//Программа также должна учитывать, что во входной структуре
// будут повторяющиеся имена с разными телефонами, их необходимо считать,
// как одного человека с
// разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

import java.util.*;

    public class PhoneBook {
        public static void main(String[] args) {
            HashMap<String, List<String>> phoneBook = new HashMap<>();

            addContact(phoneBook, "Романов Петр Алексеевич", "333-73-73");
            addContact(phoneBook, "Сафронов Игорь Дементьевич", "999-64-32");
            addContact(phoneBook, "Сидоров Николай Петрович", "555-55-55");
            addContact(phoneBook, "Сафронов Игорь Дементьевич", "111-22-33");
            addContact(phoneBook, "Петров Илья Анатольевич", "444-44-94");
            addContact(phoneBook, "Петров Илья Анатольевич", "477-44-94");
            addContact(phoneBook, "Петров Илья Анатольевич", "499-44-94");
            printPhoneBook(phoneBook);
        }

        public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phone) {
            List<String> phones = phoneBook.getOrDefault(name, new ArrayList<>());
            phones.add(phone);
            phoneBook.put(name, phones);
        }

        public static void printPhoneBook(HashMap<String, List<String>> phoneBook) {

            List<Map.Entry<String, List<String>>> sortedList = new ArrayList<>(phoneBook.entrySet());
            sortedList.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));

            for (Map.Entry<String, List<String>> entry : sortedList) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }