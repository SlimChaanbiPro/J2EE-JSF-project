package tn.esprit.Bean;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


import tn.esprit.TravelAdvice.entities.Role;
import tn.esprit.TravelAdvice.entities.User;
import tn.esprit.TravelAdvice.services.UserLocal;
import tn.esprit.TravelAdvice.services.UserServices;






@ManagedBean(name="logBean")
@SessionScoped
public class LoginBean {
	@EJB
	UserLocal service;
	private User user;
	private Role role ;
	private boolean loggedIn = false;
	private String userType;
	private String message=" ";
	private  String login;
	private String pwd;
	public User user2 ;
	
	
	
	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public UserLocal getService() {
		return service;
	}


	public void setService(UserLocal service) {
		this.service = service;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public boolean isLoggedIn() {
		return loggedIn;
	}


	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	@PostConstruct
	public void init() {
		user = new User();
	}
	public String doLogin(){
		String navigateTo = "";
		User u=null;
		user = service.authentificate(user.getLogin(), user.getPassword());

		u=service.authentificate(login, pwd);
		if (null == user) {
			loggedIn = false;
			user = new User();

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "WRONG CREDENTIALS!",
					"LOGIN OR PASSWORD ARE NOT VALID!");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} 
		if(u!=null){
			HttpSession session = SessionBean.getSession();
			session.setAttribute("login", u);
			if(u.getType().equals("simple_user"))
				{loggedIn=true;
				user2 =new  User();
				user2 = u;
				
				System.out.println("ya slim ya bhim ");
				return navigateTo="Home.xhtml";
				}
			
		}if(u.getType().equals("admin"))
			{loggedIn=true;
			user2 =new  User();
			user2 = u;
			return navigateTo="simple user";}
		if(u.getType().equals("proffessionel_user"))
		{loggedIn=true;
		user2 =new  User();
		user2 = u;
		return navigateTo="simple user";}
		
		else{
			message="vérifier le login et/ou mot de passe ";
			System.out.println(message);
		return navigateTo;
		}
	}
	public  User getUser2() {
		return user2;
	}


	public  void setUser2(User user2) {
		this.user2 = user2;
	}


	public String logout() {
		loggedIn = false;
		user = new User();
		HttpSession session = SessionBean.getSession();
		session.invalidate();
		return "/resources/template/loginfinal";
	}
}
