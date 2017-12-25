package tn.esprit.Message.service;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.TravelAdvice.entities.Message;



@Local
public interface MessageServiceLocal {
	public List<Message> getMessagesFromTo(int idSrc, int idDest);
	public List<Message> getMessagesFor(int idUser);
	public void sendMessage(int idSrc, int idDest, String text);
	public void deleteMessage(Message m);
	public void deleteConversation(int id);
}
