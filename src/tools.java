import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class tools {

    public static ArrayList<String> readInputFileToStringArray(String day) {

        ArrayList<String> lines = new ArrayList<>();
        try {
            File myObj = new File("resources/input_day" + day + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find input for day" + day);
            e.printStackTrace();
        }
        return lines;
    }

    public static ArrayList<Integer> readInputFileToIntegerArray(String day) {
        ArrayList<Integer> lines = new ArrayList<>();
        try {
            File myObj = new File("resources/input_day" + day + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines.add(Integer.parseInt(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find input for day" + day);
            e.printStackTrace();
        }
        return lines;
    }
}
