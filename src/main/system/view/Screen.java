package main.system.view;

import main.system.facade.SalesFacade;
import main.system.model.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
        JButton loginUser = new JButton("Fazer login");

        containerLeft.add(registerUser);
        containerLeft.add(loginUser);

        registerUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

        loginUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });

    }

    public void registerUser() {
        containerCenter.removeAll();
        containerCenter.setLayout(new GridLayout(3, 3, 10, 10));
        containerCenter.add(new JLabel());
        containerCenter.add(new JLabel());
        containerCenter.add(new JLabel());
        containerCenter.add(new JLabel());
        JPanel center = new JPanel(new GridLayout(2, 1, 10, 10));
        containerCenter.add(center);
        containerCenter.add(new JLabel());
        containerCenter.add(new JLabel());
        containerCenter.add(new JLabel());
        containerCenter.add(new JLabel());

        JButton btnSeller = new JButton("Cadastrar vendedor");
        JButton btnBuyer = new JButton("Cadastrar comprador");

        center.add(btnSeller);
        center.add(btnBuyer);

        btnSeller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                containerCenter.removeAll();
                containerCenter.setLayout(new GridLayout(6, 2, 10, 10));

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


                JLabel sendLabel = new JLabel("Verifique se está tudo correto antes de enviar", SwingConstants.CENTER);
                JButton sendButton = new JButton("Enviar");
                containerCenter.add(sendLabel);
                containerCenter.add(sendButton);

                sendButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        facade.registerUser(nameField.getText(), loginField.getText(), passwordField.getText(),
                                emailField.getText(), addressField.getText(), 0);
                        containerCenter.removeAll();
                        containerCenter.revalidate();
                        containerCenter.repaint();
                    }
                });

                containerCenter.revalidate();
                containerCenter.repaint();
            }
        });

        btnBuyer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                containerCenter.removeAll();
                containerCenter.setLayout(new GridLayout(6, 2, 10, 10));

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

                JLabel sendLabel = new JLabel("Verifique se está tudo correto antes de enviar", SwingConstants.CENTER);
                JButton sendButton = new JButton("Enviar");
                containerCenter.add(sendLabel);
                containerCenter.add(sendButton);

                sendButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        facade.registerUser(nameField.getText(), loginField.getText(), passwordField.getText(),
                                emailField.getText(), addressField.getText(), 1);
                        containerCenter.removeAll();
                        containerCenter.revalidate();
                        containerCenter.repaint();
                    }
                });

                containerCenter.revalidate();
                containerCenter.repaint();
            }
        });


        containerCenter.revalidate();
        containerCenter.repaint();
    }

    public void loginUser(){
        containerCenter.removeAll();
        containerCenter.revalidate();

        containerCenter.setLayout(new GridLayout(3, 3));
        containerCenter.add(new Label());//adicionando componente vazia para escrever somente no centro do grid
        containerCenter.add(new Label());
        containerCenter.add(new Label());
        containerCenter.add(new Label());
        Container center = new JPanel(new GridLayout(3, 2));
        containerCenter.add(center);
        containerCenter.add(new Label());
        containerCenter.add(new Label());
        containerCenter.add(new Label());
        containerCenter.add(new Label());


        JLabel loginLabel = new JLabel("Login:", SwingConstants.CENTER);
        JTextField loginField = new JTextField();
        center.add(loginLabel);
        center.add(loginField);

        JLabel senhaLabel = new JLabel("Senha:", SwingConstants.CENTER);
        JTextField senhaField = new JTextField();
        center.add(senhaLabel);
        center.add(senhaField);

        JLabel enviarLabel = new JLabel();
        JButton enviarButton = new JButton("Enviar");
        center.add(enviarLabel);
        center.add(enviarButton);

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    User user = facade.loginUser(loginField.getText(), senhaField.getText());
                    //container da esquerda, somente os botões disponíveis para o usuário logado
                    if (user instanceof Seller){
                        buttonsLeftSeller();
                    }
                    else {
                        buttonsLeftBuyer();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Login ou senha incorreta!");
                }
                containerCenter.removeAll();
                containerCenter.revalidate();
                containerCenter.repaint();
            }
        });

        containerCenter.revalidate();
        containerCenter.repaint();
    }

    public void buttonsLeftSeller(){
        containerLeft.removeAll();
        containerLeft.add(new JLabel("Vendedor: " + facade.getNameUser(), JLabel.CENTER));
        containerLeft.add(new JLabel());
        JLabel labelLeft = new JLabel("Selecione uma função: ", JLabel.CENTER);
        containerLeft.add(labelLeft);

        //definindo botões para o Container da Esquerda
        JButton registerUser = new JButton("Cadastrar usuário");
        JButton loginUser = new JButton("Fazer login");
        JButton registerProduct = new JButton("Cadastrar produto");
        JButton viewProducts = new JButton("Produtos à venda");
        JButton productsSold = new JButton("Produtos vendidos");

        containerLeft.add(registerUser);
        containerLeft.add(loginUser);
        containerLeft.add(registerProduct);
        containerLeft.add(viewProducts);
        containerLeft.add(productsSold);

        registerUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonsLeftSeller();
                registerUser();
            }
        });

        loginUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonsLeftSeller();
                loginUser();
            }
        });

        registerProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonsLeftSeller();
                selectType();
            }
        });

        viewProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonsLeftSeller();
                viewProductsSeller();
            }
        });

        productsSold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonsLeftSeller();
                productsSold();
            }
        });

        containerLeft.revalidate();
        containerLeft.repaint();
    }

    public void buttonsLeftBuyer() {
        containerLeft.removeAll();
        containerLeft.add(new JLabel("Comprador: " + facade.getNameUser(), JLabel.CENTER));
        containerLeft.add(new JLabel());
        JLabel labelLeft = new JLabel("Selecione uma função: ", JLabel.CENTER);
        containerLeft.add(labelLeft);

        //definindo botões para o Container da Esquerda
        JButton registerUser = new JButton("Cadastrar usuário");
        JButton loginUser = new JButton("Fazer login");
        JButton viewProducts = new JButton("Produtos à venda");
        JButton viewCart = new JButton("Carrinho");
        JButton viewOrders = new JButton("Pedidos");

        containerLeft.add(registerUser);
        containerLeft.add(loginUser);
        containerLeft.add(viewProducts);
        containerLeft.add(viewCart);
        containerLeft.add(viewOrders);

        registerUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonsLeftBuyer();
                registerUser();
            }
        });

        loginUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonsLeftBuyer();
                loginUser();
            }
        });

        viewProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonsLeftBuyer();
                viewProductsBuyer();
            }
        });

        viewCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonsLeftBuyer();
                viewCart();
            }
        });

        viewOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonsLeftBuyer();
                viewOrder();
            }
        });

        containerLeft.revalidate();
        containerLeft.repaint();
    }

    //1 = eletronico; 2 = roupa; 3 = comida
    public void registerProduct(int type) {
        containerCenter.removeAll();
        containerCenter.revalidate();

        containerCenter.setLayout(new GridLayout(3, 3));
        containerCenter.add(new Label());//adicionando componente vazia para escrever somente no centro do grid
        containerCenter.add(new Label());
        containerCenter.add(new Label());
        containerCenter.add(new Label());
        Container center = new JPanel(new GridLayout(4, 2));
        containerCenter.add(center);
        containerCenter.add(new Label());
        containerCenter.add(new Label());
        containerCenter.add(new Label());
        containerCenter.add(new Label());


        JLabel descResLabel = new JLabel("Descriçao:", SwingConstants.CENTER);
        JTextField descResField = new JTextField();
        center.add(descResLabel);
        center.add(descResField);

        JLabel pryceLabel = new JLabel("Preço da unidade:", SwingConstants.CENTER);
        JTextField pryceField = new JTextField();
        center.add(pryceLabel);
        center.add(pryceField);

        JLabel qtdLabel = new JLabel("Quantidade:", SwingConstants.CENTER);
        JTextField qtdField = new JTextField();
        center.add(qtdLabel);
        center.add(qtdField);

        JLabel enviarLabel = new JLabel();
        JButton enviarButton = new JButton("Enviar");
        center.add(enviarLabel);
        center.add(enviarButton);


        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (type == 1) {
                        facade.registerProduct("eletronic", descResField.getText(),
                                Double.parseDouble(pryceField.getText()), Integer.parseInt(qtdField.getText()));
                    }
                    if (type == 2) {
                        facade.registerProduct("clothing", descResField.getText(),
                                Double.parseDouble(pryceField.getText()), Integer.parseInt(qtdField.getText()));
                    }
                    if (type == 3) {
                        facade.registerProduct("food", descResField.getText(),
                                Double.parseDouble(pryceField.getText()), Integer.parseInt(qtdField.getText()));
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Informação incorreta sobre o produto!");
                }
                containerCenter.removeAll();
                containerCenter.revalidate();
                containerCenter.repaint();
            }
        });

        containerCenter.revalidate();
        containerCenter.repaint();
    }

    public void selectType() {
        containerCenter.removeAll();
        containerCenter.setLayout(new GridLayout(3, 3, 10, 10));
        containerCenter.add(new JLabel());
        containerCenter.add(new JLabel());
        containerCenter.add(new JLabel());
        containerCenter.add(new JLabel());
        JPanel center = new JPanel(new GridLayout(3, 1, 10, 10));
        containerCenter.add(center);
        containerCenter.add(new JLabel());
        containerCenter.add(new JLabel());
        containerCenter.add(new JLabel());
        containerCenter.add(new JLabel());

        JButton btneletronic = new JButton("Cadastrar do tipo eletrônico");
        JButton btnclothes = new JButton("Cadastrar do tipo roupa");
        JButton btnfood = new JButton("Cadastrar do tipo comida");

        center.add(btneletronic);
        center.add(btnclothes);
        center.add(btnfood);

        btneletronic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerProduct(1);
            }
        });

        btnclothes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerProduct(2);
            }
        });

        btnfood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerProduct(3);
            }
        });

        containerCenter.revalidate();
        containerCenter.repaint();
    }

    public void viewProductsSeller(){
        containerCenter.removeAll();
        containerCenter.setLayout(new GridLayout(3, 1)); // Layout ajustado para 3 linhas
        JLabel labelCenter = new JLabel("Produtos à venda", JLabel.CENTER);
        Font font = new Font("Serif", Font.BOLD, 35);
        labelCenter.setFont(font);
        labelCenter.setForeground(new Color(43, 169, 202));
        labelCenter.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        containerCenter.add(labelCenter);

        //criando um DefaultTableModel para armazenar os dados da tabela
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Categoria");
        tableModel.addColumn("Descrição");
        tableModel.addColumn("Preço");
        tableModel.addColumn("Quantidade");

        //lista para armazenar os produtos correspondentes às linhas da tabela
        List<Product> products = new ArrayList<>();


        for (Map.Entry<Product, Integer> entry : this.facade.getAllProducts().entrySet()) {
            String category = "";
            String desc;
            String pryce;

            if (entry.getKey() instanceof Electronics) {
                category = "Eletrônico";
            }
            if (entry.getKey() instanceof Clothes) {
                category = "Roupa";
            }
            if (entry.getKey() instanceof Foods) {
                category = "Comida";
            }

            Product product = entry.getKey();
            desc = product.getDescription();
            pryce = String.valueOf(product.getPrice());
            String quantity = String.valueOf(entry.getValue());

            tableModel.addRow(new Object[]{category, desc, pryce, quantity});
            products.add(product);
        }

        JTable table = new JTable(tableModel);
        table.setRowHeight(30);
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //capturar a seleção do usuário
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                buttonsLeftSeller();
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        Product selectedProduct = products.get(selectedRow);

                        containerLeft.add(new JLabel(""));
                        JButton btnRemoveProduct = new JButton("Remover produto selecionado");
                        containerLeft.add(btnRemoveProduct);

                        btnRemoveProduct.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //ainda falta criar o parâmetro para adicionar a quantidade do produto a ser removido
                                facade.removeProduct(selectedProduct);

                                viewProductsSeller(); //atualizar a página
                            }
                        });

                        containerLeft.repaint();
                        containerLeft.revalidate();
                    }
                }
            }
        });

        //adicionando o JTable em um JScrollPane e depois ao container
        JScrollPane scrollPane = new JScrollPane(table);
        containerCenter.add(scrollPane);

        containerCenter.revalidate();
        containerCenter.repaint();
    }

    public void viewProductsBuyer(){
        containerCenter.removeAll();
        containerCenter.setLayout(new GridLayout(3, 1)); // Layout ajustado para 3 linhas
        JLabel labelCenter = new JLabel("Produtos à venda", JLabel.CENTER);
        Font font = new Font("Serif", Font.BOLD, 35);
        labelCenter.setFont(font);
        labelCenter.setForeground(new Color(43, 169, 202));
        labelCenter.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        containerCenter.add(labelCenter);

        //criando um DefaultTableModel para armazenar os dados da tabela
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Categoria");
        tableModel.addColumn("Descrição");
        tableModel.addColumn("Preço");
        tableModel.addColumn("Quantidade");

        //lista para armazenar os produtos correspondentes às linhas da tabela
        List<Product> products = new ArrayList<>();


        for (Map.Entry<Product, Integer> entry : this.facade.getAllProducts().entrySet()) {
            String category = "";
            String desc;
            String pryce;

            if (entry.getKey() instanceof Electronics) {
                category = "Eletrônico";
            }
            if (entry.getKey() instanceof Clothes) {
                category = "Roupa";
            }
            if (entry.getKey() instanceof Foods) {
                category = "Comida";
            }

            Product product = entry.getKey();
            desc = product.getDescription();
            pryce = String.valueOf(product.getPrice());
            String quantity = String.valueOf(entry.getValue());

            tableModel.addRow(new Object[]{category, desc, pryce, quantity});
            products.add(product);
        }

        JTable table = new JTable(tableModel);
        table.setRowHeight(30);
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //capturar a seleção do usuário
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                buttonsLeftBuyer();
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        Product selectedProduct = products.get(selectedRow);

                        containerLeft.add(new JLabel(""));
                        JButton btnaddProduct = new JButton("Adicionar ao carrinho");
                        containerLeft.add(btnaddProduct);

                        btnaddProduct.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                facade.addInCart(selectedProduct);

                                viewProductsBuyer(); //atualizar a página
                            }
                        });

                        containerLeft.repaint();
                        containerLeft.revalidate();
                    }
                }
            }
        });

        //adicionando o JTable em um JScrollPane e depois ao container
        JScrollPane scrollPane = new JScrollPane(table);
        containerCenter.add(scrollPane);

        containerCenter.revalidate();
        containerCenter.repaint();
    }

    public void viewCart(){
        containerCenter.removeAll();
        containerCenter.setLayout(new GridLayout(3, 1)); // Layout ajustado para 3 linhas
        JLabel labelCenter = new JLabel("Carrinho", JLabel.CENTER);
        Font font = new Font("Serif", Font.BOLD, 35);
        labelCenter.setFont(font);
        labelCenter.setForeground(new Color(43, 169, 202));
        labelCenter.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        containerCenter.add(labelCenter);

        HashMap<String, String[]> list = new HashMap<>();
        list.put("Categoria 1", new String[]{"Descrição 1", "10.0", "5"});
        list.put("Categoria 2", new String[]{"Descrição 2", "20.0", "3"});
        list.put("Categoria 3", new String[]{"Descrição 3", "15.0", "8"});



        //criando um DefaultTableModel para armazenar os dados da tabela
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Categoria");
        tableModel.addColumn("Descrição");
        tableModel.addColumn("Preço");
        tableModel.addColumn("Quantidade");

        //lista para armazenar os produtos correspondentes às linhas da tabela
        List<Product> products = new ArrayList<>();


        for (Map.Entry<Product, Integer> entry : this.facade.viewCart().entrySet()) {
            String category = "";
            String desc;
            String pryce;

            if (entry.getKey() instanceof Electronics) {
                category = "Eletrônico";
            }
            if (entry.getKey() instanceof Clothes) {
                category = "Roupa";
            }
            if (entry.getKey() instanceof Foods) {
                category = "Comida";
            }

            Product product = entry.getKey();
            desc = product.getDescription();
            pryce = String.valueOf(product.getPrice());
            String quantity = String.valueOf(entry.getValue());

            tableModel.addRow(new Object[]{category, desc, pryce, quantity});
            products.add(product);
        }

        JTable table = new JTable(tableModel);
        table.setRowHeight(30);
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //capturar a seleção do usuário
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                buttonsLeftBuyer();
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        Product selectedProduct = products.get(selectedRow);

                        containerLeft.add(new JLabel(""));
                        JButton btnRemoveProduct = new JButton("Remover produto selecionado");
                        containerLeft.add(btnRemoveProduct);

                        btnRemoveProduct.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                facade.removeProductCart(selectedProduct);
                                viewCart(); //atualizar a página
                            }
                        });

                        containerLeft.repaint();
                        containerLeft.revalidate();
                    }
                }
            }
        });

        //adicionando o JTable em um JScrollPane e depois ao container
        JScrollPane scrollPane = new JScrollPane(table);
        containerCenter.add(scrollPane);

        //grid para mostrar o preço total e também pode ser usado para mostrar os botões
        JPanel gridHeader = new JPanel(new GridLayout(5, 1));
        gridHeader.add(new JLabel("Preço total: " + facade.getTotalPrice()));
        JButton btnOrder = new JButton("Finalizar pedido");
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!facade.viewCart().isEmpty()){
                    facade.order();
                    paymentMethod();
                }
            }
        });
        gridHeader.add(new JLabel());
        gridHeader.add(new JLabel());
        gridHeader.add(new JLabel());
        gridHeader.add(btnOrder);
        containerCenter.add(gridHeader);

        containerCenter.revalidate();
        containerCenter.repaint();
    }

    public void viewOrder() {
        containerCenter.removeAll();
        containerCenter.setLayout(new GridLayout(3, 1));
        JLabel labelCenter = new JLabel("Pedidos", JLabel.CENTER);
        Font font = new Font("Serif", Font.BOLD, 35);
        labelCenter.setFont(font);
        labelCenter.setForeground(new Color(43, 169, 202));
        labelCenter.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        containerCenter.add(labelCenter);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Categoria");
        tableModel.addColumn("Descrição");
        tableModel.addColumn("Preço");
        tableModel.addColumn("Quantidade");
        tableModel.addColumn("Status");

        List<Product> products = new ArrayList<>();

        Iterator<Order> iterator = this.facade.viewOrder();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            Order.OrderStatus status = order.getStatus();

            for (Map.Entry<Product, Integer> entry : order.getItems().entrySet()) {
                String category = "";
                String desc;
                String pryce;
                int quantity;

                if (entry.getKey() instanceof Electronics) {
                    category = "Eletrônico";
                }
                if (entry.getKey() instanceof Clothes) {
                    category = "Roupa";
                }
                if (entry.getKey() instanceof Foods) {
                    category = "Comida";
                }

                Product product = entry.getKey();
                desc = product.getDescription();
                pryce = String.valueOf(product.getPrice());
                quantity = entry.getValue();

                tableModel.addRow(new Object[]{category, desc, pryce, quantity, status});
                products.add(product);
            }
        }

        JTable table = new JTable(tableModel);
        table.setRowHeight(30);
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JScrollPane scrollPane = new JScrollPane(table);
        containerCenter.add(scrollPane);

        containerCenter.revalidate();
        containerCenter.repaint();
    }

    public void paymentMethod() {
        containerCenter.removeAll();
        containerCenter.setLayout(new GridLayout(3, 3, 10, 10));
        containerCenter.add(new JLabel());
        containerCenter.add(new JLabel("Forma de pagamento", JLabel.CENTER));
        containerCenter.add(new JLabel());
        containerCenter.add(new JLabel());
        JPanel center = new JPanel(new GridLayout(3, 1, 10, 10));
        containerCenter.add(center);
        containerCenter.add(new JLabel());
        containerCenter.add(new JLabel());
        containerCenter.add(new JLabel());
        containerCenter.add(new JLabel());

        JButton btnCredit = new JButton("Cartão de crédito");
        JButton btnPayPal = new JButton("PayPal");
        JButton btnBank = new JButton("Transferência bancária");

        center.add(btnCredit);
        center.add(btnPayPal);
        center.add(btnBank);

        btnCredit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paymentCredit();
            }
        });

        btnPayPal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                payPal();
            }
        });

        btnBank.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bankTransfer();
            }
        });

        containerCenter.revalidate();
        containerCenter.repaint();
    }

    public void paymentCredit() {
        containerCenter.removeAll();
        containerCenter.revalidate();

        containerCenter.setLayout(new GridLayout(3, 3));
        containerCenter.add(new Label());//adicionando componente vazia para escrever somente no centro do grid
        containerCenter.add(new Label());
        containerCenter.add(new Label());
        containerCenter.add(new Label());
        Container center = new JPanel(new GridLayout(4, 2));
        containerCenter.add(center);
        containerCenter.add(new Label());
        containerCenter.add(new Label());
        containerCenter.add(new Label());
        containerCenter.add(new Label());


        JLabel numLabel = new JLabel("Número do cartão:", SwingConstants.CENTER);
        JTextField numField = new JTextField();
        center.add(numLabel);
        center.add(numField);

        JLabel nameLabel = new JLabel("Nome do proprietário:", SwingConstants.CENTER);
        JTextField nameField = new JTextField();
        center.add(nameLabel);
        center.add(nameField);

        JLabel cvvLabel = new JLabel("cvv:", SwingConstants.CENTER);
        JTextField cvvField = new JTextField();
        center.add(cvvLabel);
        center.add(cvvField);

        JLabel enviarLabel = new JLabel();
        JButton enviarButton = new JButton("Enviar");
        center.add(enviarLabel);
        center.add(enviarButton);

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    facade.credit(numField.getText(), nameField.getText(), cvvField.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Incorreta!");
                }
                containerCenter.removeAll();
                containerCenter.revalidate();
                containerCenter.repaint();
            }
        });

        containerCenter.revalidate();
        containerCenter.repaint();
    }

    public void payPal() {
        containerCenter.removeAll();
        containerCenter.revalidate();

        containerCenter.setLayout(new GridLayout(3, 3));
        containerCenter.add(new Label());//adicionando componente vazia para escrever somente no centro do grid
        containerCenter.add(new Label());
        containerCenter.add(new Label());
        containerCenter.add(new Label());
        Container center = new JPanel(new GridLayout(4, 2));
        containerCenter.add(center);
        containerCenter.add(new Label());
        containerCenter.add(new Label());
        containerCenter.add(new Label());
        containerCenter.add(new Label());


        JLabel emailLabel = new JLabel("Email:", SwingConstants.CENTER);
        JTextField emailField = new JTextField();
        center.add(emailLabel);
        center.add(emailField);

        JLabel enviarLabel = new JLabel();
        JButton enviarButton = new JButton("Enviar");
        center.add(enviarLabel);
        center.add(enviarButton);

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    facade.payPal(emailField.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Incorreta!");
                }
                containerCenter.removeAll();
                containerCenter.revalidate();
                containerCenter.repaint();
            }
        });

        containerCenter.revalidate();
        containerCenter.repaint();
    }

    public void bankTransfer() {
        containerCenter.removeAll();
        containerCenter.revalidate();

        containerCenter.setLayout(new GridLayout(3, 3));
        containerCenter.add(new Label());//adicionando componente vazia para escrever somente no centro do grid
        containerCenter.add(new Label());
        containerCenter.add(new Label());
        containerCenter.add(new Label());
        Container center = new JPanel(new GridLayout(4, 2));
        containerCenter.add(center);
        containerCenter.add(new Label());
        containerCenter.add(new Label());
        containerCenter.add(new Label());
        containerCenter.add(new Label());


        JLabel numLabel = new JLabel("Conta bancária:", SwingConstants.CENTER);
        JTextField numField = new JTextField();
        center.add(numLabel);
        center.add(numField);

        JLabel agLabel = new JLabel("Agência:", SwingConstants.CENTER);
        JTextField agField = new JTextField();
        center.add(agLabel);
        center.add(agField);

        JLabel nameLabel = new JLabel("Nome do proprietário:", SwingConstants.CENTER);
        JTextField nameField = new JTextField();
        center.add(nameLabel);
        center.add(nameField);

        JLabel enviarLabel = new JLabel();
        JButton enviarButton = new JButton("Enviar");
        center.add(enviarLabel);
        center.add(enviarButton);

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    facade.bankTransfer(numField.getText(), agField.getText(), nameField.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Incorreta!");
                }
                containerCenter.removeAll();
                containerCenter.revalidate();
                containerCenter.repaint();
            }
        });

        containerCenter.revalidate();
        containerCenter.repaint();
    }

    public void productsSold() {
        containerCenter.removeAll();
        containerCenter.setLayout(new GridLayout(3, 1));
        JLabel labelCenter = new JLabel("Produtos vendidos", JLabel.CENTER);
        Font font = new Font("Serif", Font.BOLD, 35);
        labelCenter.setFont(font);
        labelCenter.setForeground(new Color(43, 169, 202));
        labelCenter.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        containerCenter.add(labelCenter);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Preço Total");
        tableModel.addColumn("Quantidade");
        tableModel.addColumn("Status");
        tableModel.addColumn("Ação");

        List<Order> orders = new ArrayList<>();

        Iterator<Order> iterator = this.facade.viewAllOrders();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            Order.OrderStatus status = order.getStatus();

            double totalPrice = 0;
            int totalQuantity = 0;

            for (Map.Entry<Product, Integer> entry : order.getItems().entrySet()) {
                totalPrice += entry.getKey().getPrice() * entry.getValue();
                totalQuantity += entry.getValue();
            }

            tableModel.addRow(new Object[]{totalPrice, totalQuantity, status, "Clique para alterar os status"});
            orders.add(order);
        }

        JTable table = new JTable(tableModel);
        table.setRowHeight(30);
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //capturar a seleção do usuário
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                buttonsLeftSeller();
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        Order selectedOrder = orders.get(selectedRow);
                        facade.modifyStatus(selectedOrder);
                        productsSold();
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        containerCenter.add(scrollPane);

        containerCenter.revalidate();
        containerCenter.repaint();
    }

}