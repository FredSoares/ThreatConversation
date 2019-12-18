public class PrinterImplSync implements Printer {

    private int value = -1;
    private boolean isValue = false;

    @Override
    public synchronized int getValue() {
        while (!isValue){
            System.out.println("Printer is empty");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.err.println("Consumer consumed "+value);
        isValue = false;
        this.notifyAll();
        return this.value;
    }

    @Override
    public synchronized void setValue(int value) throws InterruptedException {
        while (isValue){
            System.out.println("Printer is full");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Producer produced "+value);
        this.value = value;
        isValue = true;
        this.notifyAll();
        //notifyAll();
    }
}
