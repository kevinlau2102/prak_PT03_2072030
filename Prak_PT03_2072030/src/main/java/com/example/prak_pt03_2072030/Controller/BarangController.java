package com.example.prak_pt03_2072030.Controller;

import com.example.prak_pt03_2072030.MainApplication;
import com.example.prak_pt03_2072030.Model.Barang;
import com.example.prak_pt03_2072030.Model.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class BarangController {
    @FXML
    private TableView<Barang> tableBarang;
    @FXML
    private TableColumn<Integer, Barang> idBarang;
    @FXML
    private TableColumn<String, Barang> namaBarang;
    @FXML
    private TableColumn<String, Barang> suppBarang;
    @FXML
    private TextField id;
    @FXML
    private TextField nama;
    @FXML
    private ComboBox<String> supplier;
    @FXML
    private ObservableList<Barang> barang;
    private ObservableList<Supplier> suppList;
    private ObservableList<String> namaSupp;
    @FXML
    private FXMLLoader fxmlLoader;
    @FXML
    private Stage newStage;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnUpdate;
    @FXML
    private Label idLabel;
    private int idx;

    public void initialize() throws IOException {
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("supplier.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        newStage = new Stage();
        newStage.setTitle("Supplier Management");
        newStage.setScene(scene);
        newStage.initModality(Modality.APPLICATION_MODAL);
        barang = FXCollections.observableArrayList();
        tableBarang.setItems(barang);
        idBarang.setCellValueFactory(new PropertyValueFactory<>("id"));
        namaBarang.setCellValueFactory(new PropertyValueFactory<>("nama"));
        suppBarang.setCellValueFactory(new PropertyValueFactory<>("supplier"));
    }

    public void showSupplier() {
        newStage.showAndWait();
        SupplierController sController = fxmlLoader.getController();
        suppList = sController.getSupplier();
        namaSupp = FXCollections.observableArrayList();
        for(Supplier supp: suppList) {
            namaSupp.add(supp.getNama());
        }
        supplier.setItems(namaSupp);
        supplier.getSelectionModel().select(0);
    }
    public void addBarang() {
        barang.add(new Barang(Integer.parseInt(id.getText()), nama.getText(), supplier.getValue()));
        reset();
    }
    public void reset() {
        id.clear();
        nama.clear();
        supplier.getSelectionModel().select(0);
        btnAdd.setDisable(false);
        btnReset.setDisable(false);
        btnUpdate.setDisable(false);
    }
    public void updateBarang() {
        barang.set(idx, new Barang(Integer.parseInt(id.getText()), nama.getText(), supplier.getValue()));
        reset();
    }
    public void getSelectionItem() {
        if (!tableBarang.getSelectionModel().getSelectedCells().isEmpty()) {
            btnAdd.setDisable(true);
            btnReset.setDisable(false);
            btnUpdate.setDisable(false);
            idx = tableBarang.getSelectionModel().getSelectedIndex();
        }
        id.setText(String.valueOf(tableBarang.getSelectionModel().getSelectedItem().getId()));
        nama.setText(tableBarang.getSelectionModel().getSelectedItem().getNama());
        supplier.setValue(tableBarang.getSelectionModel().getSelectedItem().getSupplier());
    }
    public void closeApplication() {
        idLabel.getScene().getWindow().hide();
    }
}
