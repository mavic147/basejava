package patterns.Decorator;

public class Sweater extends Decorator {
    public Sweater(PersonInterface person) {
        super(person);
    }

    @Override
    public void dress() {
        person.dress();
        System.out.println("He/She is putting a sweater on.");
    }
}
