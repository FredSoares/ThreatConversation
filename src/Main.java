public class Main {

    public static void main(String[] args) {

        //Printer printer = new PrinterImpl();
        Printer printer = new PrinterImplSync();
        Producer producer = new Producer(printer);
        Consumer consumer = new Consumer(printer);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
