import java.io.BufferedReader;
import java.io.FileReader;

public class Day5 {
    public void answer(){
        String file = "./input5.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null){
//                System.out.println(line);
                if (line.length() > 5) System.out.println(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
