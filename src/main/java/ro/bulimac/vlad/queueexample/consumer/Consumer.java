package ro.bulimac.vlad.queueexample.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ro.bulimac.vlad.queueexample.QueueExampleApplication;

/**
 * @author vladclaudiubulimac on 17/02/2018.
 */

@Component
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueueExampleApplication.class);

    @JmsListener(destination = "${app.queue-name}")
    public void receiveMessage(@Payload String email) throws Exception {
        if(email.contains("\"id\":3")){
            throw new Exception("third email rejected");
        }
        LOGGER.info("We received an email");
        LOGGER.info(email);
    }

}
