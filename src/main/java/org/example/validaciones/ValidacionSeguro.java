package org.example.validaciones;
import org.example.Utilidades.MensajeSeguro;
import org.example.Utilidades.Utilidad;

public class ValidacionSeguro {
    Utilidad utilidad=new Utilidad();

    public ValidacionSeguro() {
    }

    public Boolean validarNombreAsegurado(String nombreAsegurado) throws Exception{
        if(nombreAsegurado.length()>20){
            throw new Exception(MensajeSeguro.NOMBRE_LONGITUD.getMensajeSeguro());
        }
        return true;
    }
    public Boolean validarEdad(Integer edadAsegurado) throws Exception {
        if(edadAsegurado<0 ){
            throw new Exception(MensajeSeguro.EDAD_NEGATIVA.getMensajeSeguro());
        }
        if(edadAsegurado>90){
            throw new Exception(MensajeSeguro.EDAD_MAYOR.getMensajeSeguro());
        }
        return true;
    }
    public Boolean validarMonto(double montoCobertura) throws Exception {
        if(montoCobertura<0.00 || montoCobertura>1500.00){
            throw new Exception(MensajeSeguro.COBERTURA_INCORRECTA.getMensajeSeguro());
        }
        return true;
    }
    public Boolean validarBeneficiario(String beneficiario) throws Exception{
        if(beneficiario.length()>50){
            throw new Exception(MensajeSeguro.BENEFICIARIO_LONGITUD.getMensajeSeguro());
        }
        String expresionRegular="^[a-zA-Z ]+$";
        if (!this.utilidad.buscarCoincidencia(expresionRegular,beneficiario)){
            throw new Exception(MensajeSeguro.BENEFICIARIO_FORMATO.getMensajeSeguro());
        }
        return true;
    }

    public Boolean validarFecha(String fecha) throws Exception{

        String expresionRegular="^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
        if (!this.utilidad.buscarCoincidencia(expresionRegular,fecha)){
            throw new Exception(MensajeSeguro.FECHA_INCORRECTA.getMensajeSeguro());
        }
        return true;
    }

}




