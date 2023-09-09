package restaurant.manager.kitchenapplication;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Receiver {

    private ObjectMapper objectMapper = new ObjectMapper();

    public void receiveMessage(byte[] message){
        try {
            FoodReservedDTO foodReservedDTO = objectMapper.readValue(message, FoodReservedDTO.class);
            log.info(foodReservedDTO.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
