import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivoTestes {
    public static void main(String[] args) {

        System.out.println("Testes de Sistema de Processos Seletivos:");
        System.out.println("Case 1 - Analisar Candidatos");
        System.out.println("");
        analisarCandidato(1900.0);
        analisarCandidato(2000.0);
        analisarCandidato(2100.0);
        System.out.println("");

        System.out.println("Case 2 - Selecionar Candidatos");
        
        System.out.println("");
        selecionarCandidatos();
        System.out.println("");
        
        System.out.println("Case 3 - Imprimir Candidatos Selecionados");

        System.out.println("");
        imprimirSelecionados();
        System.out.println("");

        System.out.println("Case 4 - Ligar para os Candidatos Selecionados");

        System.out.println("");
        ligarCandidatos();
        System.out.println("");

    }

    public static void ligarCandidatos() {
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};
        for (String candidato : candidatos) {
            contactar(candidato);
        }
    }

    public static void contactar(String candidato) {
        int tentativas = 1;
        boolean continuar;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuar = !atendeu;
            if (continuar)
                tentativas++;
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO");            
        } while (continuar && tentativas<3);
        if(atendeu)
			System.out.println("CONSEGUIMOS CONTATO COM " + candidato +" NA " + tentativas + "ª TENTATIVA");
		else
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato +", NÚMERO MAXIMO DE TENTATIVAS " + tentativas + " REALIZADA");
    }

    public static boolean atender() {
        return new Random().nextInt(3)==1;
    }

    public static void imprimirSelecionados(){
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato nº " + (indice+1) + " é o candidato " + candidatos[indice] +".");
        }
        System.out.println("");
        System.out.println("Forma 'For Each' abreviada:");
        System.out.println("");

        for (String candidato : candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    public static void selecionarCandidatos(){
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " tem uma pretensão salarial de " + salarioPretendido);
            if (salarioPretendido <= salarioBase) {
                System.out.println("O candidato " + candidato + " foi selecionado!");
                candidatosSelecionados++;
            }

            candidatoAtual++;
        }
    }

    public static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    public static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioPretendido < salarioBase) {
            System.out.println("LIGAR PARA O CANDIDATO");
        }else if(salarioPretendido == salarioBase) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA-PROPOSTA");
        }else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}