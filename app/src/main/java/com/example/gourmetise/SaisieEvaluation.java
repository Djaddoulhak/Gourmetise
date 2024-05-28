package com.example.gourmetise;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SaisieEvaluation extends AppCompatActivity {

    GourmetiseDAO bdd;

    private EditText dateEditText, codeUniqueEditText, nomBoulagerieEditText;
    private RatingBar noteAccueilRatingBar, notePresentationRatingBar, noteQualiteRatingBar;
    private Button validerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie_evaluation);
        bdd = new GourmetiseDAO<>(this);

        // Récupération des références aux éléments du formulaire
        nomBoulagerieEditText = findViewById(R.id.nom_boulangerie);
        dateEditText = findViewById(R.id.date);
        codeUniqueEditText = findViewById(R.id.code_unique);
        noteAccueilRatingBar = findViewById(R.id.note_accueil);
        notePresentationRatingBar = findViewById(R.id.note_presentation);
        noteQualiteRatingBar = findViewById(R.id.note_qualite);
        validerButton = findViewById(R.id.valider);

        //Récupérer le nom de la boulangerie
        String nomBoulangerie = getIntent().getStringExtra("nom_boulangerie");
        // Définir le nom de la boulangerie comme texte pour nomBoulagerieEditText
        nomBoulagerieEditText.setText(nomBoulangerie);
        // Désactiver l'édition de nomBoulagerieEditText
        nomBoulagerieEditText.setEnabled(false);


        // Définir la date d'aujourd'hui dans le EditText pour la date
        setDateToday();

        // Configuration du listener pour le bouton
        validerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {validerEvaluation();}
        });
    }

    private void setDateToday() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String todayDate = dateFormat.format(calendar.getTime());
        dateEditText.setText(todayDate);
        dateEditText.setEnabled(false);  // Rendre le champ non éditable
    }

    private void validerEvaluation() {
        String nomBoulagerie =nomBoulagerieEditText.getText().toString();
        String date = dateEditText.getText().toString();
        String codeUnique = codeUniqueEditText.getText().toString();

        float noteAccueil = noteAccueilRatingBar.getRating();
        float notePresentation = notePresentationRatingBar.getRating();
        float noteQualite = noteQualiteRatingBar.getRating();

        // Validation des données (exemple basique)
        if (date.isEmpty() || codeUnique.isEmpty() ) {
            Toast.makeText(this, "Veuillez remplir tous les champs.", Toast.LENGTH_LONG).show();
        } else {
            // Vérifier si le code unique existe déjà
            if (bdd.isCodeUniqueUsed(codeUnique)) {
                Toast.makeText(this, "Ce code unique a déjà été utilisé.", Toast.LENGTH_LONG).show();
            } else {


            // Création de l'instance Evaluation

                Evaluation e1 = new Evaluation(nomBoulagerie,date, codeUnique, noteAccueil, notePresentation, noteQualite);


            //Ajouter l'évaluation à la base de données
            bdd.ajouterEvaluation(e1);
                // Si l'évaluation est ajoutée avec succès
                Toast.makeText(this, "Évaluation enregistrée avec succès.", Toast.LENGTH_LONG).show();
            }
        }
    }

}
