package com.example.appville.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Nicolas Th on 29/05/2017.
 */

public class Fields implements Serializable {
    //---------------------------
    //         ATTRIBUTS
    //---------------------------

    private String lieu_adresse_2;
    private String descriptif_long;
    private Float googlemap_longitude;
    private String descriptif_court;
    private String theme_de_la_manifestation;
    private String categorie_de_la_manifestation;
    private String commune;
    private Float googlemap_latitude;
    private String horaires;
    private String dates_affichage_horaires;

    //---------------------------
    //      GETTER / SETTER
    //---------------------------

    public String getLieu_adresse_2() {
        return lieu_adresse_2;
    }

    public void setLieu_adresse_2(String lieu_adresse_2) {
        this.lieu_adresse_2 = lieu_adresse_2;
    }

    public String getDescriptif_long() {
        return descriptif_long;
    }

    public void setDescriptif_long(String descriptif_long) {
        this.descriptif_long = descriptif_long;
    }

    public Float getGooglemap_longitude() {
        return googlemap_longitude;
    }

    public void setGooglemap_longitude(Float googlemap_longitude) {
        this.googlemap_longitude = googlemap_longitude;
    }

    public String getDescriptif_court() {
        return descriptif_court;
    }

    public void setDescriptif_court(String descriptif_court) {
        this.descriptif_court = descriptif_court;
    }

    public String getTheme_de_la_manifestation() {
        return theme_de_la_manifestation;
    }

    public void setTheme_de_la_manifestation(String theme_de_la_manifestation) {
        this.theme_de_la_manifestation = theme_de_la_manifestation;
    }

    public String getCategorie_de_la_manifestation() {
        return categorie_de_la_manifestation;
    }

    public void setCategorie_de_la_manifestation(String categorie_de_la_manifestation) {
        this.categorie_de_la_manifestation = categorie_de_la_manifestation;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public Float getGooglemap_latitude() {
        return googlemap_latitude;
    }

    public void setGooglemap_latitude(Float googlemap_latitude) {
        this.googlemap_latitude = googlemap_latitude;
    }

    public String getHoraires() {
        return horaires;
    }

    public void setHoraires(String horaires) {
        this.horaires = horaires;
    }

    public String getDates_affichage_horaires() {
        return dates_affichage_horaires;
    }

    public void setDates_affichage_horaires(String dates_affichage_horaires) {
        this.dates_affichage_horaires = dates_affichage_horaires;
    }

    public List<Float> getGeo_point() {
        return geo_point;
    }

    public void setGeo_point(List<Float> geo_point) {
        this.geo_point = geo_point;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getLieu_nom() {
        return lieu_nom;
    }

    public void setLieu_nom(String lieu_nom) {
        this.lieu_nom = lieu_nom;
    }

    public String getReservation_site_internet() {
        return reservation_site_internet;
    }

    public void setReservation_site_internet(String reservation_site_internet) {
        this.reservation_site_internet = reservation_site_internet;
    }

    public String getReservation_telephone() {
        return reservation_telephone;
    }

    public void setReservation_telephone(String reservation_telephone) {
        this.reservation_telephone = reservation_telephone;
    }

    public String getStation_metro_tram_a_proximite() {
        return station_metro_tram_a_proximite;
    }

    public void setStation_metro_tram_a_proximite(String station_metro_tram_a_proximite) {
        this.station_metro_tram_a_proximite = station_metro_tram_a_proximite;
    }

    public String getNom_de_la_manifestation() {
        return nom_de_la_manifestation;
    }

    public void setNom_de_la_manifestation(String nom_de_la_manifestation) {
        this.nom_de_la_manifestation = nom_de_la_manifestation;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getTarif_normal() {
        return tarif_normal;
    }

    public void setTarif_normal(String tarif_normal) {
        this.tarif_normal = tarif_normal;
    }

    public Integer getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(Integer code_postal) {
        this.code_postal = code_postal;
    }

    public String getManifestation_gratuite() {
        return manifestation_gratuite;
    }

    public void setManifestation_gratuite(String manifestation_gratuite) {
        this.manifestation_gratuite = manifestation_gratuite;
    }

    public String getType_de_manifestation() {
        return type_de_manifestation;
    }

    public void setType_de_manifestation(String type_de_manifestation) {
        this.type_de_manifestation = type_de_manifestation;
    }

    public String getReservation_email() {
        return reservation_email;
    }

    public void setReservation_email(String reservation_email) {
        this.reservation_email = reservation_email;
    }

    private List<Float> geo_point = null;
    private String date_fin;
    private String lieu_nom;
    private String reservation_site_internet;
    private String reservation_telephone;
    private String station_metro_tram_a_proximite;
    private String nom_de_la_manifestation;
    private String identifiant;
    private String date_debut;
    private String tarif_normal;
    private Integer code_postal;
    private String manifestation_gratuite;
    private String type_de_manifestation;
    private String reservation_email;
}
