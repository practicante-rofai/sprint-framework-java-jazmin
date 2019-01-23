package com.registro_notas.domain;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Alumno {

    @JsonProperty("id_alumno")
    private UUID id_alumno;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("apellido")
    private String apellido;

    @JsonProperty("estado")
    private boolean estado;

   /**
    * @return the id_alumno
    */
   public UUID getId_alumno() {
       return id_alumno;
   }
   /**
    * @param id_alumno the id_alumno to set
    */
   public void setId_alumno(UUID id_alumno) {
       this.id_alumno = id_alumno;
   }

   /**
    * @return the nombre
    */
   public String getNombre() {
       return nombre;
   }
   /**
    * @param nombre the nombre to set
    */
   public void setNombre(String nombre) {
       this.nombre = nombre;
   }

   /**
    * @return the apellido
    */
   public String getApellido() {
       return apellido;
   }
   /**
    * @param apellido the apellido to set
    */
   public void setApellido(String apellido) {
       this.apellido = apellido;
   }

   /**
    * @return the estado
    */
    public boolean getEstado() {
        return estado;
    }
    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}