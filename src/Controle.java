import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Controle {
    public static void main(String[] args) {
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA"};
        for (String candidato: candidatos) {
            entrandoEmContato(candidato);
        }
    }
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("Contato realizado com sucesso!");
            }
        } while(continuarTentando && tentativasRealizadas<3);
        if (atendeu) {
            System.out.println("Conseguimos contato com " + candidato + " na "+ tentativasRealizadas + " tentiva");
        } else {
            System.out.println("Não conseguimos contato com " + candidato + " no número maximo de tentativas " + tentativasRealizadas + " realizada");
        }

    }
    static boolean atender() {
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados() {
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
        for(int i = 0; i < candidatos.length; i++) {
            System.out.println("O candidato de n " + (i + 1) + "é" + candidatos[i]);
        }
        System.out.print("Forma abreviada de interação forEach");
        for (String candidato: candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }
    static void SelecaoCandidatos() {

        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};

        int candidatosSelecionaods = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionaods < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.print("O candidato " + candidato + " Solicitou este valor de salário " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
             System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
             candidatosSelecionaods++;
            }
            candidatosAtual++;
        }
    }
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
            if (salarioBase > salarioPretendido) {
                System.out.println("Ligar para o candidato");
            } else if (salarioBase == salarioPretendido) {
                System.out.println("Ligar para o candidato com contra proposta");
            } else {
                System.out.print("Aguardando o resultado dos demais candidatos");
            }

    }
}
