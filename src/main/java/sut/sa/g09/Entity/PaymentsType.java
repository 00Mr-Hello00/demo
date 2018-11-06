package sut.sa.g09.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table( name = "PaymentsType")
public class PaymentsType{
    @Id
    @SequenceGenerator(name="pmt_seq",sequenceName="pmt_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pmt_seq")

    private  @NonNull Long paymentsTypeDI;
    private  @NonNull String typeName;

    @OneToMany(mappedBy = "payee")
    @JsonIgnore
    private List<Payments> paymentsList;

}