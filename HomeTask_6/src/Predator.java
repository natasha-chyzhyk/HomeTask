/**
 * Created by Stas on 30.10.2016.
 */
public class Predator {
    private String livingArea;
    private float age;
    private String name;
    private int fang;

    public Predator(String livingArea, float age, String name, int fang) {
        this.livingArea = livingArea;
        this.age = age;
        this.name = name;
        this.fang = fang;
    }

    public String getLivingArea() {
        return livingArea;
    }

    public float getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getFang() {
        return fang;
    }

    public void eat(){

        System.out.println("Herbivorous was eaten by predator");
    }

}
