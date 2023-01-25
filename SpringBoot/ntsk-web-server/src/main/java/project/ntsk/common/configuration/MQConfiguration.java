package project.ntsk.common.configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class MQConfiguration {

	@Bean
	@ConfigurationProperties(prefix = "spring.activemq")
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		return factory;
	}

	@Bean(name = "myFactory")
	public DefaultJmsListenerContainerFactory myFactory(
			ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {

		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connectionFactory);

		// スレッド化
		ExecutorService executor = Executors.newCachedThreadPool(new MQThreadFactory("MQReceive-%d"));
		factory.setTaskExecutor(executor);

		// コンバート指定
		//factory.setMessageConverter(new MQMessageConverter());

		return factory;
	}

	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory){
	    JmsTemplate template = new JmsTemplate();
	    template.setConnectionFactory(connectionFactory);
	    return template;
	}

	//スレッド化
	public static class MQThreadFactory implements ThreadFactory {
		private final AtomicInteger counter = new AtomicInteger(0);
		private final String format;

		private MQThreadFactory(String format) {
			this.format = format;
		}

		@Override
		public Thread newThread(Runnable r) {
			String name = String.format(format, counter.incrementAndGet());
			return new Thread(null, r, name);
		}
	}

//	//コンバート指定
//	@Bean
//	public MarshallingMessageConverter createMarshallingMessageConverter(Jaxb2Marshaller jaxb2Marshaller) {
//		return new MarshallingMessageConverter(jaxb2Marshaller);
//
//	}
//
//	@Bean
//	public Jaxb2Marshaller createJaxbMarshaller(@Value("${context.path}") final String contextPath,
//			@Value("${schema.location}") final Resource schemaLocation) {// this method will provide jaxb marshaller ,we
//																			// need to provide context path and schema
//																			// resource
//
//		BookList bookList = JAXB.unmarshal(Paths.get("/bookList.xml").toFile(), BookList.class);
//		bookList.books.forEach(System.out::println);
//
//		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
//		jaxb2Marshaller.setContextPath(contextPath);
//		jaxb2Marshaller.setSchema(schemaLocation);
//
//		Map<String, Object> prop = new HashMap<>();
//		prop.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//		jaxb2Marshaller.setMarshallerProperties(prop);
//
//		return jaxb2Marshaller;
//	}

}
