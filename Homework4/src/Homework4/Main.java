package Homework4;

public class Main {

	public static void main(String[] args) 
	{
		int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		MatrixSearch(arr, 12);
		MatrixSearch(arr, 5);
		MatrixSearch(arr, 12);
		MatrixSearch(arr, 6);
		MatrixSearch(arr, 13);
	}
	
	public static int[] MatrixSearch (int[][] arr, int key)
	{
		int[] answer = {-1,-1};
	    int numRows = arr.length;
	    int numCols = arr[0].length;
	    int low = 0;
	    int high = numRows * numCols - 1;
	    
	    while (low <= high) 
	    {
	        int mid = (low + high) / 2;
	        int row = mid / numCols;
	        int col = mid % numCols;
	        if (arr[row][col] == key) 
	        {
	        	answer[0] = row;
	        	answer[1] = col;
				System.out.print(answer[0] + ", ");
				System.out.println(answer[1]);
	        	return answer;
	        }
	        else if (arr[row][col] < key) 
	        {
	        	low = mid + 1;
	        }
	        
	        else 
	        {
	        	high = mid - 1;
	        }
	    }
	    return answer;
	}

}
