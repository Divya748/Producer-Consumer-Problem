
public class Main {
    public static void main(String[] args) {
    SharedResource obj = new SharedResource(3);

    Thread producerThread = new Thread(
            () ->{
                try {
                    for(int i=1;i<=6;i++){
                        obj.produce(i);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
    );

        Thread consumerThread = new Thread(
                () ->{
                    try {
                        for(int i=1;i<=6;i++){
                            obj.consume();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

        producerThread.start();
        consumerThread.start();
    }
}