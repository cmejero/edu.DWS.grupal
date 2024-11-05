package servicios;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import dtos.ClubDtos;
import repositorio.ClubInterfaz;
/**
 * Clase que se encargarga de gestionar operaciones relacionadas con ClubDto
 */
@Service
public class ClubFuncionalidade {

	//Sirver para inyeccion de dependencias
	@Autowired 
	ClubInterfaz clubinterfaz;
	
	/**
	 *  Metodo que se encarga de obtener todos los registros de ClubDtos desde la base de datos
	 */
	public ArrayList<ClubDtos> getClub(){
		
		return (ArrayList<ClubDtos>) clubinterfaz.findAll(); 
		
	}
	
	/**
	 *  Metodo que se encarga de guardar un nuevo objeto ClubDtos en la base de datos.
	 */
	public ClubDtos guardaclub(ClubDtos club) {
		
		return clubinterfaz.save(club);
		
	}
	
	/**
	 * Metodo que se encarga de buscar un ClubDtos en la base de datos a partir de un identificador único (id)	 
	 * @param id
	 * @return Retorna un objeto ClubDtos
	 */
	public Optional<ClubDtos> getById(Long id){
		
		return clubinterfaz.findById(id);
	}
	
	/**
	 * Metodo que se encarga de actualizar un objeto ClubDtos en la base de datos
	 * @param request
	 * @param id
	 * @return
	 */
	public ClubDtos updateById(ClubDtos request, Long id ){
		
		ClubDtos club = clubinterfaz.findById(id).get();
	
		club.setNombre_club(request.getNombre_club());
		club.setNick_club(request.getNick_club());
		club.setEmail_club(request.getEmail_club());
		club.setPassword_club(request.getPassword_club());
		
		
		return club;
				
	}
	
	/**
	 *  Meodo que se encarga de eliminar un objeto ClubDtos de la base de datos según su id
	 * @param id
	 * @return mensaje de si la eliminacion es exitosa.
	 */
	public Boolean DeleteClub(Long id) {
		
		try {
			
			clubinterfaz.deleteById(id);
			return true;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		
	}
	
	
}
