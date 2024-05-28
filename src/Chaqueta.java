
class Chaqueta extends Componente {
    private int numBotones;

    // Constructor
    public Chaqueta(int id, String nombre, String talla, String color, boolean esComunitario, double precio, int numBotones) {
        super(id, nombre, talla, color, esComunitario, precio);
        this.numBotones = numBotones;
    }

    // Getter y setter para numBotones
    public int getNumBotones() {
        return numBotones;
    }

    public void setNumBotones(int numBotones) {
        this.numBotones = numBotones;
    }

    // Método toString
    @Override
    public String toString() {
        return "Chaqueta{" +
                "numBotones=" + numBotones +
                ", id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", talla='" + getTalla() + '\'' +
                ", color='" + getColor() + '\'' +
                ", esComunitario=" + isEsComunitario() +
                ", precio=" + getPrecio() +
                '}';
    }
}

