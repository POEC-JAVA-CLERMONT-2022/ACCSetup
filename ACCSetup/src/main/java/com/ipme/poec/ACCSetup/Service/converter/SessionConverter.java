package com.ipme.poec.ACCSetup.Service.converter;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ipme.poec.ACCSetup.Model.Session;
import com.ipme.poec.ACCSetup.Service.dto.session.SessionDTO;

@Component
public class SessionConverter implements DTOConverter<Session, SessionDTO> {
	
	@Override
	public SessionDTO convertTo(Session session) {
		SessionDTO dto = new SessionDTO();
		
		BeanUtils.copyProperties(session, dto);
		
		return dto;
		
	}
	
	@Override
	public List<SessionDTO> convertTo(List<Session> sessions) {
		List<SessionDTO> dtos = new LinkedList<>();
		
		for (Session session : sessions) {
            dtos.add(this.convertTo(session));
        }

        return dtos;
		
	}

}
