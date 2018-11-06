package sut.sa.g09.Repository;

import sut.sa.g09.Entity.Payments;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface PaymentsRepository extends JpaRepository<Payments, Long> {
}