package sut.sa.g09.Repository;

import sut.sa.g09.Entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface RecordRopository extends JpaRepository<Record, Long> {


    Record findByReId(long reId);
}
