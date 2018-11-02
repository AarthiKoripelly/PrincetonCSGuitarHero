import java.util.*; 
/**
 * This GuitarString object . . .
 * 
 * @author  
 * @version 
 */
public class GuitarString 
{
    private RingBuffer ring; 
    private int count; 
    private int size; 
  
    public GuitarString(double frequency) 
    {
       int x = 44100/(int)frequency; 
       ring = new RingBuffer(x); 
       size = x; 
        for(int i = 0; i < x; i++){
         try{
            ring.add(0.0); 
         }
         catch(Exception e){}
       }
    }

    public GuitarString(double[] array) 
    {
        ring = new RingBuffer(array.length); 
        for(int i = 0; i < array.length; i++){
         try{
            ring.add(array[i]); 
         }
         catch(Exception e){}
       }
    }

    public void pluck() 
    {
        for(int i = 0; i < size; i++){
            double random = (double) (Math.random() - 0.5); 
         try{
            ring.remove(); 
            ring.add(random); 
         }
         catch(Exception e){}
       }
    }

    // advance the simulation one time step
    public void tic() 
    {
        count++; 
        double x = ring.peek(); 
        try{
            ring.remove(); 
         }
        catch(Exception e){} 
        double y = ring.peek(); 
        double both = 0.994*(0.5)*(x+y); 
        try{
            ring.add(both); 
         }
        catch(Exception e){}
        
    }

    // return the current sample
    public double sample() 
    {
        return ring.peek(); 
    }
  
    // return number of times tic was called
    public int time() 
    {
        return count; 
    }

    public static void main(String[] args) 
    {
        double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
        GuitarString testString = new GuitarString(samples);
        for (int i = 0; i < 25; i++) 
        {
            int t = testString.time();
            double sample = testString.sample();
            System.out.printf("%6d %8.4f\n", t, sample);
            testString.tic();
        }
    }
}
