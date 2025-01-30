package Service;

import Model.Message;
import DAO.MessageDAO;

import java.util.List;

public class MessageService {
    MessageDAO messageDAO;

    public MessageService(){
        messageDAO = new MessageDAO();
    }

    public MessageService(MessageDAO messageDAO){
        this.messageDAO = messageDAO;
    }

    public Message addMessage(Message message){
        try {
            return this.messageDAO.postMessage(message);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Message updateMessage(int message_id, Message message){
        if (this.messageDAO.getMessageById(message_id) != null) {
            this.messageDAO.updateMessage(message_id, message);
            return this.messageDAO.getMessageById(message_id);
        }
        else {
            return null;
        }
    }

    public List<Message> getAllMessages() {
        try {
            return this.messageDAO.getAllMessages();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Message getMessageById(int message_id) {
        try {
            return this.messageDAO.getMessageById(message_id);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Message> getAllMessagesByAccountId(int account_id) {
        try {
            return this.messageDAO.getAllMessagesByAccountId(account_id);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Message deleteMessage(int message_id){
        Message deletedMessage = this.messageDAO.getMessageById(message_id);
        if (deletedMessage != null) {
            this.messageDAO.deleteMessage(message_id);
            return deletedMessage;
        }
        else {
            return null;
        }
    }
}
