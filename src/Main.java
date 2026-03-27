import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LivroRepositorio repository = new RepositorioLivros();
        BibliotecaService biblioteca = new BibliotecaService(repository);

        biblioteca.carregarLivros();

        while (true) {

            System.out.println("\n=== SISTEMA DA BIBLIOTECA ===");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Emprestar livro");
            System.out.println("3 - Devolver livro");
            System.out.println("4 - Listar livros");
            System.out.println("5 - Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Digite o título: ");
                    String titulo = sc.nextLine();
                    System.out.println(biblioteca.adicionarLivro(titulo));
                    break;

                case 2:
                    System.out.print("Digite o título para empréstimo: ");
                    String emp = sc.nextLine();
                    System.out.println(biblioteca.emprestarLivro(emp));
                    break;

                case 3:
                    System.out.print("Digite o título para devolução: ");
                    String dev = sc.nextLine();
                    System.out.println(biblioteca.devolverLivro(dev));
                    break;

                case 4:
                    biblioteca.listarLivros();
                    break;

                case 5:
                    biblioteca.salvarLivros();
                    System.out.println("Saindo...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}