package play_naming;

import lombok.ToString;

import java.util.*;

@ToString
class Language {

    private static final List<String> ALL_VOWELS = Arrays.asList("a", "o", "u", "e", "i");
    private static final List<String[]> LABIAL_CONSONANTS = Arrays.asList(
            new String[]{"b", "p"},
            new String[]{"p", "b"},
            new String[]{"v", "f"},
            new String[]{"f", "v"},
            new String[]{"m", ""});
    private static final List<String[]> VOICED_CONSONANTS = Arrays.asList(
            new String[]{"d", "t"},
            new String[]{"t", "d"},
            new String[]{"l", "r"},
            new String[]{"r", "l"},
//            new String[]{"y", ""},
            new String[]{"n", ""});
    private static final List<String[]> HISSING_CONSONANTS = Arrays.asList(
            new String[]{"z", "s"},
            new String[]{"s", "z"},
            new String[]{"c", ""});
    private static final List<String[]> deafConsonants = Arrays.asList(
            new String[]{"g", "k"},
            new String[]{"k", "g"},
            new String[]{"h", "g"});
    private static List<String[]> allConsonants = new ArrayList<>();
    private static Map<String, String> consonantsPair = new HashMap<>();

    private static final int MAX_VOWELS = 3;
    private static final int MAX_CONSONANTS = 7;
    private static boolean printEnabled = false;

    static {
        allConsonants.addAll(LABIAL_CONSONANTS);
        allConsonants.addAll(VOICED_CONSONANTS);
        allConsonants.addAll(HISSING_CONSONANTS);
        allConsonants.addAll(deafConsonants);

        for (String[] c :
                allConsonants) {
            consonantsPair.put(c[0], c[1]);
        }
    }

    String name;
    int minWordsSize;
    int maxWordsSize;
    double startVowels;
    double endVowels;
    List<String> vowels;
    List<String> consonants;
    int vowelsSize;
    int consonantsSize;
    List<String> words;
    Map<String, Integer> letterDensity;


    Language() {
        vowels = new ArrayList<>();
        consonants = new ArrayList<>();
        startVowels = Math.random();
        endVowels = Math.random();
        words = new ArrayList<>();
        letterDensity = new HashMap<>();
        minWordsSize = (int) (Math.random() * 3 + 2);
        maxWordsSize = (int) (Math.random() * 4 + 4);

        generateSingleVowelsForLanguage();
        generateDoubleVowelsForLanguage();
        vowelsSize = vowels.size();

        generateSingleConsonantsForLanguage();
        generateDoubleConsonantsForLanguage();
        consonantsSize = consonants.size();

        generateSyllablesForLanguage();
        generateName();
    }

    private void generateSyllablesForLanguage() {
        for (int i = 0; i < randInt(5); i++) {
            vowels.add(generateMultiVowels());
        }
        for (int i = 0; i < randInt(9); i++) {
            consonants.add(generateMultiConsonants());
        }
    }

    private void generateSingleConsonantsForLanguage() {
        while (consonants.size() < MAX_CONSONANTS) {
            String[] x = allConsonants.get(randInt(allConsonants.size()));
            if (!consonants.contains(x[0])) {
                consonants.add(x[0]);
                letterDensity.put(x[0], 0);
            }
        }
    }

    private void generateSingleVowelsForLanguage() {
        while (vowels.size() < MAX_VOWELS) {
            String o = ALL_VOWELS.get(randInt(ALL_VOWELS.size()));
            if (!vowels.contains(o)) {
                vowels.add(o);
                letterDensity.put(o, 0);
            }
        }
    }

    private void generateDoubleConsonantsForLanguage() {
        for (int i = 0; i < randInt(4); i++) {
            consonants.add(generateDoubleConsonants());
        }
        if (Math.random() < 0.7) {
            consonants.add(generateDoubleConsonants());
        }
        if (Math.random() < 0.2) {
            for (int i = 0; i < 3; i++) {
                consonants.add(generateDoubleConsonants());
            }
        }
        if (Math.random() < 0.2) {
            for (int i = 0; i < 3; i++) {
                consonants.add(generateDoubleConsonants());
            }
        }
    }

    private void generateDoubleVowelsForLanguage() {
        if (Math.random() < 0.5) {
            vowels.add(generateDoubleVowels());
        }
        if (Math.random() < 0.2) {
            for (int i = 0; i < 3; i++) {
                vowels.add(generateDoubleVowels());
            }
        }
    }

    private void generateName() {
        name = "";
        if (startVowels > 0.5) {
            name += vowels.get(vowels.size() - 1) + consonants.get(consonants.size() - 1);
            if (endVowels > 0.5) {
                name += vowels.get(0);
            }
        } else {
            name += consonants.get(consonants.size() - 1) + vowels.get(vowels.size() - 1);
            if (endVowels < 0.5) {
                name += consonants.get(0);
            }
        }
        if (printEnabled) {
            System.out.println("name: " + name);
        }
    }

    private int randInt(int i) {
        return (int) (Math.random() * i);
    }

    private String getRandomSingleVowel() {
        return vowels.get(randInt(MAX_VOWELS));
    }

    private String getRandomSingleConsonant() {
        return consonants.get(randInt(MAX_CONSONANTS));
    }

    private String getRandomSingleOrDoubleVowels() {
        return vowels.get(randInt(vowelsSize));
    }

    private String getRandomSingleOrDoubleConsonants() {
        return consonants.get(randInt(consonantsSize));
    }

    private String generateDoubleVowels() {
        String first = getRandomSingleVowel();
        String second;
        do {
            second = getRandomSingleVowel();
        } while (second.equals(first));
        return first + second;
    }

    private String generateMultiVowels() {
        String letters;
        do {
            letters = getRandomSingleOrDoubleVowels() +
                    getRandomSingleOrDoubleConsonants() +
                    getRandomSingleOrDoubleVowels();
        } while (vowels.contains(letters));
        return letters;
    }

    private String generateDoubleConsonants() {
        String first = getRandomSingleConsonant();
        String second;
        do {
            second = getRandomSingleConsonant();
        } while (
                second.equals(first) || second.equals(consonantsPair.get(first)));
        return first + second;
    }

    private String generateMultiConsonants() {
        String letters;
        do {
            letters = getRandomSingleOrDoubleConsonants() +
                    getRandomSingleOrDoubleVowels() +
                    getRandomSingleOrDoubleConsonants();
        } while (consonants.contains(letters));
        return letters;
    }

    String generateWord() {
        String word = generateWord(randInt(maxWordsSize - minWordsSize) + minWordsSize);
        words.add(word);
        for (int i = 0; i < word.length(); i++) {
            String letter = word.substring(i, i + 1);
            Integer x = letterDensity.get(letter) + 1;
            letterDensity.put(letter, x);
        }
        return word;
    }

    private String generateWord(int size) {
        String wordSchema = generateWordSchema(size);
        String word = "";
        String letter;
        do {
            for (int i = 0; i < wordSchema.length() && word.length() <= wordSchema.length(); i++) {
                if (wordSchema.substring(i, i + 1).equalsIgnoreCase("X")) {
                    letter = consonants.get(randInt(consonants.size()));
                } else {
                    letter = vowels.get(randInt(vowels.size()));
                }
                word += letter;
                if (printEnabled) {
                    System.out.println("\t" + i + ": " + letter);
                }
            }
            if (endVowels > Math.random()) {
                if (!vowels.contains(word.substring(word.length() - 1))) {
                    word += vowels.get(randInt(vowels.size()));
                }
            } else {
                if (!consonants.contains(word.substring(word.length() - 1))) {
                    word += consonants.get(randInt(consonants.size()));
                }
            }
        } while (words.contains(word));
        if (printEnabled) {
            System.out.println("word: " + word);
        }
        return word;
    }

    private String generateWordSchema(int size) {
        StringBuilder wordSchema;
        if (startVowels > Math.random()) {
            wordSchema = new StringBuilder("O");
        } else {
            wordSchema = new StringBuilder("X");
        }
        for (int i = 1; i < size; i++) {
            if (wordSchema.substring(wordSchema.length() - 1).equals("O")) {
                wordSchema.append("X");
            } else {
                wordSchema.append("O");
            }
        }
        if (wordSchema.toString().equalsIgnoreCase("X")) {
            wordSchema = new StringBuilder("XO");
        }

        if (wordSchema.toString().equalsIgnoreCase("O")) {
            wordSchema = new StringBuilder("OX");
        }
        if (printEnabled) {
            System.out.println("\nword schema: " + wordSchema);
        }
        return wordSchema.toString();
    }
}
