package co.projetbank.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SavingsAccountDao extends Dao<SavingsAccount>{

	@Override
	public SavingsAccount find(int id) {
		String str = "select * from T_SavingsAccount where IdCust=?";
		PreparedStatement ps;
		SavingsAccount compte = null;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,id);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()){
				compte = new SavingsAccount(resultSet.getInt(1),resultSet.getDate(2),resultSet.getDouble(3),resultSet.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return compte;
	}

	@Override
	public boolean create(SavingsAccount obj) {
		String str = "INSERT INTO T_SavingsAccount (IdCust,DateCreation,Balance,InterestRate) VALUES (?, ? ,? ,?);";
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1, obj.getIdCust());
			ps.setDate(2,(Date) obj.getDateCreation());
			ps.setDouble(3,obj.getBalance());
			ps.setInt(4, obj.getInterestRate());
			ps.executeQuery();
			ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public boolean update(SavingsAccount obj) {		
		String str = " update T_SavingsAccount set Balance=? where IdCust=?;";		
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setDouble(1,obj.getBalance());
			ps.setInt(2,obj.getIdCust());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return ok;
	}

	@Override
	public boolean delete(SavingsAccount obj) {
		String str = "delete from T_SavingsAccount where IdCust=?;";	
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,obj.getIdCust());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}
}
