package org.example.modelos;

import org.example.validaciones.ValidacionSeguro;
import org.example.Utilidades.Utilidad;

import java.time.LocalDate;

public class Seguro {

    // Atributos
    private String nombreAsegurado;
    private int edadAsegurado;
    private String beneficiario;
    private double montoCobertura;
    private String tipoPoliza;
    private int duracionPoliza;
    private boolean fumador;
    private boolean enfermedadesPreexistentes;
    private String compañiaSeguros;

    private LocalDate fechaInicioCobertura;
    private String numeroPoliza;
    private ValidacionSeguro validacionSeguro = new ValidacionSeguro();
    private Utilidad utilidad= new Utilidad();
    public Seguro() {
    }

    public Seguro(String nombreAsegurado, int edadAsegurado, String beneficiario,
                  double montoCobertura, String tipoPoliza, int duracionPoliza, boolean fumador,
                  boolean enfermedadesPreexistentes, String compañiaSeguros, String numeroPoliza) {
        this.nombreAsegurado = nombreAsegurado;
        this.edadAsegurado = edadAsegurado;
        this.beneficiario = beneficiario;
        this.montoCobertura = montoCobertura;
        this.tipoPoliza = tipoPoliza;
        this.duracionPoliza = duracionPoliza;
        this.fumador = fumador;
        this.enfermedadesPreexistentes = enfermedadesPreexistentes;
        this.compañiaSeguros = compañiaSeguros;
        this.numeroPoliza = numeroPoliza;
    }

    public String getNombreAsegurado() {
        return nombreAsegurado;
    }

    public void setNombreAsegurado(String nombreAsegurado) {
        try {
            this.validacionSeguro.validarNombreAsegurado(nombreAsegurado);
            this.nombreAsegurado=nombreAsegurado;
            System.out.println("Nombre Ingresado con exito en nuestra BD");
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }

    public int getEdadAsegurado() {
        return edadAsegurado;
    }

    public void setEdadAsegurado(int edadAsegurado) {
        try {
            this.validacionSeguro.validarEdad(edadAsegurado);
            this.edadAsegurado=edadAsegurado;
            System.out.println("Edad ingresada con exito en nuestra BD");
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        try {
            this.validacionSeguro.validarBeneficiario(beneficiario);
            this.beneficiario=beneficiario;
            System.out.println("Beneficiario ingresad@ con exito en nuestra BD");
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }

    public double getMontoCobertura() {
        return montoCobertura;
    }

    public void setMontoCobertura(double montoCobertura) {
        try {
            this.validacionSeguro.validarMonto(montoCobertura);
            this.montoCobertura=montoCobertura;
            System.out.println("Monto ingresado con exito en nuestra BD");
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }

    public String getTipoPoliza() {
        return tipoPoliza;
    }

    public void setTipoPoliza(String tipoPoliza) {
        this.tipoPoliza = tipoPoliza;
    }

    public int getDuracionPoliza() {
        return duracionPoliza;
    }

    public void setDuracionPoliza(int duracionPoliza) {
        this.duracionPoliza = duracionPoliza;
    }

    public boolean isFumador() {
        return fumador;
    }

    public void setFumador(boolean fumador) {
        this.fumador = fumador;
    }

    public boolean isEnfermedadesPreexistentes() {
        return enfermedadesPreexistentes;
    }

    public void setEnfermedadesPreexistentes(boolean enfermedadesPreexistentes) {
        this.enfermedadesPreexistentes = enfermedadesPreexistentes;
    }

    public String getCompañiaSeguros() {
        return compañiaSeguros;
    }

    public void setCompañiaSeguros(String compañiaSeguros) {
        this.compañiaSeguros = compañiaSeguros;
    }

    public LocalDate getFechaInicioCobertura() {
        return fechaInicioCobertura;
    }

    public void setFechaInicioCobertura(String fechaInicioCobertura) {
        try {
            this.validacionSeguro.validarFecha(fechaInicioCobertura);
            this.fechaInicioCobertura=this.utilidad.convertDate(fechaInicioCobertura);
            System.out.println("Fecha ingresada con exito en nuestra BD");
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public String calcularPrima() {
        double primaBase = 500;
        double primaFinal = primaBase;


        if (edadAsegurado < 30) {
            primaFinal -= 100;
        } else if (edadAsegurado > 60) {
            primaFinal += 200;
        }

        // Aplicar ajustes basados en el monto de cobertura
        if (montoCobertura > 1000000) {
            primaFinal += 300;
        }

        return "La prima del seguro de vida es: $" + primaFinal;
    }
}