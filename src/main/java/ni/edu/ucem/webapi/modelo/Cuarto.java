package ni.edu.ucem.webapi.modelo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

/**
 * Usamos anotaciones de validación de JavaBeans; introducidas en JavaEE6
 * @author fmedina
 *
 */
public class Cuarto 
{
    private Integer id;
    
    @NotNull(message = "El número de cuarto es requerido")
    @Range(min = 1, max = Short.MAX_VALUE)
    private Short  numero;
    
    /**
     * ^Anchor the regex at the start of the string
       [\w ] Match an alphanumeric character, underscore or space
       + one or more times
       $ Anchor the regex at the end of the string
     */
    @NotNull
    @NotEmpty(message = "La descripción es requerida.")
    @Pattern(regexp = "^[\\w ]+$")
    private String descripcion;
    
    @NotNull(message = "La categoria del cuarto es requerida.")
    @Range(min = 1, max = 1000)
    private Integer categoria;
    
    private Date fecha = new Date();
    
    public Cuarto()
    {
    }
    
    public Cuarto(final Short numero, final String descripcion, final Integer categoria) {
        this.numero = numero;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public Cuarto(final Integer id, final Short numero, final String descripcion,
            final Integer categoria) 
    {
        this.id = id;
        this.numero = numero;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Short getNumero() {
        return numero;
    }
    public void setNumero(final Short numero) {
        this.numero = numero;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getCategoria() {
        return categoria;
    }
    public void setCategoria(final Integer categoria) {
        this.categoria = categoria;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
