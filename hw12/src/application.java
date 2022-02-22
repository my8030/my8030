

public class Application {
    public static void main(String[] args) {
        String text = "Буква \"О\" на бублик схожа,\n" +
                "Колесом котитись може.\n" +
                "Букву \"О\" всі знають діти,\n" +
                "З нею можна порадіти,\n" +
                "Ще й дивує буква \"О\",\n" +
                "Коли скажеш ти \"Ого!\n" +
                "Ну-мо букву \"О\" співати,\n" +
                "Дружно й голосно, малята!\n";

        Map<String, Integer> wordsBase = new HashMap<>();
        String[] words = textToWords(text);
        wordCount(words, wordsBase);
        printWords(wordsBase);
        sortWords(wordsBase);

    }

    public static String[] textToWords(String text) {
        String lowerCaseText = text.toLowerCase();
        String cleanText = lowerCaseText.replaceAll("[!\".,0-9 \\n]", " ");
        String[] words = cleanText.split("\\s");
        return words;
    }

    public static void wordCount(String[] words, Map<String, Integer> wordsBase) {
        for (String curWord : words) {
            if (curWord.equals("")) {
                wordsBase.remove(curWord);
            }else if(wordsBase.get(curWord) == null) {
                wordsBase.put(curWord, 1);
            }else {
                wordsBase.put(curWord, wordsBase.get(curWord) + 1);
            }
        }
    }

    public static void printWords(Map<String, Integer> wordsBase) {
        for (Map.Entry<String, Integer> entry : wordsBase.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("" + key + " - " + value + " шт");
        }
    }


    public static void sortWords(Map<String, Integer> wordsBase) {
        List list = new ArrayList(wordsBase.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
        System.out.println(list);
    }


}

