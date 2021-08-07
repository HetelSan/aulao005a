package com.devsuperior.myfirstprojetct.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.myfirstprojetct.entities.Category;
import com.devsuperior.myfirstprojetct.repositories.CategoryRepository;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		/* o bloco a seguir foi comentado pois as categorias serão obtidas agora do repository
		List<Category> list = new ArrayList<>();
		list.add(new Category(1L, "Eletronics"));
		list.add(new Category(2L, "Books")); 
		*/
		List<Category> list = categoryRepository.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		/*
		Category cat = new Category(1L, "Eletronics");
		*/
		Category cat = categoryRepository.findById(id);
		return ResponseEntity.ok().body(cat);
	}
}
