package ro.bulimac.vlad.queueexample;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author vladclaudiubulimac on 17/02/2018.
 */

@Configuration
@ConfigurationProperties(prefix = "app")
public class QueueExampleConfig {

    @Getter
    @Setter
    private String queueName;

    @Bean
    public ActiveMQProperties activeMQProperties(){
        return new ActiveMQProperties();
    }

}
