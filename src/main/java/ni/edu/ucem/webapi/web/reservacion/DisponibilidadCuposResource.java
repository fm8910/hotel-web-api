package ni.edu.ucem.webapi.web.reservacion;

import ni.edu.ucem.webapi.core.ApiResponse;
import ni.edu.ucem.webapi.modelo.Cuarto;
import ni.edu.ucem.webapi.modelo.Cupos;
import ni.edu.ucem.webapi.service.ReservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/v1/disponibilidad/cupos")
public class DisponibilidadCuposResource {
    
    private final ReservacionService reservacionService;

    @Autowired
    public DisponibilidadCuposResource(final ReservacionService reservacionService) {
        this.reservacionService = reservacionService;
    }

    @RequestMapping(method = RequestMethod.GET, produces="application/json")
    public ApiResponse cupos(
            @RequestParam(value = "fechaIngreso", required = true) @DateTimeFormat(pattern="dd-MM-yyyy") final Date desde,
            @RequestParam(value = "fechaSalida", required = true)  @DateTimeFormat(pattern="dd-MM-yyyy") final Date hasta,
            @RequestParam(value = "categoria", required = false) final Integer categoria)
    {

        Cupos cupos= new Cupos();
        List<Cuarto> cuarto;
        cuarto= this.reservacionService.cuartosDisponibles(categoria,desde, hasta);

        cupos.setDesde(desde);
        cupos.setHasta(hasta);
        cupos.setCuartos(cuarto);
        return new ApiResponse(ApiResponse.Status.OK, cupos);
    }
}
