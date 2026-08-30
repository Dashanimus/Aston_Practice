package org.baseapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook { 
    private final Map<String, List<String>> book = new HashMap<>(); // Фамилия = ключ, номер = значение

    public void add(String surname, String phoneNumber) { 
        if (!book.containsKey(surname)) {
            book.put(surname, new ArrayList<>());
        }
        book.get(surname).add(phoneNumber);
    }

    public List<String> get(String surname) {
        if (book.containsKey(surname)) {
            return book.get(surname);
        }
        return new ArrayList<>(); // Пустой список, если фамилии нет
    }
}