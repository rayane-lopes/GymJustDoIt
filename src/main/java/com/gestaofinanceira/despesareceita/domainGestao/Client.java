package com.gestaofinanceira.despesareceita.domainGestao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client;

    @Column(name = "full_name_client")
    private String fullName_client;

    @Column(name = "email_user", length = 50, nullable = false)
    private String email;

}

