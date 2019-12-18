public class PrinterImpl implements Printer {

    private int value = -1;
    @Override
    public int getValue() {
        System.err.println("Consumer consumed "+ this.value);
        return this.value;
    }

    @Override
    public void setValue(int value) throws InterruptedException {
        System.out.println("Producer produced " + value);
        this.value = value;
    }
}
