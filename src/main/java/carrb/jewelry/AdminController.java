package carrb.jewelry;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

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
import javafx.scene.image.ImageView;

import static carrb.jewelry.Common.driverUrl;
import static carrb.jewelry.Common.serverUrl;

public class AdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField IDMerchField;

    @FXML
    private RadioButton IDMerchRadio;

    @FXML
    private TableColumn<?, ?> IDmerchColumn;

    @FXML
    private TableColumn<?, ?> IDpurchaseColumn;

    @FXML
    private TextField IDpurchaseField;

    @FXML
    private RadioButton IDpurchaseRadio;

    @FXML
    private TableColumn<?, ?> INNEmployeeColumn;

    @FXML
    private TextField INNEmployeeField;

    @FXML
    private TableColumn<?, ?> SNILSEmployeeColumn;

    @FXML
    private TextField SNILSEmployeeField;

    @FXML
    private Button addNewUserButton;

    @FXML
    private Button addStrEmployeeButton;

    @FXML
    private Button addStrMerch;

    @FXML
    private Button addStrRequestButton;

    @FXML
    private Button addStrRequestButton1;

    @FXML
    private Button addStrRequestButton2;

    @FXML
    private Label authDataWarningLabel;

    @FXML
    private TableColumn<?, ?> birthdateClientColumn;

    @FXML
    private TextField birthdateClientField;

    @FXML
    private TableColumn<?, ?> birthdateEmployeeColumn;

    @FXML
    private TextField birthdateEmployeeField;

    @FXML
    private Button changeStrEmployeeButton;

    @FXML
    private Button changeStrMerch;

    @FXML
    private Button changeStrRequestButton;

    @FXML
    private Button changeUsersPasswordButton;

    @FXML
    private TableColumn<?, ?> clientPurchaseColumn;

    @FXML
    private TextField clientPurchaseField;

    @FXML
    private RadioButton clientPurchaseRadio;

    @FXML
    private TableView<clientTable> clientTableView;

    @FXML
    private Label clientWarningLabel;

    @FXML
    private Label connectionWarningLabel;

    @FXML
    private TableColumn<?, ?> descriptionMerchColumn;

    @FXML
    private TextField descriptionMerchField;

    @FXML
    private TableColumn<?, ?> discountLevelColumn;

    @FXML
    private TextField discountLevelField;

    @FXML
    private RadioButton discountLevelRadio;

    @FXML
    private TableColumn<?, ?> emailClientColumn;

    @FXML
    private TextField emailClientField;

    @FXML
    private RadioButton emailClientRadio;

    @FXML
    private TableColumn<?, ?> employeePurchaseColumn;

    @FXML
    private TextField employeePurchaseField;

    @FXML
    private RadioButton employeePurchaseRadio;

    @FXML
    private TableView<employeeTable> employeeTableView;

    @FXML
    private Label employeeWarningField;

    @FXML
    private Button findMerchButton;

    @FXML
    private TableColumn<?, ?> idClientColumn;

    @FXML
    private TextField idClientField;

    @FXML
    private RadioButton idClientRadio;

    @FXML
    private TableColumn<?, ?> idEmployeeColumn;

    @FXML
    private TextField idEmployeeField;

    @FXML
    private TableColumn<?, ?> manufacturerMerchColumn;

    @FXML
    private TextField manufacturerMerchField;

    @FXML
    private TableColumn<?, ?> materialMerchColumn;

    @FXML
    private TextField materialMerchField;

    @FXML
    private Button merchCheckPhotoButton;

    @FXML
    private ImageView merchImage;

    @FXML
    private TableColumn<?, ?> merchPurchaseColumn;

    @FXML
    private TextField merchPurchaseField;

    @FXML
    private RadioButton merchPurchaseRadio;

    @FXML
    private TableView<merchandiseTable> merchandiseTableView;

    @FXML
    private TableColumn<?, ?> modelMerchColumn;

    @FXML
    private TextField modelMerchField;

    @FXML
    private RadioButton modelMerchRadio;

    @FXML
    private TableColumn<?, ?> nameClientColumn;

    @FXML
    private TextField nameClientField;

    @FXML
    private TableColumn<?, ?> nameEmployeeColumn;

    @FXML
    private TextField nameEmployeeField;

    @FXML
    private TableColumn<?, ?> passDataEmployeeColumn;

    @FXML
    private TextField passDataEmployeeField;

    @FXML
    private TableColumn<?, ?> purchaseDateColumn;

    @FXML
    private TextField payMethodPurchaseField;

    @FXML
    private RadioButton payMethodPurchaseRadio;

    @FXML
    private TableColumn<?, ?> paySumPurchaseColumn;

    @FXML
    private TextField paySumPurchaseField;

    @FXML
    private RadioButton paySumPurchaseRadio;

    @FXML
    private TableColumn<?, ?> phoneClientColumn;

    @FXML
    private TextField phoneClientField;

    @FXML
    private RadioButton phoneClientRadio;

    @FXML
    private TableColumn<?, ?> phoneEmployeeColumn;

    @FXML
    private TextField phoneEmployeeField;

    @FXML
    private TableColumn<?, ?> photoMerchColumn;

    @FXML
    private TextField photoMerchField;

    @FXML
    private TableColumn<?, ?> priceMerchColumn;

    @FXML
    private TextField priceMerchField;

    @FXML
    private RadioButton priceMerchRadio;

    @FXML
    private TableView<purchaseTable> purchaseTableView;

    @FXML
    private TableColumn<?, ?> quantMerchColumn;

    @FXML
    private TextField quantMerchField;

    @FXML
    private Button removeStrClientButton;

    @FXML
    private Button removeStrClientButton1;

    @FXML
    private Button removeStrClientButton2;

    @FXML
    private Button removeStrEmployeeButton;

    @FXML
    private Button removeStrMerch;

    @FXML
    private Button removeStrRequestButton;

    @FXML
    private Button removeUserButton;

    @FXML
    private Label requestWarningLabel;

    @FXML
    private TableColumn<?, ?> sampleMerchColumn;

    @FXML
    private TextField sampleMerchField;

    @FXML
    private TableColumn<?, ?> secondNameClientColumn;

    @FXML
    private TextField secondNameClientField;

    @FXML
    private TableColumn<?, ?> secondNameEmployeeColumn;

    @FXML
    private TextField secondNameEmployeeField;

    @FXML
    private Button stopFilterMerchButton;

    @FXML
    private TableColumn<?, ?> surnameClientColumn;

    @FXML
    private TextField surnameClientField;

    @FXML
    private TableColumn<?, ?> surnameEmployeeColumn;

    @FXML
    private TextField surnameEmployeeField;

    @FXML
    private Label tariffWarningLabel;

    @FXML
    private TableColumn<?, ?> totalOrderSumClientColumn;

    @FXML
    private TableColumn<?, ?> typeMerchColumn;

    @FXML
    private TextField typeMerchField;

    @FXML
    private RadioButton typeMerchRadio;

    @FXML
    private TextField userToAddPasswordField;

    @FXML
    private TextField userToAddPhoneField;

    @FXML
    private TextField userToChangePassField;

    @FXML
    private TextField userToChangePassPhoneField;

    @FXML
    private TextField userToRemovePhoneField;

    @FXML
    private TableColumn<?, ?> warrantyMerchColumn;

    @FXML
    private TextField warrantyMerchField;

    @FXML
    private TableColumn<?, ?> weightMerchColumn;

    @FXML
    private TextField weightMerchField;
    ObservableList<employeeTable> employeeTableData = FXCollections.observableArrayList();
    ObservableList<merchandiseTable> merchandiseTableData = FXCollections.observableArrayList();
    ObservableList<purchaseTable> purchaseTableData = FXCollections.observableArrayList();
    ObservableList<clientTable> clientTableData = FXCollections.observableArrayList();


    @FXML
    void initialize() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        showEmployeeTable();
        showMerchandiseTable();
        showPurchaseTable();
        showClientTable();
        addStrEmployeeButton.setOnAction(actionEvent -> {
            employeeWarningField.setText("");
            if (idEmployeeField.getText().matches("\\d+") & phoneEmployeeField.getText().matches("[+][7][0-9]{10}") &
            surnameEmployeeField.getText().length() >= 2 & nameEmployeeField.getText().length() >= 2 &
                    birthdateEmployeeField.getText().matches("^(((2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$") &
            passDataEmployeeField.getText().length() >= 10 & INNEmployeeField.getText().matches("[0-9]{12}|[0-9]{10}") &
                    SNILSEmployeeField.getText().length() >= 5){
                System.out.println("ПРошо");
                try {
                    editEmployeeTable("addition");
                } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                         InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    void showClientTable() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        clientTableData.clear();
        Class.forName(driverUrl).getDeclaredConstructor().newInstance();
        try (Connection connection = DriverManager.getConnection(serverUrl)) {
            Statement statement = connection.createStatement();
            // таблица "подключение"
            ResultSet resultSet = statement.executeQuery("select * from client order by idClient");
            while (true) {
                assert resultSet != null;
                if (!resultSet.next()) break;
                clientTableData.add(new clientTable(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6), resultSet.getString(7), resultSet.getString(8),
                        resultSet.getString(9)));
                idClientColumn.setCellValueFactory(new PropertyValueFactory<>("idClient"));
                phoneClientColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
                surnameClientColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
                nameClientColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
                secondNameClientColumn.setCellValueFactory(new PropertyValueFactory<>("secondName"));
                birthdateClientColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
                emailClientColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
                totalOrderSumClientColumn.setCellValueFactory(new PropertyValueFactory<>("totalOrdersSum"));
                discountLevelColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
                clientTableView.setItems(clientTableData);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void showPurchaseTable() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        purchaseTableData.clear();
        Class.forName(driverUrl).getDeclaredConstructor().newInstance();
        try (Connection connection = DriverManager.getConnection(serverUrl)) {
            Statement statement = connection.createStatement();
            // таблица "подключение"
            ResultSet resultSet = statement.executeQuery("select * from purchase order by idPurchase");
            while (true) {
                assert resultSet != null;
                if (!resultSet.next()) break;
                purchaseTableData.add(new purchaseTable(resultSet.getString(1),
                        resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6)));
                IDpurchaseColumn.setCellValueFactory(new PropertyValueFactory<>("idPurchase"));
                merchPurchaseColumn.setCellValueFactory(new PropertyValueFactory<>("merchandiseId"));
                paySumPurchaseColumn.setCellValueFactory(new PropertyValueFactory<>("paySum"));
                clientPurchaseColumn.setCellValueFactory(new PropertyValueFactory<>("client"));
                employeePurchaseColumn.setCellValueFactory(new PropertyValueFactory<>("seller"));
                purchaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("purchaseDate"));
                purchaseTableView.setItems(purchaseTableData);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void showMerchandiseTable() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        merchandiseTableData.clear();
        Class.forName(driverUrl).getDeclaredConstructor().newInstance();
        try (Connection connection = DriverManager.getConnection(serverUrl)) {
            Statement statement = connection.createStatement();
            // таблица "подключение"
            ResultSet resultSet = statement.executeQuery("select * from merchandise order by idMerchandise");
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
            throw new RuntimeException(e);
        }
    }

        void showEmployeeTable() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
                InstantiationException, IllegalAccessException {
        employeeTableData.clear();
        Class.forName(driverUrl).getDeclaredConstructor().newInstance();
        try (Connection connection = DriverManager.getConnection(serverUrl)) {
            Statement statement = connection.createStatement();
            // таблица "подключение"
            ResultSet resultSet = statement.executeQuery("select * from employee order by idEmployee");
            while (resultSet.next()) {
                employeeTableData.add(new employeeTable(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6), resultSet.getString(7), resultSet.getString(8),
                        resultSet.getString(9)));
                idEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("idEmployee"));
                phoneEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
                surnameEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
                nameEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
                secondNameEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("secondName"));
                birthdateEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
                passDataEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("passData"));
                INNEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("INN"));
                SNILSEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("SNILS"));
                employeeTableView.setItems(employeeTableData);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    void editEmployeeTable(String operation) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Class.forName(driverUrl).getDeclaredConstructor().newInstance();
        try (Connection connection = DriverManager.getConnection(serverUrl)) {
            PreparedStatement statement = null;
            if (operation.equals("addition")){
                statement = connection.prepareStatement("insert into authData values (((SELECT COUNT(*) FROM authData) + 1), ?, ?, ?)");
                statement.setString(1, phoneEmployeeField.getText());
                statement.setString(2, Common.reverseString(phoneEmployeeField.getText().substring(1)));
                System.out.println(Common.reverseString(phoneEmployeeField.getText().substring(1)));
                statement.setString(3, "employee");
                statement.executeLargeUpdate();

                statement = connection.prepareStatement("insert into employee values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                statement.setInt(1, Integer.parseInt(idEmployeeField.getText()));
                statement.setString(2, phoneEmployeeField.getText());
                statement.setString(3, surnameEmployeeField.getText().trim());
                statement.setString(4, nameEmployeeField.getText().trim());
                statement.setString(5, secondNameEmployeeField.getText().trim());
                statement.setString(6, birthdateEmployeeField.getText());
                statement.setString(7, passDataEmployeeField.getText().trim());
                statement.setString(8, INNEmployeeField.getText());
                statement.setString(9, SNILSEmployeeField.getText().trim());
            }
            statement.executeLargeUpdate();
        } catch (SQLException throwable) {
            if (operation.equals("removing")){
                requestWarningLabel.setText("Ошибка при удалении данных в таблице!");
            }
            if (operation.equals("changing")){
                requestWarningLabel.setText("Ошибка при изменении таблицы!");
            }
            if (operation.equals("addition")){
                requestWarningLabel.setText("Ошибка при добавлении данных в таблицу!");
            }
            throwable.printStackTrace();
        }
        idEmployeeField.setText("");
        phoneEmployeeField.setText("");
        surnameEmployeeField.setText("");
        nameEmployeeField.setText("");
        secondNameEmployeeField.setText("");
        birthdateEmployeeField.setText("");
        passDataEmployeeField.setText("");
        INNEmployeeField.setText("");
        SNILSEmployeeField.setText("");
        showEmployeeTable();
    }

}
