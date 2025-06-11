package com.demo.documentos.service;

import com.demo.documentos.model.Documento;
import com.demo.documentos.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DocumentoService {
    @Autowired
    private DocumentoRepository documentoRepository;

    public Documento getDocumentoById(Long idDocumento) {
        return documentoRepository.findById(idDocumento).orElse(null);
    }

    public Documento updateDocumento(Long idDocumento, Documento updateRequest) {
        Documento documento = documentoRepository.findById(idDocumento).orElse(null);
        if (documento == null) return null;
        
        documento.setNombreDocumento(updateRequest.getNombreDocumento());
        documento.setTipoDocumento(updateRequest.getTipoDocumento());
        documento.setIdExpediente(updateRequest.getIdExpediente());
        documento.setFechaModificacion(new Date());
        
        return documentoRepository.save(documento);
    }

    public Documento createDocumento(Documento documento) {
        documento.setFechaCreacion(new Date());
        return documentoRepository.save(documento);
    }

    @Transactional
    public boolean deleteDocumentoById(Long idDocumento) {
        if (!documentoRepository.existsById(idDocumento)) {
            return false;
        }
        documentoRepository.deleteById(idDocumento);
        return true;
    }

    @Transactional
    public boolean deleteDocumentosByExpediente(Long idExpediente) {
        List<Documento> documentos = documentoRepository.findByIdExpediente(idExpediente);
        if (documentos.isEmpty()) {
            return false;
        }
        documentoRepository.deleteAll(documentos);
        return true;
    }

    // Lógica de negocio para documentos irá aquí
} 