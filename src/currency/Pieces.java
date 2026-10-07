package currency;

import java.util.ArrayList;
import java.util.Iterator;

public class Pieces {
    public static final float[] COINS = {0.01f, 0.2f, 0.05f, 0.1f, .2f, .5f, 1.0f, 2.0f};
    public static final int[] BILLS = {5, 10, 20, 50, 100, 200, 500};
    private float amount = 0.0f;

    public Pieces() {}

    public Pieces(float amount) {
        this();
        setAmount(amount);
    }

    public String calculateTotal() {
        // Implement the logic to calculate the total amount based on the pieces
        String r = "Total amount: " + amount +";\n";
        ArrayList<Float> reste = new ArrayList<>();
        float remainder = amount;
        System.out.println("Remainder: " + remainder);

        while(remainder != 0) {
            for(int i = BILLS.length-1; i>=0; i--) {
                int current = BILLS[i];
                if(current <= remainder) {
                    remainder=Math.subtractExact((long) remainder, (long) current);
                    reste.add(Float.valueOf(current));
                }
            }

            for(int i = COINS.length-1; i>=0; i--) {
                float current = COINS[i];
                if(current <= remainder) {
                    remainder=Math.subtractExact((long) remainder, (long) current);
                    reste.add(current);
                }
            }

            if(remainder < COINS[0]) {
                remainder=0;
            }
        }

        r+= joinWithSeparator(reste, ",");
        return r;
    }

    public final static String joinWithSeparator(ArrayList<Float> array, String separator) {
        String s = "";
        for(Iterator<Float> i = array.iterator(); i.hasNext(); ) {
            String current = String.valueOf(i.next());

            s+=current+separator;
        }
        return s;
    }

    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
    public void setAmount(int amount) {
        setAmount((float) amount);
    }
    public void setAmount(double amount) {
        setAmount((float) amount);
    }
}
