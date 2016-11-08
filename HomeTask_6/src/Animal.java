/**
 * Created by Stas on 30.10.2016.
 */
public class Animal {
    private String livingArea;
    private float age;
    private String name;

    public Animal(String name, float age, String area) {
        this.name = name;
        this.age = age;
        livingArea = area;
    }

    public void setLivingArea(String livingArea) {
        this.livingArea = livingArea;
    }

    public String getName() {
        return name;
    }

    public float getAge() {
        return age;
    }

    public String getLivingArea() {
        return livingArea;
    }

    public static void sleep(){
        System.out.println("Animal is sleeping");
    }

    public static void makeNoise(){
        System.out.println("Animal makes a noise");
    }
}
