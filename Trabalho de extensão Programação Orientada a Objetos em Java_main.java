// Classe Transacao
class Transacao {
    private String descricao;
    private double valor;
    private String tipo; // "Receita" ou "Despesa"
    public Transacao(String descricao, double valor, String tipo) {
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
    }
    public String getDescricao() {
        return descricao;
    }
    public double getValor() {
        return valor;
    }
    public String getTipo() {
        return tipo;
    }
    @Override
    public String toString() {
        return tipo + ": " + descricao + " - " + valor;
    }
}
// Classe RelatorioFinanceiro
import java.util.ArrayList;

class RelatorioFinanceiro {
    private ArrayList<Transacao> transacoes;
    public RelatorioFinanceiro() {
        this.transacoes = new ArrayList<>();
    }
    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }
    public double calcularSaldo() {
        double saldo = 0.0;
        for (Transacao transacao : transacoes) {
            if (transacao.getTipo().equalsIgnoreCase("Receita")) {
                saldo += transacao.getValor();
            } else if (transacao.getTipo().equalsIgnoreCase("Despesa")) {
                saldo -= transacao.getValor();
            }
        }
        return saldo;
    }
    public void gerarRelatorio() {
        System.out.println("Relatório Financeiro:");
        for (Transacao transacao : transacoes) {
            System.out.println(transacao);
        }
        System.out.println("Saldo Atual: " + calcularSaldo());
    }
}

// Classe principal para execução
import java.util.Scanner;

public class SistemaGestaoFinanceira {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RelatorioFinanceiro relatorio = new RelatorioFinanceiro();
        while (true) {
            System.out.println("\n1. Adicionar Receita");
            System.out.println("2. Adicionar Despesa");
            System.out.println("3. Gerar Relatório");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            if (opcao == 1) {
                System.out.print("Descrição da Receita: ");
                String descricao = scanner.nextLine();
                System.out.print("Valor da Receita: ");
                double valor = scanner.nextDouble();
                scanner.nextLine(); // Consumir nova linha
                relatorio.adicionarTransacao(new Transacao(descricao, valor, "Receita"));
            } else if (opcao == 2) {
                System.out.print("Descrição da Despesa: ");
                String descricao = scanner.nextLine();
                System.out.print("Valor da Despesa: ");
                double valor = scanner.nextDouble();
                scanner.nextLine(); // Consumir nova linha
                relatorio.adicionarTransacao(new Transacao(descricao, valor, "Despesa"));
            } else if (opcao == 3) {
                relatorio.gerarRelatorio();
            } else if (opcao == 4) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}

