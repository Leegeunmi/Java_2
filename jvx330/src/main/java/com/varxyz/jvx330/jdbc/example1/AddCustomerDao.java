//package com.varxyz.jvx330.jdbc.example1;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import org.apache.tomcat.jdbc.pool.DataSource;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementCreator;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//
//import com.mysql.cj.xdevapi.PreparableStatement;
//import com.varxyz.jvx330.jdbc.Customer;
//
//public class AddCustomerDao {
//	private JdbcTemplate jdbcTemplate;//1방식
//	
//	public AddCustomerDao(DataSource dataSource) {//2방식
//		jdbcTemplate = new JdbcTemplate(dataSource);
//	}
//	
//	//테이블 INSERT하는 방식 --------
//	//1번째 유형
//	public void addCustomer(Customer customer) {
//		String sql = "INSERT INTO Customer (email, passwd, name, ssn, phone)"
//				+ " VALUES(?,?,?,?,?)";
//		
//		jdbcTemplate.update(new PreparedStatementCreator() {
//
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con)
//					throws SQLException {
//				PreparedStatement pstmt = con.prepareStatement(sql);
//					pstmt.setString(1, customer.getEmail());
//					pstmt.setString(2, customer.getPasswd());
//					pstmt.setString(3, customer.getName());
//					pstmt.setString(4, customer.getSsn());
//					pstmt.setString(5, customer.getPhone());
//					
//					return pstmt;
//			}
//			
//		});
//	}
//
//	//2번째 유형 (가장 자주쓰임 알아두기)
//	public void addCustomer2(Customer customer) {
//		String sql = "INSERT INTO Customer (email, passwd, name, ssn, phone)"
//				+ " VALUES(?,?,?,?,?)";
//		jdbcTemplate.update(sql, customer.getEmail(), customer.getPasswd(),
//			customer.getName(), customer.getSsn(), customer.getPhone());
//	}
//	
//	//3번째 유형
//	public long addCustomer3(Customer customer) {
//		String sql = "INSERT INTO Customer (email, passwd, name, ssn, phone)"
//				+ " VALUES(?,?,?,?,?)";
//		KeyHolder keyHolder = new GeneratedKeyHolder();
//		PreparedStatementCreator creator = (connection) -> {
//			PreparedStatement pstmt = connection.prepareStatement(sql, 
//					new String[] {"cid"});
//
//			pstmt.setString(1, customer.getEmail());
//			pstmt.setString(2, customer.getPasswd());
//			pstmt.setString(3, customer.getName());
//			pstmt.setString(4, customer.getSsn());
//			pstmt.setString(5, customer.getPhone());
//			return pstmt;
//		};
//		jdbcTemplate.update(creator, keyHolder);
//		return keyHolder.getKey().longValue();
//	}
//}