package tn.esprit.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.ListAmis.service.FriendshipLocal;
import tn.esprit.TravelAdvice.entities.Friendship;
import tn.esprit.TravelAdvice.entities.User;
import tn.esprit.TravelAdvice.services.UserLocal;
import tn.esprit.TravelAdvice.services.UserServices;





@ManagedBean(name="userbean")
@ViewScoped
public class UserBean {
@EJB

UserLocal local ;
FriendshipLocal FService;
String ul ="display:none";
 public String getUl() {
	return ul;
}
public void setUl(String ul) {
	this.ul = ul;
}
public FriendshipLocal getFService() {
	return FService;
}
public void setFService(FriendshipLocal fService) {
	FService = fService;
}
public User u = new User();
	private Boolean test=false;
	private List<User> users=new ArrayList<User>();
	private List<Friendship> friends=new ArrayList<Friendship>();
	private List<Friendship> friends2=new ArrayList<Friendship>();

	public FriendshipLocal getFlocal() {
		return flocal;
	}
	public void setFlocal(FriendshipLocal flocal) {
		this.flocal = flocal;
	}
	public Friendship getF() {
		return f;
	}
	public void setF(Friendship f) {
		this.f = f;
	}
	public List<Friendship> getFriends() {
		return friends;
	}
	public void setFriends(List<Friendship> friends) {
		this.friends = friends;
	}
	public List<Friendship> getFriends2() {
		return friends2;
	}
	public void setFriends2(List<Friendship> friends2) {
		this.friends2 = friends2;
	}
	@EJB
	FriendshipLocal flocal;
	User us = new User();
	private Friendship f  ;
	int nombre;
	int nombre2;
	 private String message;
	 public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getNombre2() {
		return nombre2;
	}
	public void setNombre2(int nombre2) {
		this.nombre2 = nombre2;
	}
	//LoginBean lB ;
	 int a=1;
	public UserLocal getLocal() {
		return local;
	}
	public void setLocal(UserLocal local) {
		this.local = local;
	}
	public User getUs() {
		return us;
	}
	public void setUs(User us) {
		this.us = us;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public Boolean getTest() {
		return test;
	}
	public void setTest(Boolean test) {
		this.test = test;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public String ajouter(){
		local.create(u);
		init();
		System.out.println("gdfgfd");
		return  null;
		
	}
	@PostConstruct
	public void init(){
		u=new User();
		users=local.findAll();
	
		
		nombre = users.size();
		nombre2 = friends.size();
		test=false;
		
	}
	
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String delete(User u){
		local.deleteUser(u);
		return null;
	}
	public String initialiser(){
		test=true;
		
		return null;
		
	}
	public String update(){
		local.updateUser(u);
		init();
		return null;
	}
	public List<Friendship> frendship(User u) {
		a=u.getId();
		friends=flocal.getFriendsList(a);
		return friends;
	}
	public List<User> listUser(){
		users=local.findAll();
		return users;
	}
	
	public boolean friendrequest( User u){
		return flocal.exist(a, u.getId());
		
	}
	public boolean acceptrequest(Friendship f){
		return flocal.acceptFriendRequest(f.getId());
		
	}
	public boolean deletefriend (Friendship f){
		
		return flocal.deleteFriend(f.getId());
	}
	public List <Friendship> requestonhold(User u){
		a=u.getId();
		friends2= flocal.getRequestFor(a);
		return friends2;
	}
	LoginBean l ;
	public LoginBean getL() {
		return l;
	}
	public void setL(LoginBean l) {
		this.l = l;
	}
	public boolean sendfriendrequest(int a , int b ){
		try{
			
			
	flocal.sendFriendRequest(a,b);
	return true;
		}
		catch(Exception e){
			System.out.println("bouda");
			return false;
		}
		
	}
	public void confirmuser(User user){
		us =new User();
		us=user;
	}

	
}
