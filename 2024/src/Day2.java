import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                boolean good = false;
                for (int i = 0; i < reports.length; i++) {
                    List<Integer> list = new ArrayList<>();

                    /**
                     * make a new array with a missing element called list
                     */

                    for (int j = 0; j < reports.length; j++) {
                        if (i == j) continue;
                        list.add(reports[j]);
                    }

                    /**
                     * check to see if it's initially increasing/decreasing and also check for other constraints
                     */
                    boolean increasing = list.get(1) - list.get(0) > 0;
                    boolean decreasing = list.get(1) - list.get(0) < 0;
                    boolean withinRange = true;
                    boolean changed = false;

                    for (int k = 1; k < list.size(); k++) {
                        if (Math.abs(list.get(k) - list.get(k - 1)) > 3) withinRange = false;
                        if (increasing && list.get(k) < list.get(k - 1)) changed = true;
                        if (decreasing && list.get(k) > list.get(k - 1)) changed = true;
                        if (list.get(k).equals(list.get(k - 1))) changed = true;
                    }
                    if (withinRange && !changed) {
                        safeReports++;
                        break;
                    }
                }
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
        System.out.println(safeReports);
    }
}
