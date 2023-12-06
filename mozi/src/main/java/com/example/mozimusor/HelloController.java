package com.example.mozimusor;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import static java.lang.Boolean.parseBoolean;

public class HelloController {
    @FXML public VBox OlvasasMenu;
    @FXML public TableView<Database> tOlvas;
    public VBox vbOlvas;
    public VBox vbInsert;
    public VBox vbUpdate;
    public VBox vbShowUpdate;
    public VBox vbDelete;
    public VBox vbRest1Get;
    public VBox vbRest1;
    public HBox hbMain;
    public VBox vbEgyeb;
    public VBox vbRest1Post;
    public TableView tRest1Get;
    public ComboBox cbOlvasas;
    public TextField tfOlvas;
    public CheckBox cbSzines;
    public ToggleGroup group;
    public ComboBox cbInsertMufaj;
    public TextField tfRest1PostId;
    public ComboBox tfRest1PostStatus;
    public ComboBox tfRest1PostGender;
    public TextField tfRest1PostEmail;
    public TextField tfRest1PostName;
    public Label lResponseRest1Post;
    public TextField tfRest1Delete;
    public VBox vbRest1Delete;
    public Label lDeleted;
    public VBox vbRest1Update;
    public Label lUpdated;
    public TextField tfRest1UpdateId;
    public TextField tfRest1UpdateName;
    public TextField tfRest1UpdateEmail;
    public ComboBox cbRest1UpdateGender;
    public ComboBox cbRest1UpdateStatus;
    public VBox vbStream;
    public TableView tStream;
    public ToggleGroup group1;
    public ComboBox cbInsertSzines;
    public ComboBox cbInsertSzinkron;
    public TextField tfInsertSzarmazas;
    public TextField tfInsertHossz;
    public TextField tfInsertFilmcim;
    public ComboBox cbShowMozi;
    public TextField tfUpdateMoziNev;
    public TextField tfupdateIrszam;
    public TextField tfupdateCim;
    public TextField tfupdateTelefon;
    public ComboBox cbShowDeleteMozi;
    public ComboBox cbStreamMufaj;
    public CheckBox cbStreamSzines;
    public TextField tfStreamCim;
    @FXML private TableColumn<RestUser, String> RestUserid;
    @FXML private TableColumn<RestUser, String> RestUserName;
    @FXML private TableColumn<RestUser, String> RestUserEmail;
    @FXML private TableColumn<RestUser, String> RestUserGender;
    @FXML private TableColumn<RestUser, String> RestStatus;
//    String url="jdbc:mysql://localhost/mozimusor?user=root";
    String url = "jdbc:sqlite:/C:/mozimusor.db";
    DatabaseSzedo database=new DatabaseSzedo(url);
    MoziMusorokDatabaseSzedo mozibase=new MoziMusorokDatabaseSzedo(url);
    public void Clear()
    {
        hbMain.getChildren().removeAll(hbMain.getChildren());
        cbShowMozi.setDisable(false);
    }
    public void Mutat(String a){
        Clear();

        switch(a){

            case "OlvasMenu":
                hbMain.getChildren().add(OlvasasMenu);
                OlvasasMenu.getChildren().removeAll(OlvasasMenu.getChildren());
                OlvasasMenu.getChildren().add(tOlvas);
                break;
            case "Olvas2Menu":
                hbMain.getChildren().add(OlvasasMenu);
                OlvasasMenu.getChildren().removeAll(OlvasasMenu.getChildren());
                OlvasasMenu.getChildren().addAll(vbOlvas,tOlvas);
                break;
            case "Insert":
                hbMain.getChildren().add(OlvasasMenu);
                OlvasasMenu.getChildren().removeAll(OlvasasMenu.getChildren());

                cbInsertMufaj.getItems().removeAll(cbInsertMufaj.getItems());
                cbInsertMufaj.getItems().addAll(database.Mufajok());

                cbInsertSzinkron.getItems().removeAll(cbInsertSzinkron.getItems());
                cbInsertSzinkron.getItems().addAll("fel","mb");

                cbInsertSzines.getItems().removeAll(cbInsertSzines.getItems());
                cbInsertSzines.getItems().addAll("0","-1");

                OlvasasMenu.getChildren().addAll(vbInsert);
                break;
            case "Update":
                hbMain.getChildren().add(OlvasasMenu);
                OlvasasMenu.getChildren().removeAll(OlvasasMenu.getChildren());
                cbShowMozi.getItems().removeAll(cbShowMozi.getItems());
                cbShowMozi.getItems().addAll(mozibase.getMoziNev());
                OlvasasMenu.getChildren().addAll(vbUpdate);
                break;
            case "ShowUpdate":
                hbMain.getChildren().add(OlvasasMenu);
                OlvasasMenu.getChildren().removeAll(OlvasasMenu.getChildren());
                OlvasasMenu.getChildren().addAll(vbUpdate,vbShowUpdate);
                break;
            case "Delete":
                hbMain.getChildren().add(OlvasasMenu);
                OlvasasMenu.getChildren().removeAll(OlvasasMenu.getChildren());
                cbShowDeleteMozi.getItems().removeAll(cbShowDeleteMozi.getItems());
                cbShowDeleteMozi.getItems().addAll(mozibase.getMoziNev());
                OlvasasMenu.getChildren().addAll(vbDelete);
                break;
            case "Rest1Get":
                hbMain.getChildren().add(vbRest1);
                vbRest1.getChildren().removeAll(vbRest1.getChildren());
                vbRest1.getChildren().addAll(vbRest1Get);
                break;
            case "Rest1Post":
                hbMain.getChildren().add(vbRest1);
                vbRest1.getChildren().removeAll(vbRest1.getChildren());
                tfRest1PostStatus.getItems().removeAll(tfRest1PostStatus.getItems());
                tfRest1PostGender.getItems().removeAll(tfRest1PostGender.getItems());
                tfRest1PostGender.getItems().addAll("male","female");
                tfRest1PostStatus.getItems().addAll("active","inactive");
                vbRest1.getChildren().addAll(vbRest1Post);
                break;
            case "Rest1Delete":
                hbMain.getChildren().add(vbRest1);
                vbRest1.getChildren().removeAll(vbRest1.getChildren());
                vbRest1.getChildren().addAll(vbRest1Delete);
                break;
            case "Rest1Update":
                hbMain.getChildren().add(vbRest1);
                vbRest1.getChildren().removeAll(vbRest1.getChildren());
                cbRest1UpdateGender.getItems().removeAll(cbRest1UpdateGender.getItems());
                cbRest1UpdateStatus.getItems().removeAll(cbRest1UpdateStatus.getItems());
                cbRest1UpdateGender.getItems().addAll("male","female");
                cbRest1UpdateStatus.getItems().addAll("active","inactive");
                vbRest1.getChildren().addAll(vbRest1Update);
                break;
            case "Stream":
                hbMain.getChildren().add(vbEgyeb);
                vbEgyeb.getChildren().removeAll(vbEgyeb.getChildren());
                vbEgyeb.getChildren().addAll(vbStream);
                break;
        }
    }
    public  void Tabla(String a)
    {
        ArrayList<Database> filmek = database.getAll(a);

        if(filmek == null || filmek.isEmpty())
        {
            tOlvas.getItems().removeAll(tOlvas.getItems());
            tOlvas.getColumns().removeAll(tOlvas.getColumns());
            TableColumn filmnev = new TableColumn("Nincs adat");
            tOlvas.getColumns().addAll(filmnev);
            filmnev.setCellValueFactory(new PropertyValueFactory<>("filmcim"));

            tOlvas.getItems().add(new Database("Nincs ilyen adat!","Nincs","Nincs","Nincs","Nincs","nincs",false));
        }
        else
        {
            tOlvas.getItems().removeAll(tOlvas.getItems());
            tOlvas.getColumns().removeAll(tOlvas.getColumns());

            TableColumn filmcim = new TableColumn("filmcim");
            TableColumn szarmazas = new TableColumn("származás");
            TableColumn mufaj = new TableColumn("műfaj");
            TableColumn mozinev = new TableColumn("Mozinév");
            TableColumn cim = new TableColumn("cim");
            TableColumn szinkron = new TableColumn("szinkron");
            TableColumn szines = new TableColumn("szines");

            tOlvas.getColumns().addAll(filmcim,szarmazas,mufaj,mozinev,cim,szinkron,szines);

            filmcim.setCellValueFactory(new PropertyValueFactory<>("filmcim"));
            szarmazas.setCellValueFactory(new PropertyValueFactory<>("szarmazas"));
            mufaj.setCellValueFactory(new PropertyValueFactory<>("mufaj"));
            mozinev.setCellValueFactory(new PropertyValueFactory<>("mozinev"));
            cim.setCellValueFactory(new PropertyValueFactory<>("cim"));
            szinkron.setCellValueFactory(new PropertyValueFactory<>("szinkron"));
            szines.setCellValueFactory(new PropertyValueFactory<>("szines"));

            for(int i = 0; i < filmek.size(); i++ )
            {
                tOlvas.getItems().add(filmek.get(i));
            }
        }
    }
    @FXML
    private void initialize()
    {
        Clear();
    }
    public void Olvasas(ActionEvent actionEvent) {

        Mutat("OlvasMenu");
        Tabla("");
    }
    public void Szures(ActionEvent actionEvent) {
        Mutat("Olvas2Menu");
        Tabla("");
        cbOlvasas.getItems().add(null);
        cbOlvasas.getItems().addAll(database.Mufajok());
    }
    @FXML
    protected void Insert(ActionEvent actionEvent){
        Mutat("Insert");
    }
    public void Rest1Get(ActionEvent actionEvent) throws IOException {
        Mutat("Rest1Get");
        Rest1Tabla();

    }
    public void Rest1Tabla() throws IOException {
        tRest1Get.getItems().removeAll(tRest1Get.getItems());
        tRest1Get.getColumns().removeAll(tRest1Get.getColumns());
        RestUser[] user = RestKliens.GET("https://gorest.co.in/public/v2/users");

        RestUserid = new TableColumn("RestUserid");
        RestUserName = new TableColumn("RestUserName");
        RestUserEmail = new TableColumn("RestUserEmail");
        RestUserGender = new TableColumn("RestUserGender");
        RestStatus = new TableColumn("RestStatus");

        tRest1Get.getColumns().addAll(RestUserid, RestUserName,RestUserEmail,RestUserGender,RestStatus);

        RestUserid.setCellValueFactory(new PropertyValueFactory<>("id"));
        RestUserName.setCellValueFactory(new PropertyValueFactory<>("name"));
        RestUserEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        RestUserGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        RestStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tRest1Get.getItems().addAll(user);
    }
    public void Rest1Post(ActionEvent actionEvent) {
        Mutat("Rest1Post");
    }
    public void Rest1PostDo(ActionEvent actionEvent) throws IOException {
        RestUser user = new RestUser(Integer.parseInt(tfRest1PostId.getText()),tfRest1PostName.getText(),tfRest1PostEmail.getText(),tfRest1PostGender.getSelectionModel().getSelectedItem().toString(),tfRest1PostStatus.getSelectionModel().getSelectedItem().toString());
        lResponseRest1Post.setText("Válasz:" + RestKliens.POST(user,"https://gorest.co.in/public/v2/users?access-token=ac3cfbe3aff6093675c6c8df54b71a5ad482fcf498d66692ab21c7e54af62e12"));
    }
    public void Rest1Delete(ActionEvent actionEvent) { Mutat("Rest1Delete"); }

    public void DoRest1Delete(ActionEvent actionEvent) throws IOException {
        String id = tfRest1Delete.getText();
        String re = RestKliens.DELETE("https://gorest.co.in/public/v2/users/"+id+"?access-token=ac3cfbe3aff6093675c6c8df54b71a5ad482fcf498d66692ab21c7e54af62e12");
        if(re == "Hiba!") lDeleted.setText("Hiba, nincs ilyen id!");
        else  lDeleted.setText("Sikeres törlés!");
    }
    public void Rest1Update(ActionEvent actionEvent) { Mutat("Rest1Update"); }
    public void DoRest1Update(ActionEvent actionEvent) throws IOException {
        RestUser user = new RestUser(Integer.parseInt(tfRest1UpdateId.getText()),tfRest1UpdateName.getText(),tfRest1UpdateEmail.getText(),cbRest1UpdateGender.getSelectionModel().getSelectedItem().toString(),cbRest1UpdateStatus.getSelectionModel().getSelectedItem().toString());
        if(RestKliens.PUT(user,"https://gorest.co.in/public/v2/users/"+user.getId()+"?access-token=ac3cfbe3aff6093675c6c8df54b71a5ad482fcf498d66692ab21c7e54af62e12") == "Hiba!") lUpdated.setText("Az id nem megfelelő vagy az email foglalt.");
        else lUpdated.setText("Sikeres");
    }
    public void Stream(ActionEvent actionEvent) {
        Mutat("Stream");
        cbStreamMufaj.getItems().removeAll(cbStreamMufaj.getItems());
        cbStreamMufaj.getItems().add(null);
        cbStreamMufaj.getItems().addAll(database.Mufajok());
    }
    public void Filter(ActionEvent actionEvent) {
        String le ="";
        if(!tfOlvas.getText().isEmpty())
        {

            le +=" and filmcim = '" + tfOlvas.getText()+"'";
        }
        if(cbOlvasas.getSelectionModel().getSelectedItem() != null)
        {
            le += " and film.mufaj = '" + cbOlvasas.getSelectionModel().getSelectedItem()+"'";
        }
        if(group.getSelectedToggle() != null)
        {
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
            String toogleGroupValue = selectedRadioButton.getText();
            le += " and film.szinkron = '" + toogleGroupValue + "'";
        }
        if(cbSzines.isSelected())
        {

            le+= " and film.szines = 0" ;

        }
        Tabla(le);
        Mutat("Olvas2Menu");
    }
    public void InsertToTable(ActionEvent actionEvent) {

        String filmcim = tfInsertFilmcim.getText();
        String mufaj = cbInsertMufaj.getSelectionModel().getSelectedItem().toString();
        String szinkron=cbInsertSzinkron.getSelectionModel().getSelectedItem().toString();
        String szines=cbInsertSzines.getSelectionModel().getSelectedItem().toString();
        String szarmazas=tfInsertSzarmazas.getText();
        int hossz=0;
        try {
            hossz= Integer.parseInt(tfInsertHossz.getText());
        }catch (NumberFormatException e) {
            hossz=0;
        }
        database.InsertFilm(filmcim,mufaj,szinkron,szines,szarmazas,hossz);
        Mutat("");
    }
    public void Update(ActionEvent actionEvent) {
        Mutat("Update");
    }
    public void ShowUpdate(ActionEvent actionEvent) {
        Mutat("ShowUpdate");
        if(cbShowMozi.getSelectionModel().getSelectedItem() == null) Mutat("");
        else
        {
            MoziMusorok kiir = mozibase.getMozi(cbShowMozi.getSelectionModel().getSelectedItem().toString());
            tfUpdateMoziNev.setText(kiir.getMozinev());
            tfupdateIrszam.setText(String.valueOf(kiir.getIrszam()));
            tfupdateCim.setText(String.valueOf(kiir.getCim()));
            tfupdateTelefon.setText(String.valueOf(kiir.getTelefon()));
            cbShowMozi.setDisable(true);
        }

    }
    public void UpdateMozi(ActionEvent actionEvent) {

        MoziMusorok a= mozibase.getMozi(tfUpdateMoziNev.getText());

        MoziMusorok update = new MoziMusorok(a.getMoziazon(),tfUpdateMoziNev.getText(),Integer.parseInt(tfupdateIrszam.getText()),tfupdateCim.getText(),tfupdateTelefon.getText());
        mozibase.UpdateMozi(update);
        cbShowMozi.setDisable(false);
        cbShowMozi.getItems().removeAll(cbShowMozi.getItems());
        Mutat("Update");
    }
    public void Delete(ActionEvent actionEvent) {
        Mutat("Delete");
    }

    public void DeleteMozi(ActionEvent actionEvent) {

        String dMozi = cbShowDeleteMozi.getSelectionModel().getSelectedItem().toString();
        mozibase.deleteMozi(dMozi);
        cbShowDeleteMozi.getItems().removeAll(cbShowDeleteMozi.getItems());
        Mutat("Delete");
    }
    public void FilterStream(ActionEvent actionEvent) {
        ArrayList<Database> adat = database.getAll("");
        ArrayList<String> DataB = new ArrayList<>();
        System.out.println( adat.get(0).toString());
        for(int i =0; i < adat.size(); i++)
        {
            DataB.add(adat.get(i).toString());
        }
        String le ="";
        if(!tfStreamCim.getText().isEmpty())
        {
            le +="^"+tfStreamCim.getText()+",.*";
        }

        System.out.println(le);

        if(cbStreamMufaj.getSelectionModel().getSelectedItem() != null) {
            le += ".*" + cbStreamMufaj.getSelectionModel().getSelectedItem() + ",.*";
        }
        System.out.println(le);

        if(group1.getSelectedToggle() != null )
        {
            RadioButton selectedRadioButton = (RadioButton) group1.getSelectedToggle();
            String toogleGroupValue = selectedRadioButton.getText();
            le += ".*," + toogleGroupValue + ",.*";
        }
        System.out.println(le);

        if(cbStreamSzines.isSelected())
        {
            le+= "false$" ;

        }else{ le+= "true$" ;}

        System.out.println(le);
        Pattern pattern = Pattern.compile(le);

        List<String> matching = DataB.stream()
                .filter(pattern.asPredicate())
                .collect(Collectors.toList());

        System.out.println(matching);

        ArrayList<Database> StreamRned = new ArrayList<>();
        for(int i = 0 ; i < matching.size(); i++)
        {
            String a[] = matching.get(i).split(",");
            Database b = new Database(a[0],a[1],a[2],a[3],a[4],a[5],parseBoolean(a[6]));
            StreamRned.add(b);
        }
        tStream.getItems().removeAll(tStream.getItems());
        tStream.getColumns().removeAll(tStream.getColumns());

        TableColumn filmcim = new TableColumn("filmcim");
        TableColumn szarmazas = new TableColumn("származás");
        TableColumn mufaj = new TableColumn("műfaj");
        TableColumn mozinev = new TableColumn("Mozinév");
        TableColumn cim = new TableColumn("cim");
        TableColumn szinkron = new TableColumn("szinkron");
        TableColumn szines = new TableColumn("szines");

        tStream.getColumns().addAll(filmcim,szarmazas,mufaj,mozinev,cim,szinkron,szines);

        filmcim.setCellValueFactory(new PropertyValueFactory<>("filmcim"));
        szarmazas.setCellValueFactory(new PropertyValueFactory<>("szarmazas"));
        mufaj.setCellValueFactory(new PropertyValueFactory<>("mufaj"));
        mozinev.setCellValueFactory(new PropertyValueFactory<>("mozinev"));
        cim.setCellValueFactory(new PropertyValueFactory<>("cim"));
        szinkron.setCellValueFactory(new PropertyValueFactory<>("szinkron"));
        szines.setCellValueFactory(new PropertyValueFactory<>("szines"));

        tStream.getItems().addAll(StreamRned);

    }


}