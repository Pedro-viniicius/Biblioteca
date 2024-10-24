import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private String dataDeEmprestimo;
    private String dataDeDevolucao;
    private Usuario usuario;
    private Livro livro;

    // Lista estática para gerenciar todos os empréstimos
    static List<Emprestimo> emprestimos = new ArrayList<>();

    public Emprestimo(Usuario usuario, Livro livro, String dataDeEmprestimo) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataDeEmprestimo = dataDeEmprestimo;
        this.dataDeDevolucao = calcularDataDeDevolucao(LocalDate.parse(dataDeEmprestimo));
        emprestimos.add(this);
    }

    public static String calcularDataDeDevolucao(LocalDate dataEmprestimo) {
        return dataEmprestimo.plusDays(7).toString();
    }

    public static void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Não há empréstimos registrados.");
            return;
        }
        System.out.println("Lista de Empréstimos:");
        for (Emprestimo emp : emprestimos) {
            System.out.println("Usuário: " + emp.usuario.getNome() +
                               ", Livro: " + emp.livro.getTitulo() +
                               ", Data de Empréstimo: " + emp.dataDeEmprestimo +
                               ", Data de Devolução: " + emp.dataDeDevolucao);
        }
    }

    public static void consultarEmprestimosPorUsuario(Usuario usuario) {
        boolean found = false;
        System.out.println("Empréstimos do usuário " + usuario.getNome() + ":");
        for (Emprestimo emp : emprestimos) {
            if (emp.usuario.equals(usuario)) {
                System.out.println("Livro: " + emp.livro.getTitulo() +
                                   ", Data de Empréstimo: " + emp.dataDeEmprestimo +
                                   ", Data de Devolução: " + emp.dataDeDevolucao);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Nenhum empréstimo encontrado para este usuário.");
        }
    }

    public static void consultarEmprestimosPorLivro(Livro livro) {
        boolean found = false;
        System.out.println("Empréstimos do livro " + livro.getTitulo() + ":");
        for (Emprestimo emp : emprestimos) {
            if (emp.livro.equals(livro)) {
                System.out.println("Usuário: " + emp.usuario.getNome() +
                                   ", Data de Empréstimo: " + emp.dataDeEmprestimo +
                                   ", Data de Devolução: " + emp.dataDeDevolucao);
                found = true;
            }
        }
        if (!found) {
            System.out.println("O livro não está emprestado.");
        }
    }
}