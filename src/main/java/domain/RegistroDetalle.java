package domain;

/**
 * Clase abstracta que sirve como base para cualquier detalle diario.
 *
 * --- Principios SOLID Aplicados: ---
 * 1. OCP (Open/Closed Principle - Principio Abierto/Cerrado):
 *    Esta clase abstracta permite extender la aplicación con nuevos tipos de detalles de síntomas
 *    o actividades (por ejemplo, RegistroFlujo, ActividadSexual, DetalleDeSintoma)
 *    sin necesidad de modificar el código existente en las clases consumidoras como RegistroDiario.
 *
 * 2. LSP (Liskov Substitution Principle - Principio de Sustitución de Liskov):
 *    Cualquier subclase de RegistroDetalle puede usarse e intercambiarse en lugar de
 *    su clase padre (por ejemplo, al pasarse como argumento a RegistroDiario#imprimirDetallePolimorfico)
 *    sin romper la lógica ni el comportamiento de la aplicación.
 */
public abstract class RegistroDetalle {
    protected int id;
    protected RegistroDiario registroDiario;

    public RegistroDetalle() {
    }

    public RegistroDetalle(int id, RegistroDiario registroDiario) {
        this.id = id;
        this.registroDiario = registroDiario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RegistroDiario getRegistroDiario() {
        return registroDiario;
    }

    public void setRegistroDiario(RegistroDiario registroDiario) {
        this.registroDiario = registroDiario;
    }

    // Método abstracto (Abstracción y Polimorfismo)
    public abstract String obtenerResumen();
}
