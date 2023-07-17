package model;
public class Step{
    private String step;
    private int index;

    public Step() {
        step= "";
        index= 0;
    }
    public void reset(){
        step= "";
        index= 0;
    }
    public void setStep(String step){
        this.step += ++index + ". " + step + "\n";
    }
    public String getStep(){
        return this.step;
    }
}