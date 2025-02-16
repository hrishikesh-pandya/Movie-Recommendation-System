package Reading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReadingFilesProperties2 {
    // Read CSV file with Strings
    public static void readCSV(String filename, ArrayList<String> list) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read CSV file with Integers
    public static void readCSVInt(String filename, ArrayList<Integer> list) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read CSV file with Doubles
    public static void readCSVDouble(String filename, ArrayList<Double> list) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Double.parseDouble(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read CSV file with String arrays
    public static void readCSVArray(String filename, ArrayList<String[]> list) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line.split(",")); // Assuming genres are separated by commas
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

