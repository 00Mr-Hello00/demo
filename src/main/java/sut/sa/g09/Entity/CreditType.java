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
@Table( name = "CreditType")
public class CreditType{
    @Id
    @SequenceGenerator(name="type_seq",sequenceName="type_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="type_seq")
    private  @NonNull Long creditTypeDI;
    private  @NonNull String typeName;
    @OneToMany(mappedBy = "creditType")
    @JsonIgnore
    private List<CreditCard> creditCardList;


}