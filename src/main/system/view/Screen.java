package main.system.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Screen extends Component implements Serializable {
    private Container containerCenter;
    private Container containerLeft;
    private Container containerRight;
    private JTextArea textArea;


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Screen();
    }

    public Screen() throws IOException, ClassNotFoundException {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setTitle("Loja virtual");
        jFrame.setSize(1300, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Container container = new JPanel(new BorderLayout());
        containerCenter = new JPanel(new GridLayout(7, 2, 10, 10));
        containerLeft = new JPanel(new GridLayout(19, 1));
        containerRight = new JPanel(new BorderLayout());
        textArea = new JTextArea();

        jFrame.setContentPane(container);

        //setando cores para cada container
        containerCenter.setBackground(Color.white);
        containerLeft.setBackground(new Color(107, 178, 197));
        containerRight.setBackground(Color.white);

        //definindo a posição de cada container
        container.add(containerLeft, BorderLayout.WEST);
        container.add(containerCenter, BorderLayout.CENTER);
        container.add(containerRight, BorderLayout.EAST);

        JLabel labelLeft = new JLabel("Selecione uma função: ", JLabel.CENTER);
        JLabel labelCenter = new JLabel("Loja virtual", JLabel.CENTER);
        Font font = new Font("Serif", Font.BOLD, 35);
        labelCenter.setFont(font);
        labelCenter.setForeground(new Color(43, 169, 202));
        labelCenter.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        ImageIcon imagem = new ImageIcon("src/main/system/view/logo-uefs.png");
        Image tamImagem = imagem.getImage().getScaledInstance(120, 70, Image.SCALE_SMOOTH);//ajustando a imagem

        //cria um novo ImageIcon com a imagem redimensionada
        ImageIcon setTamImagem = new ImageIcon(tamImagem);
        JLabel labelRight = new JLabel(setTamImagem, JLabel.CENTER);

        containerLeft.add(new Label(""));
        containerLeft.add(labelLeft);
        containerCenter.add(labelCenter);
        containerRight.add(labelRight, BorderLayout.NORTH);

        //definindo botões para o Container da Esquerda
        JButton cadastrarUsuario = new JButton("Cadastrar usuário");
        JButton fazerLogin = new JButton("Fazer login");
        JButton cadastrarProduto = new JButton("Cadastrar produto");
        JButton cadastrarLeilao = new JButton("Cadastrar leilao");
        JButton iniciarLeilao = new JButton("Iniciar leilao manual");
        JButton encerrarLeilao = new JButton("Encerrar leilao manual");
        JButton participarLeilao = new JButton("Participar de um leilao");
        JButton darLance = new JButton("Dar lance");
        JButton darLanceMinimo = new JButton("Dar lance minimo");
        JButton listarUsuarios = new JButton("Listar todos os usuários");
        JButton listarProdutos = new JButton("Listar todos os produtos");
        JButton listarLeiloes = new JButton("Listar todos os leilões");
        JButton listarLances = new JButton("Abrir envelopes Leilão A. Fechado");
        JButton leiloesEmUmPeriodo = new JButton("Listar leilões de um período.");
        JButton salvar = new JButton("Salvar arquivo");
        JButton carregar = new JButton("Carregar arquivo");
        JButton userLogado = new JButton("Usuário logado");

        containerLeft.add(cadastrarUsuario);
        containerLeft.add(fazerLogin);
        containerLeft.add(cadastrarProduto);
        containerLeft.add(cadastrarLeilao);
        containerLeft.add(iniciarLeilao);
        containerLeft.add(encerrarLeilao);
        containerLeft.add(participarLeilao);
        containerLeft.add(darLance);
        containerLeft.add(darLanceMinimo);
        containerLeft.add(listarUsuarios);
        containerLeft.add(listarProdutos);
        containerLeft.add(listarLeiloes);
        containerLeft.add(listarLances);
        containerLeft.add(leiloesEmUmPeriodo);
        containerLeft.add(salvar);
        containerLeft.add(carregar);
        containerLeft.add(userLogado);

    }

    //Fazer cadastro de usuário, onde no cadastro será selecionado se ele é comprador ou vendedor
    //login
    //senha
    //email
    //metodo de pagamento

}