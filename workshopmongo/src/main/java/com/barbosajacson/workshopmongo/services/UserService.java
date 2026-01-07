package com.barbosajacson.workshopmongo.services;
import com.barbosajacson.workshopmongo.domain.User;
import com.barbosajacson.workshopmongo.dto.UserDTO;
import com.barbosajacson.workshopmongo.repository.UserRepository;
import com.barbosajacson.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();

    }

    public User findById(String id) {
        // Nas versões novas, usamos o .findById(id)
        // O .orElseThrow já trata o erro caso o usuário não exista
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não Encontrado"));
    }

    public User insert(User obj){
        return repo.insert(obj);

    }

    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

    public User update(User obj) {
        // Buscamos o objeto original no banco
        User newObj = findById(obj.getId());

        // Chamar o método auxiliar para copiar os dados novos para o objeto antigo
        updateData(newObj, obj);

        // Salvamos as alterações
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }



}



