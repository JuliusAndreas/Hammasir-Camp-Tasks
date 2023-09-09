package rabbitmq.demo.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/rabbitSend/{message}")
    public ResponseEntity sendMessage(@PathVariable String message) {
        rabbitTemplate.convertAndSend("imfanout.exchange", "I am being ignored", message);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
