package BusinessLogic;

import java.io.Serializable;

public class User  implements Serializable{
	protected String Name;
	protected String email;
	protected String password;
	
	public User(){
		Name = email = password = "";
	}

	public String getName() {
		return Name;
	}

	public User(String name, String email, String password) {
		super();
		Name = name;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [Name=" + Name + ", email=" + email + ", password=" + password + "]";
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
