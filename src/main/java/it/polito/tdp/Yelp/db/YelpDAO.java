package it.polito.tdp.Yelp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.Yelp.model.Business;

public class YelpDAO {
	
	public List<Business> readAllBusinesses(){
		String sql = "SELECT * FROM business";
		
		List<Business> result = new ArrayList<Business>();
		
		Connection conn = DBConnect.getConnection();
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet res = st.executeQuery();
			while(res.next()) {
				result.add(new Business(
						res.getString("business_id"),
						res.getString("full_address"),
						res.getString("active"),
						res.getString("categories"),
						res.getString("city"),
						res.getInt("review_count"),
						res.getString("business_name"),
						res.getString("neighborhoods"),
						res.getDouble("latitude"),
						res.getDouble("longitude"),
						res.getString("state"),
						res.getDouble("stars")
						));
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	} 
	
	public double averageStars(Business business) {
		String sql = "SELECT AVG(stars) AS avg_stars, COUNT(*) AS review_number "
				+ "FROM reviews "
				+ "WHERE business_id = ?";
		
		//String sql = "SELECT 1 AS avg_stars";
		
		
		Connection conn = DBConnect.getConnection();
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, business.getBusinessId());
			ResultSet res = st.executeQuery();
			res.first(); //Non ho bisogno di un ciclo while per iterare, essendo una query di tipo aggreto mi darà una riga sola.
			double stars = res.getDouble("avg_stars"); //Mi posiziono quindi sulla prima riga e chiedo il valore alla colonna che
			                                           //si chiama avg_stars.
			conn.close();
			return stars;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	
}
