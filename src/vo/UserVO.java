package vo;

public class UserVO {
	private String user;
	private String pwd;
	
	public UserVO(String u,String p){
		this.user=u;
		this.pwd=p;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
