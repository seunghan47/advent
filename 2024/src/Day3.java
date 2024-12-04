import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
    public static void answer() {
        String file = "./input3.txt";
        String regex = "(mul\\(\\d{1,3},\\d{1,3}\\))|(do\\(\\))|(don't\\(\\))";
        Pattern pattern = Pattern.compile(regex);
        boolean enabled = true;
        int ans = 0;
        try (BufferedReader br = new BufferedReader (new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    if (matcher.group(2) != null) {enabled = true;}
                    else if (matcher.group(3) != null) {enabled = false;}
                    else if (enabled && matcher.group(1) != null) {
                        String s = matcher.group();
                        String first = s.split(",")[0];
                        String second = s.split(",")[1];
                        int firstMul = Integer.parseInt(first.substring(4));
                        int secondMul = Integer.parseInt(second.substring(0, second.length() - 1));
                        ans += firstMul * secondMul;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(ans);
    }
}
