package tn.ListAmis.service;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.TravelAdvice.entities.Friendship;



@Local
public interface FriendshipLocal {
	public boolean sendFriendRequest(int idSrc, int idDest);

	public boolean acceptFriendRequest(int idRequest);

	public List<Friendship> getRequestFor(int idUser);

	public List<Friendship> getFriendsList(int idUser);
	public   Friendship findbyiduser( int idu1 , int idu2);

	public boolean deleteFriend(int id);
	
	public boolean exist(int idSrc, int idDest);
}
