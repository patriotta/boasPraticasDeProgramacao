import java.util.List;

public interface LivroRepositorio {

    List<Livro> carregarLivros();

    void salvarLivros(List<Livro> livros);
}