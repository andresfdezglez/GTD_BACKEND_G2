package com.capgemini.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.Category;
import com.capgemini.model.User;
import com.capgemini.repositories.CategoryRepository;
import com.capgemini.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(Long id) {
		Optional<Category> categoryOptional = categoryRepository.findById(id);
		if(categoryOptional.isEmpty()) {
			throw new IllegalArgumentException("No category found by this id: " + id);
		}
		return categoryOptional.get();
	}
	
	@Override
	public Category findByUserId(Long user) {
		Optional<Category> categoryOptional = categoryRepository.findByUserId(user);
		if(categoryOptional.isEmpty()) {
			throw new IllegalArgumentException("No category found by this user: " + user);
		}
		return categoryOptional.get();
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteById(Long id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public void delete(Category category) {
		categoryRepository.delete(category);
	}

	@Override
	public void deleteAll() {
		categoryRepository.deleteAll();
	}

	@Override
	public List<Category> findByUser(User user) {
		return categoryRepository.findByUser(user);
	}

}
