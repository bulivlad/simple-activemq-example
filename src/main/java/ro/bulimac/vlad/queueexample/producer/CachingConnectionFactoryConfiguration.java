package ro.bulimac.vlad.queueexample.producer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import ro.bulimac.vlad.queueexample.QueueExampleConfig;

import javax.jms.ConnectionFactory;
import java.util.Arrays;

/**
 * @author vladclaudiubulimac on 17/02/2018.
 */

@Configuration
@AutoConfigureAfter(value = QueueExampleConfig.class)
public class CachingConnectionFactoryConfiguration {

    @Autowired
    private ActiveMQProperties activeMQProperties;

    @Bean
    public ConnectionFactory cachingConnectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(activeMQProperties.getBrokerUrl());
        connectionFactory.setUserName(activeMQProperties.getUser());
        connectionFactory.setPassword(activeMQProperties.getPassword());

        CachingConnectionFactory connectionFactory1 = new CachingConnectionFactory();
        connectionFactory1.setTargetConnectionFactory(connectionFactory);
        connectionFactory1.setSessionCacheSize(10);
        return connectionFactory1;
    }

}
