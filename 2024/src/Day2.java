import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Day2 {
    public void answer () {
        String filepath = "./input2.txt";
        int safeReports = 0;
        int start = 0;
        try ( BufferedReader br = new BufferedReader (new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                int [] reports = Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                boolean increasing = false;
                boolean decreasing = false;
                int conditionmet = 0;



                for (int i = 1; i < reports.length; i++) {
                    if (Math.abs(reports[i] - reports[i-1]) > 3) break;
                    if (reports[i] > reports[i-1] && decreasing) break;
                    if (reports[i] < reports[i-1] && increasing) break;
                    if (reports[i] == reports[i-1]) break;
                    if (reports[i] > reports[i-1]) increasing = true;
                    if (reports[i] < reports[i-1]) decreasing = true;
                    conditionmet++;
                }
                if (conditionmet == reports.length - 1) safeReports++;
//                System.out.println(start++ + " " + safeReports);
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
        System.out.println(safeReports);
    }
}
