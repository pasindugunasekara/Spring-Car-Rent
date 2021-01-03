package lk.ijse.spring.controller;

import lk.ijse.spring.dto.Lose_damage_wDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.srevice.Lose_damage_wServices;
import lk.ijse.spring.srevice.UserServices;
import lk.ijse.spring.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/losedamage")
public class Lose_damage_wController {

    @Autowired
    Lose_damage_wServices lose_damage_wServices;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addLoseDamageW(@RequestBody Lose_damage_wDTO dto){
        lose_damage_wServices.SaveLoseDamageW(dto);
        StandardResponce responce = new StandardResponce(200, "Success", null);
        return new ResponseEntity(responce, HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"lose_damage_w_id"})
    public ResponseEntity deleteLoseDamage(@RequestParam String lose_damage_w_id){
        lose_damage_wServices.deleteLoseDamageW(lose_damage_w_id);
        return new ResponseEntity(new  StandardResponce(200,"Success",null), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateLoseDamage(@RequestBody Lose_damage_wDTO dto){
        lose_damage_wServices.updateLoseDamageW(dto);
        return new ResponseEntity(new StandardResponce(200,"Success",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{lose_damage_w_id}")
    public ResponseEntity searchLoseDamage(@PathVariable String lose_damage_w_id){
        Lose_damage_wDTO lose_damage_wDTO = lose_damage_wServices.searchLoseDamageW(lose_damage_w_id);
        return new ResponseEntity(new StandardResponce(200,"Success",lose_damage_wDTO) ,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllLoseDamage(){
        List<Lose_damage_wDTO> allLoseDamage = lose_damage_wServices.getAllLoseDamageW();
        return new ResponseEntity(new StandardResponce(200,"Success",allLoseDamage) ,HttpStatus.OK);
    }
}
