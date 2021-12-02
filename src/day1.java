import java.util.ArrayList;

public class day1 {

    public static void main(String[] args) {

        ArrayList<Integer> depths = tools.readInputFileToIntegerArray("1");

        /* Part 2 */
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

        /* Part 1
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
