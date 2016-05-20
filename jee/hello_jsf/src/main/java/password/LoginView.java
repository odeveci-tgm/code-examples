package password;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class LoginView {
	private final static String superSecret = "DasIstDasSicherstePasswortEver";
	private final static String bestUser = "admin";
	
	private String password;
	private String username;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public boolean validation() {
		if (password.equals(superSecret) && username.equals(bestUser)) return true;
		return false;
	}
}
