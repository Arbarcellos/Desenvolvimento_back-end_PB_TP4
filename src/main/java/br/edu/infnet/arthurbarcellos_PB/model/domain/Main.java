package br.edu.infnet.arthurbarcellos_PB.model.domain;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main{
	
	static Scanner leitura = new Scanner (System.in);
	static String caminhoArquivo = "clientes.csv";
	
	public static void main(String args[]) {
		
		gerenciador(obterEscolha(menu()));
		
	}
	
	public static int menu() {
		//método responsável pelo menu do programa
		System.out.println("\n---------------Lojas Amazones---------------");
		System.out.println(" [1] - Login");
		System.out.println(" [2] - Cadastrar conta");
		System.out.println("\n [0] - Sair");
		System.out.println("----------------------------------------\n");
		
		return 3;
	}
	public static int obterEscolha(int opcoes) {
		//método responsável pela obtenção da escolha do menu feita pelo usuário. Nele é feita uma validação se a escolha é uma opção válida e retorna o integer escolhido.
		//inicialização de variável integer
		int escolha;
		System.out.print(">>>> Digite o número o número da opção desejada: ");
		escolha = Integer.valueOf(leitura.nextLine());
		
		//validação da escolha inputada pelo usuário. Caso não seja uma opção válida, repete
		if(escolha >opcoes && escolha <0 ) {
			System.out.println("Opção inválida! Digite um número de 0 a "+ opcoes + ".");
			return obterEscolha(opcoes);

		}else {
			return escolha;
		}
	}
	public static void gerenciador(int escolha) {
		//método para direcionamento da escolha feita pelo usuário. Recebe como argumento uma integer que é direcionado pelo SWITCH, em caso de uma opção inválida, sinaliza o usuário.
		switch(escolha) {
			case 1: login(); break;
			case 2: cadastro(); break;
			case 0: System.out.println("Muito obrigado! Aplicação finalizada."); break;
			default:
				System.out.println("Opção inválida! Digite um número de 0 a 2.");
				gerenciador(obterEscolha(menu()));
		}
	}
	
	public static void login(){
		// coletar email e senha
		// abrir csv e buscar informação
		// validar
		// 		positivo: abrir tela de produtos
		// 		negativo: solicitar email e senha novamente ou cadastrar conta
		System.out.println("\n---------------LOGIN---------------");		
		
		System.out.print("Digite o seu e-mail: ");
		String email = leitura.nextLine();
		System.out.print("Digite sua senha: ");
		String senha = leitura.nextLine();		


		if(validaEmailSenhaLeitor(email, senha)){
			System.out.println("\nLogin realizado com sucesso!");
			produtos();
		} else {
			System.out.println("\nEmail ou senha inválidos! Digite novamente.");
			login();
		}
	}
		
	public static void produtos() {
		//método responsável pelo menu do programa
		System.out.println("\n---------------Produtos---------------");
		System.out.println(" !!Página em desenvolvimento!!");
		System.out.println("----------------------------------------\n");

	}
	public static void cadastro(){
		// solicitar nome e email
		// validar se email já existe
		// 		negativo: 	solicitar senha
		//					validar senha
		//					mensagem de cadastro concluído e ir para tela de produtos
		//		positivo:	informar que já existe.
		System.out.println("\n---------------Cadastrar Conta---------------");		
		
		String nome;
		
		do{
			System.out.print("Digite o seu nome completo: ");
			nome = leitura.nextLine();
		}while(nome == null);
		
		String email = solicitarEmail();
		
		if(!verificaLeitorEmail(email)){
			String senha = solicitarSenha();
			
			Cliente cliente = new Cliente();
		 	cliente.setNome(nome);
		 	cliente.setEmail(email);
		 	cliente.setSenha(senha);
		 	
		 	escritor(cliente);
		 	
			System.out.println("\nLogin realizado com sucesso!");
			produtos();
			
		}else{
			System.out.println("Conta de e-mail já existente. Realize seu login.");
			login();
		}
		
		}	
	public static String solicitarEmail(){
		String email = "asdf";
		do {
			
			System.out.print("Digite seu email: ");
        	email = leitura.nextLine();
        	
        	if(!validaEmailRegex(email)){
				System.out.println("Formato inválido de e-mail!");
			}
        	
       } while (!validaEmailRegex(email));
       return email;
	}	
	
	
	public static String solicitarSenha(){
		String senha = "asdf";
		do {
			System.out.print("Cadastre uma senha. Ela deve conter no mínimo 8 caracteres, pelo menos uma letra maiúscula, um número e um caractere especial (@, #, $, etc.): ");
        	senha = leitura.nextLine();
       } while (!validaSenha(senha));
       return senha;
	}
	
	public static boolean verificaLeitorEmail(String email) {	
		try {
			FileReader arquivo = new FileReader(caminhoArquivo);
			BufferedReader leitura = new BufferedReader(arquivo);
	
			String linha;	
			
			while((linha = leitura.readLine()) != null) {
				if (linha.contains(email)){	
					leitura.close();		
					return true;
				};
			}
			leitura.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFound" + e.getMessage());
	
		} catch (IOException e) {
			System.out.println("IO" + e.getMessage());
		}
		return false;	
	}
	public static boolean validaEmailSenhaLeitor(String email, String senha) {	
		try {
			FileReader arquivo = new FileReader(caminhoArquivo);
			BufferedReader leitura = new BufferedReader(arquivo);
	
			String linha;	
			
			while((linha = leitura.readLine()) != null) {
				if (linha.contains(email) & linha.contains(senha)){	
					leitura.close();		
					return true;
				};
			}
			leitura.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFound" + e.getMessage());
	
		} catch (IOException e) {
			System.out.println("IO" + e.getMessage());
		}
		return false;	
	}
	
	public static void escritor(Cliente cliente) {
		try {
			String nome = cliente.getNome();
			String email = cliente.getEmail();
			String senha = cliente.getSenha();
			
			FileWriter writer = new FileWriter(caminhoArquivo, true);
			writer.write(nome + ";" + email + ";" + senha + "\n");
			writer.close();
	        System.out.println("\nCliente "+ nome + " cadastrado com sucesso " + caminhoArquivo);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFound" + e.getMessage());
	
		} catch (IOException e) {
			System.out.println("IO" + e.getMessage());
		}		
	}
	public static boolean validaEmailRegex(String email) {
		String regex = "(^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$)";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		return matcher.matches();
	}
	
	public static boolean validaSenha(String senha) {
		String [] caracteresEspeciais = {"@", "%", "#", "!", "\\", "&", "*", "(", ")", "-", "+", "=", "[", "]", "{", "}", ";", ":", ",", ".", "<", ">", "/", "?", "|", "$", "~", "`", "'", "\""};
		
		boolean senhaValida = true;
        boolean temMaiuscula = false;
        boolean temNumero = false;
        boolean temCaractereEspecial = false;

        if (senha.length() < 8) {
            System.out.println("Erro: A senha deve ter no mínimo 8 caracteres.");
            senhaValida = false;
        }

        for (char c : senha.toCharArray()) {
            if (Character.isUpperCase(c)) {
                temMaiuscula = true;
            }

            if (Character.isDigit(c)) {
                temNumero = true;
            }

            for (String especial : caracteresEspeciais) {
                if (String.valueOf(c).equals(especial)) {
                    temCaractereEspecial = true;
                    break; 
                }
            }
        }

        if (!temMaiuscula) {
            System.out.println("Erro: A senha deve conter pelo menos uma letra maiúscula.");
            senhaValida = false;
        }
        if (!temNumero) {
            System.out.println("Erro: A senha deve conter pelo menos um número.");
            senhaValida = false;
        }
        if (!temCaractereEspecial) {
            System.out.println("Erro: A senha deve conter pelo menos um caractere especial (@, #, $, etc.).");
            senhaValida = false;
        }
				
		return senhaValida ;
	}
	
	
}