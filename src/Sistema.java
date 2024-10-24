import java.time.LocalDate;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bem-vindo ao sistema de Biblioteca!");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Listar Usuários");
            System.out.println("3. Excluir Usuário");
            System.out.println("4. Adicionar Livro");
            System.out.println("5. Listar Livros");
            System.out.println("6. Excluir Livro");
            System.out.println("7. Registrar Empréstimo");
            System.out.println("8. Listar Empréstimos");
            System.out.println("9. Consultar Empréstimos por Usuário");
            System.out.println("10. Consultar Empréstimos por Livro");
            System.out.println("11. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcao) {
                case 1:
                    Usuario.cadastrarUsuario();
                    break;
                case 2:
                    Usuario.listarUsuarios();
                    break;
                case 3:
                    System.out.print("Digite o número de matrícula do usuário a ser excluído: ");
                    int matricula = scanner.nextInt();
                    Usuario.excluirUsuario(matricula);
                    break;
                case 4:
                    Livro.adicionarLivro();
                    break;
                case 5:
                    Livro.listarLivros();
                    break;
                case 6:
                    System.out.print("Digite o título do livro a ser excluído: ");
                    String tituloLivro = scanner.nextLine();
                    Livro.excluirLivro(tituloLivro);
                    break;
                case 7:
                    System.out.print("Digite o nome do usuário (número de matrícula): ");
                    int numeroMatricula = scanner.nextInt();
                    Usuario usuario = Usuario.buscarUsuarioPorMatricula(numeroMatricula);
                    if (usuario != null) {
                        System.out.print("Digite o título do livro: ");
                        String titulo = scanner.nextLine();
                        Livro livro = Livro.buscarLivroPorTitulo(titulo);
                        if (livro != null) {
                            Emprestimo emprestimo = new Emprestimo(usuario, livro, LocalDate.now().toString());
                            System.out.println("Empréstimo registrado com sucesso!");
                        } else {
                            System.out.println("Livro não encontrado.");
                        }
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;
                case 8:
                    Emprestimo.listarEmprestimos();
                    break;
                case 9:
                    System.out.print("Digite o número de matrícula do usuário: ");
                    int matriculaUsuario = scanner.nextInt();
                    Usuario usuarioParaConsultar = Usuario.buscarUsuarioPorMatricula(matriculaUsuario);
                    if (usuarioParaConsultar != null) {
                        Emprestimo.consultarEmprestimosPorUsuario(usuarioParaConsultar);
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;
                case 10:
                    System.out.print("Digite o título do livro: ");
                    String tituloConsulta = scanner.nextLine();
                    Livro livroParaConsultar = Livro.buscarLivroPorTitulo(tituloConsulta);
                    if (livroParaConsultar != null) {
                        Emprestimo.consultarEmprestimosPorLivro(livroParaConsultar);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                case 11:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
                    //teste commit
            }
        }
    }
}