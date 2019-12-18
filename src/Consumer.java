import java.sql.Ref;
import java.util.Random;

public class Consumer implements Runnable {

    Printer printer;

    public Consumer(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        int total = 0;
        for (int i = 0; i <5 ; i++) {
            try {
                Thread.sleep(new Random().nextInt(1000));
                total += printer.getValue();
                System.err.println(total);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
