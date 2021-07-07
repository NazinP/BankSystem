import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FrontEnd {
    private Queue<Request> requestList = new LinkedList<>();

    public synchronized void addRequest(Request request) throws InterruptedException {
        while (requestList.size() == 2) {
            wait();
        }
        requestList.add(request);
        System.out.println("Заявка " + request.toString() + " обрабатывается");
        notifyAll();
    }

    public synchronized Request getRequest() {
        while (requestList.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Request request = requestList.poll();
        return request;
    }
}
