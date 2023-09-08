package restaurant.manager.kitchenapplication;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private ObjectMapper objectMapper = new ObjectMapper();

    public void receiveMessage(byte[] message){
        try {
            FoodReservedDTO foodReservedDTO = objectMapper.readValue(message, FoodReservedDTO.class);
            System.out.println(foodReservedDTO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
