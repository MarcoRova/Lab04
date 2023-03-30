package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public boolean cercaStudente(int matricola) {
		
		final String sql = "SELECT matricola "
				+ "FROM studente "
				+ "WHERE matricola = ?";
		
		Integer matr = 0;

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				matr = rs.getInt("matricola");
				}

			rs.close();
			st.close();
			conn.close();
			
			if(matr == 0)
				return false;
			else
				return true;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	public String[] getInfoStudente(int matricola){
		
		final String sql = "SELECT nome, cognome "
				+ "FROM studente "
				+ "WHERE matricola = ?";
		
		String[] ris = new String[2];

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				
				ris[0] = nome;
				ris[1] = cognome;
			}

			rs.close();
			st.close();
			conn.close();
			
			return ris;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	public List<Corso> getCorsiFromStudente(int matricola) {
		
		final String sql = "SELECT * "
				+ "FROM iscrizione i, corso c "
				+ "WHERE i.codins = c.codins AND matricola = ?";

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();
			
			List<Corso> corsi = new LinkedList<Corso>();

			while (rs.next()) {
				
				String codins = rs.getString("codins");
				int crediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int pd = rs.getInt("pd");
				
				corsi.add(new Corso(codins, crediti, nome, pd));
			}

			rs.close();
			st.close();
			conn.close();
			
			return corsi;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	
}
