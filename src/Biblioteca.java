import java.util.ArrayList;
import java.util.Scanner;

// Classe principal para gerenciar a biblioteca
public class Biblioteca {

    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }


    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado: " + livro.getTitulo());
    }


    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro disponível.");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    // Função para remover um livro pelo ID
    public void removerLivro(int id) {
        livros.removeIf(livro -> livro.getId() == id);
        System.out.println("Livro removido.");
    }

    // Função para adicionar um usuário à biblioteca
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário adicionado: " + usuario.getNome());
    }

    // Função para listar todos os usuários da biblioteca
    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário registrado.");
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        // Menu principal
        while (true) {
            System.out.println("\nSistema de Gerenciamento de Biblioteca");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Remover Livro");
            System.out.println("4. Adicionar Usuário");
            System.out.println("5. Listar Usuários");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Digite o ano de publicação: ");
                    int ano = scanner.nextInt();
                    Livro livro = new Livro(Livro.gerarId(), titulo, autor, ano);
                    biblioteca.adicionarLivro(livro);
                    break;
                case 2:
                    biblioteca.listarLivros();
                    break;
                case 3:
                    System.out.print("Digite o ID do livro a ser removido: ");
                    int idLivro = scanner.nextInt();
                    biblioteca.removerLivro(idLivro);
                    break;
                case 4:
                    System.out.print("Digite o nome do usuário: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a idade do usuário: ");
                    int idade = scanner.nextInt();
                    Usuario usuario = new Usuario(Usuario.gerarId(), nome, idade);
                    biblioteca.adicionarUsuario(usuario);
                    break;
                case 5:
                    biblioteca.listarUsuarios();
                    break;
                case 6:
                    System.out.println("Saindo do sistema.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}