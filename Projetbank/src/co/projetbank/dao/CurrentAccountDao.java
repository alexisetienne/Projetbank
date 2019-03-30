package co.projetbank.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.simplon.dao.CurrentAccount;
import co.simplon.entities.Account;

public class CurrentAccountDao extends T<CurrentAccount> {
	
	
	@Override
	public CurrentAccount find(int id) {
		String str = "select * from T_CurrentAccount where IdCust=?";
		PreparedStatement ps;
		Account compte = null;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,id);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()){
				compte = new CurrentAccount(resultSet.getInt(1),resultSet.getDate(2),resultSet.getDouble(3),resultSet.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return compte;
	}

	@Override
	public boolean create(CurrentAccount obj) {
		String str = "INSERT INTO T_CurrentAccount (IdCust,DateCreation,Balance,Overdraft) VALUES (?, ? ,? ,?);";
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1, obj.getIdCust());
			ps.setDate(2,(Date) obj.getDateCreation());
			ps.setDouble(3,obj.getBalance());
			ps.setInt(4, obj.getOverdraft());
			ps.executeQuery();
			ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public boolean update(CurrentAccount obj) {		
		String str = " update T_CurrentAccount set Balance=? where IdCust=?;";		
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
	public boolean delete(CurrentAccount obj) {
		String str = "delete from T_CurrentAccount where IdCust=?;";	
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