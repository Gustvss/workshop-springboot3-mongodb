package com.tcser.workshopmongo.services;

import com.tcser.workshopmongo.dto.UserDTO;
import com.tcser.workshopmongo.entities.User;
import com.tcser.workshopmongo.repositories.UserRepository;
import com.tcser.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;


    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public User insert(User obj) {
       return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

    public User update(String id, User obj){
        try {
            User newObj = repo.getReferenceById(id);
            updateData(newObj, obj);
            return repo.save(newObj);
        } catch (NullPointerException e){
            throw new ObjectNotFoundException(id);
        }
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

}
