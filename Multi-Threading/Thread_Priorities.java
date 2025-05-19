class MyThr1 extends Thread {
    public MyThr1(String name) {
        super(name);
    }
    public void run() {
        int i = 5;
        while(true) {
            System.out.println("Thank you " + this.getName());
        }
    }
}

public class Thread_Priorities {
    public static void main(String[] args) {
        MyThr1 t1 = new MyThr1("Harshit1");
        MyThr1 t2 = new MyThr1("Harshit2");
        MyThr1 t3 = new MyThr1("Harshit3");
        MyThr1 t4 = new MyThr1("Harshit4");
        MyThr1 t5 = new MyThr1("Harshit5 (most important)");
        t5.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
