package net.hammed.craft.chat;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    // Handles messages sent to "/app/chat"
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message handleChatMessage(Message message) {
       
        System.out.println("Received message from: " + message);
        return message; // Broadcast the received message to all subscribers of /topic/messages
    }

    // Handles connection notifications sent to "/app/connect"
    @MessageMapping("/connect")
    public void handleConnect() {
        System.out.println("New client connected!");
        
        messagingTemplate.convertAndSend("/topic/connection", "rokeeb");
    }
}


