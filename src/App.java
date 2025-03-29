
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String nome;
        int idade, probabilidadeInfeccao = 0;

        Scanner scanner = new Scanner(System.in);
        while (true) { 
            System.out.print("Informe o seu nome: ");
            nome = scanner.next();
            System.out.print("Informe a sua idade:");
            idade = scanner.nextInt();

            while (true){
                System.out.println("Responda com 'SIM' ou 'NAO'");
                System.out.println("Seu cartão de vacina está em dia?");
                String cartaoVacina = scanner.next();
                if (!cartaoVacina.equals("SIM") && !cartaoVacina.equalsIgnoreCase("NAO")){
                    int tentativas = 4;
                    if (tentativas < 1){
                        break;
                    }
                    System.out.println("Responda APENAS com 'SIM' ou 'NAO'. Você tem apenas %d tentativas".formatted(tentativas));
                    tentativas--;
                }

                System.out.println("Teve algum dos sintomas recentemente? (dor de cabeça, febre, náusea, dor articular, gripe)");
                System.out.println("Teve contato com pessoas com sintomas gripais nos últimos dias?");
                System.out.println("Está retornando de viagem realizada no exterior?");

            }
        }
    }
}