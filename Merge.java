import java.util.*;
/**
 *  A class to study merging.
 *
 *  @author Jason Quesenberry and Nancy Quesenberry
 *  @created January 16, 2006
 */

public class Merge{
  public void merge (ArrayList <Comparable> a, ArrayList <Comparable> b, ArrayList <Comparable> c){
      int indexA = 0;
      int indexB = 0;
      boolean isDoneA = false;
      boolean isDoneB = false;
      while(!isDoneA && !isDoneB) {
          Comparable A = a.get(indexA);
          Comparable B = a.get(indexB);
          if(indexA >= a.size()) isDoneA = true;
          if(indexB >= b.size()) isDoneB = true;
          if(isDoneA) c.add(B);
          else if(isDoneB) c.add(A);
          else if(!isDoneA && A.compareTo(B) < 0) c.add(A);
          else if(!isDoneB && B.compareTo(A) < 0) c.add(B);
          indexA++;
          indexB++;
      }
      if(isDoneA) {
          for(int i = indexB; i < b.size(); i++) c.add(c.get(i));
      } else if(isDoneB) {
          for(int d = indexA; d < a.size(); d++) c.add(c.get(d));
      }
 }

  /**
   *  Initializes and returns temp with random integers in the range
   *  1 to largestInt
   *
   * @return  an ArrayList of size specified by the user filled
   *          with random numbers
   */
  public ArrayList <Comparable> fillArray(){
    Scanner console = new Scanner(System.in);

    System.out.println();
    System.out.print("How many numbers do you wish to generate? ");
    int numInts = console.nextInt();

    ArrayList <Comparable> temp = new ArrayList <Comparable> ();

    System.out.print("Largest integer to generate? ");
    int largestInt = console.nextInt();

    Random randGen = new Random();

    for (int loop = 0; loop < numInts; loop++){
      temp.add(randGen.nextInt(largestInt) + 1);
    }

    return temp;
  }

  /**
   *  Prints out the contents of the array in tabular form, 20 columns
   */
  public void screenOutput(ArrayList <Comparable> temp){
    for (int loop = 0; loop < temp.size(); loop++){
      if (loop % 15 == 0){
        System.out.println();
      }
      System.out.printf("%5d",temp.get(loop));
    }
    System.out.println();
  }

}

