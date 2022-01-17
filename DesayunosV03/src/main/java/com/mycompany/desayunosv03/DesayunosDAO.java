package com.mycompany.desayunosv03;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import models.Pedido;
import models.Producto;

public class DesayunosDAO {
    
    private static EntityManager em;
    private static EntityManagerFactory emf;
    
    private static final String LISTAR_CARTA = "Select pr from Producto pr";
    private static final String LISTAR_PEDIDOS = "Select p from Pedido p";
    private static final String PRODUCTO_ID = "Select pr from Producto pr where pr.id=:id";
    private static final String PEDIDO_ID = "Select p from Pedido p where p.id=:id";
    private static final String PENDIENTE_HOY = "Select p from Pedido p where p.recogido='pendiente' and p.fecha=:fecha";
    
    static {
        emf = Persistence.createEntityManagerFactory("desayunos.odb");
        
    }
    
    public List<Producto> MostrarCarta(){
        em = emf.createEntityManager();
        TypedQuery<Producto> q = (TypedQuery<Producto>) em.createQuery(LISTAR_CARTA);
        List carta = q.getResultList();
        em.close();
        
        return carta;
    }
    
    public void guardar(Long id){
        
        try{
            em = emf.createEntityManager();
            Pedido pedido = new Pedido();
            Producto producto = new Producto();
            
            pedido.setProducto(producto);
            pedido.setPrecio(producto.getPrecio());
            pedido.setFecha(fecha());
            pedido.setRecogido("pendiente");
            
            em.getTransaction().begin();
            em.persist(pedido);
            em.getTransaction().commit();
            em.close();
            
        }catch (Exception e){
            System.out.println("Ese producto no existe, inserte un id valido por favor");
            e.printStackTrace();
        }
        
    }
    
    public void guardarProducto(Producto p){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }
    
    private Date fecha(){
            return new Date(Calendar.getInstance().getTimeInMillis());
        }
        
    
    public List<Pedido> MostrarPedidos(){
        em = emf.createEntityManager();
        TypedQuery<Pedido> q = (TypedQuery<Pedido>) em.createQuery(LISTAR_PEDIDOS);
        List pedidos = q.getResultList();
        em.close();
        
        return pedidos;
    }
    
    public List<Pedido> MostrarPendientes(){
        Date FechaHoy = fecha();
        em = emf.createEntityManager();
        TypedQuery<Pedido> q = (TypedQuery<Pedido>) em.createQuery(PENDIENTE_HOY);
        q.setParameter("fecha", FechaHoy);
        List PedidosPendientesHoy = q.getResultList();
        em.close();
        
        return PedidosPendientesHoy;
    }
    
    public void borrar(Long id){
        
        try{
            em = emf.createEntityManager();
            Pedido pedido = getPedido(id, em);
            
            em.getTransaction().begin();
            em.remove(pedido);
            em.getTransaction().commit();
            em.close();
            
        }catch (Exception e){
            System.out.println("Ese pedido no existe, revise que lo ha escrito correctamente");
            e.printStackTrace();
        }
        
    }
    
    public void recoger(Long id){
        
        try{
            em = emf.createEntityManager();
            Pedido pedido = getPedido(id, em);
            
            em.getTransaction().begin();
            pedido.setRecogido("recogido");
            em.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Ese pedido no existe, revise que lo ha escrito correctamente");
            e.printStackTrace();
        }
        
    }
    
    public Producto getProducto(Long id, EntityManager em){
        TypedQuery<Producto> q = (TypedQuery<Producto>) em.createQuery(PRODUCTO_ID);
        q.setParameter("id", id);
        Producto producto = q.getSingleResult();
        
        return producto;
    }
    
    public Pedido getPedido(Long id, EntityManager em){
        TypedQuery<Pedido> q = (TypedQuery<Pedido>) em.createQuery(PEDIDO_ID);
        q.setParameter("id", id);
        Pedido pedido = q.getSingleResult();
        
        return pedido;
    }
    
    
}
