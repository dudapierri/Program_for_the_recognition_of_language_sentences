/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenerico;

import java.util.ArrayList;

public class AlgoritmoGenerico {
    int[] estadosFinais;
    int[][] tabelaTransicaoAF;
    // armazena as palavras de saída
    ArrayList<String> saidas;
    // armazena os tipos das palavras de saída
    ArrayList<Integer> saidasTipo;
    
    public AlgoritmoGenerico(int[] estadosFinais, int[][] tabelaTransicaoAF) //construtor
    {
    	this.saidas = new ArrayList<String>();
        this.saidasTipo = new ArrayList<Integer>();
        this.estadosFinais = estadosFinais;
        this.tabelaTransicaoAF = tabelaTransicaoAF;
    }
    
    public String reconhecer(String expressaoString)
    {
    	String operadores = "+-*/";
    	String alfabeto = "abcde";
    	
    	String expressao = expressaoString.concat("$");
        int estado = 0; // ESTADO INICIAL
        
        int inicio = 0;
        int i = -1;
        
        while (i < expressaoString.length()){
            i++;
            char simbolo = expressao.charAt(i); // ler a letra da posição i 
            // se chegou ao final de tudo
            if (simbolo == '$') {
            	String palavra = expressao.substring(inicio, i).trim(); //pega a expressão (palavra toda) e tira os espaços 
            	if (palavra.length() > 0 && palavra != "$") { //se não for tudo vazio e nem final '$'
            		saidas.add(palavra); // armazena cada uma das palavras 
                	Boolean reconhecida = this.estadosFinais[estado] == 1; // verifica se o estado que ele está é igual a 1 (palavra foi reconhecida)
                	if (reconhecida)
                		saidasTipo.add(0);
                	else
                		saidasTipo.add(1);
                	break;
            	}
            }
            // se o símbolo é um espaço ou quebra de linha
            else if (simbolo == ' ' || simbolo == '\n') {
            	String palavra = expressao.substring(inicio, i).trim();
            	if (palavra.length() > 0) {
            		saidas.add(palavra);
                	Boolean reconhecida = this.estadosFinais[estado] == 1;
                	if (reconhecida)
                		saidasTipo.add(0);
                	else
                		saidasTipo.add(1);
                	
                	inicio = i+1; //define o inicio da próxima palavra
                	estado = 0; // reseta estado
            	}
            }
            // se o símbolo é um operador aritmetico
            else if (operadores.contains(String.valueOf(simbolo)))
            {
            	String palavra = expressao.substring(inicio, i).trim();
            	if (palavra.length() > 0) {
            		saidas.add(palavra);
                	Boolean reconhecida = this.estadosFinais[estado] == 1;
                	if (reconhecida)
                		saidasTipo.add(0);
                	else
                		saidasTipo.add(1);
            	}
            	saidas.add(String.valueOf(simbolo));
            	saidasTipo.add(2);
            	
            	inicio = i+1;
            	estado = 0;
            // se o símbolo não faz parte do alfabeto
            } else if (!alfabeto.contains(String.valueOf(simbolo))) {
            	while (simbolo != ' ' && simbolo != '\n' && simbolo != '$' && !operadores.contains(String.valueOf(simbolo))) {
            		i++;
            		simbolo = expressao.charAt(i);
            	}
            	String palavra = expressao.substring(inicio, i).trim();
            	saidas.add(palavra);
            	saidasTipo.add(3);
            	
            	i--;
            	inicio = i+1;
            	estado = 0;
            } else {
            	estado = this.tabelaTransicaoAF[estado][this.obterIndiceSimbolo(simbolo)];
            }
            
        }
        
        // itera as palavras de saída e coloca no formato de visualização
        String saida = "";
        for (int j = 0; j < saidas.size(); j++) {
        	String tipo = "";
        	Integer saidaTipo = saidasTipo.get(j);
        	switch (saidaTipo) {
        		case 0: tipo = "RECONHECIDA"; break;
        		case 1: tipo = "NÃO RECONHECIDA"; break;
        		case 2: tipo = "OPERADOR ARITMETICO"; break;
        		case 3: tipo = "SÍMBOLO(S) INVÁLIDO(S)"; break;
        	};
        	saida = saida.concat(tipo + ": " + saidas.get(j) + "\n");
        }
        return saida;
    }
    
    private static int obterIndiceSimbolo(char simbolo){
        switch (simbolo){
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
            	return 4;
            default:
                return 5;
        }

    }

    

}
