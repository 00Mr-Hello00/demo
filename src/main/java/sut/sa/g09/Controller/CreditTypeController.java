package sut.sa.g09.Controller;
import sut.sa.g09.Entity.CreditType;
import sut.sa.g09.Repository.CreditTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CreditTypeController {

    @Autowired
    private final CreditTypeRepository creditTypeRepository;
    public CreditTypeController(CreditTypeRepository creditTypeRepository) {
        this.creditTypeRepository = creditTypeRepository;
    }
    @GetMapping("/CreditType")
    public Collection<CreditType> CreditType() {

        return creditTypeRepository.findAll().stream().collect(Collectors.toList());
    }
}
