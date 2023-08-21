package scheduled.tasks.demo;

// Importing required classes
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    // Method
    // To trigger the scheduler every one minute
    // between 19:00 PM to 19:59 PM
    @Scheduled(fixedDelay = 3000)
    public void specialScheduleTask(){
        System.out.println("I am a special task");
    }
    @Scheduled(cron = "${interval-in-cron}")
    public void scheduleTask()
    {

        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "dd-MM-yyyy HH:mm:ss.SSS");

        String strDate = dateFormat.format(new Date());

        System.out.println(
                "job Scheduler: Job running at - "
                        + strDate);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
