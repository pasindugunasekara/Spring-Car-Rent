package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class Payment {
    @Id
    private String payment_id;
    private String method_type;
    private String payment_date;
    private String amount;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "rent_id", referencedColumnName = "rent_id",nullable = false)
    private Rent rent;

    public Payment(String payment_id, String method_type,
                   String payment_date, String amount, Rent one) {
        this.payment_id=payment_id;
        this.method_type=method_type;
        this.payment_date=payment_date;
        this.amount=amount;
        this.rent=one;
    }
}
