package ni.edu.ucem.webapi.web.reservacion;

import java.util.Date;
import java.util.List;
import ni.edu.ucem.webapi.core.ApiResponse;
import ni.edu.ucem.webapi.modelo.*;
import ni.edu.ucem.webapi.service.ReservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/v1/reservaciones")
public class ReservacionResource {

    private final ReservacionService reservacionService;

    @Autowired
    public ReservacionResource(ReservacionService reservacionService) {
        this.reservacionService = reservacionService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces="application/json")
    public ApiResponse obtener(@PathVariable("id") final int id)
    {
        final Reservacion cuarto = this.reservacionService.obtenerPorId(id);
        return new ApiResponse(ApiResponse.Status.OK, cuarto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST,
            produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse guardarReservacion(@Valid @RequestBody final Reservacion reservacion, BindingResult result)
    {
        if(result.hasErrors())
        {
            throw new IllegalArgumentException(result.getFieldError().getDefaultMessage());
        }

        this.reservacionService.agregar(reservacion);
        return new ApiResponse(ApiResponse.Status.OK, reservacion);
    }
    

}
