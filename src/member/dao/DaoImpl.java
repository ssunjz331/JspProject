package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import conn.DBConnect;
import model.MemberVO;

public class DaoImpl implements Dao {
	private DBConnect db;
	 
	public DaoImpl() {
		db = DBConnect.getInstance();
	}
	
	@Override
	public void insert(MemberVO m) {
		Connection conn = null;
		
		String sql = "insert into MEMBER values(?, ?, ?, ?, ?, 1, 0)";
		
		PreparedStatement pstmt = null;
		try {
			
			conn = db.getConnection();
			
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getAddr());
			
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public MemberVO select(String id) {
		Connection conn = null;
		ResultSet rs = null;
		MemberVO m = null;
		
		String sql = "select * from MEMBER where id=?";
		PreparedStatement pstmt = null;
		try {
			
			conn = db.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public void update(MemberVO m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

}