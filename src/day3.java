import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class day3 {

    public static final ArrayList<String> input = tools.readInputFileToStringArray("3");
    public static void main(String[] args) {

        /* Part 1 */ /*

        ArrayList<String> input = tools.readInputFileToStringArray("3");
        int lineSize = input.get(0).length();
        int[] bitList = new int[lineSize];
        int gamma = 0;
        int epsilon = 0;
        for (String line: input) {
            for (int i = 0; i < lineSize; i++) {
                if (line.charAt(i) == '0')
                    bitList[i] -= 1;
                else
                    bitList[i] += 1;
            }
        }
        StringBuilder gammaBin = new StringBuilder();
        StringBuilder epsilonBin = new StringBuilder();
        for (int j : bitList) {
            if (j < 0) {
                gammaBin.append("0");
                epsilonBin.append("1");
            } else if (j > 0) {
                gammaBin.append("1");
                epsilonBin.append("0");
            } else {
                System.out.println("Error: equal 0s and 1s");
            }
        }
        gamma = Integer.parseInt(gammaBin.toString(), 2);
        epsilon = Integer.parseInt(epsilonBin.toString(),2);

        System.out.println(gamma * epsilon);*/

        /* Part 2 */

        int lineSize = input.get(0).length();

        int[] bitList = calcBitList(input, lineSize);

        int oxygenRating = calcRating('o', lineSize, bitList), CO2Rating = calcRating('c', lineSize, bitList);

        System.out.println(oxygenRating);
        System.out.println(CO2Rating);
        System.out.println(oxygenRating * CO2Rating);
    }

    private static int calcRating(char c, int lineSize, int[] bitList) {
        ArrayList<String> possibleNumbers = input;
        int i = 0;
        int[] mcb = mostCommonBits(c, bitList);
        while (possibleNumbers.size() > 1) {
            possibleNumbers = calcOnPos(i, mcb[i], possibleNumbers);
            mcb = mostCommonBits(c, calcBitList(possibleNumbers,lineSize));
            i++;
        }
        return Integer.parseInt(possibleNumbers.get(0), 2);
    }

    private static ArrayList<String> calcOnPos(int pos, int val, ArrayList<String> numbers) {
        ArrayList<String> remainingNumbers = new ArrayList<>(numbers);
        Collections.copy(remainingNumbers, numbers);
        for (String curNum : numbers) {
            if (remainingNumbers.size() == 1) {
                return remainingNumbers;
            }
            if (val != Character.getNumericValue(curNum.charAt(pos))) {
                remainingNumbers.remove(curNum);
            }
        }
        return remainingNumbers;
    }


    private static int[] mostCommonBits(char c, int[] bitList) {
        int[] mcbList = new int[bitList.length];
        int val = 0;
        int i = 0;
        if (c == 'o') {
            for (int j : bitList) {
                if (j < 0)
                    mcbList[i] = 0;
                else if (j > 0)
                    mcbList[i] = 1;
                else
                    mcbList[i] = 1;
                i++;
            }
        } else {
            for (int j : bitList) {
                if (j < 0)
                    mcbList[i] = 1;
                else if (j > 0)
                    mcbList[i] = 0;
                else
                    mcbList[i] = 0;
                i++;
            }
        }
        return mcbList;
    }

    private static int[] calcBitList(ArrayList<String> input, int ls) {
        int[] bitList = new int[ls];
        for (String line: input) {
            for (int i = 0; i < ls; i++) {
                if (line.charAt(i) == '0')
                    bitList[i] -= 1;
                else
                    bitList[i] += 1;
            }
        }
        return bitList;
    }
}
