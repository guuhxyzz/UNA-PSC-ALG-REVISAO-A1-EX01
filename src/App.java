
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String nome, viagemExterior, contatoSintomas, sintomas;
        int idade, probabilidadeInfeccao = 0;

        Scanner scanner = new Scanner(System.in);
        while (true) { 
            System.out.print("Informe o seu nome: ");
            nome = scanner.next();
            System.out.print("Informe a sua idade:");
            idade = scanner.nextInt();

            while (true){ // Loop para perguntar os sintomas
                System.out.println("Responda com 'SIM' ou 'NAO'");
                System.out.println("Seu cartão de vacina está em dia?");
                String cartaoVacina = scanner.next();
                if (!cartaoVacina.equalsIgnoreCase("SIM") && !cartaoVacina.equalsIgnoreCase("NAO")){
                    int tentativas = 4;
                    if (tentativas < 1){
                        break;
                    }
                    System.out.println("Responda APENAS com 'SIM' ou 'NAO'. Você tem apenas %d tentativas".formatted(tentativas));
                    tentativas--;
                    continue;
                } else if (cartaoVacina.equalsIgnoreCase("NAO")){
                    probabilidadeInfeccao += 10;
                }
                System.out.println("Teve algum dos sintomas recentemente? (dor de cabeça, febre, náusea, dor articular, gripe)");
                sintomas = scanner.next();
                if (!sintomas.equalsIgnoreCase("SIM") && !sintomas.equalsIgnoreCase("NAO")){
                    int tentativas = 4;
                    if (tentativas < 1){
                        break;
                    }
                    System.out.println("Responda APENAS com 'SIM' ou 'NAO'. Você tem apenas %d tentativas".formatted(tentativas));
                    tentativas--;
                    continue;
                } else if (sintomas.equalsIgnoreCase("SIM")){
                    probabilidadeInfeccao += 30;
                }
                System.out.println("Teve contato com pessoas com sintomas gripais nos últimos dias?");
                contatoSintomas = scanner.next();
                if (!contatoSintomas.equalsIgnoreCase("SIM") && !contatoSintomas.equalsIgnoreCase("NAO")){
                    int tentativas = 4;
                    if (tentativas < 1){
                        break;
                    }
                    System.out.println("Responda APENAS com 'SIM' ou 'NAO'. Você tem apenas %d tentativas".formatted(tentativas));
                    tentativas--;
                    continue;
                } else if (contatoSintomas.equalsIgnoreCase("SIM")){
                    probabilidadeInfeccao += 30;
                }
                System.out.println("Está retornando de viagem realizada no exterior?");
                viagemExterior = scanner.next();
                if (!viagemExterior.equalsIgnoreCase("SIM") && !viagemExterior.equalsIgnoreCase("NAO")){
                    int tentativas = 4;
                    if (tentativas < 1){
                        break;
                    }
                    System.out.println("Responda APENAS com 'SIM' ou 'NAO'. Você tem apenas %d tentativas".formatted(tentativas));
                    tentativas--;
                    continue;
                } else if (viagemExterior.equalsIgnoreCase("SIM")){
                    probabilidadeInfeccao += 30;
                }
                // Calculo da probabilidade de infecção
                if (probabilidadeInfeccao <= 30){
                    System.out.println("Paciente sob observação. Caso apareça algum sintoma, gentileza buscar assistência médica.");
                } else if (probabilidadeInfeccao <=  60){
                    System.out.println("Paciente com risco de estar infectado. Gentileza aguardar em lockdown por 02 dias para ser acompanhado.");
                } else if (probabilidadeInfeccao >= 90){
                    System.out.println("Paciente crítico! Gentileza aguardar em lockdown por 10 dias para ser acompanhado.");
                } else if (viagemExterior.equalsIgnoreCase("SIM")){
                    System.out.println("Você ficará sob observação por 05 dias.");
                }
                break;
            }
        }
    }
}