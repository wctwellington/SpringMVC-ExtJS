package br.com.projeto.dao;

import java.util.List;

public interface IGenericDAO<Entity, PK> {
	
	void create(Entity entity);
	
	Entity read(PK pk);
	
	void delete(Entity entity);
	
	List<Entity> readAll();
	
}
