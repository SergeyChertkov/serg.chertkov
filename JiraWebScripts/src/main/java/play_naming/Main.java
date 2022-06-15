package play_naming;


public class Main {

    public static void main(String... args) {
        Language language;
        for (int i = 0; i < 10; i++) {
            language = new Language();
            print(language);
        }
    }

    private static void print(Language language) {
        System.out.println(language);
        for (int j = 0; j < 25; j++) {
            System.out.print(language.generateWord() + " ");
        }
        System.out.println();
        System.out.println(language.letterDensity + "\n");
    }
}
