package com.demo.documentos.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "documento")
@Data
public class Documento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDocumento")
    private Long idDocumento;
    
    @Column(name = "nombreDocumento", nullable = false)
    private String nombreDocumento;
    
    @Column(name = "tipoDocumento")
    private String tipoDocumento;
    
    @Column(name = "fechaCreacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    
    @Column(name = "fechaModificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    
    @Column(name = "idExpediente")
    private Long idExpediente;
    
    // Relación con Expediente (solo si se quiere mapear la relación)
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "idExpediente", insertable = false, updatable = false)
    // private Expediente expediente;
} 