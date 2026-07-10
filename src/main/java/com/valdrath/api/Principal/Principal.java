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
        telaInicial();
        cadastro.verificaCadastroLogin();


    }

    public static void delay(int tempo){

        try{

            Thread.sleep(tempo);

        }catch(InterruptedException e){

            e.getMessage();

        }
    }

    public static void pulaLinhas(int linhas){
        for(int i = 0; i < linhas; i++){
            System.out.println("");
        }
    }

    public static void telaInicial(){

        pulaLinhas(40);
        delay(7000);

        System.out.println("""
                ====================================================================
                ██╗   ██╗ █████╗ ██╗     ██████╗ ██████╗  █████╗ ████████╗██╗  ██╗
                ██║   ██║██╔══██╗██║     ██╔══██╗██╔══██╗██╔══██╗╚══██╔══╝██║  ██║
                ██║   ██║███████║██║     ██║  ██║██████╔╝███████║   ██║   ███████║
                ╚██╗ ██╔╝██╔══██║██║     ██║  ██║██╔══██╗██╔══██║   ██║   ██╔══██║
                 ╚████╔╝ ██║  ██║███████╗██████╔╝██║  ██║██║  ██║   ██║   ██║  ██║
                  ╚═══╝  ╚═╝  ╚═╝╚══════╝╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝   ╚═╝  ╚═╝   
                ====================================================================
                
                """);

        delay(7000);



    }

}
