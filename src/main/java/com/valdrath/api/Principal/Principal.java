package com.valdrath.api.Principal;

import com.valdrath.api.Exception.ValdrathException;
import com.valdrath.api.Repository.PlayerRepository;
import com.valdrath.api.Service.CadastroPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal {

    private static Scanner l = new Scanner(System.in);

    @Autowired
    private CadastroPlayerService cadastro;

    private PlayerRepository playerRepository;

    public void rodandoJogo(){
        telaInicial();
        telaPrincipal();
    }

    public static void delay(int tempo){

        try{

            Thread.sleep(tempo);

        }catch(InterruptedException e){

            e.getMessage();

        }
    }

    public static void telaInicial(){
        pulaLinhas(40);
        delay(4000);
    }

    public static void mostrarLogo(){
        System.out.println("""
                ====================================================================
                ██╗   ██╗ █████╗ ██╗     ██████╗ ██████╗  █████╗ ████████╗██╗  ██╗
                ██║   ██║██╔══██╗██║     ██╔══██╗██╔══██╗██╔══██╗╚══██╔══╝██║  ██║
                ██║   ██║███████║██║     ██║  ██║██████╔╝███████║   ██║   ███████║
                ╚██╗ ██╔╝██╔══██║██║     ██║  ██║██╔══██╗██╔══██║   ██║   ██╔══██║
                 ╚████╔╝ ██║  ██║███████╗██████╔╝██║  ██║██║  ██║   ██║   ██║  ██║
                  ╚═══╝  ╚═╝  ╚═╝╚══════╝╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝   ╚═╝  ╚═╝   
                ====================================================================""");
    }



    public void telaPrincipal(){
        pulaLinhas(35);
        mostrarLogo();
        try {
            System.out.print("""
                    ====================================================================
                    - Escolha uma opção
                    
                    [ 1 ] Jogar 
                    [ 2 ] Configurações
                    [ 3 ] Sair 
                    
                    >>>""");

            int opPrincipal = l.nextInt();
            l.nextLine();

            while (!(opPrincipal == 1 || opPrincipal == 2 || opPrincipal == 3)) {

                System.out.print("Pow mano, digita a opção certa ae: ");
                opPrincipal = l.nextInt();
                l.nextLine();

            }

            if (opPrincipal == 1) {
                System.out.println("Entrou no 1. JOGAR");
                esperaENTER(l);
                cadastro.verificaCadastroLogin();

            } else if (opPrincipal == 2) {

                System.out.println("Entrou no 2. CONFIGURAÇÃO");

                delay(1000);

                System.out.println("EM MANUTENÇÃO");

                delay(2000);

                esperaENTER(l);

                telaPrincipal();

            } else if (opPrincipal == 3) {

                System.out.println("Entrou no 3. Sair");

                esperaENTER(l);

            }

        }catch(ValdrathException e){
            e.getMessage();
        }


    }

    public static void pulaLinhas(int linhas){
        for(int i = 0; i < linhas; i++){
            System.out.println("");
        }
    }

    public static void esperaENTER(Scanner l){
        System.out.println("\nAperte ENTER para continuar.");
        l.nextLine();
    }



}
