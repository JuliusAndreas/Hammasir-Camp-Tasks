package task.threads;

import task.threads.Utilities.CustomThreadPool;

public class Main {
    public static void main(String[] args) {
//        Queue<Message> msgQueue = new C

        CustomThreadPool threadPoolExecutor = new CustomThreadPool(10);
        threadPoolExecutor.addTask(() -> System.out.println("First print task"));
        threadPoolExecutor.addTask(() -> System.out.println("Second print task"));

    }
}