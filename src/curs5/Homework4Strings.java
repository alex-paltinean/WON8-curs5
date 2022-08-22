package curs5;

import java.util.Arrays;
import java.util.Random;

public class Homework4Strings {

    public static void main(String[] args) {
        String[] names = {"Andrei", "Alex", "Mircea", "Oana", "Maria", "", "Em", null, "Razvan"};
        System.out.println("Exercise 1");
        printAllStartingWithA(names);
        System.out.println("Exercise 2");
        printAllContainingString(names, "e");
        System.out.println("Exercise 3:");
        System.out.println(Arrays.toString(replaceRWithStar(names)));
        System.out.println("Exercise 4:");
        printFirstThreeChars(names);
        System.out.println("Exercise 5:");
        printRandomLetter(names);
        System.out.println("Exercise 6:");
        System.out.println(abbreviateMiddleNameIfPresent("Maria Clara Popescu"));
        System.out.println(abbreviateMiddleNameIfPresent("Maria Popescu"));
        System.out.println(abbreviateMiddleNameIfPresent("Maria  Popescu"));
    }

    //1.
    public static void printAllStartingWithA(String[] names) {
        for (String name : names) {
            if (name != null && name.startsWith("A")) {
                System.out.println(name);
            }
        }
    }

    //2.
    public static void printAllContainingString(String[] names, String stringToSearchFor) {
        for (String name : names) {
            if (name != null && name.contains(stringToSearchFor)) {
                System.out.println(name);
            }
        }
    }

    //3.
    public static String[] replaceRWithStar(String[] names) {
        String[] result = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null) {
                result[i] = names[i].replaceAll("[rR]", "*");
            }
        }
        return result;
    }

    //4.
    public static void printFirstThreeChars(String[] names) {
        for (String name : names) {
            if (name != null) {
                System.out.println(name.substring(0, Math.min(3, name.length())));
            }
        }
    }

    //5.
    public static void printRandomLetter(String[] names) {
        Random random = new Random();
        String randomName = names[random.nextInt(names.length)];
        while (randomName == null || randomName.length() == 0) {
            randomName = names[random.nextInt(names.length)];
        }
        System.out.println(randomName.charAt(random.nextInt(randomName.length())));
    }

    //6.
    public static String abbreviateMiddleNameIfPresent(String name) {
        String[] nameParts = name.split(" +");
        if (nameParts.length == 3) {
            return String.format("%s %s. %s", nameParts[0], nameParts[1].charAt(0), nameParts[2]);
        } else {
            return name;
        }
    }
}
