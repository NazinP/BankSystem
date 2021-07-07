import java.util.LinkedList;
import java.util.List;

public class FrontEnd {
    private List<Request> requestList = new LinkedList<>();

    public synchronized void addRequest(Request request) throws InterruptedException {
        while (requestList.size() == 2){
            wait();
        }
        requestList.add(request);
        System.out.println("Заявка" + request.toString() + "обрабатывается");
        notifyAll();
    }
}
