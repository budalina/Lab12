package lab_inherit;

import java.time.LocalDate;

public class Client extends Person{
    private String[] projects;
    private int purchaseCount;
    private double discount;

    public Client(String name, LocalDate birthDay, String gender, String[] projects, int purchaseCount, double discount) {
        super(name, birthDay, gender);
        this.projects = projects;
        this.purchaseCount = purchaseCount;
        this.discount = discount;
    }

    public Client(String[] projects, int purchaseCount, double discount) {
        this.projects = projects;
        this.purchaseCount = purchaseCount;
        this.discount = discount;
    }

    @Override
    public double bonus() {
        return this.projects.length/10.0*5+this.purchaseCount/20.0*2;
    }

    @Override
    public String toString() {
        String f = "\tPurchaseCount - %d\tDiscount=%.2f\n";
        return "Client -> "+super.toString()+ String.format(f,this.purchaseCount, this.discount);
    }

    @Override
    public String toShortString() {
        return super.toShortString();
    }
}
