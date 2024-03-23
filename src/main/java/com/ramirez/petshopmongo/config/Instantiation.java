package com.ramirez.petshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ramirez.petshopmongo.domain.Post;
import com.ramirez.petshopmongo.domain.User;
import com.ramirez.petshopmongo.dto.AuthorDTO;
import com.ramirez.petshopmongo.repository.PostRepository;
import com.ramirez.petshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("BRT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User Ramirez = new User(null, "Ramirez Marques", "ramirez@gmail.com");
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob, Ramirez));

		Post post1 = new Post(null, sdf.parse("21/03/2018 10:53:00"), "Partiu viagem!",
				"vou viajar para Noruega. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("22/03/2024 10:54:00"), "Bom Dia!",
				"Acordei e ja fui logo estudando hoje", new AuthorDTO(maria));

		postRepository.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);

	}

}
