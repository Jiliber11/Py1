
class Falda extends Componente {
    private boolean conCremallera;

    // Constructor
    public Falda(int id, String nombre, String talla, String color, boolean esComunitario, double precio, boolean conCremallera) {
        super(id, nombre, talla, color, esComunitario, precio);
        this.conCremallera = conCremallera;
    }

    // Getter y setter para conCremallera
    public boolean isConCremallera() {
        return conCremallera;
    }

    public void setConCremallera(boolean conCremallera) {
        this.conCremallera = conCremallera;
    }

    // Método toString
    @Override
    public String toString() {
        return "Falda{" +
                "conCremallera=" + conCremallera +
                ", id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", talla='" + getTalla() + '\'' +
                ", color='" + getColor() + '\'' +
                ", esComunitario=" + isEsComunitario() +
                ", precio=" + getPrecio() +
                '}';
    }
}
