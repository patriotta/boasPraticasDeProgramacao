import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioLivros implements LivroRepositorio {

    private static final String ARQUIVO = "livros.txt";

    @Override
    public List<Livro> carregarLivros() {

        List<Livro> livros = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {

            String linha;

            while ((linha = reader.readLine()) != null) {

                String[] partes = linha.split(";");

                Livro livro = new Livro(partes[0]);

                if (partes.length > 1 && Boolean.parseBoolean(partes[1])) {
                    livro.emprestar();
                }

                livros.add(livro);
            }

        } catch (IOException e) {
            System.out.println("Erro ao carregar livros.");
        }

        return livros;
    }

    @Override
    public void salvarLivros(List<Livro> livros) {

        try (PrintWriter writer = new PrintWriter(ARQUIVO)) {

            for (Livro livro : livros) {
                writer.println(livro.getTitulo() + ";" + livro.isEmprestado());
            }

        } catch (IOException e) {
            System.out.println("Erro ao salvar livros.");
        }
    }
}