import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

    private  Queue<Integer> sharedBuffer;
    private  int bufferSize;

    public SharedResource(int bufferSize) {
        this.bufferSize = bufferSize;
        sharedBuffer = new LinkedList<>();
    }

    public synchronized void produce(int item) throws InterruptedException {
        while(sharedBuffer.size() == bufferSize){
            System.out.println("Buffer size full wait for consumer to consume data");
            wait();
        }
        System.out.println("produced item" + item);
        sharedBuffer.add(item);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while(sharedBuffer.isEmpty()){
            System.out.println("Buffer size is empty wait for producer to produce data");
            wait();
        }
        int item = sharedBuffer.poll();
        System.out.println("produced item" + item);
        notifyAll();
        return item;
    }
}
