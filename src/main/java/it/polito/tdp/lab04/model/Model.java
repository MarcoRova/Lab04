package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	private CorsoDAO corsoDao;
	private StudenteDAO studenteDao;
	
	public Model() {
		this.corsoDao = new CorsoDAO();
		this.studenteDao = new StudenteDAO();
	}
	
	public List<Corso> getTuttiICorsi() {
		return this.corsoDao.getTuttiICorsi() ; 
	}
	
	public String[] getInfoStudente(int matricola){
		return this.studenteDao.getInfoStudente(matricola);
	}
	
	public List<Integer> getStudentiIscrittiAlCorso(Corso corso){
		return this.corsoDao.getStudentiIscrittiAlCorso(corso);
	}
	
	public List<Corso> getCorsiFromStudente(int matricola) {
		return this.studenteDao.getCorsiFromStudente(matricola);
	}
	
	public boolean cercaStudente(int matricola) {
		return this.studenteDao.cercaStudente(matricola);
	}
	
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		return this.corsoDao.inscriviStudenteACorso(studente, corso);
	}
}
