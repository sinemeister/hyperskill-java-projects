package readability;

/**
 * Score Class
 */
public class Score {

    private final Checker checker;

    /**
     * Constructor
     * Sets class variable Checker object
     * @param checker       Checker object
     */
    public Score(Checker checker) {
        this.checker = checker;
    }

    /**
     * Calculates Automated readability index (ARI) score
     * @param readSentence      String literal of the read sentence from the file
     * @return                  Returns ARI score as Double
     */
    public double calculateAriScore(String readSentence) {
        int sentences = this.checker.calculateSentences(readSentence);
        int words = this.checker.calculateWords(readSentence);
        int chars = this.checker.calculateCharacters(readSentence);

        return 4.71 * ((double) chars / words) + 0.5 * ((double) words / sentences) - 21.43;
    }

    /**
     * Calculates Flesch-Kincaid readability (FK) score
     * @param readSentence      String literal of the read sentence from the file
     * @return                  Returns FK score as Double
     */
    public double calculateFkScore(String readSentence) {
        int sentences = this.checker.calculateSentences(readSentence);
        int words = this.checker.calculateWords(readSentence);
        int syllables = this.checker.calculateSyllables(readSentence)[0];

        return 0.39 * ((double) words / sentences) + 11.8 * ((double) syllables / words) - 15.59;
    }

    /**
     * Calculates Simple Measure of Gobbledygook (SMOG) score
     * @param readSentence      String literal of the read sentence from the file
     * @return                  Returns SMOG score as Double
     */
    public double calculateSmogScore(String readSentence) {
        int sentences = this.checker.calculateSentences(readSentence);
        int polysyllables = this.checker.calculateSyllables(readSentence)[1];

        return 1.043 * Math.sqrt(polysyllables * 30 / (double) sentences) + 3.1291;
    }

    /**
     * Calculates Coleman-Liau (CL) score
     * @param readSentence      String literal of the read sentence from the file
     * @return                  Return CL score as Double
     */
    public double calculateClScore(String readSentence) {
        int sentences = this.checker.calculateSentences(readSentence);
        int words = this.checker.calculateWords(readSentence);
        int chars = this.checker.calculateCharacters(readSentence);

        double averageCharsPerHundredWords = (double) chars / words * 100;
        double averageSentencesPerHundredWords = (double ) sentences / words * 100;

        return (0.0588 * averageCharsPerHundredWords) - (0.296 * averageSentencesPerHundredWords) - 15.8;
    }

    /**
     * Prepares result text and returns it depending on the selected score(s)
     * @param testNames         Selected score names as String[] Array
     * @param scores            Actual scores as double[] Array
     * @return                  Returns result text with all the information
     */
    private String getAllResults(String[] testNames, double[] scores) {
        String resultText = "\n";
        int sum = 0;

        for (int i = 0; i < testNames.length; i++) {
            String age = "";
            switch ((int) Math.ceil(scores[i])) {
                case 1:
                    age = Age.KINDERGARTEN.getAge();
                    break;
                case 2:
                    age = Age.FIRST_GRADE.getAge();
                    break;
                case 3:
                    age = Age.SECOND_GRADE.getAge();
                    break;
                case 4:
                    age = Age.THIRD_GRADE.getAge();
                    break;
                case 5:
                    age = Age.FOURTH_GRADE.getAge();
                    break;
                case 6:
                    age = Age.FIFTH_GRADE.getAge();
                    break;
                case 7:
                    age = Age.SIXTH_GRADE.getAge();
                    break;
                case 8:
                    age = Age.SEVENTH_GRADE.getAge();
                    break;
                case 9:
                    age = Age.EIGHTH_GRADE.getAge();
                    break;
                case 10:
                    age = Age.NINTH_GRADE.getAge();
                    break;
                case 11:
                    age = Age.TENTH_GRADE.getAge();
                    break;
                case 12:
                    age = Age.ELEVENTH_GRADE.getAge();
                    break;
                case 13:
                    age = Age.TWELFTH_GRADE.getAge();
                    break;
                case 14:
                    age = Age.COLLEGE.getAge();
                    break;
                default:
                    age = Age.COLLEGE_PLUS.getAge();
                    break;
            }
            resultText += String.format("%s: %.2f (about %s-year-olds).\n", testNames[i], scores[i], age);
            sum += Integer.parseInt(age);
        }
        double average = (double) sum / testNames.length;
        resultText += String.format("\nThis text should be understood in average by %.2f-year-olds.", average);
        return resultText;
    }

    /**
     * Selects score(s) to be shown
     * @param userInput         User input for which score to be shown
     * @param readSentence      String literal of the read sentence from the file
     * @return                  Returns getAllResults() method depending on the user input
     */
    public String selectScores(String userInput, String readSentence) {
        double ariScore = calculateAriScore(readSentence);
        double fkScore = calculateFkScore(readSentence);
        double smogScore = calculateSmogScore(readSentence);
        double clScore = calculateClScore(readSentence);

        if ("all".equals(userInput)) {
            double[] scoreArray = new double[] {ariScore, fkScore, smogScore, clScore};
            String[] testArray = new String[] {"Automated Readability Index", "Flesch-Kincaid readability tests",
                                              "Simple Measure of Gobbledygook", "Coleman-Liau index"};
            return getAllResults(testArray, scoreArray);
        } else if ("ari".equals(userInput)) {
            return getAllResults(new String[] {"Automated Readability Index"}, new double[]{ariScore});
        } else if ("fk".equals(userInput)) {
            return getAllResults(new String[] {"Flesch-Kincaid readability tests"}, new double[] {fkScore});
        } else if ("smog".equals(userInput)) {
            return getAllResults(new String[] {"Simple Measure of Gobbledygook"}, new double[] {smogScore});
        } else if ("cl".equals(userInput)) {
            return getAllResults(new String[] {"Coleman-Liau index"}, new double[] {clScore});
        }
        return "";
    }
}
