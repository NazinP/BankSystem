import java.util.Random;

public class Client implements Runnable{
    private FrontEnd frontEnd;
    private final int multiplicity = 10000;

    public Client(FrontEnd frontEnd) {
        this.frontEnd = frontEnd;
    }

    @Override
    public void run() {
        Random random = new Random();
        int amount = (random.nextInt(100) + 1) * multiplicity;

        RequestType type = RequestType.values()[random.nextInt(2)];
        Request request = new Request(Thread.currentThread().getName(), amount, type);

        frontEnd.addRequest(request);
    }
}
