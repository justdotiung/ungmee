package ungmee.web.entity;

public class ExDao {
	public String name;
	public String email;
	public String date;
	public String message;
	
	
	
	public ExDao() {}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ExDao [name=" + name + ", email=" + email + ", date=" + date + ", message=" + message + "]";
	}
	
	
}
