package task.threads.Utilities;

import task.threads.Artifacts.Message;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Task implements Runnable {
    private ConcurrentLinkedQueue<Message> queue;
    public Task(ConcurrentLinkedQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (Message msg : queue) {
            msg.extendBody("a");
        }
    }
}
