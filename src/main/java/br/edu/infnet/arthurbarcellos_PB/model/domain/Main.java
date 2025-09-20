package br.edu.infnet.arthurbarcellos_PB.model.domain;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.infnet.arthurbarcellos_PB.model.dto.UsuarioDTO;
import br.edu.infnet.arthurbarcellos_PB.model.service.UsuarioService;

@Component
public class Main {
    static Scanner leitura = new Scanner(System.in);
    static String caminhoArquivo = "clientes.csv";

    @Autowired
    private UsuarioService usuarioService;

    public void runMainLogic() {
        gerenciador(obterEscolha(menu()));
    }

    public int menu() {
        System.out.println("\n---------------Lojas Amazones---------------");
        System.out.println(" [1] - Login");
        System.out.println(" [2] - Cadastrar conta");
        System.out.println("\n [0] - Sair");
        System.out.println("----------------------------------------\n");
        return 3;
    }

    public int obterEscolha(int opcoes) {
        int escolha;
        System.out.print(">>>> Digite o número da opção desejada: ");
        escolha = Integer.parseInt(leitura.nextLine());
        if(escolha > opcoes || escolha < 0 ) {
            System.out.println("Opção inválida! Digite um número de 0 a " + opcoes + ".");
            return obterEscolha(opcoes);
        }
        return escolha;
    }

    public void gerenciador(int escolha) {
        switch(escolha) {
            case 1: login(); break;
            case 2: cadastro(); break;
            case 0: System.out.println("Muito obrigado! Aplicação finalizada."); break;
            default:
                System.out.println("Opção inválida! Digite um número de 0 a 2.");
                gerenciador(obterEscolha(menu()));
        }
    }

    public void login(){
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

    public void produtos() {
        System.out.println("\n---------------Produtos---------------");
        System.out.println(" !!Página em desenvolvimento!!");
        System.out.println("----------------------------------------\n");
    }

    public void cadastro(){
        System.out.println("\n---------------Cadastrar Conta---------------");

        String nome;
        do{
            System.out.print("Digite o seu nome completo: ");
            nome = leitura.nextLine();
        }while(nome == null);

        String email = solicitarEmail();

        if(!verificaLeitorEmail(email)){
            String senha = solicitarSenha();

            UsuarioDTO cliente = new UsuarioDTO();
         	cliente.setNome(nome);
         	cliente.setEmail(email);
         	cliente.setSenha(senha);

         	escritor(cliente);

            usuarioService.salvar(cliente);

            System.out.println("\nLogin realizado com sucesso!");
            produtos();

        }else{
            System.out.println("Conta de e-mail já existente. Realize seu login.");
            login();
        }
    }

    public String solicitarEmail(){
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

    public String solicitarSenha(){
        String senha = "asdf";
        do {
            System.out.print("Cadastre uma senha. Ela deve conter no mínimo 8 caracteres, pelo menos uma letra maiúscula, um número e um caractere especial (@, #, $, etc.): ");
        	senha = leitura.nextLine();
       } while (!validaSenha(senha));
       return senha;
    }

    public boolean verificaLeitorEmail(String email) {
		try {
			FileReader arquivo = new FileReader(caminhoArquivo);
			BufferedReader leitura = new BufferedReader(arquivo);

			String linha;
			
			while((linha = leitura.readLine()) != null) {
				if (linha.contains(email)){	
					leitura.close();		
					return true;
				}
			}
			leitura.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFound" + e.getMessage());

		} catch (IOException e) {
			System.out.println("IO" + e.getMessage());
		}
		return false;	
	}

    public boolean validaEmailSenhaLeitor(String email, String senha) {
		try {
			FileReader arquivo = new FileReader(caminhoArquivo);
			BufferedReader leitura = new BufferedReader(arquivo);

			String linha;
			
			while((linha = leitura.readLine()) != null) {
				if (linha.contains(email) & linha.contains(senha)){	
					leitura.close();		
					return true;
				}
			}
			leitura.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFound" + e.getMessage());

		} catch (IOException e) {
			System.out.println("IO" + e.getMessage());
		}
		return false;	
	}

    public void escritor(UsuarioDTO cliente) {
		try {
			String nome = cliente.getNome();
			String email = cliente.getEmail();
			String senha = cliente.getSenha();
			
			FileWriter writer = new FileWriter(caminhoArquivo, true);
			writer.write(nome + ";" + email + ";" + senha + "\n");
			writer.close();

            usuarioService.salvar(cliente);

	        System.out.println("\nCliente "+ nome + " cadastrado com sucesso " + caminhoArquivo);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFound" + e.getMessage());

		} catch (IOException e) {
			System.out.println("IO" + e.getMessage());
		}		
	}

    public boolean validaEmailRegex(String email) {
		String regex = "(^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$)";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		return matcher.matches();
	}

    public boolean validaSenha(String senha) {
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

