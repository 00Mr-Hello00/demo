package sut.sa.g09.Entity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table( name = "Payments")
public class Payments {
    @Id
    @SequenceGenerator(name="payments_seq",sequenceName="payments_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="payments_seq")
    private  @NonNull Long paymentsDI;

    private  @NonNull String namePay;
    private  @NonNull Float price;
    private  @NonNull Date datePayments;



    @ManyToOne(fetch = FetchType.EAGER)
        private  Payee payee;
    @ManyToOne(fetch = FetchType.EAGER)
        private  CreditCard credit;
    @ManyToOne(fetch = FetchType.EAGER)
        private  PaymentsType paymentsType;
    @ManyToOne(fetch = FetchType.EAGER)
        private  Record record;


}



