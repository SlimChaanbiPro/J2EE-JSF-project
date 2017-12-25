package tn.esprit.TravelAdvice.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.TravelAdvice.entities.User;




@Local
public interface UserLocal {
	void create(User user);
	public User authentificate(String login, String password);
	public void delete(int id);
	public List<User> findAll();
	public User find(int id);
	public User findByLogin(String login);
	public User findByAdress(String adress);
	public Boolean deleteUser( User u);
	public Boolean updateUser(User u);

		
	

}
