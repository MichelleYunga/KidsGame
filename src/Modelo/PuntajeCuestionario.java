/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Shalva
 */
@Entity
@Table(name = "PUNTAJE_CUESTIONARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PuntajeCuestionario.findAll", query = "SELECT p FROM PuntajeCuestionario p"),
    @NamedQuery(name = "PuntajeCuestionario.findByIdPuntaje", query = "SELECT p FROM PuntajeCuestionario p WHERE p.idPuntaje = :idPuntaje")})
public class PuntajeCuestionario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PUNTAJE")
    private BigDecimal idPuntaje;
    @JoinColumn(name = "PC_ID_CUESTIONARIO", referencedColumnName = "ID_CUESTIONARIO")
    @ManyToOne
    private Cuestionario pcIdCuestionario;
    @JoinColumn(name = "PC_ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne
    private Persona pcIdPersona;
    @JoinColumn(name = "PC_ID_RESPUESTA", referencedColumnName = "ID_RESPUESTA")
    @ManyToOne
    private Respuestas pcIdRespuesta;

    public PuntajeCuestionario() {
    }

    public PuntajeCuestionario(BigDecimal idPuntaje) {
        this.idPuntaje = idPuntaje;
    }

    public BigDecimal getIdPuntaje() {
        return idPuntaje;
    }

    public void setIdPuntaje(BigDecimal idPuntaje) {
        this.idPuntaje = idPuntaje;
    }

    public Cuestionario getPcIdCuestionario() {
        return pcIdCuestionario;
    }

    public void setPcIdCuestionario(Cuestionario pcIdCuestionario) {
        this.pcIdCuestionario = pcIdCuestionario;
    }

    public Persona getPcIdPersona() {
        return pcIdPersona;
    }

    public void setPcIdPersona(Persona pcIdPersona) {
        this.pcIdPersona = pcIdPersona;
    }

    public Respuestas getPcIdRespuesta() {
        return pcIdRespuesta;
    }

    public void setPcIdRespuesta(Respuestas pcIdRespuesta) {
        this.pcIdRespuesta = pcIdRespuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPuntaje != null ? idPuntaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuntajeCuestionario)) {
            return false;
        }
        PuntajeCuestionario other = (PuntajeCuestionario) object;
        if ((this.idPuntaje == null && other.idPuntaje != null) || (this.idPuntaje != null && !this.idPuntaje.equals(other.idPuntaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.PuntajeCuestionario[ idPuntaje=" + idPuntaje + " ]";
    }
    
}
