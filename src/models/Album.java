package models;

public class Album {
    private final String titre;
    private final String interprete;
    private final Chanson[] chansons;

    public Album(String titre, String interprete, Chanson[] chansons) {
        this.titre = titre;
        this.interprete = interprete;
        this.chansons = chansons;
    }

    public String getTitre() {
        return titre;
    }

    public String getInterprete() {
        return interprete;
    }

    public Chanson[] getChansons() {
        return chansons;
    }

    public int getDureeTotale() {
        int total = 0;
        for (int i = 0; i < chansons.length; i++) {
            total += chansons[i].getDuree();
        }
        return total;
    }

    @Override
    public String toString() {
        int duree = getDureeTotale();
        int minutes = duree / 60;
        int secondes = duree % 60;
        return titre + " par " + interprete + " : " + chansons.length +
            " titre" + (chansons.length > 1 ? "s" : "") + ", durée " +
            minutes + " minutes et " + secondes + " secondes";
    }
}
