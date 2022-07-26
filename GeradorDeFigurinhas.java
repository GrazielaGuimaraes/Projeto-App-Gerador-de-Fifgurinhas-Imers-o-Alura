import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;



public class GeradorDeFigurinhas  {




    public void cria(InputStream inputStream, String nomeArquivo) throws  Exception{



        //InputStream inputStream = new FileInputStream(new File("entrada/imagem.jpg"));
        //inputStream = new URL("https://img.olhardigital.com.br/wp-content/uploads/2021/09/Chloe-meme-1024x586.jpg").openStream();

        //Ler a imagem original
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        //Pega a largura e altura da imagem original
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();

        //Acrescenta 200px a imagem original
        int novaAltura = altura + 200;

        // criar imagem em memória com fundo transparente passando a largura da imagem original e a nova altura(que possui + 200px)
        BufferedImage imagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);


        Graphics2D graphics2D = (Graphics2D) imagem.getGraphics();

        // colocar a imagem original na nova imagem
        graphics2D.drawImage(imagemOriginal, 0, 0, null);


        // verificando se a pasta local "saida" já existe
        File nomeDiretorio = new File("saida");
        if (!nomeDiretorio.exists()) {
            nomeDiretorio.mkdir(); //Cria, caso não exista
        }

        // Criando a fonte
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 100);

        graphics2D.setFont(font);
        graphics2D.setColor(Color.YELLOW);
        graphics2D.translate(0, 15);

        //Posição do texto
        float leftTexto = (imagem.getWidth() / 2) - 200;



        String texto = "Rolezera";


        graphics2D.drawString(texto, leftTexto, novaAltura - 100);



        //Gerando a figurinha
        ImageIO.write(imagem, "png", new File(nomeDiretorio + "/" +  nomeArquivo));




    }













}

