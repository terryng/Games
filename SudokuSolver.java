

import java.util.Arrays;
import java.util.List;

public class SudokuSolver {
	public static void solveSudoku (int[][] grid){
		solveSudoku (grid,0,0);	
	}

	public static void solveSudoku (int[][] grid, int i, int j){
		if (i == grid.length){
			for (int p = 0; p < grid.length; p++){
				for (int q = 0; q < grid.length; q++){
					System.out.print(grid[p][q]+",");
				}
				System.out.println();
			}
			return;
		}
		if (grid[i][j] == 0){
			for (int m = 1; m <= 9; m++){
				if (isValid(grid,i,j,m)){
					grid[i][j] = m;
					if (j+1 == grid.length){
						solveSudoku(grid,i+1,0);
					}
					else {
						solveSudoku(grid,i,j+1);
					}
					grid[i][j] = 0;
				}
			}
		}
		else {
			if (j+1 == grid.length){
				solveSudoku(grid,i+1,0);
			}
			else {
				solveSudoku(grid,i,j+1);	
			}
			
		}

	}

	public static boolean isValid (int[][] grid, int i, int j, int m){
		int quadi = i/3;
		int quadj = j/3;
		int loi = 0;
		int hii = 0;
		int loj = 0;
		int hij = 0;

		for (int r = 0; r < grid.length; r++){
			if (grid[r][j] == m){
				return false;
			}
			if (grid[i][r] == m){
				return false;
			}
		}

		if (quadi == 0){
			loi = 0;
			hii = 2;
		}
		else if (quadi == 1){
			loi = 3;
			hii = 5;
		}
		else if (quadi == 2){
			loi = 6;
			hii = 8;
		}

		if (quadj == 0){
			loj = 0;
			hij = 2;
		}
		else if (quadj == 1){
			loj = 3;
			hij = 5;
		}
		else if (quadj == 2){
			loj = 6;
			hij = 8;
		}

		for (int w = loi; w <= hii; w++){
			for (int v = loj; v <= hij; v++){
				if (grid[w][v] == m){
					return false;
				}
			}
		}
		return true;

	}

	public static void main (String[] args){
		int[][] grid = new int[][]{{0,2,6,0,0,0,8,1,0},
			{3,0,0,7,0,8,0,0,6},
			{4,0,0,0,5,0,0,0,7},
			{0,5,0,1,0,7,0,9,0},
			{0,0,3,9,0,5,1,0,0},
			{0,4,0,3,0,2,0,5,0},
			{1,0,0,0,3,0,0,0,2},
			{5,0,0,2,0,4,0,0,9},
			{0,3,8,0,0,0,4,6,0}};
			solveSudoku(grid);
	}
}


