/**
 * This RingBuffer object . . .
 * 
 * @AarthiKoripelly  
 * @version 
 */
public class RingBuffer extends Exception
{
    private double[] array; 
    private int front;
    private int rear; 
    private int size; 
    
    public RingBuffer(int capacity)
    {
        array = new double[capacity]; 
        size = 0;
        front = 0;
        rear = 0;
    }

    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size==0;  
    }
    
    public boolean isFull()
    {
        return size==array.length; 
    }
    
    public void add(double value) throws Exception
    {
        if(isFull()){
            throw new Exception("Cannot add into full array.");
        }
        array[rear] = value;
        rear++; 
        if(rear == array.length){
            rear = 0;
        }
        size++;
        
    }
    
    public double peek() 
    {
        return array[front]; 
    }
    
   
    public double remove() throws Exception
    {
        if(isEmpty()){
            throw new Exception("Cannot remove an empty array.");
        }
        double result = peek();
        array[front] = 0; 
        front++; 
        if(front==array.length){
            front = 0;
        }
        size--; 
        return result; 
    }
    
    // a simple test of the constructor and methods in RingBuffer
    public static void main(String[] args) throws Exception
    {
        int capacity = 100;
        RingBuffer buffer = new RingBuffer(capacity);  
        for (int i = 1; i <= capacity; i++) 
            buffer.add(i);
      
        double t = buffer.remove();
        buffer.add(t);
        System.out.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) 
        {
            double x = buffer.remove();
            double y = buffer.remove();
            buffer.add(x + y);
        }
        System.out.println(buffer.peek());
    }

}
