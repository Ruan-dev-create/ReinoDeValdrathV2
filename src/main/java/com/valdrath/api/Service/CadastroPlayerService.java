package com.valdrath.api.Service;

import com.valdrath.api.Cutscene.CutsceneView;
import com.valdrath.api.Model.Player;
import com.valdrath.api.Repository.PlayerRepository;
import com.valdrath.api.Exception.ValdrathException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CadastroPlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private CadastroPersonagemService cadastroPersonagem;

    private Scanner l = new Scanner(System.in);

    @Autowired
    private CutsceneView cutscineInicial;

    public void verificaCadastroLogin(){
        System.out.print("""
                \n
                =====================================================================
                - Você já esteve aqui antes?
                [ sim ] Login
                [ não ] Cadastro
                >>>>>
                """);

        String opcao = l.nextLine().trim().toLowerCase();

        while(!opcao.equals("sim") && !opcao.equals("nao") && !opcao.equals("não")){
            System.out.print("Digite a opção corretamente: ");
            opcao = l.nextLine().trim().toLowerCase();
        }

        try{

            if(opcao.equals("sim")){
                LogarPlayer();
                cutscineInicial.iniciarCutsceneAbertura(l);
            }else{
                CadastroPlayer();
                cutscineInicial.iniciarCutsceneAbertura(l);
            }
        }catch(ValdrathException e){
            e.getMessage();
        }

    }

    public void CadastroPlayer(){

        try {
            Player playerLogado = new Player();

            System.out.println("<< =============== Cadastro Player =============== >>");

            System.out.print("Digite o nome do jogador: ");
            String nome = l.nextLine().trim();
            playerLogado.setNome(nome);

            System.out.print("Digite sua idade: ");
            int idade = Integer.parseInt(l.nextLine().trim());
            playerLogado.setIdade(idade);

            System.out.println("Digite o email da sua conta: ");
            String email = l.nextLine().trim();
            playerLogado.setEmail(email);

            System.out.println("Digite a senha: ");
            String senha = l.nextLine().trim();
            playerLogado.setSenha_conta(senha);

            playerRepository.save(playerLogado);

            cadastroPersonagem.cadastroPersonagem(playerLogado);

        }catch (ValdrathException e) {
            e.getMessage();
        }
    }

    public void LogarPlayer(){

        try {
            System.out.println("<< =============== Logando Player =============== >>");

            System.out.print("Digite o email da sua conta: ");
            String email = l.nextLine().trim();

            System.out.println("Digite a senha: ");
            String senha = l.nextLine().trim();

            Optional<Player> player = playerRepository.findByEmail(email);

            if (player.isEmpty()) {
                System.out.println("Email/Senha incorretos. ");
                return;
            }

            if (!player.get().getSenha_conta().equals(senha)) {
                System.out.println("Senha incorreta.");
                return;
            }

            System.out.println("Login realizado com sucesso!");
        }catch (ValdrathException e){
            e.getMessage();
        }

    }
}
