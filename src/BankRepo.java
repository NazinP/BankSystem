public class BankRepo {
    private int repo = 1000000;

    private void getSomeMoney(int amount) {
        try{
            repo -= amount;
        } catch (Exception e) {
            System.out.println("Недостаточно денег!");;
        }
    }

    private void addSomeMoney(int amount){
        repo += amount;
    }

    public synchronized void actionWithBankRepo(Request request){
        if(request.getRequestType() == RequestType.TAKEALOAN){
            getSomeMoney(request.getAmount());
        }else{
            addSomeMoney(request.getAmount());
        }
    }
}
