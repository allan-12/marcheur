package org.example.model;

import org.example.model.carte.Carte;
import org.example.model.carte.Lieu;
import org.example.model.carte.Rue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public record Marcheur(String name, Carte carte) {
    public List<Lieu> marcheEntre(Lieu lieuDeDépart, Lieu destination) {
        var générateurDeNombresAléatoires = new Random();
        List<Lieu> itinéraire = new ArrayList<>();
        Lieu position = lieuDeDépart;
        itinéraire.add(position);

        while (!position.equals(destination)) {
            List<Lieu> lieuxVoisins = détermineLesLieuxVoisins(position);
            position = prendUnLieuAléatoirement(lieuxVoisins, générateurDeNombresAléatoires);
            itinéraire.add(position);
        }

        return itinéraire;
    }

    private Lieu prendUnLieuAléatoirement(List<Lieu> lieux, Random générateurDeNombresAléatoires) {
        return lieux.get(générateurDeNombresAléatoires.nextInt(lieux.size()));
    }

    private List<Lieu> détermineLesLieuxVoisins(Lieu position) {
        Set<Rue> rues = carte.rues();
        return rues.stream()
                .filter(rue -> rue.getLieu1().equals(position) || rue.getLieu2().equals(position))
                .map(rue -> prendLeLieuSuivant(rue, position))
                .toList();
    }

    private Lieu prendLeLieuSuivant(Rue rue, Lieu position) {
        Lieu lieuSuivant = null;
        if (rue.getLieu1().equals(position)) lieuSuivant = rue.getLieu2();
        if (rue.getLieu2().equals(position)) lieuSuivant = rue.getLieu1();
        return lieuSuivant;
    }
    public void imprimerItinéraire(List<Lieu> itinéraire) {
        System.out.println("Itinéraire de la marche :");
        for (Lieu lieu : itinéraire) {
            System.out.print(lieu.name() + " -> ");
        }
        System.out.println("FIN");
    }
}
