package exception;

import java.time.LocalDate;

public final class Validation {

    public Validation () {}

    public static boolean isNotEmpty (String field) {return field != null && !field.trim().isEmpty();}

    public static boolean notNegative (double field) {return field > 0;}

    public static boolean validDateCheck (int year) {
        int currentYear = LocalDate.now().getYear();
        return   year <= currentYear;
    }
}
