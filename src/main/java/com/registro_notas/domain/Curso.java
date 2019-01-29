package com.registro_notas.domain;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Curso {

     @JsonProperty("ui_id_curso")
     private UUID ui_id_curso;

     @JsonProperty("vc_nombre")
     private String vc_nombre;

     @JsonProperty("estado")
     private boolean estado;

     /**
      * @return the ui_id_curso
      */
     public UUID getUi_id_curso() {
          return ui_id_curso;
     }

     /**
      * @param ui_id_curso the ui_id_curso to set
      */
     public void setUi_id_curso(UUID ui_id_curso) {
          this.ui_id_curso = ui_id_curso;
     }

     /**
      * @return the vc_nombre
      */
     public String getVc_nombre() {
          return vc_nombre;
     }

     /**
      * @param vc_nombre the vc_nombre to set
      */
     public void setVc_nombre(String vc_nombre) {
          this.vc_nombre = vc_nombre;
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