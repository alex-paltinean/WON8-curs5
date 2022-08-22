package curs5;

public class Homework4Confidential {
    public static void main(String[] args) {
        String[] sensitiveWords = {"mere", "Ana"};
        System.out.println(confidential("Ana are mere multe mere bune", sensitiveWords));
        System.out.println(confidential("", sensitiveWords));
        System.out.println(confidential(null, sensitiveWords));
        System.out.println(confidential("Ana  are mere multe m bune", sensitiveWords));
    }

    public static int countChar(String text, char c) {
        int result = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == c) {
                result++;
            }
        }
        return result;
    }

    public static int countCharV2(String text, char c) {
        String replaced = text.replaceAll(String.valueOf(c), "");
        return text.length() - replaced.length();
    }

    public static String redact(String text) {
        return text.replaceAll(".", "*");
    }

    public static boolean contains(String[] texts, String contained) {
        for (String text : texts) {
            if (text.equals(contained)) {
                return true;
            }
        }
        return false;
    }

    public static String[] words(String text) {
        return text.split(" +");
    }

    public static String confidential(String text, String[] sensitiveWords) {
        if (text == null || text.length() == 0) {
            return text;
        }
        String[] words = words(text);
        for (int i = 0; i < words.length; i++) {
            if (contains(sensitiveWords, words[i])) {
                words[i] = redact(words[i]);
            }
        }
        return String.join(" ", words);
    }
}
