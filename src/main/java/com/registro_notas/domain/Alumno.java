package com.registro_notas.domain;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Alumno {

    @JsonProperty("idAlumno")
    private UUID ui_idalumno;

    @JsonProperty("name")
    private String vc_nombre;

    @JsonProperty("surname")
    private String vc_apellido;

    /**
     * @return the ui_idalumno
     */
    public UUID getUi_idalumno() {
        return ui_idalumno;
    }
    /**
     * @param ui_idalumno the ui_idalumno to set
     */
    public void setUi_idalumno(UUID ui_idalumno) {
        this.ui_idalumno = ui_idalumno;
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
     * @return the vc_apellido
     */
    public String getVc_apellido() {
        return vc_apellido;
    }
    /**
     * @param vc_apellido the vc_apellido to set
     */
    public void setVc_apellido(String vc_apellido) {
        this.vc_apellido = vc_apellido;
    }
}