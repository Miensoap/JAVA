package Modern;

public class Apple {
    String Color;
    int Weight;

    public Apple (String color, int weight){
        this.Color = color;
        this.Weight=weight;
    }

    public Apple() {

    }

    public Apple(Integer integer) {
        this.Weight = integer;
    }

    public Integer getWeight() {
        return this.Weight;
    }
    public String getColor(){
        return this.Color;
    }

    
    
    

}

