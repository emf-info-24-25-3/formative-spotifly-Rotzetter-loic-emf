package models;

public class Chanson {
    public static String interprete;
    public static String titre;
    public static int duree;

    public Chanson(String interprete, String titre, int duree){
        this.interprete = interprete;
        this.titre = titre;
        this.duree = duree;
    }

    public String getInterprete(){
        return interprete;
    }

    public String getTitre(){
        return titre;
    }

    public int getDuree(){
        return duree;
    }

    @Override
    public String toString() {
        int minutes = duree / 60;
        int seconds = duree % 60;
        return interprete + " - " + titre + ", " + minutes + ":" + String.format("%02d", seconds);
    }
}
