package com.ipme.poec.ACCSetup.Service.converter;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ipme.poec.ACCSetup.Model.User;
import com.ipme.poec.ACCSetup.Service.dto.user.UserDTO;

@Component
public class UserConverter implements DTOConverter<User, UserDTO>{

	@Override
	public UserDTO converterTo(User user) {
		UserDTO dto = new UserDTO();
		
		return dto;
	}
	
	@Override
    public List<UserDTO> convertTo(List<User> users) {
        List<UserDTO> dtos = new LinkedList<>();

        for (User user : users) {
            dtos.add(this.converterTo(user));
        }

        return dtos;
    }
}
