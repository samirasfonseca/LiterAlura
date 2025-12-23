package com.literalura;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.literalura.model.Autor;
import com.literalura.model.GutendexResponse;
import com.literalura.model.Livro;
import com.literalura.model.LivroGutendex;
import com.literalura.service.ConsumoApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String URL = "https://gutendex.com/books/";
    private static final List<Livro> livros = new ArrayList<>();
    private static final List<Autor> autores = new ArrayList<>();

    public static void main(String[] args) {

        int opcao = -1;

        while (opcao != 0) {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> buscarLivroPorTitulo();
                case 2 -> listarLivros();
                case 3 -> listarAutores();
                case 4 -> listarAutoresVivosPorAno();
                case 0 -> System.out.println("Encerrando aplicação...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("""
                
                ===== LiterAlura =====
                1 - Buscar livro por título
                2 - Listar livros cadastrados
                3 - Listar autores
                4 - Listar autores vivos em determinado ano
                0 - Sair
                """);
    }

    // 🔍 BUSCAR LIVRO NA API
    private static void buscarLivroPorTitulo() {
        System.out.print("Digite o título do livro: ");
        String tituloBusca = scanner.nextLine();

        try {
            ConsumoApi consumoApi = new ConsumoApi();
            String endereco = URL + "?search=" + tituloBusca.replace(" ", "%20");

            String json = consumoApi.buscarDados(endereco);

            ObjectMapper mapper = new ObjectMapper();
            GutendexResponse resposta =
                    mapper.readValue(json, GutendexResponse.class);

            if (resposta.getResults().isEmpty()) {
                System.out.println("Nenhum livro encontrado.");
                return;
            }

            LivroGutendex livroApi = resposta.getResults().get(0);

            String titulo = livroApi.getTitle();
            String idioma = livroApi.getLanguages().get(0);
            int downloads = livroApi.getDownloadCount();

            var autorApi = livroApi.getAuthors().get(0);

            Autor autor = new Autor(
                    autorApi.getName(),
                    autorApi.getBirthYear(),
                    autorApi.getDeathYear()
            );

            Livro livro = new Livro(titulo, autor, idioma, downloads);

            livros.add(livro);

            if (!autores.contains(autor)) {
                autores.add(autor);
            }

            System.out.println("\nLivro encontrado e salvo:");
            System.out.println(livro);

        } catch (Exception e) {
            System.out.println("Erro ao buscar livro: " + e.getMessage());
        }
    }

    // 📚 LISTAR LIVROS
    private static void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        System.out.println("\n📚 Livros cadastrados:");
        livros.forEach(System.out::println);
    }

    // ✍ LISTAR AUTORES
    private static void listarAutores() {
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor cadastrado.");
            return;
        }

        System.out.println("\n✍ Autores cadastrados:");
        autores.forEach(System.out::println);
    }

    // 📅 AUTORES VIVOS EM UM ANO
    private static void listarAutoresVivosPorAno() {
        System.out.print("Digite o ano: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nAutores vivos em " + ano + ":");

        autores.stream()
                .filter(a ->
                        (a.getAnoNascimento() <= ano) &&
                                (a.getAnoFalecimento() == null || a.getAnoFalecimento() >= ano)
                )
                .forEach(System.out::println);
    }
}
