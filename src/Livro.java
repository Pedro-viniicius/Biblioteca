import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Livro {
    private String titulo;
    private String autor;
    private String anoDePublicacao;
    private int ISBN;
    private boolean status; 

    static List<Livro> acervo = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public Livro(String titulo, String autor, String anoDePublicacao, int ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.ISBN = ISBN;
        this.status = true; 
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static void adicionarLivro() {
        System.out.println("Digite o título do livro:");
        String titulo = scanner.nextLine();

        System.out.println("Digite o autor do livro:");
        String autor = scanner.nextLine();

        System.out.println("Digite o ano de publicação:");
        String anoDePublicacao = scanner.nextLine();

        System.out.println("Digite o ISBN do livro:");
        int ISBN = scanner.nextInt();
        scanner.nextLine(); 

        Livro novoLivro = new Livro(titulo, autor, anoDePublicacao, ISBN);
        acervo.add(novoLivro);
        System.out.println("Livro adicionado com sucesso.");
    }

    public static void listarLivros() {
        if (acervo.isEmpty()) {
            System.out.println("O acervo está vazio.");
            return;
        }

        System.out.println("Lista de livros no acervo:");
        for (Livro livro : acervo) {
            System.out.println("Título: " + livro.getTitulo() +
                    ", Autor: " + livro.autor + 
                    ", Ano: " + livro.anoDePublicacao +
                    ", ISBN: " + livro.ISBN +
                    ", Status: " + (livro.isStatus() ? "Disponível" : "Emprestado"));
        }
    }

    public static void excluirLivro(String titulo) {
        Livro livroParaExcluir = null;

        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livroParaExcluir = livro;
                break;
            }
        }

        if (livroParaExcluir != null) {
            if (!livroParaExcluir.isStatus()) {
                System.out.println("O livro '" + titulo + "' está emprestado e não pode ser excluído.");
            } else {
                acervo.remove(livroParaExcluir);
                System.out.println("Livro '" + titulo + "' removido do acervo.");
            }
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    public static Livro buscarLivro(String titulo) {
        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo) && livro.isStatus()) {
                return livro; 
            }
        }
        return null; 
    }
    public static Livro buscarLivroPorTitulo(String titulo) {
        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null; 
    }
}
