import java.util.Random;

public class Program {
    public static void main(String[] args) {
        FrontEnd front = new FrontEnd();
        Client[] clients = new Client[]{
                new Client("client1", 1000, RequestType.LOANREPAYMENT, front),
                new Client("client5", 5000, RequestType.TAKEALOAN, front),
                new Client("client2", 10000, RequestType.TAKEALOAN, front),
                new Client("client3", 500, RequestType.LOANREPAYMENT, front),
                new Client("client4", 2000, RequestType.LOANREPAYMENT, front)
        };


        for (int i = 0; i < clients.length; i++) {
            new Thread(clients[i]).start();
        }
    }
}
