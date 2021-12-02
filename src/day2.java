import java.util.ArrayList;

public class day2 {

    public static void main(String[] args) {
        ArrayList<String> commands = tools.readInputFileToStringArray("2");


        /* Part 2 */
        int depth = 0;
        int horiz = 0;
        int aim = 0;

        for (String command: commands) {
            String[] cur = command.split("\\s+");
            switch (cur[0]) {
                case "up":
                    aim -= Integer.parseInt(cur[1]);
                    break;
                case "down":
                    aim += Integer.parseInt(cur[1]);
                    break;
                case "forward":
                    horiz += Integer.parseInt(cur[1]);
                    depth += Integer.parseInt(cur[1]) * aim;
                    break;
            }
        }
        System.out.println(depth * horiz);


        /* Part 1
        int depth = 0;
        int horiz = 0;

        for (String command: commands) {
            String[] cur = command.split("\\s+");
            switch (cur[0]) {
                case "up":
                    depth -= Integer.parseInt(cur[1]);
                    break
                case "down":
                    depth += Integer.parseInt(cur[1]);
                    break;
                case "forward":
                    horiz += Integer.parseInt(cur[1]);
                    break;
            }
        }
        System.out.println(depth * horiz); */
    }
}
