public class knapsack {

    static int knapsack_dp(int weight[],int profit[],int capacity , int n)
    {

        int dp[][] = new int[n+1][capacity+1];

        for(int i = 0;i<=n;i++)
        {
            for(int w = 0;w<=capacity;w++)
            {
                if(i==0||w==0)
                {
                    dp[i][w] = 0;
                }
                else if(weight[i-1]<=w)
                {
                    dp[i][w] = Math.max(profit[i-1]+dp[i-1][w-weight[i-1]],dp[i-1][w]);
                }
                else
                 {
                    dp[i][w] = dp[i-1][w];

                 }
            }
        }


        return dp[n][capacity];

    }


    public static void main(String args[])
    {
        int profit[] = {2,3,1,4};
        int weight[] = {3,4,5,5};
        int capacity = 8;
        int n = profit.length;

        int max_value = knapsack_dp(weight,profit,capacity,n);
        System.out.println("the maximum value is:"+max_value);
    }
    
}
