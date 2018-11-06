package sut.sa.g09.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.sa.g09.Entity.Record;
import sut.sa.g09.Repository.RecordRopository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RecordController {
    @Autowired
    private final RecordRopository recordRopository;
    public RecordController(RecordRopository recordRopository) {
        this.recordRopository = recordRopository;
    }


    @GetMapping("/Record")
    public Collection<Record> Record() {

        return recordRopository.findAll().stream().collect(Collectors.toList());
    }


    @GetMapping("/Record/getdata/{reId}")
    public Optional<Record> Record(@PathVariable Long reId) {
        Optional<Record> V = recordRopository.findById(reId);
        return V;
    }


    @PutMapping(path = "/record/{id}")
    private Record newRecord(@RequestBody Record newRecord, @PathVariable Long reid) {
        return this.recordRopository.findById(reid).map(record -> {
            record.setDisease(newRecord.getDisease());
            record.setHealthcheckerinfo(newRecord.getHealthcheckerinfo());
            record.setProgram(newRecord.getProgram());
            record.setPayment(newRecord.getPayment());
            return this.recordRopository.save(record);
        }).orElseGet(() ->{
            newRecord.setReId(reid);
            return recordRopository.save(newRecord);
        });
    }
    @PostMapping(path = "/record")
    private Record newrecord(@RequestBody Record newRecord){
        return recordRopository.save(newRecord);
    }
}
