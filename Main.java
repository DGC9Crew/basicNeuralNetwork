import java.util.Random;
import java.util.Scanner;

class Main {
  static Random rand = new Random();
  static double lr = 1;
  static double bias = 100;
  static double weights[] = {rand.nextDouble()*100,rand.nextDouble()*100};
  static int lessers;
  static int greaters;

  static void Perceptron(double input1, double output) {
    double outputP = input1*weights[0]+bias*weights[1];
    
    if(outputP > 0) {
      outputP = 1;
      
    } else {
      outputP = 0;
    }
   System.out.println(outputP);
    double error = output - outputP;
    
    weights[0] += error * input1 * lr;
    weights[1] += error * bias * lr;
  }


  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    
    for(int i = 0; i < 10000; i++) {
      double x = rand.nextDouble()*100;
      double trueornot = 0;
      
      if(x > 50) {
        trueornot = 1;
        greaters += 1;
      } else {
        trueornot = 0;
        lessers += 1;
      }
      System.out.println(x + ", " + trueornot);
      
      Perceptron(x,trueornot);
      
      System.out.println("----");
    }
    System.out.println("Greaters: " + greaters);
    System.out.println("Lessers: " + lessers);
    while(true) {
      double x = scn.nextDouble();
      double outputP = x*weights[0] + bias*weights[1];
      if(outputP > 0) {
        outputP = 100;
      } else {
        outputP = 0;
      }
      System.out.println(x + " is closer to : " + outputP);
    }
  }
}
