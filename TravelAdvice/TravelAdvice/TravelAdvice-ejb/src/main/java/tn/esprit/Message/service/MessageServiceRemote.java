package tn.esprit.Message.service;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.TravelAdvice.entities.Message;

@Remote
public interface MessageServiceRemote {
	public List<Message> getMessagesFromTo(int src, int dest);
	public List<Message> getMessagesFor(int idUser);
	public void sendMessage(int src, int dest, String text);
	public void deleteMessage(Message m);}
