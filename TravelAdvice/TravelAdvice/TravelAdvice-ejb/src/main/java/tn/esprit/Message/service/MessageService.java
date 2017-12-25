package tn.esprit.Message.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.TravelAdvice.entities.Friendship;
import tn.esprit.TravelAdvice.entities.Message;
import tn.esprit.TravelAdvice.entities.User;



@Stateless
public class MessageService implements MessageServiceRemote, MessageServiceLocal {

	@PersistenceContext
	EntityManager em;

	public MessageService() {
	}

	@Override
	public void sendMessage(int idSrc, int idDest, String text) {
		User src = em.find(User.class, idSrc);
		User dest = em.find(User.class, idDest);
		Message m = new Message(src, dest, text);
		em.persist(m);
	}

	@Override
	public void deleteMessage(Message m) {
		em.remove(em.find(Message.class, m.getIdMessage()));
	}

	@Override
	public List<Message> getMessagesFromTo(int idSrc, int idDest) {
		Query query = em
				.createQuery(
						"select m from Message m where (m.receiver.id = :src and m.sender.id = :dest) or (m.receiver.id = :dest and m.sender.id = :src) order by m.date desc")
				.setParameter("src", idSrc).setParameter("dest", idDest);
		return query.getResultList();
	}

	@Override
	public List<Message> getMessagesFor(int id) {
		List<Message> listOfMessages = new ArrayList<>();
		User u = em.find(User.class, id);
		Query query = em.createQuery("select distinct m.sender from Message m where m.receiver = :user")
				.setParameter("user", u);
		Query query2 = em
				.createQuery(
						"select m from Message m where m.sender = :user and m.receiver = :receiver order by m.date desc")
				.setParameter("receiver", u).setMaxResults(1);
		try {
			List<User> results = query.getResultList();
			for (User user : results) {
				query2.setParameter("user", user);
				List<Message> messages = (List<Message>) query2.getResultList();
				if (messages.size() > 0) {
					listOfMessages.add(messages.get(0));
				}
			}
			return listOfMessages;
		} catch (Exception e) {
			e.printStackTrace();
			return listOfMessages;
		}
	}

	@Override
	public void deleteConversation(int id) {
		Message m = em.find(Message.class, id);
		int idSender = m.getSender().getId();
		int idReceiver = m.getReceiver().getId();
		List<Message> tmp = getMessagesFromTo(idSender, idReceiver);
		for (Message message : tmp) {
			em.remove(em.find(Message.class, message.getIdMessage()));
		}
	}

}
