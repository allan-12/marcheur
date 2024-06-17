package org.example.model.carte;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Rue {
    private final String nom;
    private final Lieu lieu1;
    private final Lieu lieu2;

    public Rue(Lieu lieu1, Lieu lieu2) {
        this.nom = null;
        this.lieu1 = lieu1;
        this.lieu2 = lieu2;
}
}
