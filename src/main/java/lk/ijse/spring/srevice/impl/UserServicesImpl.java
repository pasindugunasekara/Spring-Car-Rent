package lk.ijse.spring.srevice.impl;

import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.UserRepo;
import lk.ijse.spring.srevice.UserServices;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServicesImpl implements UserServices {

    @Autowired
    UserRepo repo;

    @Autowired
    ModelMapper mapper;


    @Override
    public void SaveUser(UserDTO dto) {
        if (!repo.existsById(dto.getUser_id())){
            User u = mapper.map(dto, User.class);
            repo.save(u);
        }else {
            throw new RuntimeException("User Allready exist");
        }
    }

    @Override
    public void updateUser(UserDTO dto) {

        if (repo.existsById(dto.getUser_id())) {
            User u = mapper.map(dto, User.class);
            repo.save(u);
        }else {
            throw new RuntimeException("No Such a User for update");
        }

    }

    @Override
    public UserDTO serchUser(String user_id) {
        Optional<User> user = repo.findById(user_id);
        if (user.isPresent()){
            return mapper.map(user.get(),UserDTO.class);
        }else {
            throw new  RuntimeException("No User For "+user_id);
        }
    }

    @Override
    public void deleteUser(String user_id) {
        if (repo.existsById(user_id)){
            repo.deleteById(user_id);
    }else {
            throw new  RuntimeException("No User For Delete UserID: "+user_id);
        }
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> all = repo.findAll();
        return mapper.map(all,new TypeToken<List<UserDTO>>(){}.getType());
    }
}
