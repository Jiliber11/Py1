
class Blusa extends Componente {
    private boolean mangaLarga;

    // Constructor
    public Blusa(int id, String nombre, String talla, String color, boolean esComunitario, double precio, boolean mangaLarga) {
        super(id, nombre, talla, color, esComunitario, precio);
        this.mangaLarga = mangaLarga;
    }

    // Getter y setter para mangaLarga
    public boolean isMangaLarga() {
        return mangaLarga;
    }

    public void setMangaLarga(boolean mangaLarga) {
        this.mangaLarga = mangaLarga;
    }

    // Método toString
    @Override
    public String toString() {
        return "Blusa{" +
                "mangaLarga=" + mangaLarga +
                ", id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", talla='" + getTalla() + '\'' +
                ", color='" + getColor() + '\'' +
                ", esComunitario=" + isEsComunitario() +
                ", precio=" + getPrecio() +
                '}';
    }
}
