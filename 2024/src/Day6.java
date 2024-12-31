import java.io.BufferedReader;
import java.io.FileReader;

public class Day6 {
    public void answer() {
        String file = "./practice.txt";
       int ans = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int row = 0, col = 0;
            char[][] grid = new char[10][10];
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    grid[row][i] = line.charAt(i);
                }
                row++;
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < 10; j++) {
                    if (grid[i][j] == '^') {
                        ans = dfs(grid, i, j, 0);
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(ans);
    }
        public int dfs(char [][] grid, int r, int c, int dx){
            int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            

            return 1;
        }
    }

