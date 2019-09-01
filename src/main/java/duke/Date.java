package duke;

import java.util.Hashtable;
import java.util.regex.Pattern;

public class Date {
    private String date;
    private String time;

    public Date(String datetime) {
        String[] content = datetime.split(" ");
        this.date = content[0];
        this.time = content[1];
    }

    private static Hashtable<Integer, String> ordinals = new Hashtable<>() {{
        put(1, "1st");
        put(2, "2nd");
        put(3, "3rd");
        put(4, "4th");
        put(5, "5th");
        put(6, "6th");
        put(7, "7th");
        put(8, "8th");
        put(9, "9th");
    }};

    private static Hashtable<Integer, String> months = new Hashtable<>() {{
        put(1, "January");
        put(2, "February");
        put(3, "March");
        put(4, "April");
        put(5, "May");
        put(6, "June");
        put(7, "July");
        put(8, "August");
        put(9, "September");
        put(10, "October");
        put(11, "November");
        put(12, "December");
    }};

    private static Pattern DATE_PATTERN = Pattern.compile("^\\d{2}/\\d{2}/\\d{4} \\d{4}$");

    public static boolean matches(String date) {
        return DATE_PATTERN.matcher(date).matches();
    }

    public String getDate() {
        String[] dmy = this.date.split("/");
        int dayAsInt = Integer.parseInt(dmy[0]);
        String day, month;
        if (dayAsInt > 10) {
            day = dmy[0].substring(0,1) + ordinals.get(dayAsInt % 10);
        } else {
            day = ordinals.get(dayAsInt);
        }
        month = months.get(Integer.parseInt(dmy[1]));
        return String.format("%s of %s %s", day, month, dmy[2]);
    }

    private String getTime() {
        int hour = Integer.parseInt(this.time.substring(0,2));
        String min = this.time.substring(2);
        return String.format("%d:%s%s", hour > 12 ? hour % 12 : hour, min, hour > 12 ? "pm" : "am");
    }

    public String getRawDate() {
        return this.date + " " + this.time;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", this.getDate(), this.getTime());
    }
}
