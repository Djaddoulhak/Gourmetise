package com.example.gourmetise;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class GourmetiseHelper extends SQLiteOpenHelper {
    public GourmetiseHelper(@Nullable Context context)
    {
        super(context, "baseGourmetise.db", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
// création des tables de la base embarquée
// création de la table
        db.execSQL("CREATE TABLE Boulangerie ("
                + "siren TEXT NOT NULL PRIMARY KEY,"
                + "nom TEXT NOT NULL,"
                + "rue TEXT NOT NULL,"
                + "ville TEXT NOT NULL,"
                + "code_postal TEXT NOT NULL,"
                + "descriptif TEXT NOT NULL);");

        db.execSQL("CREATE TABLE Evaluation ("
                + "code_unique TEXT NOT NULL PRIMARY KEY,"
                + "date_evaluation TEXT NOT NULL,"
                + "note_critere1 INTEGER NOT NULL,"
                + "note_critere2 INTEGER NOT NULL,"
                + "note_critere3 INTEGER NOT NULL,"
                + "siren TEXT NOT NULL,"
                + "FOREIGN KEY(siren) REFERENCES Boulangerie(siren));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Boulangerie;");
        db.execSQL("DROP TABLE IF EXISTS Evaluation;");
        onCreate(db);
    }


}

