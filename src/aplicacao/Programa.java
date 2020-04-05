package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Contribuinte;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Contribuinte> listaContribuinte = new ArrayList<>();
		
		System.out.print("Informe o número de contribuintes: ");
		int numeroContribuintes = sc.nextInt();
		
		for(int i=1; i <= numeroContribuintes; i++) {
			System.out.println("Dados do contribuinte " + i + ":");
			System.out.print("Pesso Física ou Juridica (f/j)? ");
			char tipoPessoa = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Renda anual: ");
			Double rendaAnual = sc.nextDouble();
			
			if (tipoPessoa == 'f') {
				System.out.print("Gastos com saúde: ");
				Double gastosComSaude = sc.nextDouble();
				listaContribuinte.add(new PessoaFisica(nome, rendaAnual, gastosComSaude));
			}
			else {
				System.out.print("Número de empregados: ");
				int numeroDeEmpregados = sc.nextInt();
				listaContribuinte.add(new PessoaJuridica(nome, rendaAnual, numeroDeEmpregados));
			}		
		}
		
		System.out.println();
		System.out.println("IMPOSTO PAGO");
		
		Double totalImposto = 0.0;
		
		for (Contribuinte contribuinte : listaContribuinte) {
			System.out.println(contribuinte.getNome() + ": $ " + String.format("%.2f", contribuinte.calculoImposto()));
			totalImposto += contribuinte.calculoImposto();
		}
		
		System.out.println();
		System.out.println("TOTAL IMPOSTO: $ " + String.format("%.2f", totalImposto));
		
		sc.close();
	}

}
