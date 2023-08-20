package task.threads;

import task.threads.Artifacts.Message;
import task.threads.Utilities.CustomThreadPool;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) {
        Queue<Message> msgQueue = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < 60; i++) {
            msgQueue.add(new Message(String.valueOf(i*2),String.valueOf(i+2)));
        }
        CustomThreadPool threadPoolExecutor = new CustomThreadPool(10);
        threadPoolExecutor.addTask(() -> System.out.println("First print task"));
        threadPoolExecutor.addTask(() -> System.out.println("Second print task"));

    }
}