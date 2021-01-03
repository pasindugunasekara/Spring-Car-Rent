package lk.ijse.spring.srevice;

import lk.ijse.spring.dto.PaymentDTO;
import lk.ijse.spring.dto.RentDTO;

import java.util.List;

public interface PaymentServices {

    void SavePayment(PaymentDTO dto);
    void updatePayment(PaymentDTO dto);
    PaymentDTO searchPayment(String payment_id);
    void deletePaymnet(String payment_id);
    List<PaymentDTO> getAllPayment();
}
