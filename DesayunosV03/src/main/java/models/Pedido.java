package models;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Pedido implements Serializable{
    
    @Id
    @GeneratedValue(strategy=IDENTITY)
    private Long id;
    
    private double precio;
    private Date fecha;
    private String recogido;

    @ManyToOne
    @JoinColumn(name="producto_id")
    private Producto producto;

    public Pedido() {
    }

    public Pedido(Long id, double precio, Date fecha, String recogido) {
        this.id = id;
        this.precio = precio;
        this.fecha = fecha;
        this.recogido = recogido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRecogido() {
        return recogido;
    }

    public void setRecogido(String recogido) {
        this.recogido = recogido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", precio=" + precio + ", fecha=" + fecha + ", recogido=" + recogido + ", producto="  + producto.getNombre() + '}';
    }
    
    
}
