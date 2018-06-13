package com.nwtProject.Transport.Services;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.AMQP.Exchange;

@Configuration
public class TransportConfiguration {

	 @Bean
	 public TopicExchange eventExchange() {
	   return new TopicExchange("eventExchange");
	 }
	
	
	@Bean
	 public TransportService transportService(RabbitTemplate rabbitTemplate, TopicExchange eventExchange)
	 {
		return new TransportService(rabbitTemplate,eventExchange);
	 }
}
