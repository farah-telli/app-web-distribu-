package com.example.job.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;
@Entity
public class Job implements Serializable{


        @Id
        @GeneratedValue
        private int id;
        private String service;
        private boolean etat;

        public int getId() {
            return id;
        }

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public Boolean getEtat() {
            return etat;
        }

        public void setEtat(Boolean etat) {
            this.etat= etat;
        }

        public Job() {
            super();
        }

        public Job(String service) {
            super();
            this.service = service;
        }
        public Job(String service,Boolean etat) {
            super();
            this.service = service;
            this.etat=etat;

        }
    }

