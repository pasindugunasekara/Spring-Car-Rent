package lk.ijse.spring.controller;

import lk.ijse.spring.dto.PaymentDTO;
import lk.ijse.spring.dto.RentDTO;
import lk.ijse.spring.srevice.PaymentServices;
import lk.ijse.spring.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/payment")
public class PaymentController {

    @Autowired
    PaymentServices paymentServices;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addPayment(@RequestBody PaymentDTO dto){
        paymentServices.SavePayment(dto);
        StandardResponce responce = new StandardResponce(200, "Success", null);
        return new ResponseEntity(responce, HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"payment_id"})
    public ResponseEntity deletePayment(@RequestParam String payment_id){
        paymentServices.deletePaymnet(payment_id);
        return new ResponseEntity(new  StandardResponce(200,"Success",null), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updatePayment(@RequestBody PaymentDTO dto){
        paymentServices.updatePayment(dto);
        return new ResponseEntity(new StandardResponce(200,"Success",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{payment_id}")
    public ResponseEntity searchPayment(@PathVariable String payment_id ){
        PaymentDTO paymentDTO = paymentServices.searchPayment(payment_id);
        return new ResponseEntity(new StandardResponce(200,"Success",paymentDTO) ,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllPayment(){
        List<PaymentDTO> allPayment = paymentServices.getAllPayment();
        return new ResponseEntity(new StandardResponce(200,"Success",allPayment) ,HttpStatus.OK);
    }
}
