import java.util.stream.IntStream;

public class Polynomial{
    double [] coef;
    int [] exp;
    

    public Polynomial(){
        this.coef = new double[1];
        this.exp = new int[1];
        this.coef[0] = 0;
        this.exp[0] = 0;
    }

    public Polynomial(double [] coef, int [] exp){
        this.coef = new double[coef.length];
        this.exp = new int[exp.length];
        for(int i=0; i<coef.length; i++){
            this.coef[i] = coef[i];
        }
        for(int j=0; j<exp.length; j++){
            this.exp[i] = exp[i];
        }
    }

    public Polynomial add(Polynomial p){

        int max = Math.max(p.exp.length, this.exp.length);
        for(int i=0; i<max; i++){
            if(p.coef[i] == this.coef[i]){
                max--;
            }
        }

        int [] newCoef = new int[max];
        int [] newExp = new int[max];
        int cp = 0;

        for(cp=0; cp<p.coef.length; cp++){
            if(IntStream.of(newCoef).anyMatch(x -> x == p.coef[cp])){
                newCoef[cp] = p.coef[cp];
            }
        }
        
        for(int j=i; j<this.coef.length; j++){
            if(IntStream.of(newCoef).anyMatch(x -> x == this.coef[cp])){
                newCoef[cp] = this.coef[cp];
                cp++;
            } 
        }
        for(int i=0; i<max; i++){
            int val1 = Arrays.asList(this.coef).indexOf(newCoef[i]);
            int val2 = Arrays.asList(p.coef).indexOf(newCoef[i]);
            int add1 = this.coef[i];
            int add2 = p.coef[i];
            if(val1 == -1){
                add1 = 0;
            }
            if(val2 == -1){
                add2 = 0;
            }
            newExp[i] = add1 = add2;
        }

        Polynomial newP = new Polynomial(newCoef, newExp);
        return newP;
    }

    public double evaluate(double num){
        double sum = 0;
        for(int i=0; i<this.coef.length; i++){
            sum = sum + this.coef[i] * Math.pow(num,this.exp[i]);
        }
        return sum;
    }

    public boolean hasRoot(double num){
        return (this.evaluate(num) == 0);
    }
}