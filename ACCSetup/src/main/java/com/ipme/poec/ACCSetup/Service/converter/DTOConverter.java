package com.ipme.poec.ACCSetup.Service.converter;

import java.util.List;

public interface DTOConverter<ENTITY, DTO> {
	
	DTO convertTo(ENTITY entity);
	
	List<DTO> convertTo(List<ENTITY> items);

}
