import java.util.*; 
import java.util.StringTokenizer;
/**
 * Write a description of class Palindrome here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Palindrome
{
    public static boolean isPalindrome(String s){
        StringTokenizer sub = new StringTokenizer(s, "''.,;:'? \t\n\r");
        Queue<String> queue = new LinkedList<String>(); 
        Stack<String> stack = new Stack<String>();
        int count = 0; 
        while(sub.hasMoreTokens()){
            String str = sub.nextToken(); 
            for(int i=0; i<str.length(); i++){
                String c = Character.toString(str.charAt(i)); 
                if(c != " "){
                    queue.add(c.toLowerCase()); 
                    stack.push(c.toLowerCase()); 
                    count++;
                }
                
                 
            }
        }
        int otherCount = 0; 
        int counter = 0; 
        while(counter < count){
            if((queue.remove().equals(stack.pop()))){
              otherCount++;   
            }
            counter++; 
        }
        if(count == otherCount) return true;
        return false; 
        
    }
}
