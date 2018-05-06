package com.example;

/**
 * An example of a singleton.
 */
public class FormatterService {

    private static FormatterService instance;

    private FormatterService() {
    }

    public static FormatterService getInstance() {
        if (instance == null) {
            instance = new FormatterService();
        }
        return instance;
    }

    public String formatTachoIcon() {
        return "URL";
    }

}
