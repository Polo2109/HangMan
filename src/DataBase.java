import java.util.Random;

public class DataBase {
    Random random = new Random();

    private String[] words = {
            "kot w butach",
            "czekolada",
            "java",
            "alicja w krainie czarów"
    };

    public String getRandomWord(){
        int i = random.nextInt(words.length);
        return words[i];
    }

}
