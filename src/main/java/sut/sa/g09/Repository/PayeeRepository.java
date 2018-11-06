package sut.sa.g09.Repository;
import sut.sa.g09.Entity.Payee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface PayeeRepository extends JpaRepository< Payee, Long> {
    Payee findByPayeeID(Long payeeName);
}