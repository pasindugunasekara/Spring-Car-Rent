package lk.ijse.spring.srevice.impl;

import lk.ijse.spring.dto.PaymentDTO;
import lk.ijse.spring.dto.RentDTO;
import lk.ijse.spring.entity.Payment;
import lk.ijse.spring.entity.Rent;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.PaymentRepo;
import lk.ijse.spring.repo.RentRepo;
import lk.ijse.spring.srevice.PaymentServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentServicesImpl implements PaymentServices {

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    RentRepo rentRepo;

    @Override
    public void SavePayment(PaymentDTO dto) {

        if (!paymentRepo.existsById(dto.getPayment_id())){

            updateAndSave(dto,dto.getRent_id());
//                Rent u = mapper.map(dto, Rent.class);
//                rentRepo.save(u);
        }else {
            throw new RuntimeException("Payment  Allready exist");
        }
    }

    @Override
    public void updatePayment(PaymentDTO dto) {
        if (paymentRepo.existsById(dto.getPayment_id())) {

            updateAndSave(dto,dto.getRent_id());

//                Rent r = mapper.map(dto, Rent.class);
//            rentRepo.save(r);
        }else {
            throw new RuntimeException("No Such a Payment for update");
        }
    }

    @Override
    public PaymentDTO searchPayment(String payment_id) {
        Optional<Payment> payment = paymentRepo.findById(payment_id);
        if (payment.isPresent()){
            return mapper.map(payment.get(), PaymentDTO.class);
        }else {
            throw new  RuntimeException("No payment For "+payment_id);
        }
    }

    @Override
    public void deletePaymnet(String payment_id) {
        if (paymentRepo.existsById(payment_id)){
            paymentRepo.deleteById(payment_id);
        }else {
            throw new  RuntimeException("No payment For Delete PaymentID: "+payment_id);
        }
    }

    @Override
    public List<PaymentDTO> getAllPayment() {
        List<Payment> all = paymentRepo.findAll();
//        return mapper.map(all,new TypeToken<List<RentDTO>>(){}.getType());

        List<PaymentDTO> list = new ArrayList<>();
        for (Payment ss: all){
            list.add(new PaymentDTO(ss.getPayment_id(),
                    ss.getAmount(),
                    ss.getPayment_date(),
                    ss.getMethod_type(),
                    ss.getRent().getRent_id()));
        }
        return list;
    }

    private void updateAndSave(PaymentDTO dto, String payment_id ) {
        if (rentRepo.existsById(dto.getRent_id())) {
            Rent one = rentRepo.getOne(dto.getRent_id());
            Payment payment = new Payment(dto.getPayment_id(),
                    dto.getMethod_type(),
                    dto.getPayment_date(),
                    dto.getAmount(),
                    one);

            paymentRepo.save(payment);
        } else {
            throw new RuntimeException("This payment ID isn't Exist !");

        }

    }
}
