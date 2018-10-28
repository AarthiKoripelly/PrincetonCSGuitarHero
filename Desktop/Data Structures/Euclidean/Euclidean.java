/**
 * This class represents the Euclidean algoritm for calculating
 * the Greatest Common Divisor of two integers, using both recursive
 * and iterative solutions.
 * 
 * @Aarthi Koripelly  
 * @version 
 */
public class Euclidean
{
    // complete the recursive version below
    public static int gcdRecursive(int m, int n)
    {
        if(m < n){
            int t = m; 
            m = n;
            n = t; 
        }
        if (m % n == 0){
            return n; 
        }
        else{
            return gcdRecursive(n, m % n); 
        }
    }

    // complete the iterative version below
    public static int gcdIterative(int m, int n)
    {
        
        int c = 0; 
           while(c == 0){ 
               if(m < n){
                   int t = m; 
                   m = n;
                   n = t; 
             }
             if (m % n == 0){
                  return n;  
               }
             else{
                 m = m % n; 
               }  
        }
        return 0; 
    }
}
