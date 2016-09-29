/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leitura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Leitura {

    public static void main(String[] args) {
        
        String vet[] = new String[100];
        
        int tamanho = leArquivo(vet);
        escreveArquivo(vet,tamanho);
        
    }
    
    static int leArquivo(String vet[]) {
        
        int tam = 0;
        
        Scanner ler = new Scanner(System.in);

        String nome = "";
        JFileChooser arquivo = new JFileChooser();
        int retorno = arquivo.showOpenDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION){
            nome = arquivo.getSelectedFile().getAbsolutePath();

        }
        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);
            System.out.println(nome);
            String linha = lerArq.readLine();
            while (linha != null) {
                
                vet[tam++] = linha;
                linha = lerArq.readLine();
                
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        return tam;
    }
    
    
    
    
    
    
    static void escreveArquivo(String[] vet, int tam) {

        String nome = "";
        JFileChooser arquivo = new JFileChooser();
        
        int retorno = arquivo.showSaveDialog(arquivo);
        if (retorno == JFileChooser.APPROVE_OPTION){
            nome = arquivo.getSelectedFile().getAbsolutePath();
        }
        try {
            
            
            // o parâmetro true/false da linha abaixo serve para definir
            // se você deseja acrescentar algo no final do arquivo (true) ou gerar
            // um novo arquivo com o que deseja gravar (false)
            FileWriter arq = new FileWriter(nome,false );
           
            BufferedWriter escArq = new BufferedWriter(arq);
            
            //String linha = "teste de escrita";
            
            // a linha abaixo "adiciona" o texto na string linha ao final do arquivo
            for(int i=0; i<tam; i++){
                System.out.println("Escrevendo: "+vet[i]);
                escArq.append(vet[i]);
                escArq.newLine();
            }
            //escArq.newLine();
            //escArq.append("bla bla bla");
            
            //escArq.write(linha+"\n\n"+linha+"testeteste");
	
            
            escArq.close();
                

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
    } 
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
