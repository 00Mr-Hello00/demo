package sut.sa.g09.Controller;
import sut.sa.g09.Entity.Payee;
import sut.sa.g09.Repository.PayeeRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.stream.Collectors;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
class PayeeController {
    @Autowired
    private final PayeeRepository payeeRepository;

    public PayeeController(PayeeRepository payeeRepository) {
        this.payeeRepository = payeeRepository;
    }

    @GetMapping("/Payee")
    public Collection<Payee> Payee() {
        return payeeRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @PostMapping("/Payee/{payeeName}")
    //@RequestMapping(path="Regit", method=RequestMethod.POST,  consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Payee newnamePayee(@PathVariable String payeeName) {
        Payee newnamePayee = new Payee();
        newnamePayee.setNamePayee(payeeName);
        return payeeRepository.save(newnamePayee); // บันทึก Objcet ชื่อ newnamePayee

    }



    @PostMapping("/Payee")
    public void newPayee (@RequestBody String nameP)
            throws JsonParseException, IOException {

        final String decoded = URLDecoder.decode(nameP, "UTF-8");        // DECODE UTF8
        nameP = decoded;                  // .substring(0, decoded.length() - 1); // Remove last Char at String

        Payee newPayee = new Payee();

        if (nameP.charAt(0) == '{') { // Check Json

            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(nameP);

            JsonNode jsonNode = actualObj.get("userName");
            newPayee.setNamePayee(jsonNode.textValue());
            payeeRepository.save(newPayee);    // บันทึก Objcet ชื่อ video
        }
    }
}