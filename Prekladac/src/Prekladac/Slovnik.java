package Prekladac;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Slovnik {
    private final Map<String, String> angDoCZ;
    private final Map<String, String> cesDoAng;

    public Slovnik() {
        this.angDoCZ = new HashMap<>();
        this.cesDoAng = new HashMap<>();
    }

    public void pridatSlovicko(String anglictina, String cestina) {
        angDoCZ.put(anglictina, cestina);
        cesDoAng.put(cestina, anglictina);
    }

    public void aktualizaceAnglickehoPrekladu(String anglictina, String novyCesky) {
        if (angDoCZ.containsKey(anglictina)) {
            String staryCesky = angDoCZ.get(anglictina);
            cesDoAng.remove(staryCesky);
        }
        pridatSlovicko(anglictina, novyCesky);
    }

    public void aktualizaceCeskehoPrekladu(String cestina, String novyAnglicky) {
        if (cesDoAng.containsKey(cestina)) {
            String staryAnglicky = cesDoAng.get(cestina);
            angDoCZ.remove(staryAnglicky);
        }
        pridatSlovicko(novyAnglicky, cestina);
    }

    public String prekladDoCestiny(String anglictina) {
        return angDoCZ.get(anglictina);
    }

    public String prekladDoAnglictiny(String cestina) {
        return cesDoAng.get(cestina);
    }

    public Set<Map.Entry<String, String>> getVsecnhySlovicka() {
        return angDoCZ.entrySet();
    }

    public void vymazat() {
        angDoCZ.clear();
        cesDoAng.clear();
    }
}