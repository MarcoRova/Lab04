package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {
	
	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";
		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");
				//System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);
				corsi.add(new Corso(codins, numeroCrediti, nome, periodoDidattico));
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
	
	
	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public List<Corso> getCorso(Corso corso) {
		return null;
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Integer> getStudentiIscrittiAlCorso(Corso corso) {
		
		final String sql = "SELECT i.matricola "
				+ "FROM iscrizione i, corso c "
				+ "WHERE i.codins = c.codins AND c.codins = ?";
		
		List<Integer> studenti = new LinkedList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, corso.getCodins());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int matricola = rs.getInt("matricola");
				
				studenti.add(matricola);
				}

			rs.close();
			st.close();
			conn.close();
			return studenti;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		return false;
	}

}
