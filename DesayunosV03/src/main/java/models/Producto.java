package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Producto implements Serializable{
    
    @Id
    @GeneratedValue(strategy=IDENTITY)
    private Long id;
    
    private String nombre;
    private double precio;
    
    @OneToMany(mappedBy="producto", fetch=FetchType.EAGER)
    private List<Pedido> pedidos;

    public Producto() {
    }

    public Producto(Long id, String nombre, double precio, List<Pedido> pedidos) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
//        this.pedidos = pedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Producto = " + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + '€';
    }
    
    
}
