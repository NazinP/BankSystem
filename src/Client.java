import java.util.Random;

public class Client implements Runnable {
    private String clientName;
    private int amount;
    private RequestType requestType;
    private Request request;
    private FrontEnd frontEnd;

    public Client(String clientName, int amount, RequestType requestType, FrontEnd frontEnd) {
        this.clientName = clientName;
        this.amount = amount;
        this.requestType = requestType;
        this.request = new Request(requestType, amount, clientName);
    }

    @Override
    public void run() {
        System.out.println("Заявка " + request.toString() + " отправлена банку");
        try {
            frontEnd.addRequest(request);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
