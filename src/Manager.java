import java.util.Objects;

public class Manager implements Runnable {
    private FrontEnd frontEnd;
    private BackEnd backEnd;

    public Manager(FrontEnd frontEnd, BackEnd backEnd) {
        this.frontEnd = frontEnd;
        this.backEnd = backEnd;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            Request request = frontEnd.getRequest();
            if (Objects.nonNull(request)) {
                backEnd.executeRequest(request);
            }
        }
    }
}
