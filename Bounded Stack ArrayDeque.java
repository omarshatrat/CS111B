import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;


public class Main {
    public static void main(String args[]) {
    BoundedStack instance = new BoundedStack();
    instance.load();
    instance.pop();
    instance.unload();
    instance.printStack();
  }
}
      
class BoundedStack { 
  
  private ArrayDeque<Double> stack1 = new ArrayDeque<>();
  Scanner loopValue = new Scanner(System.in); // input variable
  int numElements;
  Scanner t = new Scanner(System.in);
  int cont;

    public void load() {
      System.out.println("Entering values in excess of 50 means the oldest values above fifty will be removed.");
      do{
        
        System.out.println("Enter 1 to continue, anything else to quit: ");
        cont = t.nextInt();
        if (cont == 1) {
          System.out.println("Enter value:");
          double nxt = loopValue.nextDouble();
          stack1.add(nxt);
          numElements++;
          System.out.println(stack1);
            if (numElements >= 50){
              stack1.poll();
            }
        } else
              System.out.println("Bye");
        
      }while (cont == 1);
      loopValue.close();
      //System.out.println(stack1);
      /* for (int i = 1; i <= 5; i++) {
        System.out.println("Enter value "+i+":");
        double nxt = loopValue.nextDouble();
        stack1.add(nxt);
        numElements ++;*/
        
        //if (numElements > 50) {
          
          
        //}
      }

    public void pop() {
      double x = stack1.pollLast();
      numElements --;
      System.out.println("Removed: "+ x);
      
    }

    public void printStack() {
      System.out.println(stack1);
      }

    public void unload() {
      while (!stack1.isEmpty()) {
        System.out.println("element removed:"+ stack1.pop());
        numElements--;
      }
      System.out.println("Done.");
    }
      
}
     


      

    