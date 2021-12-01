import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class day1 {

    public static void main(String[] args) {

        ArrayList<Integer> depths = new ArrayList<>();
        try {
            File myObj = new File("resources/input_day1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                depths.add(Integer.parseInt(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find input for day1!");
            e.printStackTrace();
        }

        // Part 2
        ArrayList<Integer> depthSums = new ArrayList<>();
        for (int i = 0; i < depths.size() - 2; i++) {
            depthSums.add(depths.get(i) + depths.get(i + 1) + depths.get(i + 2));
        }

        int prevDepth = depthSums.get(0);
        int incCounter = 0;
        for (Integer depthSum : depthSums) {
            if (prevDepth < depthSum)
                incCounter++;
            prevDepth = depthSum;
        }
        System.out.println(incCounter);

        // Part 1
        /*
        int prevDepth = depths.get(0);
        int incCounter = 0;
        for (int i = 1; i < depths.size(); i++) {
            if (prevDepth < depths.get(i))
                incCounter++;
            prevDepth = depths.get(i);
        }
        System.out.println(incCounter); */
    }
}
