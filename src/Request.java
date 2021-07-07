public class Request {
    private RequestType requestType;
    private int amount;
    private String nameOfOwner;

    public Request(RequestType requestType, int amount, String nameOfRequest) {
        this.requestType = requestType;
        this.amount = amount;
        this.nameOfOwner = nameOfRequest;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public int getAmount(){
        return amount;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestType=" + requestType +
                ", amount=" + amount +
                ", nameOfRequest='" + nameOfOwner + '\'' +
                '}';
    }
}
