package br.com.gmbconsulting.approvalsystem.service;

import br.com.gmbconsulting.approvalsystem.infra.exception.UserException;
import br.com.gmbconsulting.approvalsystem.domain.user.UserRepository;
import br.com.gmbconsulting.approvalsystem.domain.user.UserResponse;
import br.com.gmbconsulting.approvalsystem.domain.user.UserResquest;
import br.com.gmbconsulting.approvalsystem.utils.MessageDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private MessageDefinition messageDefinition;

    @Transactional
    public UserResponse create(UserResquest user){
        validadeUserRequest(user);
        var entity = repository.save(user.toEntity());
        return new UserResponse(entity);
    }

    private void validadeUserRequest(UserResquest user) {
        if(repository.existsById(user.getEmail())){
            throw new UserException(messageDefinition.getUserAlreadyRegistered());
        }
    }

    public UserResponse findByEmail(String email) {
        return repository.findByEmail(email).map(UserResponse::new).orElseThrow();

    }

    @Transactional
    public void deleteByEmail(String email) {
        repository.deleteById(email);
    }
}
