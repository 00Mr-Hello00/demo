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
@Table(name = "Record")
public class Record {
    @Id
    @SequenceGenerator(name="r_seq",sequenceName="r_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="r_seq")
    private @NonNull Long reId;
    private @NonNull String healthcheckerinfo;
    private @NonNull String program;
    private @NonNull int payment;
    private @NonNull String Disease;


    @OneToMany(mappedBy = "record")
    @JsonIgnore
    private List<Payments> paymentsList;

}