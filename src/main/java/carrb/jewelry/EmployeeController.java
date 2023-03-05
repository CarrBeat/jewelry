package carrb.jewelry;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

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
    private Button findPurchaseButton;

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
    private TextField returnClientPhoneField;

    @FXML
    private RadioButton returnClientPhoneRadio;

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

    @FXML
    void initialize() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        merhShower("full");
        addMerchButton.setOnAction(actionEvent -> {
            merchandiseWarningLabel.setText("");
            if (manufacturerMerchColumn.getText().length() >= 4 &
            modelMerchColumn.getText().length() >= 4 & typeMerchColumn.getText().length() >= 4 &
            materialMerchColumn.getText().length() >= 4 & sampleMerchColumn.getText().length() >= 3 &
            weightMerchColumn.getText().length() >= 3 & warrantyMerchColumn.getText().length() >= 2 &
            priceMerchColumn.getText().length() >= 3 & quantMerchColumn.getText() != null &
            descriptionMerchColumn.getText().length() >= 1){
                try {
                    System.out.println("метод запущен");
                    fillMerchTable();
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
                         InvocationTargetException | NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
            }
            findMerchButton.setOnAction(actionEvent1 -> {
                System.out.println(IDMerchRadio.isSelected());
                if (IDMerchRadio.isSelected() & IDMerchField.getText() != null){
                    try {
                        merhShower("id");
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                             InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (manufacturerMerchRadio.isSelected() & manufacturerMerchField.getText() != null){
                    try {
                        merhShower("manufacturer");
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                             InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (warrantyMerchRadio.isSelected() & warrantyMerchField.getText() != null){
                    try {
                        merhShower("warranty");
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                             InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (typeMerchRadio.isSelected() & typeMerchField.getText() != null){
                    try {
                        merhShower("type");
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                             InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (materialMerchRadio.isSelected() & materialMerchField.getText() != null){
                    try {
                        merhShower("material");
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                             InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (modelMerchRadio.isSelected() & modelMerchField.getText() != null){
                    try {
                        merhShower("model");
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                             InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (priceMerchRadio.isSelected() & priceMerchField.getText() != null){
                    try {
                        merhShower("price");
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                             InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (descriptionMerchRadio.isSelected() & descriptionMerchField.getText() != null){
                    try {
                        merhShower("description");
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                             InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        });
        stopFilterMerchButton.setOnAction(actionEvent -> {
            try {
                merhShower("full");
            } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                     InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

    void merhShower(String command) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        merchandiseTableData.clear();
        Class.forName(driverUrl).getDeclaredConstructor().newInstance();
        try (Connection connection = DriverManager.getConnection(serverUrl)) {
            Statement statement = connection.createStatement();
            // таблица "подключение"
            ResultSet resultSet = null;
            switch (command) {
                case "id":
                    resultSet = statement.executeQuery("select * from merchandise where id ='" + IDMerchField.getText() + "'");
                    break;
                case "manufacturer":
                    resultSet = statement.executeQuery("select * from merchandise where manufacturer ='"
                            + manufacturerMerchField.getText() + "'");
                    break;
                case "warranty":
                    resultSet = statement.executeQuery("select * from merchandise where warrantyPeriod ='"
                            + warrantyMerchField.getText() + "'");
                    break;
                case "type":
                    resultSet = statement.executeQuery("select * from merchandise where type ='"
                            + typeMerchField.getText() + "'");
                    break;
                case "material":
                    resultSet = statement.executeQuery("select * from merchandise where material ='"
                            + materialMerchField.getText() + "'");
                    break;
                case "model":
                    resultSet = statement.executeQuery("select * from merchandise where model ='"
                            + modelMerchField.getText() + "'");
                    break;
                case "price":
                    resultSet = statement.executeQuery("select * from merchandise where price ='"
                            + priceMerchField.getText() + "'");
                    break;
                case "description":
                    resultSet = statement.executeQuery("select * from merchandise where desription ='"
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
            warrantyMerchField.setText("Ошибка при поиске!");
            throw new RuntimeException(e);
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
            merchandiseWarningLabel.setText("Ошибка при добавлении товара!");
            throw new RuntimeException(e);
        }
    }
    void merchFieldCleaner(){
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
    }
}
