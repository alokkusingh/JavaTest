package alok.test.volatilE;

public class VolatileTest {
    //private static volatile int x=0;
	private static int x=0;
    public static void set(){
        //Keep the variable quickly changing
        while(true){
            x=3;
            x=5;
        }
    }
    public static void display(){
        while(true){
            int y=x;
            //See if x is modified in between
            if(y!=x){
                System.out.println(System.currentTimeMillis() +  " whoa");
            }
        }
    }

    public static void main(String [] args){
        new Thread(){
            public void run(){
                set();
            }
        }.start();
        
        new Thread(){
            public void run(){
                display();
            }
        }.start();
    }


}