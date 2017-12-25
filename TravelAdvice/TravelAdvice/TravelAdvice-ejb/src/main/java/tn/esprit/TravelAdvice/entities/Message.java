package tn.esprit.TravelAdvice.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;

@Entity
@XmlRootElement
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMessage;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String text;

	@ManyToOne
	@JoinColumn(name = "idSender")
	private User sender;

	@ManyToOne
	@JoinColumn(name = "idReceiver")
	private User receiver;

	public Message() {
	}

	public Message(User src, User dest, String text) {
		this.sender = src;
		this.receiver = dest;
		this.text = text;
		this.date = new Date();
	}

	public int getIdMessage() {
		return this.idMessage;
	}

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getReceiver() {
		return this.receiver;
	}

	public void setReceiver(User reciver) {
		this.receiver = reciver;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getSender() {
		return this.sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	@Override
	public int hashCode() {
		return idMessage;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Message))
			return false;
		Message other = (Message) obj;
		if (idMessage != other.idMessage)
			return false;
		return true;
	}

}