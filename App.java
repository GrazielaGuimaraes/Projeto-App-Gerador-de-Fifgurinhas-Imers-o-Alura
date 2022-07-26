import extratores.ExtratorDeConteudo;
import extratores.ExtratorDeConteudoDaNasa;
import model.ClientHttp;
import model.Conteudo;
import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {

    public static void main(String[] args) throws Exception {



        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";


        //Envia a url via parâmetro para a classe ClientHttp que retorna uma string (body)
        ClientHttp httpClient = new ClientHttp();
        String json = httpClient.recebeBodyHttp(url);

        //Passando o json para o extratorDeConteudoDaNasa
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        List<Conteudo> listaDeConteudos = extrator.extraiConteudos(json);



        //Gerador do IMDB
       /* ExtratorDeConteudoDoIMDB extrator = new ExtratorDeConteudoDoIMDB();
        List<Conteudo> listaDeConteudos = extrator.extraiConteudos(json);*/



        var geradorDeFigurinhas = new GeradorDeFigurinhas();


        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = listaDeConteudos.get(i);

            String urlImagem = conteudo.getUrl();

            InputStream inputStream = new URL(urlImagem).openStream();

             String titulo = conteudo.getTitle();

             String nomeArquivo = conteudo.getTitle() + ".png";

           // 🌠 ☄  🚀 🌌
           geradorDeFigurinhas = new GeradorDeFigurinhas();
           geradorDeFigurinhas.cria(inputStream, nomeArquivo);

            System.out.println(nomeArquivo);
            System.out.println();


        }

    }


}


