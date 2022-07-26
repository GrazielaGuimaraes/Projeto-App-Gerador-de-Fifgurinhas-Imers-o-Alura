package model;

public class Conteudo {

    private final String title;
    private final String url;



    public Conteudo(String title, String url) {

        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
