import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        // Array com a lista de candidatos
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};
        double salarioBase = 2000.0;

        // Inicialização do programa
        System.out.println("\n\nInicializando programa de Processo Seletivo\n");
        // Selecionar os candidados com base em suas propostas de salário
        String [] candidatosSelecionados = selecionarCandidatos(candidatos, salarioBase);

        // Imprimir o resultado de candidatos selecionados
        imprimirCandidatos(candidatosSelecionados,candidatos);

        // Ligar para os candidatos selecionados
        System.out.println("\nContactando os candidatos selecionados...");
        ligarCandidatos(candidatosSelecionados);

    }

    public static void ligarCandidatos(String[] candidatosSelecionados) {
        for (String candidato : candidatosSelecionados) {
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
                System.out.println("Contato realizado com sucesso!");            
        } while (continuar && tentativas<3);
        if(atendeu)
			System.out.println("Conseguimos contato com o candidato '" + candidato +"' na " + tentativas + "ª tentativa!\n");
		else
			System.out.println("Não conseguimos contato com o candidato '" + candidato +"', número máximo de " + tentativas + " tentativas realizadas.\n");
    }

    public static boolean atender() {
        return new Random().nextInt(3)==1;
    }

    public static void imprimirCandidatos(String[] candidatosSelecionados, String[] candidatos) {
        System.out.println("");
        if (candidatosSelecionados.length != 0) {
            System.out.println("Dentre o total de " + candidatos.length + " candidatos, foram selecionados " + candidatosSelecionados.length);
            System.out.println("Os candidatos selecionados foram:");
            for (String candidatosSelecionado : candidatosSelecionados) {
                System.out.println("   > " + candidatosSelecionado); }
        }
        else
            System.out.println("Nenhum candidato foi selecionado.");
        System.out.println("");
    }

    public static String[] selecionarCandidatos(String [] candidatos, double salarioBase) {
        //O método recebe a lista de candidatos e o salário base e cria uma lista com os candidatos selecionados.

        int candidatosSelecionadosTotal = 0;
        int indice = 0;
        int indiceAuxiliar = 0;
        int[] indiceCandidatosSelecionados = new int[5];

        while (candidatosSelecionadosTotal < 5 && indice < candidatos.length) {
            System.out.println("Candidato nº" + (indice+1) + ": " + candidatos[indice]);
            boolean selecionado = analisarSalarios(valorPretendido(), salarioBase);
            if (selecionado) {
                indiceCandidatosSelecionados[indiceAuxiliar] = indice; 
                candidatosSelecionadosTotal++; 
                indiceAuxiliar++; }
            indice++;
            System.out.println("");
        }

        String[] candidatosSelecionados = new String[candidatosSelecionadosTotal];
        for (indice = 0; indice < candidatosSelecionadosTotal; indice++) {
            candidatosSelecionados[indice] = candidatos[indiceCandidatosSelecionados[indice]];
        }
        return candidatosSelecionados;
    }

    public static boolean analisarSalarios(double salarioPretendido, double salarioBase) {
        // O método analisa a pretensão de cada candidato e define se ele foi ou não aprovado.
        System.out.printf("O candidato propôs um salário de R$%.2f", (salarioPretendido));
        if (salarioPretendido < salarioBase) {
            System.out.println("\nProposta válida! Candidato selecionado.");
            return true;
        }else if (salarioPretendido == salarioBase) {
            System.out.println("\nApresentar contra-proposta! Candidato selecionado.");
            return true;
        }else
            System.out.println("\nProposta negada!");
            return false;

    }

    public static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
        // Retorna a pretensão salarial entre 1800 e 2200 de um candidato.
    }
}