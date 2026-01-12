package com.barbosajacson.workshopmongo.services;

import com.barbosajacson.workshopmongo.domain.Post;
import com.barbosajacson.workshopmongo.repository.PostRepository;
import com.barbosajacson.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        // O findById retorna um Optional, por isso usamos o .orElseThrow
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post>findByTitle(String text){
        return repo.findByTitleContainingIgnoreCase(text);
    }

}




