public class CeaserCipher {

    public static void main(String[] args) {
        bruteForce("khoor pb shrsoh");
    }

    public static String cipher(String plain, int amount) {
        String cipher = "";
        amount = amount % 26;
        for (int i = 0; i < plain.length(); i++) {
            if (plain.charAt(i) != ' ') {
                cipher += (char) ('a' + (((plain.charAt(i) - 'a') + amount) % 26));
            } else {
                cipher += " ";
            }
        }
        return cipher;
    }

    public static String decipher(String text, int amount) {
        return cipher(text, 26 - (amount % 26));
    }

    public static void bruteForce(String text) {
        for (int i = 0; i < 26; i++)
            System.out.println(i + ": " + decipher(text, i));
    }
}
