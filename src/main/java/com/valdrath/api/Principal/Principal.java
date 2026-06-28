package com.valdrath.api.Principal;

import com.valdrath.api.Repository.PlayerRepository;
import com.valdrath.api.Service.CadastroPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal {

    private Scanner l = new Scanner(System.in);

    @Autowired
    private CadastroPlayerService cadastro;

    private PlayerRepository playerRepository;

    public void rodandoJogo(){
        cadastro.CadastroPlayer();


    }

}
