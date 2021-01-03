package lk.ijse.spring.controller;

import lk.ijse.spring.dto.RentDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.srevice.RentServices;
import lk.ijse.spring.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/rent")
public class RentController {

    @Autowired
    RentServices rentServices;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addRent(@RequestBody RentDTO dto){
        rentServices.SaveRent(dto);
        StandardResponce responce = new StandardResponce(200, "Success", null);
        return new ResponseEntity(responce, HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"rent_id"})
    public ResponseEntity deleteRent(@RequestParam String rent_id){
        rentServices.deleteRent(rent_id);
        return new ResponseEntity(new  StandardResponce(200,"Success",null), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateRent(@RequestBody RentDTO dto){
        rentServices.updateRent(dto);
        return new ResponseEntity(new StandardResponce(200,"Success",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{rent_id}")
    public ResponseEntity searchRent(@PathVariable String rent_id ){
        RentDTO rentDTO = rentServices.searchRent(rent_id);
        return new ResponseEntity(new StandardResponce(200,"Success",rentDTO) ,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllRent(){
        List<RentDTO> allRent = rentServices.getAllRent();
        return new ResponseEntity(new StandardResponce(200,"Success",allRent) ,HttpStatus.OK);
    }
}
