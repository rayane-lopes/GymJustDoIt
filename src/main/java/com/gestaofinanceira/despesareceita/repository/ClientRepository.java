package com.gestaofinanceira.despesareceita.repository;

import com.gestaofinanceira.despesareceita.domainGestao.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
