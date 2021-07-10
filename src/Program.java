import java.util.ArrayList;
import java.util.List;

public class Program {
    public static final int countClients = 5;
    public static final int countManagers = 2;

    public static void main(String[] args) {
        FrontEnd frontEnd = new FrontEnd(countClients);
        BackEnd backEnd = new BackEnd(countClients);

        Client client = new Client(frontEnd);
        for (int i = 1; i < countClients + 1; i++) {
            Thread thread = new Thread(client, "Клиент №" + i);
            thread.start();
        }

        Manager manager = new Manager(frontEnd, backEnd);
        List<Thread> handlers = new ArrayList<>();
        for (int i = 1; i < countManagers + 1; i++) {
            Thread thread = new Thread(manager, "Менеджер №" + i);
            thread.start();
            handlers.add(thread);
        }

        while(true) {
            if (backEnd.getRemainPerform() == 0) {
                for (Thread thread : handlers) {
                    thread.interrupt();
                }
                break;
            }
        }
    }
}
