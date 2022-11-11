package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.models.UsuarioModel;
import com.example.demo.models.Response.GenericResponse;
import com.example.demo.repositories.UsuarioRespository;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRespository usuarioRespository;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>)usuarioRespository.findAll();
    }
    
    public GenericResponse<ArrayList<UsuarioModel>> obtenerUsuarios2(){
        try {
            var list = (ArrayList<UsuarioModel>)usuarioRespository.findAll();
            return new GenericResponse<ArrayList<UsuarioModel>>(HttpStatus.OK,"exitoso",true,list);
        } catch (Exception exception) {
            return new GenericResponse<ArrayList<UsuarioModel>>(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage(),false,null);
        }
    }

    public GenericResponse<UsuarioModel> guardarUsuario(UsuarioModel usuario){
        try {
            return new GenericResponse<UsuarioModel>(HttpStatus.OK,"exitoso",true,usuarioRespository.save(usuario));
        } catch (Exception exception) {
            return new GenericResponse<UsuarioModel>(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage(),false,null);
        }
    }

}
