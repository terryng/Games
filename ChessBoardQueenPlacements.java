import java.util.ArrayList;
import java.util.List;

public class QueenPlacements {
	
	public static List<String[]> computePlacements (int n){
		int[][] grid = new int[n][n];
		ArrayList<String[]> aL = new ArrayList<String[]>();
		computePlacements(0,grid,aL);
		return aL;
	}

	public static void computePlacements (int i, int[][] grid, ArrayList<String[]> list){
		if (i == grid.length){
			int r = 0;
			String[] container = new String[grid.length];
			for (int p = 0; p < grid.length; p++){
				StringBuilder sb = new StringBuilder("");
				for (int q = 0; q < grid[0].length; q++){
					if (grid[p][q] == 1){
						sb.append('Q');
					}
					else {
						sb.append('.');
					}
				}
				container[r] = sb.toString();
				r++;
			}
			list.add(container);
			return;
		}
		for (int j = 0; j < grid.length; j++){
			if (isValid(grid,i,j)){
				grid[i][j] = 1;
				computePlacements(i+1,grid,list);
				grid[i][j] = 0;
			}
		}
	}

	public static boolean isValid (int[][] grid, int a, int c){
		for (int j = 0; j < grid[0].length; j++){
			if (grid[a][j] == 1){
				return false;
			}
		}	
		for (int i = 0; i < grid.length; i++){
			if (grid[i][c] == 1){
				return false;
			}
		}
		for (int i = 0; i < grid.length; i++){
			if (a+i < grid.length && c+i < grid.length && grid[a+i][c+i] == 1){
				return false;
			}
			if (a+i < grid.length && c-i >= 0 && grid[a+i][c-i] == 1){
				return false;
			}
			if (a-i >= 0 && c+i < grid.length && grid[a-i][c+i] == 1){
				return false;
			}
			if (a-i >= 0 && c-i >= 0 && grid[a-i][c-i] == 1){
				return false;
			}
		}
		return true;
	}

	public static void main (String[] args){
		List<String[]> returnList = computePlacements(4);
		for (String[] sa : returnList){
			for (String s : sa){
				System.out.println(s);
			}
			System.out.println();
		}
	}

}
