package sut.sa.g09.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table( name = "Payee")

public class Payee {
    @Id
    @SequenceGenerator(name="payee_seq",sequenceName="payee_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="payee_seq")
    private  @NonNull Long payeeID;
    private  @NonNull String namePayee;
    @OneToMany(mappedBy = "payee")
    @JsonIgnore
        private List<Payments> paymentsList;




}
