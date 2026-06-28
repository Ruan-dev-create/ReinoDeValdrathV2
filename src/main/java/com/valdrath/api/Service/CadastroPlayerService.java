package com.valdrath.api.Service;

import com.valdrath.api.Model.Player;
import com.valdrath.api.Repository.PlayerRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CadastroPlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    private Scanner l = new Scanner(System.in);

    public void CadastroPlayer(){

        Player playerLogado = new Player();

        System.out.println("< =============== Cadastro Player ==============>");

        System.out.print("Digite o nome do jogador: ");
        String nome = l.nextLine();
        playerLogado.setNome(nome);

        System.out.print("Digite sua idade: ");
        int idade = Integer.parseInt(l.nextLine());
        playerLogado.setIdade(idade);

        System.out.println("Digite o email da sua conta: ");
        String email = l.nextLine();
        playerLogado.setEmail(email);

        System.out.println("Digite a senha: ");
        String senha = l.nextLine();
        playerLogado.setSenha_conta(senha);

        playerRepository.save(playerLogado);
    }

    public void LogarPlayer(){

    }
}
