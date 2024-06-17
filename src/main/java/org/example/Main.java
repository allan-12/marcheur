package org.example;

import org.example.model.Marcheur;
import org.example.model.carte.Carte;
import org.example.model.carte.Lieu;
import org.example.model.carte.Rue;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        var marais = new Lieu("Marais");
        var sekolintsika = new Lieu("Sekolintsika");
        var hei = new Lieu("HEI");
        var pullman = new Lieu("Pullman");
        var balançoire = new Lieu("Balançoire");
        var boulevardDelEurope = new Lieu("Boulevard de l'Europe");
        var nexta = new Lieu("Nexta");
        var esti = new Lieu("ESTI");

        var rue1 = new Rue(marais, sekolintsika);
        var rue2 = new Rue(sekolintsika, hei);
        var andriantsihoarana = new Rue("Rue Andriantsihoarana", hei, pullman);
        var rue3 = new Rue(hei, balançoire);
        var ranaivo = new Rue("Rue Ranaivo", pullman, balançoire);
        var rue4 = new Rue(balançoire, esti);
        var rue5 = new Rue(balançoire, boulevardDelEurope);
        var rue6 = new Rue(esti, boulevardDelEurope);
        var rue7 = new Rue(pullman, nexta);

        var carteDeTana = new Carte(Set.of(rue1, rue2, andriantsihoarana, rue3, ranaivo, rue4, rue5, rue6, rue7));

        var bjarni = new Marcheur("Bjarni", carteDeTana);

        var itinéraireDeBjarni = bjarni.marcheEntre(esti, hei);

        bjarni.imprimerItinéraire(itinéraireDeBjarni);

        var actualLieuDeDépart = itinéraireDeBjarni.get(0);
        var actualLieuDArrivée = itinéraireDeBjarni.get(itinéraireDeBjarni.size() - 1);
        var longueurDeLaMarche = itinéraireDeBjarni.size();

        System.out.println("Départ : " + actualLieuDeDépart.name());
        System.out.println("Arrivée : " + actualLieuDArrivée.name());
        System.out.println("Longueur de la marche : " + longueurDeLaMarche);
    }
    }

