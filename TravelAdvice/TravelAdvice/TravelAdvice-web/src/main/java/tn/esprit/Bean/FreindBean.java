package tn.esprit.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import tn.ListAmis.service.FriendshipLocal;
import tn.esprit.TravelAdvice.entities.Friendship;
import tn.esprit.TravelAdvice.entities.User;
import tn.esprit.TravelAdvice.services.UserLocal;
@ManagedBean(name="friend")
@ViewScoped
public class FreindBean {
	@EJB
	UserLocal service;
	int idDest ;
	private Boolean test=false;
	public int getIdDest() {
		return idDest;
	}
	public void setIdDest(int idDest) {
		this.idDest = idDest;
	}
	public LoginBean getlB() {
		return lB;
	}
	public void setlB(LoginBean lB) {
		this.lB = lB;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	private User user;
    LoginBean lB ;
    int a = lB.getUser().getId();
	private Friendship f  ;
	@EJB
	FriendshipLocal flocal;
	public UserLocal getService() {
		return service;
	}
	public void setService(UserLocal service) {
		this.service = service;
	}
	public Boolean getTest() {
		return test;
	}
	public void setTest(Boolean test) {
		this.test = test;
	}
	public Friendship getF() {
		return f;
	}
	public void setF(Friendship f) {
		this.f = f;
	}
	public FriendshipLocal getFlocal() {
		return flocal;
	}
	public void setFlocal(FriendshipLocal flocal) {
		this.flocal = flocal;
	}
	private List<User> users=new ArrayList<User>();
	public List<Friendship> frendship() {
		List<Friendship> users = new ArrayList<Friendship>();
		users=flocal.getFriendsList(lB.getUser().getId());
		return users;
	}
	public List<User> listUser(){
		users=service.findAll();
		return users;
	}
	public boolean friendrequest( User u){
		return flocal.exist(a, u.getId());
		
	}
	public boolean acceptrequest(Friendship f){
		return flocal.acceptFriendRequest(f.getId());
		
	}
	public boolean delete (Friendship f){
		
		return flocal.deleteFriend(f.getId());
	}
	public List <Friendship> requestonhold(){
		
		return flocal.getRequestFor(a);
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@PostConstruct
	public void init() {
		user = new User();
		listUser();
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

}
	
