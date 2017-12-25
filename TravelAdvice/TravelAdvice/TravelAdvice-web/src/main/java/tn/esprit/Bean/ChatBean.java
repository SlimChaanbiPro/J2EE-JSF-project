package tn.esprit.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import tn.esprit.Message.service.MessageServiceLocal;
import tn.esprit.TravelAdvice.entities.Message;
import tn.esprit.TravelAdvice.entities.User;
import tn.esprit.TravelAdvice.services.UserLocal;
import tn.esprit.TravelAdvice.services.UserServices;



@ManagedBean
@SessionScoped
public class ChatBean {
	
	
	private List<Message> inbox;
	
	private LoginBean lb ;
	
	

	private  int currentUserId =1;
	public LoginBean getLb() {
		return lb;
	}
	public void setLb(LoginBean lb) {
		this.lb = lb;
	}

	List<Message> lmm = new ArrayList<>();
	public List<Message> getLmm() {
		return lmm;
	}
	public void setLmm(List<Message> lmm) {
		this.lmm = lmm;
	}
	public void confirmuser(User u , User u2){
		this.user = u;
		currentUserId=u2.getId();
	}
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	public MessageServiceLocal getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageServiceLocal messageService) {
		this.messageService = messageService;
	}

	public UserLocal getUserService() {
		return userService;
	}

	public void setUserService(UserLocal userService) {
		this.userService = userService;
	}

	private int otherUserId=1;
	private List<Message> conversation;
	private Message message;

	public List<Message> Inbox(int a) {
		
	
		return inbox = messageService.getMessagesFor(a);
	}

	public String Converstation(int idUser ) {
	//	String navigateTo = "/Chat/conversation?faces-redirect=true";
		currentUserId = lb.user2.getId();
		List<Message> lm =new ArrayList<>();
		lm = messageService.getMessagesFromTo(currentUserId, idUser);
		otherUserId = idUser;
		lmm=lm;
		return "message.xhtml";
	}

	public void SendMessage(int b,int id,String messages) {
		otherUserId=id;
		
		
		
		
		messageService.sendMessage(b, id, messages);
		//conversation = messageService.getMessagesFromTo(lb.user2.getId(), otherUserId);
		message = new Message();
		message.setReceiver(new User());
	}
	
	public void doSend(int idUser){
		
		messageService.sendMessage(currentUserId, idUser, message.getText());
		inbox = messageService.getMessagesFor(currentUserId);
		message = new Message();
		message.setReceiver(new User());
	}

	public void DeleteMessages(Message m) {
	try {
		messageService.deleteMessage(m);
		lmm.remove(m);
	} catch (Exception e) {
	System.out.println("bouda ya bhim");
		e.printStackTrace();
	}
	}

	public List<User> UsersList() {
		return userService.findAll();
	}

	public List<Message> getInbox() {
		return inbox;
	}

	public void setInbox(List<Message> inbox) {
		this.inbox = inbox;
	}

	public int getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(int currentIdUser) {
		currentUserId = currentIdUser;
	}

	public List<Message> getConversation() {
		return conversation;
	}

	public void setConversation(List<Message> conversation) {
		this.conversation = conversation;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public int getOtherUserId() {
		return otherUserId;
	}

	public void setOtherUserId(int otherUserId) {
		this.otherUserId = otherUserId;
	}

	@EJB
	MessageServiceLocal messageService;
	@EJB
	UserLocal userService;

	@PostConstruct
	public void init() {
		message = new Message();
		message.setReceiver(new User());
		lb =new LoginBean();
	}
}
