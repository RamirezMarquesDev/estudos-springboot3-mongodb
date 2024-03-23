package com.ramirez.petshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramirez.petshopmongo.domain.Post;
import com.ramirez.petshopmongo.repository.PostRepository;
import com.ramirez.petshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Post user = repo.findById(id).get();
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}

	public List<Post> findByTitle(String text) {
		return repo.findByTitleContainingIgnoreCase(text);
	}

	/*
	 * public Iterable<Post> findAll() {
	 * return repo.findAll();
	 * }
	 */
}
