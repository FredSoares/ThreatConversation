import java.util.Random;

public class Producer implements Runnable{
    Printer printer;

    public Producer(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        int total = 0;
        for (int i = 0; i < 5 ; i++) {
            try {
                Thread.sleep(new Random().nextInt(1000));
                total += i;
                printer.setValue(i);
                System.out.println(total);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
