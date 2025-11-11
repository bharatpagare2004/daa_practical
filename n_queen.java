import java.util.*;
public class n_queen {

    static public int N;

    static void printBoard(int board[][])
    {
        for(int i = 0;i<N;i++)
        {
            for(int j = 0;j<N;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        
    }

    static boolean issafe(int board[][],int row,int col)
    {
        for(int i = 0;i<row;i++)
        if(board[i][col]==1) return false;

        for(int i = row-1,j =col-1;i>=0 && j>=0;i--,j--)
        {
        if(board[i][j] == 1) return false;
        }

        for(int i = row-1,j =col+1;i>=0 && j<N;i--,j++)
        {
        if(board[i][j] == 1) return false;
        }


        return true;
    }

    static boolean solve(int board[][],int row)
    {
        if(row == N) return true;

        for(int col =0;col<N;col++)
        {
            if(issafe(board,row,col))
            {
                board[row][col] = 1;
                if(solve(board , row+1))
                return true;
                board[row][col] = 0;
            }

        }

        return false;

    }




    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the N");
        N = sc.nextInt();

        int board[][] = new int[N][N];

        if(solve(board,0))
        {
            System.out.println("one solution exist:");
            printBoard(board);

        }
        else{
            System.out.println("there is no solution exist");
        }

    }
    
}
