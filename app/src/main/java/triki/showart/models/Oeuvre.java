package triki.showart.models;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HAJEUR on 05/09/2016.
 */
public class Oeuvre {

    public String uid;
    public String titre;
    public String taille;
    public double prix;
    public String description;
    public String  technique;
    public String image;

    public Oeuvre(String uid, String titre, String taille, double prix, String description, String technique, String image) {
        this.uid = uid;
        this.titre = titre;
        this.taille = taille;
        this.prix = prix;
        this.description = description;
        this.technique = technique;
        this.image = image;
    }


    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("titre", titre);
        result.put("taille", taille);
        result.put("prix", prix);
        result.put("description", description);
        result.put("technique", technique);
        result.put("image", image);

        return result;
    }
}
