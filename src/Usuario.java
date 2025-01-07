// Classe para representar um Usuário
public class Usuario {

    private static int idCounter = 1;
    private int id;
    private String nome;
    private int idade;

    public Usuario(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public static int gerarId() {
        return idCounter++;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Idade: " + idade;
    }
}
