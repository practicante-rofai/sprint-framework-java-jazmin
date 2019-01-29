package com.registro_notas.domain;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Nota {

    @JsonProperty("ui_id_nota")
    private UUID ui_id_nota;

    @JsonProperty("ui_id_curso")
    private UUID ui_id_curso;

    @JsonProperty("id_alumno")
    private UUID id_alumno;

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