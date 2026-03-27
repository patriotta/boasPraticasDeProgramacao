import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {

    private List<Livro> livros = new ArrayList<>();
    private LivroRepositorio repository;

    public BibliotecaService(LivroRepositorio repository) {
        this.repository = repository;
    }

    public void carregarLivros() {
        this.livros = repository.carregarLivros();
    }

    public void salvarLivros() {
        repository.salvarLivros(livros);
    }

    public String adicionarLivro(String titulo) {

        if (titulo == null || titulo.trim().length() < 3) {
            return "Título inválido!";
        }

        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return "Livro já existe!";
            }
        }

        livros.add(new Livro(titulo));
        return "Livro adicionado com sucesso!";
    }

    public String emprestarLivro(String titulo) {

        for (Livro livro : livros) {

            if (livro.getTitulo().equalsIgnoreCase(titulo)) {

                if (livro.isEmprestado()) {
                    return "Livro já está emprestado! Tente outra opção";
                }

                livro.emprestar();
                return "Livro emprestado com sucesso!";
            }
        }

        return "Livro não encontrado!";
    }

    public String devolverLivro(String titulo) {

        for (Livro livro : livros) {

            if (livro.getTitulo().equalsIgnoreCase(titulo)) {

                if (!livro.isEmprestado()) {
                    return "Livro já está disponível!";
                }

                livro.devolver();
                return "Livro devolvido com sucesso!";
            }
        }

        return "Livro não encontrado!";
    }

    public void listarLivros() {

        System.out.println("\n=== LISTA DE LIVROS ===");

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        for (Livro livro : livros) {

            String status = livro.isEmprestado() ? "Emprestado" : "Disponível";

            System.out.println("- " + livro.getTitulo() + " (" + status + ")");
        }
    }
}