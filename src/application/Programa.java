package application;

import java.util.Date;
import java.util.Scanner;
import entities.Aluno;
import jdbc.AlunoJDBC;

public class Programa {

	public static void main(String[] args) {
		
        try {
        	
            int opcao = 0;
            Scanner console = new Scanner(System.in);
            
            do {
                System.out.print("######## Menu ########"
                                 + "\n1- Cadastrar"
                                 + "\n2- Listar"
                                 + "\n3- Alterar"
                                 + "\n4- Excluir"
                                 + "\n5- Sair");
                System.out.print("\n\tOpção: ");
                opcao = Integer.parseInt(console.nextLine());
                System.out.println("\n\n\n\n");
                
                if (opcao == 1){
                    
                    Aluno a = new Aluno();
                    AlunoJDBC acao = new AlunoJDBC();
                    
                    System.out.print("\n*** Cadastrar Aluno ***\n\r");
                    System.out.print("Nome: ");
                    a.setNome(console.nextLine());
                    System.out.print("Sexo: ");
                    a.setSexo(console.nextLine());
                    System.out.print("Data de nascimento: ");
                    a.setDt_nasc( new Date(console.nextLine()) );
                    
                    acao.salvar(a);
                    console.nextLine();
                    System.out.println("\n\n\n\n");
                }
            } while(opcao != 5);
        } catch (Exception e){
            System.out.println("Erro: " + e);
        }
	}
}
