package com.literalura.model;

import java.util.List;

public class LivroGutendex {

    private int id;
    private String title;
    private List<Autor> authors;
    private List<String> languages;
    private int download_count;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Autor> getAuthors() {
        return authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public int getDownload_count() {
        return download_count;
    }
}
