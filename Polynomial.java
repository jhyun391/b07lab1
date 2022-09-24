public class Polynomial{
    double [] coef;
    

    public Polynomial(){
        this.coef = new double[1];
        this.coef[0] = 0;
    }

    public Polynomial(double [] coef){
        this.coef = new double[coef.length];
        for(int i=0; i<coef.length; i++){
            this.coef[i] = coef[i];
        }
    }

    public Polynomial add(Polynomial p){


        int min = Math.min(this.coef.length, p.coef.length);
        int max = Math.max(this.coef.length, p.coef.length);
        double arr[] = new double[max];
        Polynomial newP = new Polynomial(arr);

        int indicator = 0;

        if(this.coef.length < p.coef.length){
            indicator = 1;
        }

        for(int i=0; i<min; i++){
            newP.coef[i] = p.coef[i] + this.coef[i];
        }

        for(int j=min; j<max; j++){
            if(indicator == 0){
                newP.coef[j] = this.coef[j];
            }
            else{
                newP.coef[j] = p.coef[j];
            }
        }
        return newP;
    }

    public double evaluate(double num){
        double sum = 0;
        for(int i=0; i<this.coef.length; i++){
            sum = sum + this.coef[i] * Math.pow(num,i);
        }
        return sum;
    }

    public boolean hasRoot(double num){
        return (this.evaluate(num) == 0);
    }
}