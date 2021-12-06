package com.project.api.service;

import java.util.List;

public interface MySerivce<T> {

	List<T> getAll();

	T getById(int id);

	T addNew(T object);

	T update(T object);

	void delete(int id);
}
