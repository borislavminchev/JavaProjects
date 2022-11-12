import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MyClass {

    private final static String SEARCH_WORD = "Contr99";
    private final static int DATA_LENGTH = 24;
    private final static String SPLITTER = ";";

    static final String DB_URL = "jdbc:mysql://localhost/ca_setpoint";
    static final String USER = "root";
    static final String PASS = "B21032001pi/6";
    static final String DATE_FIELD = "date_plan";
    static final String VALUE_FIELD = "value_plan";

    private static List<String> readInfo(String path) {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(SEARCH_WORD)) {
                    for (int i = 0; i < DATA_LENGTH; i++) {
                        line = reader.readLine();
                        data.add(line);
                    }
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    private static List<Double> processData(List<String> data) {
        if (data.size() != DATA_LENGTH) {
            throw new IllegalArgumentException("There is problem with file data: Expected size " +
                    DATA_LENGTH + " but there was " + data.size() + " lines");
        }

        List<List<String>> splitted = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            splitted.add(splitLine(data.get(i)));
        }

        List<List<Double>> asDouble = new ArrayList<>();
        for (int i = 0; i < splitted.size(); i++) {
            asDouble.add(convertToDoubles(splitted.get(i)));
        }

        List<Double> averages = new ArrayList<>();
        for (int i = 0; i < asDouble.size(); i++) {
            averages.add(getAverage(asDouble.get(i)));
        }

        return averages;

//        return data.stream()
//                .map(i -> i.split(SPLITTER))
//                .map(i -> Arrays.stream(i)
//                        .map(Double::parseDouble)
//                        .collect(Collectors.toList()))
//                .map(i -> i.stream()
//                        .mapToDouble(j -> j)
//                        .summaryStatistics().getAverage())
//                .collect(Collectors.toList());
    }

    private static List<String> splitLine(String line) {
        return Arrays.asList(line.split(SPLITTER));
    }

    private static List<Double> convertToDoubles(List<String> data) {
        List<Double> res = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            res.add(Double.parseDouble(data.get(i)));
        }

        return res;
    }

    private static double getAverage(List<Double> data) {
        double sum = 0;
        for (int i = 0; i < data.size(); i++) {
            sum += data.get(i);
        }

        return sum / data.size();
    }

    private static LocalDateTime getDate(String path){
        LocalDateTime dateTime = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line = reader.readLine();
            dateTime = LocalDateTime.parse(
                    line.split(" ")[1],
                    DateTimeFormatter.ofPattern("yyyyMMddHHmm"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        return dateTime;
    }


    private static void writeInDB(LocalDateTime dateTime,  List<Double> numbers) {
        String date = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String nextDay = dateTime.plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_UPDATABLE);

             ResultSet rs = stmt.executeQuery("SELECT * FROM ca_setpoint.setpoints " +
                     "WHERE " + DATE_FIELD + " >= '" + date + "' AND " + DATE_FIELD + " < '" + nextDay + "';")) {

            while (rs.next()) {
                LocalDateTime current = rs.getObject(DATE_FIELD, LocalDateTime.class);
                rs.updateDouble(VALUE_FIELD, numbers.get(current.getHour()));
                rs.updateRow();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



//    public static void main(String[] args) {
//        LocalDateTime date = getDate(args[0]);
//        List<Double> processedData = processData(readInfo(args[0]));
//        writeInDB(date, processedData);
//        System.out.println(processedData);
//    }
    public static void main(String[] args) {
        String str = "prefix_21-03-2001.txt";
        String pref = "prefix_";
        str = str.replace("prefix_", "");
        str = str.replace(".txt", "");
        System.out.println(str);

    }
}
