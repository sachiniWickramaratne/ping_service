package com.alten.pingservice.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.remoting.client.AmqpProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alten.RPC.CustomerRPCService;

/**
 * @author sachini
 *
 */
@Configuration
public class RabbitConfig {

	@Autowired
	ConnectionFactory connectionFactory;
	
	@Bean
	Queue vehicleQueue(){
		return new Queue("alten.vehicle.rpc", true);
	}
	
	@Bean 
	AmqpProxyFactoryBean customerRPCService() {
        AmqpProxyFactoryBean factoryBean = new AmqpProxyFactoryBean();
        factoryBean.setServiceInterface(CustomerRPCService.class);
        factoryBean.setAmqpTemplate(rabbitTemplate());
        return factoryBean;
    }

	@Bean TopicExchange vehicleExchange() { 
		return new TopicExchange("alten.vehicle.rpc.xch"); 
	}
			  
	@Bean 
	public Binding binding() { 
		return BindingBuilder
				.bind(vehicleQueue())
				.to(vehicleExchange())
				.with("alten.vehicle.binding"); 
	}

    @Bean 
    RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setRoutingKey("alten.vehicle.binding");
        template.setExchange("alten.vehicle.rpc.xch");
        return template;
    }
	
}
