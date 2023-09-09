package rabbitmq.demo.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ReceiverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReceiverApplication.class, args);
    }

    @RabbitListener(queues = {"fanout.queue1", "fanout.queue2"})
    public void listen(String in) {
        log.info("Message read from the queue : " + in);
    }

}
