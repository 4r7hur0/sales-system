package main.system.view;

import main.system.facade.SalesFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Screen extends Component implements Serializable {
    private SalesFacade facade = new SalesFacade();
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

        ImageIcon image = new ImageIcon("src/main/system/view/logo-uefs.png");
        Image sizeImage = image.getImage().getScaledInstance(120, 70, Image.SCALE_SMOOTH);//ajustando a imagem

        //cria um novo ImageIcon com a imagem redimensionada
        ImageIcon setTamImagem = new ImageIcon(sizeImage);
        JLabel labelRight = new JLabel(setTamImagem, JLabel.CENTER);

        containerLeft.add(new Label(""));
        containerLeft.add(labelLeft);
        containerCenter.add(labelCenter);
        containerRight.add(labelRight, BorderLayout.NORTH);

        //definindo botões para o Container da Esquerda
        JButton registerUser = new JButton("Cadastrar usuário");

        containerLeft.add(registerUser);

        registerUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
    }

    public void registerUser() {
        containerCenter.removeAll();
        containerCenter.setLayout(new GridLayout(7, 2, 10, 10));

        JLabel loginLabel = new JLabel("Digite o seu login:", SwingConstants.CENTER);
        JTextField loginField = new JTextField();
        containerCenter.add(loginLabel);
        containerCenter.add(loginField);

        JLabel nameLabel = new JLabel("Digite o seu nome:", SwingConstants.CENTER);
        JTextField nameField = new JTextField();
        containerCenter.add(nameLabel);
        containerCenter.add(nameField);

        JLabel passwordLabel = new JLabel("Digite a sua senha:", SwingConstants.CENTER);
        JTextField passwordField = new JTextField();
        containerCenter.add(passwordLabel);
        containerCenter.add(passwordField);

        JLabel emailLabel = new JLabel("Digite o seu email:", SwingConstants.CENTER);
        JTextField emailField = new JTextField();
        containerCenter.add(emailLabel);
        containerCenter.add(emailField);

        JLabel addressLabel = new JLabel("Digite o seu endereço:", SwingConstants.CENTER);
        JTextField addressField = new JTextField();
        containerCenter.add(addressLabel);
        containerCenter.add(addressField);

        JLabel paymentLabel = new JLabel("Digite a sua forma de pagamento:", SwingConstants.CENTER);
        JTextField paymentField = new JTextField();
        containerCenter.add(paymentLabel);
        containerCenter.add(paymentField);


        JLabel sendLabel = new JLabel("Verifique se está tudo correto antes de enviar", SwingConstants.CENTER);
        JButton sendButton = new JButton("Enviar");
        containerCenter.add(sendLabel);
        containerCenter.add(sendButton);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facade.registerUser(nameField.getText(), loginField.getText(), passwordField.getText(),
                        emailField.getText(), addressField.getText(), Integer.parseInt(paymentField.getText()));
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                containerCenter.removeAll();
                containerCenter.revalidate();
                containerCenter.repaint();
            }
        });

        containerCenter.revalidate();
        containerCenter.repaint();
    }

}