import currency.Pieces;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void print(Object e) {
        System.out.println(e);
    }
    public static void main(String[] args) {
        float amount = 216.76f;
        print("Test");
        print(216.76d-200);
        print(216.76f-200);

        Pieces p = new Pieces(amount);

        print(p.calculateTotal());
    }
}