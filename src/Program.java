import java.util.Random;

public class Program {
    public static void main(String[] args) {
        Client client1 = new Client("client1", 1000, RequestType.LOANREPAYMENT);
        Client client2 = new Client("client2", 10000, RequestType.TAKEALOAN);
        Client client3 = new Client("client3", 500, RequestType.LOANREPAYMENT);
        Client client4 = new Client("client4", 2000, RequestType.LOANREPAYMENT);
        Client client5 = new Client("client5", 5000, RequestType.TAKEALOAN);
    }
}
