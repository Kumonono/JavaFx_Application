package com.example.mozimusor;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseSzedo {
        private Connection Con;
        public DatabaseSzedo(String url){//jdbc:sqlite:/c:/adatbazis/feladat.db
            try {
                Con= DriverManager.getConnection(url);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        public ArrayList<Database> getAll(String txt){
            String sql="SELECT filmcim,szarmazas,mufaj,mozinev,cim,szinkron,szines FROM mozi,hely,film where mozi.moziazon=hely.moziazon and film.fkod=hely.fkod "+txt;
            System.out.println(sql);
            ArrayList<Database> data = new ArrayList<Database>();
            try {

                Statement Sta = Con.createStatement();
                ResultSet Res = Sta.executeQuery(sql);
                Res.next();

                if(Res.getRow()==0){return null;}

                String filcim=Res.getString("filmcim");
                String szarmazas=Res.getString("szarmazas");
                String mufaj=Res.getString("mufaj");
                String mozinev=Res.getString("mozinev");
                String cim=Res.getString("cim");
                String szinkron=Res.getString("szinkron");
                boolean szines=Res.getBoolean("szines");
                data.add(new Database(filcim,szarmazas,mufaj,mozinev,cim,szinkron,szines));
                while(Res.next()){
                    filcim=Res.getString("filmcim");
                    szarmazas=Res.getString("szarmazas");
                    mufaj=Res.getString("mufaj");
                    mozinev=Res.getString("mozinev");
                    cim=Res.getString("cim");
                    szinkron=Res.getString("szinkron");
                    szines=Res.getBoolean("szines");

                    data.add(new Database(filcim,szarmazas,mufaj,mozinev,cim,szinkron,szines));
                }
                return data;
            } catch (SQLException e) {
                System.out.println( e.getMessage());
                throw new RuntimeException(e);
            }

        }
        public ArrayList<String> Mufajok() {
            ArrayList<String> lista = new ArrayList<>();
            try {
                Statement st = Con.createStatement();
                ResultSet res = st.executeQuery("SELECT distinct(mufaj) as mufajok FROM film");
                while (res.next()) {

                    String mufaj = res.getString("mufajok");
                    lista.add(mufaj);
                }
                return lista;
            } catch (SQLException e) {
                System.out.println(e);
                return null;
            }
        }


        public void InsertFilm(String filmcim, String mufaj, String szinkron, String szines, String szarmazas, int hossz) {

            try {
                Statement st = Con.createStatement();

                ResultSet res=st.executeQuery("select count(*) as db from film");
                res.next();
                int id=res.getInt("db");
                id++;
                String sql="Insert into film Values ("+id+",'"+filmcim+"','"+szines+"','"+szinkron+"','"+szarmazas+"','"+mufaj+"',"+hossz+")";
                st.execute(sql);
            } catch (SQLException e) {
                System.out.println(e);
            }

        }

    }
