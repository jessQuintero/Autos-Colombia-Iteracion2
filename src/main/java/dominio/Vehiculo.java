
package dominio;


public class Vehiculo {
    
 private int id;
    private String placa;
    private String color;
    private String marca;
    private String modelo;

    public Vehiculo() {
    }

    public Vehiculo(int id) {
        this.id = id;
    }
    
    
    

    public Vehiculo(int id, String placa, String color, String marca, String modelo) {
        this.id = id;
        this.placa = placa;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
    }
    
     public Vehiculo(String placa, String color, String marca, String modelo) {
        
        this.placa = placa;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    @Override
    public String toString(){
        return "\nVehiculos {"+ "id= "+id+", placa= "+placa+", nombre="+color+", marca= "+marca+", modelo= "+modelo+"}";
        
        
    }

    

}
