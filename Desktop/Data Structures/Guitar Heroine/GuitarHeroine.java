/**
 * This GuitarHeroine object . . .
 * 
 * @AarthiKoripelly  
 * @version 
 */
public class GuitarHeroine
{
    public static void main(String[] args) 
    {
            // Create 37 guitar strings, for concert A and C
     GuitarString[] strings = new GuitarString[37];
     String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
     for(int i = 0; i < 37; i++){
            double frequency = 440 * Math.pow(1.05956, i-24); 
            strings[i] = new GuitarString(frequency); 
     }
     
     // the main input loop
     while (true) 
        {
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) 
            {
                // the user types this character2
                char key = StdDraw.nextKeyTyped();

                int index = keyboard.indexOf(key); 
                if(index == -1){
                     continue; 
                 }
                 
                strings[index].pluck(); 
                
               
            }
            
            // compute the superposition of the samples
            double sample = 0; 

            // send the result to standard audio
            for(int i = 0; i < strings.length; i++){
                sample += strings[i].sample(); 
            }
            
            StdAudio.play(sample);
            // advance the simulation of each guitar string by one step
            for(int i = 0; i < strings.length; i++){
                strings[i].tic(); 
            } 
            
        }
  }
}
