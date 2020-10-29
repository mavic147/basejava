package patterns.Decorator;

public class Underwear extends Decorator {
    public Underwear(PersonInterface person) {
        super(person);
    }

    @Override
    public void dress() {
        person.dress();
        System.out.println("He/She is putting on pants.");
    }
}
