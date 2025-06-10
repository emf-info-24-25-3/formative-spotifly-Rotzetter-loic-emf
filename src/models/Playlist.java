package models;

public class Playlist {
    private String proprietaire;
    private String nom;
    private Chanson[] chansons;

    public Playlist(String proprietaire, String nom) {
        this.proprietaire = proprietaire;
        this.nom = nom;
        this.chansons = new Chanson[0];
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Chanson[] getChansons() {
        return chansons;
    }

    public boolean contientChanson(Chanson chanson) {
        for (int i = 0; i < chansons.length; i++) {
            if (chansons[i] == chanson) {
                return true;
            }
        }
        return false;
    }

    public boolean ajouterChanson(Chanson chanson) {
        boolean reussite = false;
        boolean chansonDejaPresente = contientChanson(chanson);

        if (!chansonDejaPresente) {
            Chanson[] nouvellePlaylist = new Chanson[chansons.length + 1];
            for (int i = 0; i < chansons.length; i++) {
                nouvellePlaylist[i] = chansons[i];
            }
            nouvellePlaylist[nouvellePlaylist.length - 1] = chanson;
            chansons = nouvellePlaylist;
            reussite = true;
        }

        return reussite;
    }

    public void retirerChanson(Chanson chanson) {
        if (!contientChanson(chanson)) return;

        Chanson[] nouvellePlaylist = new Chanson[chansons.length - 1];
        int index = 0;
        for (int i = 0; i < chansons.length; i++) {
            if (chansons[i] != chanson) {
                nouvellePlaylist[index] = chansons[i];
                index++;
            }
        }
        chansons = nouvellePlaylist;
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
        return "Playlist '" + nom + "' crée par " + proprietaire + " : " +
               chansons.length + " titre" + (chansons.length > 1 ? "s" : "") +
               ", durée " + minutes + " minutes et " + secondes + " secondes";
    }
}
