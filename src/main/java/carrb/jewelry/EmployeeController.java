package carrb.jewelry;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import static carrb.jewelry.Common.driverUrl;
import static carrb.jewelry.Common.serverUrl;

public class EmployeeController {

    @FXML
    private TextField IDMerchField;

    @FXML
    private RadioButton IDMerchRadio;

    @FXML
    private TableColumn<?, ?> IDmerchColumn;

    @FXML
    private Button addMerchButton;

    @FXML
    private TextField birthdateClientField;

    @FXML
    private Button calculateButton;

    @FXML
    private Button clearFields;

    @FXML
    private TextField clientPhoneField;

    @FXML
    private RadioButton clientPhoneRadio;
    @FXML
    private RadioButton descriptionMerchRadio;

    @FXML
    private TableColumn<?, ?> descriptionMerchColumn;

    @FXML
    private TextField descriptionMerchField;

    @FXML
    private TextField discountField;

    @FXML
    private TextField emailClientField;

    @FXML
    private Button findMerchButton;



    @FXML
    private TextField firstMerchField;

    @FXML
    private RadioButton firstMerchRadio;

    @FXML
    private TextField fourthMerchField;

    @FXML
    private RadioButton fourthMerchRadio;

    @FXML
    private Button getReturnButton;

    @FXML
    private TextField goodsSumField;

    @FXML
    private TextField idPurchaseField;

    @FXML
    private TableColumn<?, ?> manufacturerMerchColumn;

    @FXML
    private TextField manufacturerMerchField;

    @FXML
    private RadioButton manufacturerMerchRadio;

    @FXML
    private TableColumn<?, ?> materialMerchColumn;

    @FXML
    private TextField materialMerchField;

    @FXML
    private RadioButton materialMerchRadio;

    @FXML
    private TableView<merchandiseTable> merchandiseTableView;

    @FXML
    private Label merchandiseWarningLabel;

    @FXML
    private TableColumn<?, ?> modelMerchColumn;

    @FXML
    private TextField modelMerchField;

    @FXML
    private RadioButton modelMerchRadio;

    @FXML
    private TextField nameClientField;

    @FXML
    private TextField phoneRegisterClientField;

    @FXML
    private TableColumn<?, ?> priceMerchColumn;

    @FXML
    private TextField priceMerchField;

    @FXML
    private RadioButton priceMerchRadio;

    @FXML
    private Label purchaseWarningLabel;

    @FXML
    private Button pushPurchase;

    @FXML
    private TableColumn<?, ?> quantMerchColumn;

    @FXML
    private TextField quantMerchField;

    @FXML
    private Button registerClientButton;

    @FXML
    private TableColumn<?, ?> sampleMerchColumn;

    @FXML
    private TextField sampleMerchField;

    @FXML
    private TextField secondMerchField;

    @FXML
    private RadioButton secondMerchRadio;

    @FXML
    private TextField secondNameClientField;

    @FXML
    private Button stopFilterMerchButton;

    @FXML
    private TextField sumPurchaseField;

    @FXML
    private TextField surnameClientField;

    @FXML
    private TextField thirdMerchField;

    @FXML
    private RadioButton thirdMerchRadio;

    @FXML
    private TextField totalSumField;

    @FXML
    private TableColumn<?, ?> typeMerchColumn;

    @FXML
    private TextField typeMerchField;

    @FXML
    private RadioButton typeMerchRadio;

    @FXML
    private TableColumn<?, ?> warrantyMerchColumn;

    @FXML
    private TextField warrantyMerchField;

    @FXML
    private RadioButton warrantyMerchRadio;

    @FXML
    private TableColumn<?, ?> weightMerchColumn;

    @FXML
    private TextField weightMerchField;
    ObservableList<merchandiseTable> merchandiseTableData = FXCollections.observableArrayList();
    float discount;
    int goodsSum;
    int goodsQuant;
    String idClient;

    @FXML
    void initialize() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        merhShower("full");
        addMerchButton.setOnAction(actionEvent -> {
            merchandiseWarningLabel.setText("");
            if (manufacturerMerchField.getText().length() >= 4 &
            modelMerchField.getText().length() >= 4 & typeMerchField.getText().length() >= 4 &
            materialMerchField.getText().length() >= 4 & sampleMerchField.getText().length() >= 3 &
            weightMerchField.getText() != null & warrantyMerchField.getText().length() >= 2 &
            priceMerchField.getText().length() >= 3 & quantMerchField.getText() != null &
            descriptionMerchField.getText().length() >= 1){
                try {
                    fillMerchTable();
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
                         InvocationTargetException | NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
            } else {
                merchandiseWarningLabel.setText("?????? ???????? ???????????? ???????? ??????????????????!");
            }
        });

            findMerchButton.setOnAction(actionEvent -> {
                if (IDMerchRadio.isSelected() & IDMerchField.getText() != null){
                    try {
                        merhShower("id");
                        IDMerchRadio.fire();
                        IDMerchField.setText("");
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                             InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (manufacturerMerchRadio.isSelected() & manufacturerMerchField.getText() != null){
                    try {
                        merhShower("manufacturer");
                        manufacturerMerchField.setText("");
                        manufacturerMerchRadio.fire();
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                             InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (warrantyMerchRadio.isSelected() & warrantyMerchField.getText() != null){
                    try {
                        merhShower("warranty");
                        warrantyMerchField.setText("");
                        warrantyMerchRadio.fire();
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                             InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (typeMerchRadio.isSelected() & typeMerchField.getText() != null){
                    try {
                        merhShower("type");
                        typeMerchField.setText("");
                        typeMerchRadio.fire();
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                             InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (materialMerchRadio.isSelected() & materialMerchField.getText() != null){
                    try {
                        merhShower("material");
                        materialMerchField.setText("");
                        materialMerchRadio.fire();
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                             InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (modelMerchRadio.isSelected() & modelMerchField.getText() != null){
                    try {
                        merhShower("model");
                        modelMerchField.setText("");
                        modelMerchRadio.fire();
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                             InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (priceMerchRadio.isSelected() & priceMerchField.getText() != null){
                    try {
                        merhShower("price");
                        priceMerchField.setText("");
                        priceMerchRadio.fire();
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                             InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (descriptionMerchRadio.isSelected() & descriptionMerchField.getText() != null){
                    try {
                        merhShower("description");
                        descriptionMerchRadio.fire();
                        descriptionMerchField.setText("");
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                             InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

        stopFilterMerchButton.setOnAction(actionEvent -> {
            try {
                merhShower("full");
            } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                     InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });

        registerClientButton.setOnAction(actionEvent -> {
            purchaseWarningLabel.setText("");
            if (surnameClientField.getText().length() >= 3 & nameClientField.getText().length() >= 3 &
                    birthdateClientField.getText().matches("^(((2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$") &
                phoneRegisterClientField.getText().matches("[+][7][0-9]{10}") & emailClientField.getText().contains("@")){
                try {
                    addNewClient();
                } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                         InstantiationException | IllegalAccessException | SQLException e) {
                    throw new RuntimeException(e);
                }
            } else {
                purchaseWarningLabel.setText("???????? ???????????? ???????? ??????????????????!");
            }
        });
        clearFields.setOnAction(actionEvent -> {
            merchFieldCleaner();
        });
        calculateButton.setOnAction(actionEvent -> {
            goodsQuant = 0;
            discount = 0;
            if (firstMerchField.getText().length() >= 1 & firstMerchRadio.isSelected() &
                    secondMerchField.getText().length() >= 1 & secondMerchRadio.isSelected() &
                    thirdMerchField.getText().length() >= 1 & thirdMerchRadio.isSelected() &
                    fourthMerchField.getText().length() >= 1 & fourthMerchRadio.isSelected()){
                try {
                    purchaseProcess("fourMerches");
                } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                         InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            } else if (firstMerchField.getText().length() >= 1 & firstMerchRadio.isSelected() &
                    secondMerchField.getText().length() >= 1 & secondMerchRadio.isSelected() &
                    thirdMerchField.getText().length() >= 1 & thirdMerchRadio.isSelected()) {
                try {
                    purchaseProcess("threeMerches");
                } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                         InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            } else if (firstMerchField.getText().length() >= 1 & firstMerchRadio.isSelected() &
                    secondMerchField.getText().length() >= 1 & secondMerchRadio.isSelected()) {
                try {
                    purchaseProcess("twoMerches");
                } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                         InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            } else if (firstMerchField.getText().length() >= 1  & firstMerchRadio.isSelected()) {
                try {
                    purchaseProcess("oneMerch");
                } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                         InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        pushPurchase.setOnAction(actionEvent -> {
            try {
                newPurchase();
            } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                     InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

    void newPurchase() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Class.forName(driverUrl).getDeclaredConstructor().newInstance();
        try (Connection connection = DriverManager.getConnection(serverUrl)) {
            PreparedStatement statement;
            switch (goodsQuant){
                case 1:
                    statement = connection.prepareStatement("update merchandise set quantInStok = quantInStok - 1 where idMerchandise = '"
                            + firstMerchField.getText() + "'");
                    statement.executeLargeUpdate();
                    break;
                case 2:
                    statement = connection.prepareStatement("update merchandise set quantInStok = quantInStok - 1 where idMerchandise = '"
                            + firstMerchField.getText() + "'");
                    statement.executeLargeUpdate();
                    statement = connection.prepareStatement("update merchandise set quantInStok = quantInStok - 1 where idMerchandise = '"
                            + secondMerchField.getText() + "'");
                    statement.executeLargeUpdate();
                    break;
                case 3:
                    statement = connection.prepareStatement("update merchandise set quantInStok = quantInStok - 1 where idMerchandise = '"
                            + firstMerchField.getText() + "'");
                    statement.executeLargeUpdate();
                    statement = connection.prepareStatement("update merchandise set quantInStok = quantInStok - 1 where idMerchandise = '"
                            + secondMerchField.getText() + "'");
                    statement.executeLargeUpdate();
                    statement = connection.prepareStatement("update merchandise set quantInStok = quantInStok - 1 where idMerchandise = '"
                            + thirdMerchField.getText() + "'");
                    statement.executeLargeUpdate();
                    break;
                case 4:
                    statement = connection.prepareStatement("update merchandise set quantInStok = quantInStok - 1 where idMerchandise = '"
                            + firstMerchField.getText() + "'");
                    statement.executeLargeUpdate();
                    statement = connection.prepareStatement("update merchandise set quantInStok = quantInStok - 1 where idMerchandise = '"
                            + secondMerchField.getText() + "'");
                    statement.executeLargeUpdate();
                    statement = connection.prepareStatement("update merchandise set quantInStok = quantInStok - 1 where idMerchandise = '"
                            + thirdMerchField.getText() + "'");
                    statement.executeLargeUpdate();
                    statement = connection.prepareStatement("update merchandise set quantInStok = quantInStok - 1 where idMerchandise = '"
                            + fourthMerchField.getText() + "'");
                    statement.executeLargeUpdate();
                    break;
            }
            if (clientPhoneField.getText().matches("[+][7][0-9]{10}") & clientPhoneRadio.isSelected()){
                statement = connection.prepareStatement("update client set totalOrdersSum = totalOrdersSum + '"
                        + Float.parseFloat(totalSumField.getText()) + "'" +" where phone = '" + clientPhoneField.getText() + "'");
                statement.executeLargeUpdate();
                statement = connection.prepareStatement("insert into purchase VALUES (((SELECT COUNT(*) FROM purchase) + 1), ?, ?, " +
                        "(select idClient from client where phone = ?), (select idEmployee from employee where phone = ?), " +
                        "(SELECT CAST(GETDATE() AS DATE)))");
                statement.setInt(1, Integer.parseInt(firstMerchField.getText()));
                statement.setFloat(2, Float.parseFloat(totalSumField.getText()));
                statement.setString(3, clientPhoneField.getText());
                statement.setString(4, Authorization.authorizedPhone);
            } else {
                statement = connection.prepareStatement("insert into purchase VALUES (((SELECT COUNT(*) FROM purchase) + 1), ?, ?, " +
                        "0, (select idEmployee from employee where phone = ?), " +
                        "(SELECT CAST(GETDATE() AS DATE)))");
                statement.setInt(1, Integer.parseInt(firstMerchField.getText()));
                statement.setFloat(2, Float.parseFloat(totalSumField.getText()));
                statement.setString(3, Authorization.authorizedPhone);
            }
            statement.executeLargeUpdate();
            merchFieldCleaner();
        } catch (SQLException e){
            e.printStackTrace();
            purchaseWarningLabel.setText("???????????? ?????? ???????????????? ????????????!");
        }
    }

    void merhShower(String command) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        merchandiseTableData.clear();
        Class.forName(driverUrl).getDeclaredConstructor().newInstance();
        try (Connection connection = DriverManager.getConnection(serverUrl)) {
            Statement statement = connection.createStatement();
            // ?????????????? "??????????????????????"
            ResultSet resultSet = null;
            switch (command) {
                case "id":
                    resultSet = statement.executeQuery("select * from merchandise where idMerchandise ='" + IDMerchField.getText() + "'");
                    break;
                case "manufacturer":
                    resultSet = statement.executeQuery("select * from merchandise where manufacturer ='"
                            + manufacturerMerchField.getText() + "'");
                    break;
                case "warranty":
                    resultSet = statement.executeQuery("select * from merchandise where warrantyPeriod like '%"
                            + warrantyMerchField.getText() + "'");
                    break;
                case "type":
                    resultSet = statement.executeQuery("select * from merchandise where type like '%"
                            + typeMerchField.getText() + "'");
                    break;
                case "material":
                    resultSet = statement.executeQuery("select * from merchandise where material like '%"
                            + materialMerchField.getText() + "%'");
                    break;
                case "model":
                    resultSet = statement.executeQuery("select * from merchandise where model like '%"
                            + modelMerchField.getText() + "'");
                    break;
                case "price":
                    resultSet = statement.executeQuery("select * from merchandise where price ='"
                            + priceMerchField.getText() + "'");
                    break;
                case "description":
                    resultSet = statement.executeQuery("select * from merchandise where like '%"
                            + descriptionMerchField.getText() + "'");
                    break;
                case "full":
                    resultSet = statement.executeQuery("select * from merchandise order by idMerchandise");
                    break;
            }
            while (true) {
                assert resultSet != null;
                if (!resultSet.next()) break;
                merchandiseTableData.add(new merchandiseTable(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6), resultSet.getString(7), resultSet.getString(8),
                        resultSet.getString(9), resultSet.getString(10), resultSet.getString(11)));
                IDmerchColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
                manufacturerMerchColumn.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
                modelMerchColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
                typeMerchColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
                materialMerchColumn.setCellValueFactory(new PropertyValueFactory<>("material"));
                sampleMerchColumn.setCellValueFactory(new PropertyValueFactory<>("sample"));
                weightMerchColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
                warrantyMerchColumn.setCellValueFactory(new PropertyValueFactory<>("warranty"));
                priceMerchColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
                quantMerchColumn.setCellValueFactory(new PropertyValueFactory<>("quantOnStok"));
                descriptionMerchColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
                merchandiseTableView.setItems(merchandiseTableData);
            }
        } catch (SQLException e) {
            merchandiseWarningLabel.setText("???????????? ?????? ????????????!");
            throw new RuntimeException(e);
        }
    }

    void purchaseProcess (String input) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        goodsSum = 0;
        try (Connection connection = DriverManager.getConnection(serverUrl)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            switch (input){
                case "oneMerch":
                    resultSet = statement.executeQuery("select price from merchandise where idMerchandise = '" +
                            firstMerchField.getText() + "'");
                    resultSet.next();
                    goodsSumField.setText(String.valueOf(resultSet.getInt(1)));
                    getDiscountInOrder();
                    firstMerchField.setEditable(false);
                    goodsQuant = 1;
                    break;
                case "twoMerches":
                    resultSet = statement.executeQuery("select price from merchandise where idMerchandise = '" + firstMerchField.getText() + "'");
                    resultSet.next();
                    goodsSum += resultSet.getInt(1);
                    resultSet = statement.executeQuery("select price from merchandise where idMerchandise = '" + secondMerchField.getText() + "'");
                    resultSet.next();
                    goodsSum += resultSet.getInt(1);
                    goodsSumField.setText(String.valueOf(goodsSum));
                    getDiscountInOrder();
                    firstMerchField.setEditable(false);
                    secondMerchField.setEditable(false);
                    goodsQuant = 2;
                    break;
                case "threeMerches":
                    resultSet = statement.executeQuery("select price from merchandise where idMerchandise = '" + firstMerchField.getText() + "'");
                    resultSet.next();
                    goodsSum += resultSet.getInt(1);
                    resultSet = statement.executeQuery("select price from merchandise where idMerchandise = '" + secondMerchField.getText() + "'");
                    resultSet.next();
                    goodsSum += resultSet.getInt(1);
                    resultSet = statement.executeQuery("select price from merchandise where idMerchandise = '" + thirdMerchField.getText() + "'");
                    resultSet.next();
                    goodsSum += resultSet.getInt(1);
                    goodsSumField.setText(String.valueOf(goodsSum));
                    getDiscountInOrder();
                    firstMerchField.setEditable(false);
                    secondMerchField.setEditable(false);
                    thirdMerchField.setEditable(false);
                    goodsQuant = 3;
                    break;
                case "fourMerches":
                    resultSet = statement.executeQuery("select price from merchandise where idMerchandise = '" + firstMerchField.getText() + "'");
                    resultSet.next();
                    goodsSum += resultSet.getInt(1);
                    resultSet = statement.executeQuery("select price from merchandise where idMerchandise = '" + secondMerchField.getText() + "'");
                    resultSet.next();
                    resultSet = statement.executeQuery("select price from merchandise where idMerchandise = '" + thirdMerchField.getText() + "'");
                    resultSet.next();
                    goodsSum += resultSet.getInt(1);
                    resultSet = statement.executeQuery("select price from merchandise where idMerchandise = '" + fourthMerchField.getText() + "'");
                    resultSet.next();
                    goodsSum += resultSet.getInt(1);
                    goodsSumField.setText(String.valueOf(goodsSum));
                    getDiscountInOrder();
                    firstMerchField.setEditable(false);
                    secondMerchField.setEditable(false);
                    thirdMerchField.setEditable(false);
                    fourthMerchField.setEditable(false);
                    goodsQuant = 4;
                    break;
            }
        } catch (SQLException e) {
            purchaseWarningLabel.setText("???????????? ?????? ????????????????????!");
            merchFieldCleaner();
            throw new RuntimeException(e);
        }
        getReturnButton.setOnAction(actionEvent -> {
            if (idPurchaseField.getText() != null){
                try {
                    findPurchase();
                    System.out.println("??????????????");
                } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                         InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });


    }

        void findPurchase() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
                InstantiationException, IllegalAccessException {
            Class.forName(driverUrl).getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(serverUrl)) {
                Statement statement = connection.createStatement();
                // ?????????????? "??????????????????????"
                ResultSet resultSet;
                resultSet = statement.executeQuery("select paySum, client from purchase where idPurchase = '"
                        + idPurchaseField.getText() + "'");
                resultSet.next();
                sumPurchaseField.setText(resultSet.getString(1));
                idClient = resultSet.getString(2);
                if (!Objects.equals(idClient, "0")){
                    resultSet = statement.executeQuery("update client set totalOrdersSum = totalOrdersSum - (select paySum from purchase where idPurchase = '" +
                            idPurchaseField.getText() + "')");
                    resultSet.next();
                }
            } catch (SQLException e) {
                purchaseWarningLabel.setText("????????????!");
                throw new RuntimeException(e);
            }
        }

            void getDiscountInOrder(){
            if (clientPhoneField.getText().matches("[+][7][0-9]{10}") & clientPhoneRadio.isSelected()){
                try (Connection connection = DriverManager.getConnection(serverUrl)) {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet;
                    resultSet = statement.executeQuery("select discountLevel from client where phone = '" +
                            clientPhoneField.getText() + "'");
                    resultSet.next();
                    discount = resultSet.getFloat(1);
                    clientPhoneField.setEditable(false);
                    if (discount > 0) {
                        discountField.setText(String.valueOf(discount));
                    }
                    if (discountField.getText().equals("0")) {
                        totalSumField.setText(goodsSumField.getText());
                    } else {
                        totalSumField.setText(String.valueOf(Float.parseFloat(goodsSumField.getText()) * (1 - discount)));
                    }
                } catch (SQLException ex) {
                    purchaseWarningLabel.setText("???????????? ???? ????????????!");
                    throw new RuntimeException(ex);
                }
            } else {
                totalSumField.setText(goodsSumField.getText());
            }
        }

        void fillMerchTable() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Class.forName(driverUrl).getDeclaredConstructor().newInstance();
        try (Connection connection = DriverManager.getConnection(serverUrl)) {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into merchandise values (((SELECT COUNT(*) FROM merchandise) + 1), " +
                            "?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, manufacturerMerchField.getText().trim());
            statement.setString(2, modelMerchField.getText().trim());
            statement.setString(3, typeMerchField.getText().trim());
            statement.setString(4, materialMerchField.getText().trim());
            statement.setString(5, sampleMerchField.getText().trim());
            statement.setFloat(6, Float.parseFloat(weightMerchField.getText()));
            statement.setString(7, warrantyMerchField.getText().trim());
            statement.setInt(8, Integer.parseInt(priceMerchField.getText()));
            statement.setInt(9, Integer.parseInt(quantMerchField.getText().trim()));
            statement.setString(10, descriptionMerchField.getText().trim());
            statement.executeLargeUpdate();
            merhShower("full");
            merchFieldCleaner();
        } catch (SQLException e) {
            merchandiseWarningLabel.setText("???????????? ?????? ???????????????????? ????????????!");
            throw new RuntimeException(e);
        }
    }

    void addNewClient() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException, SQLException {
        Class.forName(driverUrl).getDeclaredConstructor().newInstance();
        try (Connection connection = DriverManager.getConnection(serverUrl)) {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into client values (((SELECT COUNT(*) FROM client) + 1), ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, phoneRegisterClientField.getText());
            statement.setString(2, surnameClientField.getText());
            statement.setString(3, nameClientField.getText());
            statement.setString(4, secondNameClientField.getText());
            statement.setString(5, birthdateClientField.getText());
            statement.setString(6, emailClientField.getText());
            statement.setInt(7, 0);
            statement.setFloat(8, 0);
            statement.executeLargeUpdate();
        } catch (SQLException throwable) {
            purchaseWarningLabel.setText("?????????????????? ????????????, ?????????????????? ???????????????? ????????????!");
            throwable.printStackTrace();
        }
        purchaseWarningLabel.setText("???????????? ????????????????!");
        newClientDataCleaner();
    }

    void newClientDataCleaner(){
        phoneRegisterClientField.setText("");
        surnameClientField.setText("");
        nameClientField.setText("");
        secondNameClientField.setText("");
        birthdateClientField.setText("");
        emailClientField.setText("");
    }

    void merchFieldCleaner(){
        if (firstMerchRadio.isSelected()){
            firstMerchRadio.fire();
        }
        if (secondMerchRadio.isSelected()){
            secondMerchRadio.fire();
        }
        if (thirdMerchRadio.isSelected()){
            thirdMerchRadio.fire();
        }
        if (thirdMerchRadio.isSelected()){
            thirdMerchRadio.fire();
        }
        goodsQuant = 0;
        IDMerchField.setText("");
        firstMerchField.setText("");
        secondMerchField.setText("");
        thirdMerchField.setText("");
        manufacturerMerchField.setText("");
        modelMerchField.setText("");
        typeMerchField.setText("");
        materialMerchField.setText("");
        sampleMerchField.setText("");
        weightMerchField.setText("");
        warrantyMerchField.setText("");
        priceMerchField.setText("");
        quantMerchField.setText("");
        descriptionMerchField.setText("");
        discountField.setText("");
        purchaseWarningLabel.setText("");
        firstMerchField.setEditable(true);
        secondMerchField.setEditable(true);
        thirdMerchField.setEditable(true);
        fourthMerchField.setEditable(true);
        clientPhoneField.setEditable(true);
        sumPurchaseField.setText("");
        totalSumField.setText("");
        sumPurchaseField.setText("");
        clientPhoneField.setText("");
        goodsSumField.setText("");
        goodsSum = 0;
    }

}
