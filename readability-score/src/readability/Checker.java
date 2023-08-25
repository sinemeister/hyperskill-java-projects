package readability;

/**
 * Checker Class
 */
public class Checker {

    /**
     * Calculates number of sentences in the read sentence
     * Uses regular expressions
     * @param readSentence      String literal of the read sentence from the file
     * @return                  Returns number of sentences as Integer
     */
    public int calculateSentences(String readSentence) {
        String[] pieces = readSentence.split("[?!.]");
        return pieces.length;
    }

    /**
     * Calculates number of words in the read sentence
     * Uses regular expressions
     * @param readSentence      String literal of the read sentence from the file
     * @return                  Returns number of words as Integer
     */
    public int calculateWords(String readSentence) {
        String[] pieces = readSentence.split("\\s"); // Split the sentence by whitespaces
        return pieces.length;
    }

    /**
     * Calculates number of characters in the read sentence
     * Uses regular expressions
     * @param readSentence      String literal of the read sentence from the file
     * @return                  Returns number of characters as Integer
     */
    public int calculateCharacters(String readSentence) {
        int charCount = 0;
        String charRegex = "\\S"; // Count everything except whitespaces

        for (int i = 0; i < readSentence.length(); i++) {
            if (String.valueOf(readSentence.charAt(i)).matches(charRegex)) {
                charCount++;
            }
        }
        return charCount;
    }

    /**
     * Calculates number of syllables and polysyllables in the read sentence
     * Uses regular expressions
     * @param readSentence      String literal of the read sentence from the file
     * @return                  Returns int[] Array containing number of syllables and polysyllables
     */
    public int[] calculateSyllables(String readSentence) {
        int syllableCount = 0;
        int polysyllableCount = 0;
        int vowelCount;
        int inWordSyllableCount;
        boolean isPreviousVowel;

        String vowelRegex = "[aeoiuy]";
        String[] words = readSentence.split("\\s");

        for (String word: words) {
            vowelCount = 0;
            inWordSyllableCount = 0;
            isPreviousVowel = false;
            for (int i = 0; i < word.length(); i++) {
                boolean matches = String.valueOf(word.charAt(i)).matches(vowelRegex);
                if (i == word.length() - 1 && word.charAt(i) == 'e') {
                    ;
                } else if (!isPreviousVowel && matches) {
                    syllableCount++;
                    inWordSyllableCount++;
                    vowelCount++;
                    isPreviousVowel = true;
                } else if (!matches) {
                    isPreviousVowel = false;
                }
            }
            if (vowelCount == 0) {
                syllableCount++;
            } else if (inWordSyllableCount >= 3) {
                polysyllableCount++;
            }
        }
        return new int[] {syllableCount, polysyllableCount};
    }

    /**
     * Shows the properties of the text read from the file
     * @param readSentence      String literal of the read sentence from the file
     * @return                  String literal of properties text
     */
    public String showProperties(String readSentence) {

        return "The text is:\n" + readSentence + "\n" +
                "Words: " + calculateWords(readSentence) + "\n" +
                "Sentences: " + calculateSentences(readSentence) + "\n" +
                "Characters: " + calculateCharacters(readSentence) + "\n" +
                "Syllables: " + calculateSyllables(readSentence)[0] + "\n" +
                "Polysyllables: " + calculateSyllables(readSentence)[1] + "\n";
    }
}
