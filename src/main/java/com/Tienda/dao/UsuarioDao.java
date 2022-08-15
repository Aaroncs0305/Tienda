package com.Tienda.dao;

import com.Tienda.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {
    
    Usuario findByUsername (String username);
    
    // para dos opciones Usuario findByUsernameOrPassword (String username, String password);
    
    // para listas List<Usuario> findByIdRol (Long idRol);
    
}
