package less_06_21_05_23_Class_Set;


public class Laptop {
    private String name;
    Integer ram;
    Integer ssd;
    String os;
    String color;
    String cpu;
    Double price;

    public Laptop (String name, Integer ram, Integer ssd, String os, String color, String cpu){
        this.name = name;
        this.ram = ram;
        this.ssd = ssd;
        this.os = os;
        this.color = color;
        this.cpu = cpu;
    }

    public String getName(){
        return this.name;
    }
    
    public Integer getRam(){
        return this.ram;
    }


    public Integer getSsd(){
        return this.ssd;
    }


    public String getOs(){
        return this.os;
    }


    public String getColor(){
        return this.color;
    }


    public void setPrice(Double price){
        this.price = price;
    }

    public void printing(){
        System.out.println(this.name + ", RAM: " + this.ram + ", SSD: " + this.ssd + ", OS: " + this.os + ", CPU: " + this.cpu + ", Цвет: " + this.color +  ", Цена: " + this.price);
    }

    @Override
    public String toString(){
        return this.color + " " + this.name + " с процессором " + this.cpu + " всего за " + this.price + "\n";
    }
}
