package teste;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import dao.QuartoDAO;
import model.Quarto;
import dao.HospedeDAO;
import dao.OcupacaoQuartoDAO;
import model.Hospede;
import model.OcupacaoQuarto;

public class TesteQuarto {
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
	
		QuartoDAO quartoDAO = new QuartoDAO();
		System.out.println("Informe a opcao desejada");
		System.out.println("1 - Inserir Quarto");
		System.out.println("2 - Buscar Quarto");
		System.out.println("3 - Editar Quarto");
		System.out.println("4 - Excluir Quarto");
		System.out.println("5 - Listar todos os Quartos");
		int opcao = s1.nextInt();
		s1.nextLine();
		
		if(opcao == 1){
			OcupacaoQuartoDAO ocupacaoquartoDAO = new OcupacaoQuartoDAO();
			OcupacaoQuarto oc1 = new OcupacaoQuarto();
			oc1.setDisponibilidade("Disponivel");
			
			Quarto q1 = new Quarto();
			System.out.println("Numero do Quarto");
			q1.setNumeroQuarto(s1.nextInt());
			s1.nextLine();
			System.out.println("Descricao");
			q1.setDescricao(s1.nextLine());		
			System.out.println("Valor da diaria");
			q1.setValor(s1.nextDouble());
			s1.nextLine();
			 if (ocupacaoquartoDAO.pesquisaDisponibilidade(oc1.getDisponibilidade()).getIdOcupacaoQuarto() == 0) {
				 ocupacaoquartoDAO.inserir(oc1);
			 }
			 oc1 = ocupacaoquartoDAO.pesquisaDisponibilidade(oc1.getDisponibilidade());
			 
			 q1.setOcupacaoQuarto(oc1);
			 quartoDAO.inserir(q1);
			 System.out.println("FIM");
		}
		
		if(opcao == 2){
			System.out.println("Digite o nome do quarto que deseja buscar");
			int numero = s1.nextInt();
			Quarto quartoPesquisado = quartoDAO.pesquisaNumero(numero);
	            System.out.println("Numero do Quarto: " +quartoPesquisado.getNumeroQuarto());
	            System.out.println("Descricao: " +quartoPesquisado.getDescricao());
	            System.out.println("Valor da diaria: " +quartoPesquisado.getValor());
	            System.out.println("idDisponibilidade: " +quartoPesquisado.getOcupacaoQuarto().getIdOcupacaoQuarto());
	            System.out.println("Disponibilidade: " +quartoPesquisado.getOcupacaoQuarto().getDisponibilidade());
		 }
		
		
		if(opcao == 3){
			System.out.println("Qual registro ser� alterado?");
			System.out.println("1 - Numero do Quarto");
			System.out.println("2 - Descricao");
			System.out.println("3 - Valor da Diaria");
			System.out.println("4 - Ocupacao");
			int editar = s1.nextInt();
			s1.nextLine();
			
			if(editar == 1){
				Quarto q1 = new Quarto();
				System.out.println("Novo Numero");
				q1.setNumeroQuarto(s1.nextInt());
				System.out.println("idQuarto");
				q1.setNumeroQuarto(s1.nextInt());
				quartoDAO.editarNumero(q1);
				System.out.println("FIM");
			}
			if(editar == 2){
				Quarto q1 = new Quarto();
				System.out.println("Novo Descricao");
				q1.setDescricao(s1.nextLine());
				System.out.println("Numero do Quarto");
				q1.setNumeroQuarto(s1.nextInt());
				quartoDAO.editarDescricao(q1);
				System.out.println("FIM");
			}
			if(editar == 3){
				Quarto q1 = new Quarto();
				System.out.println("Novo Valor da Diaria");
				q1.setValor(s1.nextInt());
				System.out.println("Numero do Quarto");
				q1.setNumeroQuarto(s1.nextInt());
				quartoDAO.editarValor(q1);
				System.out.println("FIM");
			}
			
		}
		
		if(opcao == 4){
			System.out.println("Informe os dados para excluir um hospede");
			Quarto q1 = new Quarto();
			System.out.println("Numero do Quarto");
			q1.setNumeroQuarto(s1.nextInt());
			quartoDAO.excluir(q1);
			System.out.println("FIM");
		}
		
		if(opcao == 5){
			 ArrayList<Quarto> quarto = quartoDAO.listarQuartos();
		        for (Quarto q : quarto) {
		            System.out.println("Numero: " + q.getNumeroQuarto());
		            System.out.println("Descricao: " +q.getDescricao());
		            System.out.println("Valor da diaria: " +q.getValor());
		            System.out.println("idDisponibilidade: " +q.getOcupacaoQuarto().getIdOcupacaoQuarto());
		            System.out.println("Disponibilidade: " +q.getOcupacaoQuarto().getDisponibilidade());
		            System.out.println("********************************");
		          
		        }
		}
	}
}