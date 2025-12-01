package com.example.DicionarioPlantae.service;

import com.example.DicionarioPlantae.dto.request.UserDTORequest;
import com.example.DicionarioPlantae.dto.response.UserDTOResponse;
import com.example.DicionarioPlantae.entity.User;
import com.example.DicionarioPlantae.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<User> listarUser() {
        return userRepository.findAll();
    }

    public User listarUserPorId(Integer idUser) {
        return userRepository.findById(Long.valueOf(idUser)).orElse(null);
    }

    public UserDTOResponse salvar(UserDTORequest userDTORequest) {
        User user = modelMapper.map(userDTORequest, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTOResponse.class);
    }

    public UserDTOResponse atualizar(Integer idUser, UserDTORequest userDTORequest) {
        User user = userRepository.findById(Long.valueOf(idUser)).orElseThrow(() -> new RuntimeException("User not found"));
        modelMapper.map(userDTORequest, user);
        User updatedUser = userRepository.save(user);
        return modelMapper.map(updatedUser, UserDTOResponse.class);
    }

    public void apagar(Integer idUser) {
        userRepository.deleteById(Long.valueOf(idUser));
    }
}
