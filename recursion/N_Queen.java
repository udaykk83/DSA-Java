package recursion;

import java.util.*;

public class N_Queen {
	    static List<List<String>> ans = new ArrayList<List<String>>();
	    public static List<List<String>> solveNQueens(int n) {
	        ans.clear();
	        int row=0, col = 0; 
	        char[][] board = new char[n][n];
	        for (int i = 0; i < n; i++){
	            for (int j = 0; j < n; j++) {
	                board[i][j] = '.';
	            }
	        }
	        NQUeenSol(row, board, n);
	        return ans;        
	    }
	    
	    public static boolean isSafe(char[][] board, int row, int col, int n) {
	        if(row >= n || col >= n) {
	            return false;
	        }
	        for(int i=row-1; i>=0; i--) {
	            if(board[i][col] == 'Q'){
	                return false;
	            }
	        }
	        int h= row-1, v = col-1; 
	        while(h >= 0 && v >= 0) {
	            if(board[h][v] == 'Q'){
	                return false;
	            }
	            h--;
	            v--;
	        }
	        
	        h= row-1; v = col+1; 
	        while(h >= 0 && v < n) {
	            if(board[h][v] == 'Q'){
	                return false;
	            }
	            h--;
	            v++;
	        }
	        return true;        
	    }
	    
	    public static boolean NQUeenSol(int row, char[][] board, int n) {
	        if(row >= n) {
	            List<String> res = new ArrayList<String>();
	            for(int x=0; x<n; x++){
	                res.add(new String(board[x]));
	            }            
	            ans.add(res);
	        }
	        
	        for(int j = 0; j< n; j++) {
	            if(isSafe(board, row, j, n)) {
	                board[row][j] = 'Q';
	                if(NQUeenSol(row+1, board, n)) {
	                    return true;
	                }
	                board[row][j] = '.';
	            }
	        }
	        return false;
	    }
	    
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solveNQueens(4);
		System.out.println(ans);
	}

}
