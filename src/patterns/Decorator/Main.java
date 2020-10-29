package patterns.Decorator;

public class Main {
    public static void main(String[] args) {
        PersonInterface person1 = new Shoes(new Jeans(new Sweater(new Underwear(new Person("Samantha", "w")))));
        person1.dress();
    }
}
