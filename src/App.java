
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String nome, viagemExterior, contatoSintomas, sintomas;
        int idade, probabilidadeInfeccao = 0,tentativas = 3;

        Scanner scanner = new Scanner(System.in);
        while (true) { 
            System.out.println("Informe o seu nome:");
            nome = scanner.next();
            System.out.println("Informe a sua idade:");
            idade = scanner.nextInt();

            while (tentativas > 0){ // Loop para perguntar os sintomas
                System.out.println("Responda com 'SIM' ou 'NAO'");
                System.out.println("Não responda errado, você tem apenas %d tentativas".formatted(tentativas));
                System.out.println("Seu cartão de vacina está em dia?");
                String cartaoVacina = scanner.next();
                if (!cartaoVacina.equalsIgnoreCase("SIM") && !cartaoVacina.equalsIgnoreCase("NAO")){
                    System.out.println("Responda APENAS com 'SIM' ou 'NAO'. Você tem apenas %d tentativas".formatted(tentativas));
                    tentativas--;
                    continue;
                } else if (cartaoVacina.equalsIgnoreCase("NAO")){
                    probabilidadeInfeccao += 10;
                }
                System.out.println("Teve algum dos sintomas recentemente? (dor de cabeça, febre, náusea, dor articular, gripe)");
                sintomas = scanner.next();
                if (!sintomas.equalsIgnoreCase("SIM") && !sintomas.equalsIgnoreCase("NAO")){
                    System.out.println("Responda APENAS com 'SIM' ou 'NAO'. Você tem apenas %d tentativas".formatted(tentativas));
                    tentativas--;
                    continue;
                } else if (sintomas.equalsIgnoreCase("SIM")){
                    probabilidadeInfeccao += 30;
                }
                System.out.println("Teve contato com pessoas com sintomas gripais nos últimos dias?");
                contatoSintomas = scanner.next();
                if (!contatoSintomas.equalsIgnoreCase("SIM") && !contatoSintomas.equalsIgnoreCase("NAO")){
                    System.out.println("Responda APENAS com 'SIM' ou 'NAO'. Você tem apenas %d tentativas".formatted(tentativas));
                    tentativas--;
                    continue;
                } else if (contatoSintomas.equalsIgnoreCase("SIM")){
                    probabilidadeInfeccao += 30;
                }
                System.out.println("Está retornando de viagem realizada no exterior?");
                viagemExterior = scanner.next();
                if (!viagemExterior.equalsIgnoreCase("SIM") && !viagemExterior.equalsIgnoreCase("NAO")){
                    System.out.println("Responda APENAS com 'SIM' ou 'NAO'. Você tem apenas %d tentativas".formatted(tentativas));
                    tentativas--;
                    continue;
                } else if (viagemExterior.equalsIgnoreCase("SIM")){
                    probabilidadeInfeccao += 30;
                }
                // Dados do paciente
                System.out.println("""
                    Nome do paciente: %s
                    Idade do paciente: %d
                    Cartão de vacina: %s
                    Sintomas: %s
                    Contato com pessoas com sintomas gripais: %s
                    Retorno de viagem realizada no exterior: %s
                    Probabilidade de infecção: %d%%
                    """.formatted(nome, idade, cartaoVacina, sintomas, contatoSintomas, viagemExterior, probabilidadeInfeccao));
                // Calculo da probabilidade de infecção
                if (probabilidadeInfeccao <= 30){
                    System.out.println("Paciente sob observação. Caso apareça algum sintoma, gentileza buscar assistência médica.");
                } else if (probabilidadeInfeccao <=  60){
                    System.out.println("Paciente com risco de estar infectado. Gentileza aguardar em lockdown por 02 dias para ser acompanhado.");                    } else if (probabilidadeInfeccao >= 90){
                    System.out.println("Paciente crítico! Gentileza aguardar em lockdown por 10 dias para ser acompanhado.");
                } else if (viagemExterior.equalsIgnoreCase("SIM")){
                    System.out.println("Você ficará sob observação por 05 dias.");
                }
                break;
                }
            if (tentativas == 0){
                System.out.println("Não foi possível realizar o diagnóstico.\nGentileza procurar ajuda médica caso apareça algum sintoma.");
                break;
            }
            System.out.print("Deseja realizar outro diagnóstico? (SIM/NAO): ");
            String resposta = scanner.next();
            if (resposta.equalsIgnoreCase("NAO")){
                System.out.println("Programa encerrando.");
                break;
            } else if (!resposta.equalsIgnoreCase("SIM")){
                System.out.println("Resposta inválida. O programa será encerrado.");
                break;
            }
        }
        scanner.close();
    }
}