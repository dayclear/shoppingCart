package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.PhoneVO;

public class PhonesDAO extends BaseDAO{

	//通过id查找商品
	public PhoneVO getPhonesById(int id){
		PhoneVO vo=null;
		String str="select id,name,img,price from phones where id=?";
		Connection conn=super.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(str);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vo = new PhoneVO(id,
						rs.getString("name"),
						rs.getString("img"),
						rs.getInt("price")
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.close(conn);
		}
		return vo;
	}
	
	//通过品牌查找商品
	public List<PhoneVO> getPhonesByBrand(String brand){
		List<PhoneVO> list=new ArrayList<PhoneVO>();
		String str="select id,name,img,price from phones where brand=? order by id";
		Connection conn=super.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(str);
			ps.setString(1,brand);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				PhoneVO vo = new PhoneVO(rs.getInt("id"),
						rs.getString("name"),
						rs.getString("img"),
						rs.getInt("price")
						);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.close(conn);
		}
		return list;
	}
	
	//通过名字查找商品
		public List<PhoneVO> getPhonesByName(String name){
			List<PhoneVO> list=new ArrayList<PhoneVO>();
			String str="select id,name,img,price from phones where name like ?";
			Connection conn=super.getConn();
			try {
				PreparedStatement ps = conn.prepareStatement(str);
				String strName="%"+name+"%";
				ps.setString(1,strName);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					PhoneVO vo = new PhoneVO(rs.getInt("id"),
							rs.getString("name"),
							rs.getString("img"),
							rs.getInt("price")
							);
					list.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				super.close(conn);
			}
			return list;
		}
	
}
