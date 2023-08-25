package readability;

public enum Age {
    KINDERGARTEN("6"),
    FIRST_GRADE("7"),
    SECOND_GRADE("8"),
    THIRD_GRADE("9"),
    FOURTH_GRADE("10"),
    FIFTH_GRADE("11"),
    SIXTH_GRADE("12"),
    SEVENTH_GRADE("13"),
    EIGHTH_GRADE("14"),
    NINTH_GRADE("15"),
    TENTH_GRADE("16"),
    ELEVENTH_GRADE("17"),
    TWELFTH_GRADE("18"),
    COLLEGE("19"),
    COLLEGE_PLUS("20");

    private final String age;

    Age(String age) {
        this.age = age;
    }

    public String getAge() {
        return this.age;
    }
}
