package com.eiv;

public class CajaEntity {
    
    private Long numero;
    private String estacion;
    private String obs;
     
    public CajaEntity() {
        
    }
    
         

    public CajaEntity(Long numero, String estacion, String obs) {
        super();
        this.numero = numero;
        this.estacion = estacion;
        this.obs = obs;
    }



    public Long getNumero() {
        return numero;
    }



    public void setNumero(Long numero) {
        this.numero = numero;
    }



    public String getEstacion() {
        return estacion;
    }



    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }



    public String getObs() {
        return obs;
    }



    public void setObs(String obs) {
        this.obs = obs;
    }



    @Override
    public String toString() {
        return "CajaEntity [numero=" + numero + ", estacion=" + estacion + ", obs=" + obs + "]";
    }


    

}
