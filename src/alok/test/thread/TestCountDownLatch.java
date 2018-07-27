package alok.test.thread;


import java.util.concurrent.CountDownLatch;

/**
* CountDown Latch is useful if you want to start main processing thread once its 
* dependency is completed as illustrated in this Example.
* 
* In this example, Car can start only after all 4 employees take their seat in the car.
* 
*/
public class TestCountDownLatch {

public static void main(String args[]) {

  final CountDownLatch latch = new CountDownLatch(4);
  Thread emp1 = new Thread(new Employee("EMP 1", 1000, latch));
  Thread emp2 = new Thread(new Employee("EMP 2", 1000, latch));
  Thread emp3 = new Thread(new Employee("EMP 3", 1000, latch));
  Thread emp4 = new Thread(new Employee("EMP 4", 1000, latch));
   
 // separate threads will start moving all four employees 
 // from their office to car parking.

  emp1.start(); 
  emp2.start(); 
  emp3.start();
  emp4.start();

   
 // Driver should not start car until all 4 employees take their seats in the car.
   
  try
 {
       // carDriver thread is waiting on CountDownLatch to finish
       latch.await();  
       System.out.println("All employees have taken their seat, Driver started the car");
  }
  catch(InterruptedException ie){
      ie.printStackTrace();
  }
   
}

}

/**
* Employee class which will be executed by Thread using CountDownLatch.
*/
class Employee implements Runnable{
private final String name;
private final int timeToReachParking;
private final CountDownLatch latch;

public Employee(String name, int timeToReachParking, CountDownLatch latch){
   this.name = name;
   this.timeToReachParking = timeToReachParking;
   this.latch = latch;
}

@Override
public void run() {
   try {
       Thread.sleep(timeToReachParking);
   } catch (InterruptedException ex) {
       System.err.println("Error : ");
       ex.printStackTrace();
   }
   System.out.println( name + " has taken his seat");
   latch.countDown(); //reduce count of CountDownLatch by 1
}

}
