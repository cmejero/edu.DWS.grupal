package controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dtos.ClubDtos;
import servicios.ClubFuncionalidade;

@RestController
@RequestMapping("/club")

/**
 * Clase que se encarga de gestionar las operaciones de CRUD de datos de ClubDto
 */
public class ClubController {

	
	/**
	 * Metodo que implemementa el servicio ClubFuncionalidade para acceder a la lógica de negocio de los clubes.
	 * Permite que  ClubController use sus métodos sin inicializar el servicio manualmente.
	 */
	@Autowired
	private ClubFuncionalidade clubFuncionalidade;
	
	/**
	 * Metodo que se encarga de devolver la lista de clubes.
	 * @return lista de objetos de ClubDto.
	 */
	
	@GetMapping
	public ArrayList<ClubDtos> getClub(){
		return this.clubFuncionalidade.getClub();
		
	}
	
	/**
	 * Metodo que se encarga de guardar un nuevo club.
	 * @param club
	 * @return devuelve el objeto ClubDto nuevo.
	 */
	@PostMapping
	public ClubDtos guardaClub(@RequestBody ClubDtos club) {
		return this.clubFuncionalidade.guardaclub(club);
	}
	
	
	 
	 
	/**
	 * Metodo que se encarga de encontrar un club especifico mediante un id
	 * @param id del club de la ruta
	 * @return contiene los datos del club sí se encuentra.
	 */
	@GetMapping(path = "/{id}")
	public Optional<ClubDtos> getClubbyId(@PathVariable Long id){
		
		return this.clubFuncionalidade.getById(id);
		
	}
	
	/**
	 * Metodo que se encarga de actualizar los datos de un club existente
	 * @param request de los datos actualizados
	 * @param id del club que se a actualizar
	 * @return devuelve el objeto ClubDto actalizado
	 */
	@PutMapping(path = "/{id}")
	public ClubDtos updateClubById(@RequestBody ClubDtos request, long id) {
		
		return this.clubFuncionalidade.updateById(request, id);
		
	}
		
	
	/**
	 * Metodo que se encarga de eliminar un objeto ClubDto mediante su id
	 * @param id del clubDto
	 * @return mensaje de eliminacion
	 */
	@DeleteMapping(path = "/{id}")
	public String deleteClubById(@PathVariable("id") Long id) {
		
		
		boolean ok = this.clubFuncionalidade.DeleteClub(id);
		
		if(ok) {
			return "Club" + id + "Eliminao";
		}else {
			return "No sa Eliminao";
		}
		
	}
	
}
