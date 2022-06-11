package it.polito.tdp.crimes.model;

import java.util.*;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
import it.polito.tdp.crimes.db.EventsDao;

public class Model {
	
	private Graph<String,DefaultWeightedEdge> grafo;
	EventsDao dao;
	List<String> listaId = new ArrayList<>();
	List<Integer> anni = new ArrayList<>();
	
	public Model() {
		dao = new EventsDao();
		//anni = dao.listAllYears();
		//listaId = dao.listAllCategoryId();
	}
	
	public void creaGrafo(int year, String offenseId) {
		
		this.grafo = 
				new SimpleGraph<String,DefaultWeightedEdge>
		(DefaultWeightedEdge.class);
		
		List<String> vertici = 
				dao.listParametresGraph(year, offenseId);

		for(String s : vertici) {
			this.grafo.addVertex(s);
		}
		
		
	}

	public List<String> getListaId() {
		return listaId;
	}

	public List<Integer> getAnni() {
		return anni;
	}
	
	
	
}
