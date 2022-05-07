package com.ipme.poec.ACCSetup.Service.dto.user;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.ipme.poec.ACCSetup.Service.dto.session.SessionDTO;

public class CreateUserDTO {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String password;
	
    private List<SessionDTO> sessions;

	public CreateUserDTO() {
	}

	public CreateUserDTO(@NotBlank String name, @NotBlank String password) {
		this.name = name;
		this.password = password;
	}

	public CreateUserDTO(@NotBlank String name, @NotBlank String password, List<SessionDTO> sessions) {
		this(name, password);
		this.sessions = sessions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<SessionDTO> getSessions() {
		return sessions;
	}

	public void setSessions(List<SessionDTO> sessions) {
		this.sessions = sessions;
	}

    
}
