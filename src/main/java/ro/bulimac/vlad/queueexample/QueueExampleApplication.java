package ro.bulimac.vlad.queueexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import ro.bulimac.vlad.queueexample.producer.Producer;

@SpringBootApplication
@EnableJms
@EnableAutoConfiguration
public class QueueExampleApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(QueueExampleApplication.class);

	@Autowired
	private Producer producer;

	public static void main(String[] args) {
		SpringApplication.run(QueueExampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(){
		return (strings) -> {
			LOGGER.info("The app started");
			producer.sendMessage(1L);
			producer.sendMessage(2L);
			producer.sendMessage(3L);
			producer.sendMessage(4L);
		};
	}
}
