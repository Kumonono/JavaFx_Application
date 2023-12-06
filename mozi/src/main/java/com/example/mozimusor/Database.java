package com.example.mozimusor;

public class Database {
        private String filmcim;
        private String szarmazas;
        private String mufaj;
        private String mozinev;
        private String cim;
        private String szinkron;
        private boolean szines;

        public String getSzinkron() {
            return szinkron;
        }

        public void setSzinkron(String szinkron) {
            this.szinkron = szinkron;
        }

        public boolean isSzines() {
            return szines;
        }

        public void setSzines(boolean szines) {
            this.szines = szines;
        }

        public Database() {
        }

        public String getFilmcim() {
            return filmcim;
        }

        public void setFilmcim(String filmcim) {
            this.filmcim = filmcim;
        }

        public String getSzarmazas() {
            return szarmazas;
        }

        public void setSzarmazas(String szarmazas) {
            this.szarmazas = szarmazas;
        }

        public String getMufaj() {
            return mufaj;
        }

        public void setMufaj(String mufaj) {
            this.mufaj = mufaj;
        }

        public String getMozinev() {
            return mozinev;
        }

        public void setMozinev(String mozinev) {
            this.mozinev = mozinev;
        }

        public String getCim() {
            return cim;
        }

        public void setCim(String cim) {
            this.cim = cim;
        }

        public Database(String filmcim, String szarmazas, String mufaj, String mozinev, String cim,String szinkron,boolean szines) {
            this.filmcim = filmcim;
            this.szarmazas = szarmazas;
            this.mufaj = mufaj;
            this.mozinev = mozinev;
            this.cim = cim;
            this.szinkron=szinkron;
            this.szines=szines;
        }
        @Override
        public String toString() {
            return filmcim+","+szarmazas+","+ mufaj+","+ mozinev+","+ cim+","+ szinkron+","+ szines;
        }
    }
