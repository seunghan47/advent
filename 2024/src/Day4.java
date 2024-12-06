import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Day4 {
    public int answer () {
        int [][] directions = {
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, 1}, {-1, -1}, {1, 1}, {1, -1}
        };
        int [][] direction = {
                {1,1}, {-1, -1}, {-1, 1}, {1, -1}
        };
        int lines = 0, ans = 0, ans2 = 0;
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
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == 'X'){
                    for (int [] dir : directions) {
                        ans += dfs(grid, i, j, 0, dir[0], dir[1], "XMAS");
                    }
                }
                if (grid[i][j] == 'A'){
                    boolean forward = dfs2(grid, i, j);
                    boolean backward = dfs3(grid, i, j);
                    if (forward && backward) ans2 ++;
                }
            }
        }
//        return ans;
        return ans2;
    }
    public int dfs(char[][]grid, int r, int c, int index, int dx, int dy, String word) {
        if (index == 4) return 1;
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '.' || grid[r][c] != word.charAt(index))
            return 0;
        return dfs(grid, r + dx, c + dy, index + 1, dx, dy, "XMAS");
    }
    public boolean dfs2(char[][]grid, int r, int c) {
        boolean containsM = false;
        boolean containsS = false;
        if (r - 1 < 0 || c - 1 < 0 || r  >= grid.length - 1 || c >= grid[0].length - 1) return false;
        if (grid[r - 1][c - 1] == 'M') containsM = true;
        if (grid[r - 1][c - 1] == 'S') containsS = true;
        if (grid[r + 1][c + 1] == 'M') containsM = true;
        if (grid[r + 1][c + 1] == 'S') containsS = true;
        return (containsM && containsS);
    }
    public boolean dfs3(char[][]grid, int r, int c) {
        boolean containsM = false;
        boolean containsS = false;
        if (r - 1 < 0 || c  - 1 < 0 || r >= grid.length - 1 || c >= grid[0].length - 1) return false;
        if (grid[r - 1][c + 1] == 'M') containsM = true;
        if (grid[r - 1][c + 1] == 'S') containsS = true;
        if (grid[r + 1][c - 1] == 'M') containsM = true;
        if (grid[r + 1][c - 1] == 'S') containsS = true;
        return (containsM && containsS);

    }
}
