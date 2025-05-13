import java.util.Arrays;

public class Polynomial implements Comparable<Polynomial> 
{

    private final int[] coeff;
    
    public Polynomial(int[] coefficients) 
    {
        int count = 0;
        boolean bool1 = false;
        for (int i = 0; i < coefficients.length; i ++) {
            if ((coefficients[i] == 0 && coefficients[0] == 0) || (coefficients[i] == 0 && coefficients[coefficients.length - 1] == 0)) {
                count++;
                bool1 = true;
            }
        }

        if (coefficients[0] == 0 || coefficients[coefficients.length - 1] == 0) {
            int c = 0;
            int c2 = 0;

            boolean bool2 = false;
            for (int i = 0; i < coefficients.length; i++) {
                if (coefficients[i] == 0) {
                    bool2 = true;
                }
                else {
                    bool2 = false;
                    break;
                }
            }

            for(int i = coefficients.length - 1; 0 < i; i--) {
                if (coefficients[i] == 0) {
                    c++;
                }
                else {
                    break;
                }
            }
            for(int i = 0; i < coefficients.length; i++) {
                if (coefficients[i] == 0) {
                    c2++;
                }
                else {
                    break;
                }
            }

            //do condtion for {0,0,0,0,0}
            int len = coefficients.length - c - c2;
            if (bool2) {
                len = 1;
            }
            int[] new1 = new int[len];


            for (int i = 0; i < new1.length; i++) {
                if (bool2) {
                    new1[0] = 0;
                    break;
                } 
                new1[i] = coefficients[c2];
                c2++;
            }

            this.coeff = Arrays.copyOf(new1, new1.length);
        }

        else if (bool1) {

            int p;
            if (coefficients.length == count + 1) {
                p = 1;
            }
            else {
                p = coefficients.length - count + 1;  
            }
            int[] coefficient2 = new int[p];
            if (coefficients[0] == 0) {
                int c = count - 1;
                for (int i = 0; i < coefficient2.length; i++) {
                    coefficient2[i] = coefficients[c];
                    c++;
                }
            }
            else {
                int count2 = 0;
                if (coefficients.length == count + 1) {
                    count2 = 1;
                }

                for(int i = 0; i <= coefficients.length - count - count2; i++) {
                    coefficient2[i] = coefficients[i];
                }
            }
            this.coeff = Arrays.copyOf(coefficient2, coefficient2.length);
            //System.out.print(Arrays.toString(copy2));
        }
        else {
            this.coeff = Arrays.copyOf(coefficients, coefficients.length);
        }
        
        //coeff = new int[1]; // Modify this
    }
    
    public int getDegree() 
    {
        return coeff.length - 1;
    }
    
    public int getCoefficient(int k) 
    {
       
        if (k > coeff.length - 1) {
            return 0;
        }

        return coeff[k]; // Modify this
    }

    public String getCoeff() {
        return Arrays.toString(this.coeff);
    }
    
    public long evaluate(int x) 
    {
        long num = coeff[0];

        int d = getDegree();
        for (int i = coeff.length - 1; i > 0; i --) {
        
            int c = 1;
            for (int j = 0; j < d; j++) {
                c = c * x;
            }
            num = num + coeff[i] * (c);

            d--;
        }

        return num;
    }
    
    @Override
    public String toString() 
    {
        boolean bool = true;
        for (int s = 0; s < this.coeff.length; s++) {
            if (this.coeff[s] != 0) {
                bool =  false;
            }
        }

        if (bool) {
            return "0";
        }

        int deg = getDegree();
        String eq = "";

        boolean opp = true;
        for (int i = this.coeff.length - 1; i >= 0; i--) {
            int count = i - 1;
            while (count >= 0) {
                if (this.coeff[count] != 0 && this.coeff[count] > 0) {
                    opp = true;
                    break;
                }
                if (this.coeff[count] != 0 && this.coeff[count] < 0) {
                    opp = false;
                    break;
                }
                count --;
            }

            if (this.coeff[i] != 0) {
                if (i == this.coeff.length - 1 && deg > 1 && opp) {
                    eq = coeff[i] + "x^" + deg + " + ";
                }
                else if (i == this.coeff.length - 1 && deg > 1 && !opp) {
                    eq = coeff[i] + "x^" + deg + " - ";
                }
                else if((deg > 1 && opp)) {
                    eq = eq + Math.abs(this.coeff[i]) + "x^" + deg + " + ";
                }
                else if(deg > 1 && !opp) {
                    eq = eq + Math.abs(this.coeff[i]) + "x^" + deg + " - ";
                }
                else if (deg == 1 && opp) {
                    eq = eq + Math.abs(this.coeff[i]) + "x" + " + ";
                }
                else if (deg == 1 && !opp) {
                    eq = eq + Math.abs(this.coeff[i]) + "x" + " - ";
                }
                else {
                    eq = eq + Math.abs(this.coeff[i]) + " ";
                }
            }
            deg--;
        }
        char a = eq.charAt(eq.length() - 2);
        if (!(Character.isDigit(a))) {
            eq = eq.substring(0, eq.length() - 2);
        }
        return eq.trim(); // Modify this
    }
    
    public Polynomial add(Polynomial other) 
    {
        int[] x = new int[(Math.max(other.getDegree(), this.getDegree())) + 1];

        for (int i= 0; i <= Math.max(other.getDegree(), this.getDegree()); i++) {
            x[i] = this.getCoefficient(i) + other.getCoefficient(i);
        }
        
        return new Polynomial(x);
    }
    
    public Polynomial multiply(Polynomial other) 
    {
        int[] arr = new int[other.getDegree() + this.getDegree() + 1];

        for (int i = 0; i < other.coeff.length; i++) { // lowest
            for (int j = 0; j < this.coeff.length; j++) { //highest
                if (arr[i +j] == 0) {
                    arr[i + j] = this.coeff[j] * other.coeff[i];
                }
            }

        }
        return new Polynomial(arr);
    }

    @Override 
    public boolean equals(Object other) 
    {
        if (!(other instanceof Polynomial)) {
            return false;
        }
        boolean bool = true;

        Polynomial poly = (Polynomial) other;

        if (poly.coeff.length == this.coeff.length) {
            for (int i = 0; i < poly.coeff.length; i++) {
                if (poly.coeff[i] == this.coeff[i]) {
                    bool = true;
                }
                else {
                    bool = false;
                    break;
                }
            }

            return bool;
        }
        else {
            return false;
        }
    }
    
    public int compareTo(Polynomial other) 
    {
        if (this.equals(other)) {
            return 0;
        }
        else if (this.getDegree() > other.getDegree()) {
            return 1;
        }
        else if (this.getDegree() < other.getDegree()) {
            return -1;
        }
        else {
            for (int i = 0; i < other.coeff.length; i++) {
                if (other.coeff[i] < this.coeff[i]) {
                    return -1;
                }
                if (other.coeff[i] > this.coeff[i]) {
                    return 1;
                }
            }
        }
        return 0; // Modify this
    }
}