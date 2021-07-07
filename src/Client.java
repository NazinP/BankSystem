import java.util.Random;

public class Client implements Runnable {
    private String clientName;
    private int amount;
    private RequestType requestType;
    private Request request;

    public Client(String clientName, int amount, RequestType requestType) {
        this.clientName = clientName;
        this.amount = amount;
        this.requestType = requestType;
        this.request = new Request(requestType, amount, clientName);
    }

    @Override
    public void run() {

    }

    @Override
    public String toString() {
        return "Client{" +
                ", clientName='" + clientName + '\'' +
                ", amount=" + amount +
                ", requestType=" + requestType +
                ", threadNmae=" + Thread.currentThread().getName() +
                '}';
    }
}
