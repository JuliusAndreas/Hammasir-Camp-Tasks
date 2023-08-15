package task.threads.Artifacts;

public class Message {
    private String head;
    private volatile String body;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void extendBody(String appendee){
        //Critical Section
        synchronized (this.body) {
            this.body = this.body.concat(appendee);
        }
    }
}
