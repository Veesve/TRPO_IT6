package lab1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Pattern;


public class DateParser {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ss 'Z'");

    public static void main(String[] args) throws Exception {
        LocalDate currentDate = LocalDate.now();

        System.out.println("Part 1 testing:\n");

        //computing and printing date of the next week monday
        int currentDayOfTheWeek = currentDate.getDayOfWeek().getValue();
        LocalDate nextWeek = currentDate.plusDays(8 - currentDayOfTheWeek);
        Instant instantNextWeek = nextWeek.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date nextWeekDate = Date.from(instantNextWeek);
        System.out.println("Beginning of the next week " + dateFormat.format(nextWeekDate) + " day of the week is " + nextWeek.getDayOfWeek());

        //computing and printing date of the next  month
        int currentDayOfTheMonth = currentDate.getDayOfMonth();
        LocalDate nextMonth = currentDate.minusDays(currentDayOfTheMonth - 1).plusMonths(1);
        Instant instantNextMonth = nextMonth.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date nextMonthDate = Date.from(instantNextMonth);
        System.out.println("Beginning of the next month " + dateFormat.format(nextMonthDate) + " day of the week is " + nextMonth.getDayOfWeek());

        System.out.println("\nPart 2 testing:\n");

        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String patternTestString = "";

        System.out.println("Type in string for testing");
        patternTestString = reader.readLine();


        //Regular expression for date with month verification
        Pattern datePattern = Pattern.compile("\\d{4}-" +
                "(" +
                "((0[13578]|1[02])-([012][1234567890]|[3][01]))" + //months with 31 days
                "|" +
                "(((0[469])|11])-(([012][1234567890])|30))" + //month with 30 days
                "|" +
                "(02-([012][123456789]))" + //february check
                ")");
        //Regular expression for date with time
        Pattern dateWithTimePattern = Pattern.compile("\\d{4}-" +
                "(" +
                "((0[13578]|1[02])-([012][1234567890]|[3][01]))" + //months with 31 days
                "|" +
                "(((0[469])|11])-(([012][1234567890])|30))" + //month with 30 days
                "|" +
                "(02-([012][1234567890]))" + //february check
                ") " +
                "(([01][0123456789])|(2[0123])):" +//hours
                "[012345]\\d:" +//minutes
                "[012345]\\d");//seconds
                System.out.println("Fork testing");
        Pattern emailPattern = Pattern.compile("\\w{5,20}@" + //any symbols combination at least 5 symbol but not more than 20
                "(gmail|ya|yandex|mail)" +
                "(\\.com|\\.ru)"); //white list of domens. Could be extended or changed with offered pattern
        System.out.println("\ndate Pattern: "+datePattern.matcher(patternTestString).matches());
        System.out.println("date With Time Pattern: "+dateWithTimePattern.matcher(patternTestString).matches());
        System.out.println("email Pattern: "+emailPattern.matcher(patternTestString).matches());
    }

}