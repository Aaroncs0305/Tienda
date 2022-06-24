package com.Tienda.controller;

import com.Tienda.dao.ClienteDao;
import com.Tienda.domain.Cliente;
import com.Tienda.service.ClienteService;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class IndexController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/")
    public String inicio(Model model){
        log.info("Ahora se usa arquitectura MVC");
        
        /*String mensaje = "Estamos en la semana 4, saludos.";
        
        model.addAttribute("texto", mensaje);
        
        Cliente cliente = new Cliente("Aarón", "Segura", "asegura60619@ufide.ac.cr", "8624-3402");
        
        model.addAttribute("cliente", cliente);
        
        Cliente cliente2 = new Cliente("Juan", "Lopez", "asegura60619@ufide.ac.cr", "8624-3402");
        
        Cliente cliente3 = new Cliente("Pedro", "Lopez", "asegura60619@ufide.ac.cr", "8624-3402");
        
        var clientes = Arrays.asList(cliente, cliente2, cliente3);
        
        //var clientes = Arrays.asList();*/
        
        var clientes = clienteService.getClientes();
        
        model.addAttribute("clientes", clientes);
        
        return "index";
    }
    
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
        return "modificarCliente";
    }
    
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        
        return "redirect:/";
    }
    
    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);
        
        model.addAttribute("cliente", cliente);
        
        return "modificarCliente";
    }
    
    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente){
        clienteService.delete(cliente);
        
        return"redirect:/";
    }
}
