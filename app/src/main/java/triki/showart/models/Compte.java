package triki.showart.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;
@IgnoreExtraProperties
public class Compte {

    public String username;
    public String email;
    public String mp;
    public String pays;
    public String adressePostal;
    public String bibliographie;
    public String sex;
    public int phone;

    public Compte(String username, String email, String mp, String pays, String adressePostal, String bibliographie, String sex, int phone) {
        this.username = username;
        this.email = email;
        this.mp = mp;
        this.pays = pays;
        this.adressePostal = adressePostal;
        this.bibliographie = bibliographie;
        this.sex = sex;
        this.phone = phone;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("email", email);
        result.put("mp", mp);
        result.put("username", username);
        result.put("biblio", bibliographie);
        result.put("pays", pays);
        result.put("sex", sex);
        result.put("phone", phone);
        result.put("adressePstal", adressePostal);
        return result;
    }
}

