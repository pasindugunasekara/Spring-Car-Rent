package lk.ijse.spring.controller;

import lk.ijse.spring.dto.RentDTO;
import lk.ijse.spring.dto.SheduleDTO;
import lk.ijse.spring.srevice.SheduleServices;
import lk.ijse.spring.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/shedule")
public class SheduleController {

    @Autowired
    SheduleServices sheduleServices;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addShedule(@RequestBody SheduleDTO dto){
        sheduleServices.SaveShedule(dto);
        StandardResponce responce = new StandardResponce(200, "Success", null);
        return new ResponseEntity(responce, HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"shedule_id"})
    public ResponseEntity deleteShedule(@RequestParam String shedule_id){
        sheduleServices.deleteShedule(shedule_id);
        return new ResponseEntity(new  StandardResponce(200,"Success",null), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateShedule(@RequestBody SheduleDTO dto){
        sheduleServices.updateShedule(dto);
        return new ResponseEntity(new StandardResponce(200,"Success",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{shedule_id}")
    public ResponseEntity searchshedule(@PathVariable String shedule_id ){
        SheduleDTO sheduleDTO = sheduleServices.searchShedule(shedule_id);
        return new ResponseEntity(new StandardResponce(200,"Success",sheduleDTO) ,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllShedule(){
        List<SheduleDTO> allShedule = sheduleServices.getAllShedule();
        return new ResponseEntity(new StandardResponce(200,"Success",allShedule) ,HttpStatus.OK);
    }
}
