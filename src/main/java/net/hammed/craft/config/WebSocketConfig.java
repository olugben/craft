package net.hammed.craft.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override 
    public void registerStompEndpoints(@NonNull StompEndpointRegistry registry) {
        // Define the WebSocket endpoint that the client will use to connect to the server
        registry.addEndpoint("/chat").withSockJS();
    }

    @Override
    public void configureMessageBroker(@NonNull MessageBrokerRegistry config) {
        // Enable a simple in-memory message broker and set the destination prefixes
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }
}
