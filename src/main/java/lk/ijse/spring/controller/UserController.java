package lk.ijse.spring.controller;

import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.srevice.UserServices;
import lk.ijse.spring.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addUser(@RequestBody UserDTO dto){
        userServices.SaveUser(dto);
        StandardResponce responce = new StandardResponce(200, "Success", null);
        return new ResponseEntity(responce, HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"user_id"})
    public ResponseEntity deleteUser(@RequestParam String user_id){
        userServices.deleteUser(user_id);
        return new ResponseEntity(new  StandardResponce(200,"Success",null), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody UserDTO dto){
        userServices.updateUser(dto);
        return new ResponseEntity(new StandardResponce(200,"Success",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{user_id}")
    public ResponseEntity searchUser(@PathVariable String user_id){
        UserDTO userDTO = userServices.serchUser(user_id);
        return new ResponseEntity(new StandardResponce(200,"Success",userDTO) ,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllUser(){
        List<UserDTO> allUser = userServices.getAllUser();
        return new ResponseEntity(new StandardResponce(200,"Success",allUser) ,HttpStatus.OK);
    }
}
