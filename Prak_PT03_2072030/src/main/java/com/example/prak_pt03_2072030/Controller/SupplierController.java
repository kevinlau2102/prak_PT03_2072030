package com.example.prak_pt03_2072030.Controller;

import com.example.prak_pt03_2072030.Model.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class SupplierController {
    @FXML
    private TableView<Supplier> tableSupp;
    @FXML
    private TableColumn<Integer, Supplier> idSupp;
    @FXML
    private TableColumn<String, Supplier> namaSupp;
    @FXML
    private TableColumn<String, Supplier> alamatSupp;
    @FXML
    private TextField id;
    @FXML
    private TextField nama;
    @FXML
    private TextField alamat;
    @FXML
    private ObservableList<Supplier> supplier;
    @FXML
    private Label idLabel;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnUpdate;
    private int idx;

    public ObservableList<Supplier> getSupplier() {
        return supplier;
    }

    public void setSupplier(ObservableList<Supplier> supplier) {
        this.supplier = supplier;
    }

    public void initialize() {
        supplier = FXCollections.observableArrayList();
        tableSupp.setItems(supplier);
        idSupp.setCellValueFactory(new PropertyValueFactory<>("id"));
        namaSupp.setCellValueFactory(new PropertyValueFactory<>("nama"));
        alamatSupp.setCellValueFactory(new PropertyValueFactory<>( "alamat"));
    }
    public void reset() {
        id.clear();
        nama.clear();
        alamat.clear();
        btnAdd.setDisable(false);
        btnReset.setDisable(false);
        btnUpdate.setDisable(false);
    }

    public void addSupplier() {
        supplier.add(new Supplier(Integer.parseInt(id.getText()), nama.getText(), alamat.getText()));
        reset();
    }

    public void updateSupplier() {
        supplier.set(idx, new Supplier(Integer.parseInt(id.getText()), nama.getText(), alamat.getText()));
        reset();
    }

    public void closeSupplier() {
        setSupplier(supplier);
        idLabel.getScene().getWindow().hide();
    }
    public void getSelectedItem() {
        if (!tableSupp.getSelectionModel().getSelectedCells().isEmpty()) {
            btnAdd.setDisable(true);
            btnReset.setDisable(false);
            btnUpdate.setDisable(false);
            idx = tableSupp.getSelectionModel().getSelectedIndex();
        }
        id.setText(String.valueOf(tableSupp.getSelectionModel().getSelectedItem().getId()));
        nama.setText(tableSupp.getSelectionModel().getSelectedItem().getNama());
        alamat.setText(tableSupp.getSelectionModel().getSelectedItem().getAlamat());
    }

}