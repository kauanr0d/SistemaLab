package model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(schema = "LabQ")
public class AnaliseCliente extends Analise implements Serializable {
    private Cliente cliente;
}
