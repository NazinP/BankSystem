public class BackEnd {

    private int repo = 1_000_000;
    public static final String SUCCESFULLTRANSACTION = "Оповещение: %s выполнена. Получена от %s. Баланс банка: %d\n";
    public static final String FAILURETRANSACTION = "Оповещение: %s не выполнена. Получена от %s. " +
            "Сумма больше баланса банка. Баланс банка: %d\n";

    private int remainPerform;

    public BackEnd(int remainPerform) {
        this.remainPerform = remainPerform;
    }

    public synchronized void executeRequest(Request request) {

        switch (request.getType()) {
            case TAKEALOAN:
                getSomeMoney(request);
                break;
            case LOANREPAYMENT:
                addSomeMoney(request);
                break;

        }
        remainPerform--;
    }

    private void getSomeMoney(Request request) {
        int amount = request.getAmount();
        if (repo < amount) {
            System.out.printf(FAILURETRANSACTION,
                    request,
                    Thread.currentThread().getName(),
                    repo);
        }else{
            repo -= amount;
            System.out.printf(SUCCESFULLTRANSACTION,
                    request,
                    Thread.currentThread().getName(),
                    repo);
        }
    }

    private void addSomeMoney(Request request){
        repo += request.getAmount();
        System.out.printf(SUCCESFULLTRANSACTION,
                request,
                Thread.currentThread().getName(),
                repo);
    }

    public synchronized int getRemainPerform() {
        return remainPerform;
    }
}
