import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
    public static void answer() {
        String file = "./input3.txt";
        String regex = "mul\\(\\d{1,3},\\d{1,3}\\)";
        Pattern pattern = Pattern.compile(regex);
        int ans = 0;
        try (BufferedReader br = new BufferedReader (new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    String s = matcher.group();
                    String first = s.split(",")[0];
                    String second = s.split(",")[1];
                    int firstMul = Integer.parseInt(first.substring(4));
                    int secondMul = Integer.parseInt(second.substring(0, second.length()-1));
                    ans += firstMul * secondMul;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(ans);
    }
}
