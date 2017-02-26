package ni.edu.ucem.webapi.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;


public class Cupos {

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
    private Date desde;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
    private Date hasta;

    private List<Cuarto> cuartos;


    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public List<Cuarto> getCuartos() {
        return cuartos;
    }

    public void setCuartos(List<Cuarto> cuartos) {
        this.cuartos = cuartos;
    }
}
