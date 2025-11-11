import java.util.*;
class fractional_knapsack
{

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the no of item:");
        int n = sc.nextInt();

        int profit[] = new int[n];
        int weight[] = new int[n];
        double ratio[] = new double[n];

        System.out.print("enter the profit and weight:");
        for(int i = 0;i<n;i++)
        {
            profit[i] = sc.nextInt();
            weight[i] = sc.nextInt();
            ratio[i] = (double)profit[i]/weight[i]; 
        }
        System.out.println("enter the bag capacity:");
        int capacity = sc.nextInt();

        // descending order of ratio
        for(int i = 0;i<n;i++)
        {
            for(int j = i+1;j<n;j++)
            {
                if(ratio[i]<ratio[j])
                {
                    int tempProfit = profit[i];
                    profit[i] = profit[j];
                    profit[j] = tempProfit;

                     int tempWeight = weight[i];
                    weight[i] = weight[j];
                     weight[j] = tempWeight;

                     double tempRatio = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = tempRatio;

                }
            }
        }

        double totalvalue = 0.0;
        int i =0;
        while(capacity>0&&i<n)
        {
            if(weight[i]<=capacity)
            {
                totalvalue = totalvalue+profit[i];
                capacity = capacity - weight[i];
                i++;
            }
            else{
                totalvalue = totalvalue + ratio[i]*capacity;
                capacity = 0;
            }

        }
        System.out.println("the totalvalue is :"+totalvalue);
    }

    
}