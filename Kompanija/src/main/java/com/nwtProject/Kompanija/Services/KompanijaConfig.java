package com.nwtProject.Kompanija.Services;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.AMQP.Exchange;

@Configuration
public class KompanijaConfig {

	@Bean
	  public TopicExchange eventExchange() {
	    return new TopicExchange("eventExchange");
	  }
	
	@Bean
	public Queue transportQueue() {
		return new Queue("transports.queue");
	
	}
	@Bean
	  public Binding binding(Queue queue, TopicExchange eventExchange) {
	    return BindingBuilder
	            .bind(queue)
	            .to(eventExchange)
	            .with("customer.*");
	  }
	 @Bean
	  public TransportService transportService() {
	    return new TransportService();
	  }

}
