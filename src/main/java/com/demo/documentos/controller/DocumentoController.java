package com.demo.documentos.controller;

import com.demo.documentos.model.Documento;
import com.demo.documentos.service.DocumentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {
    private final DocumentoService documentoService;

    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @GetMapping("/ping")
    public String ping() {
        return "Documentos microservice is running";
    }

    @GetMapping("/{idDocumento}")
    public Documento getDocumentoById(@PathVariable Long idDocumento) {
        return documentoService.getDocumentoById(idDocumento);
    }

    @PutMapping("/{idDocumento}")
    public ResponseEntity<Documento> updateDocumento(
            @PathVariable Long idDocumento,
            @RequestBody Documento updateRequest) {
        Documento updated = documentoService.updateDocumento(idDocumento, updateRequest);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @PostMapping
    public ResponseEntity<Documento> createDocumento(@RequestBody Documento documento) {
        Documento created = documentoService.createDocumento(documento);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{idDocumento}")
    public ResponseEntity<Void> deleteDocumento(@PathVariable Long idDocumento) {
        boolean deleted = documentoService.deleteDocumentoById(idDocumento);
        if (!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/expediente/{idExpediente}")
    public ResponseEntity<Void> deleteDocumentosByExpediente(@PathVariable Long idExpediente) {
        boolean deleted = documentoService.deleteDocumentosByExpediente(idExpediente);
        if (!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
} 