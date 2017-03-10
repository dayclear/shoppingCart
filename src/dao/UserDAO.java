package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vo.UserVO;

public class UserDAO extends BaseDAO{
	
	//判断用户名和密码是否正确
	public boolean login(UserVO vo) {
		boolean flag = false;
		String sql = "select pwd from member where user = ?";
		Connection conn = null;
		try {
			conn = getConn();
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, vo.getUser());
			ResultSet rs = ps.executeQuery();
			if( rs.next() ) {
				String pwd = rs.getString("pwd");
				if(pwd.equals(vo.getPwd()))
					flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(conn);
		}
		return flag;
	}
	
	//注册时，检查用户名是否存在
	public boolean exist(String user){
		boolean flag=false;
		String sql = "select count(*) from member where user=?";
		Connection conn = null;
		try {
			conn = getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				if (rs.getInt("count(*)")>0){
					flag=true;
				}
			}
		}catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.close(conn);
			}
			return flag;
		}
	
	
	public boolean register(UserVO vo) {
		boolean flag = false;
		String sql = "insert into member(user,pwd) values(?,?)";
		Connection conn = null;
		try {
			conn = getConn();
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1,vo.getUser());
			ps.setString(2, vo.getPwd());
			int count=ps.executeUpdate();
			if(count>0){
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(conn);
		}
		return flag;
	}
	
	//修改密码
		public boolean update(UserVO vo) {
			boolean flag = false;
			String sql = "update member set pwd=? where user=?";
			Connection conn = null;
			try {
				conn = getConn();
				PreparedStatement ps =conn.prepareStatement(sql);
				ps.setString(1, vo.getPwd());
				ps.setString(2,vo.getUser());
				int count=ps.executeUpdate();
				if(count>0){
					flag=true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.close(conn);
			}
			return flag;
		}
}
