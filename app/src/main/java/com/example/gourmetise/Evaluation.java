package com.example.gourmetise;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class Evaluation {

    private String nomBoulangerie;
    private String codeUnique;
    private String dateEvaluation;
    private float noteCritere1;
    private float noteCritere2;
    private float noteCritere3;



    public Evaluation(String nom, String date, String codeUnique, float noteAccueil, float notePresentation, float noteQualite) {
        this.nomBoulangerie = nom;
        this.dateEvaluation = date;
        this.codeUnique = codeUnique;

        this.noteCritere1 = noteAccueil;
        this.noteCritere2 = notePresentation;
        this.noteCritere3 = noteQualite;
    }

    // Constructeur et getters et setters
    public String getNomBoulangerie() { return nomBoulangerie;}
    public void setNomBoulangerie(String nomBoulangerie) { this.nomBoulangerie = nomBoulangerie;}
    public String getCodeUnique() {
        return codeUnique;
    }
    public void setCodeUnique(String codeUnique) {this.codeUnique = codeUnique;}

    public String getDateEvaluation() {
        return dateEvaluation;
    }
    public void setDateEvaluation(String date) {
        this.dateEvaluation = date;
    }

    public float getNoteCritere1() {
        return noteCritere1;
    }
    public void setNoteCritere1(int note) {this.noteCritere1 = note;}

    public float getNoteCritere2() {
        return noteCritere2;
    }
    public void setNoteCritere2(int note) {this.noteCritere2 = note;}

    public float getNoteCritere3() {
        return noteCritere3;
    }
    public void setNoteCritere3(int note) {
        this.noteCritere3 = note;
    }







}




