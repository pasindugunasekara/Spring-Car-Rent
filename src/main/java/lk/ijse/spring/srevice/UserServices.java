package lk.ijse.spring.srevice;

import lk.ijse.spring.dto.UserDTO;


import java.util.List;

public interface UserServices {

    void SaveUser(UserDTO dto);
    void updateUser(UserDTO dto);
    UserDTO serchUser(String user_id);
    void deleteUser(String user_id);
    List<UserDTO> getAllUser();
}
