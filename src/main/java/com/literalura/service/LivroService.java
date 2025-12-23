package com.literalura.model;

private static List<Livro> livros = new ArrayList<>();


public class Livro {

    private static void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        System.out.println("📚 Livros cadastrados:");
        livros.forEach(System.out::println);
    }


    private String titulo;
    private String autor;
    private String idioma;
    private int downloads;

    public Livro(String titulo, String autor, String idioma, int downloads) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.downloads = downloads;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public int getDownloads() {
        return downloads;
    }

    @Override
    public String toString() {
        return """
               📘 Título: %s
               ✍ Autor: %s
               🌍 Idioma: %s
               ⬇ Downloads: %d
               ---------------------
               """.formatted(titulo, autor, idioma, downloads);
    }
}

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
        String autor = livroApi.getAuthors().get(0).getName();
        String idioma = livroApi.getLanguages().get(0);
        int downloads = livroApi.getDownloadCount();

        Livro livro = new Livro(titulo, autor, idioma, downloads);
        livros.add(livro);

        System.out.println("Livro encontrado e salvo:");
        System.out.println(livro);

    } catch (Exception e) {
        System.out.println("Erro na busca: " + e.getMessage());
    }
}
