package patterns.Decorator;

public class Shoes extends Decorator {
    public Shoes(PersonInterface person) {
        super(person);
    }

    @Override
    public void dress() {
        person.dress();
        System.out.println("He/She is putting shoes on and leaving home.");
    }
}
