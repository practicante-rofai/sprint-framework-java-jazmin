package com.registro_notas.domain;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DetalleNCA {

    @JsonProperty("ui_id_nota")
    private UUID ui_id_nota;

    @JsonProperty("vc_nombre")
    private String vc_nombre;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("apellido")
    private String apellido;

    @JsonProperty("nr_nota")
    private Number nr_nota;

    /**
     * @return the ui_id_nota
     */
    public UUID getUi_id_nota() {
        return ui_id_nota;
    }

    /**
     * @param ui_id_nota the ui_id_nota to set
     */
    public void setUi_id_nota(UUID ui_id_nota) {
        this.ui_id_nota = ui_id_nota;
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
     * @return the nr_nota
     */
    public Number getNr_nota() {
        return nr_nota;
    }

    /**
     * @param nr_nota the nr_nota to set
     */
    public void setNr_nota(Number nr_nota) {
        this.nr_nota = nr_nota;
    }
}