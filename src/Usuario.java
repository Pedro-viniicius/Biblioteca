import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    private String nome;
    private int numeroDeMatricula;
    private int telefone;
    private int quantidadeLivros; // Quantidade de livros emprestados

    static List<Usuario> usuarios = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public Usuario(String nome, int numeroDeMatricula, int telefone) {
        this.nome = nome;
        this.numeroDeMatricula = numeroDeMatricula;
        this.telefone = telefone;
        this.quantidadeLivros = 0;
    }

    public Usuario() {
		
	}

	public String getNome() {
        return nome;
    }

    public int getNumeroDeMatricula() {
        return numeroDeMatricula;
    }

    public int getTelefone() {
        return telefone;
    }

    public int getQuantidadeLivros() {
        return quantidadeLivros;
    }

    public void emprestarLivro() {
        quantidadeLivros++;
    }

    public void devolverLivro() {
        if (quantidadeLivros > 0) {
            quantidadeLivros--;
        }
    }

    public boolean temEmprestimosPendentes() {
        return quantidadeLivros > 0;
    }

    public static void cadastrarUsuario() {
        System.out.println("Cadastre o novo usuário! ");
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a matrícula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Digite o telefone: ");
        int telefone = scanner.nextInt();
        scanner.nextLine(); 

        Usuario novo = new Usuario(nome, matricula, telefone);
        usuarios.add(novo);
        System.out.println("Usuário adicionado com sucesso.");
    }

    public static void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Não há usuários cadastrados.");
            return;
        }

        System.out.println("Lista de Usuários:");
        for (Usuario usuario : usuarios) {
            System.out.println("Nome: " + usuario.getNome() +
                    ", Matrícula: " + usuario.getNumeroDeMatricula() +
                    ", Telefone: " + usuario.getTelefone() +
                    ", Livros Emprestados: " + usuario.getQuantidadeLivros());
        }
    }

    public static void excluirUsuario(int numeroDeMatricula) {
        Usuario usuarioParaExcluir = null;

        for (Usuario usuario : usuarios) {
            if (usuario.getNumeroDeMatricula() == numeroDeMatricula) {
                usuarioParaExcluir = usuario;
                break;
            }
        }

        if (usuarioParaExcluir != null) {
            if (usuarioParaExcluir.temEmprestimosPendentes()) {
                System.out.println("Não é possível excluir o usuário " + usuarioParaExcluir.getNome() +
                        ", pois ele possui empréstimos pendentes.");
            } else {
                usuarios.remove(usuarioParaExcluir);
                System.out.println("Usuário " + usuarioParaExcluir.getNome() + " excluído com sucesso.");
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
    public static Usuario buscarUsuarioPorMatricula(int matricula) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNumeroDeMatricula() == matricula) {
                return usuario;
            }
        }
        return null; // Usuário não encontrado
    }
}
