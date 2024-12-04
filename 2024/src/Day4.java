import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Day4 {
    public int answer () {
        int lines = 0, ans = 0;
        char [][] grid = new char[140][140];
        try (BufferedReader br = new BufferedReader(new FileReader("./input4.txt"))){
            String line;
            while ((line = br.readLine()) != null){
                /** filling up the grid */
                for (int i = 0; i < 140; i++) grid[lines][i] = line.charAt(i);
                lines++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        ans = dfs(grid, 0, 0);
        return ans;
    }
    public int dfs(char[][]grid, int r, int c){
        return 1;
    }
}
