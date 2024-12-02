import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Day1 {
    public void answer() {
        String filePath = "./input.txt";
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0, ans2 = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                int first = Integer.parseInt(line.split(" {3}")[0]);
                int second = Integer.parseInt(line.split(" {3}")[1]);
                list1.add(first);
                list2.add(second);
                map.put(second, map.getOrDefault(second, 0) + 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(list1);
        Collections.sort(list2);
        for (int i = 0; i < list1.size(); i++) ans += Math.abs(list1.get(i) - list2.get(i));
        for (int i = 0; i < list1.size(); i++) {
            if (map.containsKey(list1.get(i))) {
                ans2 += list1.get(i) * map.get(list1.get(i));
            }
        }

        System.out.println(ans);
        System.out.println(ans2);
    }
}
