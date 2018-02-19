package ro.bulimac.vlad.queueexample.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import ro.bulimac.vlad.queueexample.QueueExampleConfig;
import ro.bulimac.vlad.queueexample.model.Email;

/**
 * @author vladclaudiubulimac on 17/02/2018.
 */

@Component
public class Producer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);


    private QueueExampleConfig config;

    private JmsTemplate jmsTemplate;

    @Autowired
    public Producer(QueueExampleConfig config,
                    JmsTemplate jmsTemplate){
        this.config = config;
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(Long id){
        Email email = Email.builder().id(id).from("vlad").to("vlad").subject("test subject").body("test body").build();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonified = objectMapper.writeValueAsString(email);
            jmsTemplate.convertAndSend(config.getQueueName(),jsonified);
            LOGGER.info("The message was sent");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            LOGGER.error("ERROR! The message was not sent");
        }
    }

}
