package sut.sa.g09.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table( name = "CreditCard")

public class CreditCard {
    @Id
    @SequenceGenerator(name="credit_seq",sequenceName="credit_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="credit_seq")
    private  @NonNull Long creditID;


    private  @NonNull String creditNumber;
    private  @NonNull int csc;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private @NonNull Date expiredDate;


    @ManyToOne(fetch = FetchType.EAGER)
        private CreditType creditType;

    @OneToMany(mappedBy = "credit")
    @JsonIgnore
        private List<Payments> paymentsList;

}
