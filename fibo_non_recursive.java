public class fibo_non_recursive {


    static void fib_n_rec(int n)
    {
        if(n<=0)
        {
            return;
        }
        int a = 0;
        if(n == 1)
        {
            System.out.print(a);
            return;
        }
        int b = 1;
        System.out.print(a+"  "+b);
        for(int i = 2;i<n;i++)
        {
            int c = a +b;
            System.out.print(" "+c);
            a=b;
            b=c;
        }
        
    }

    public static void main(String args[])
    {
        int n =10;
        fib_n_rec(n);
    }
    
}
