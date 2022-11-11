package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.UsuarioModel;
import com.example.demo.models.Response.GenericResponse;
import com.example.demo.services.UsuarioService;

@RestController
@RequestMapping("v1/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public GenericResponse<ArrayList<UsuarioModel>> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios2();
    }

    @PostMapping()
    public GenericResponse<UsuarioModel> guardarUsuario(@RequestBody UsuarioModel usuario){
        return usuarioService.guardarUsuario(usuario);
    }

}       

