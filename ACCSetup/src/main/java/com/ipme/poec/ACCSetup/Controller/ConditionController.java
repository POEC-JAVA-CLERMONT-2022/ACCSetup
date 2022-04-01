package com.ipme.poec.ACCSetup.Controller;

import com.ipme.poec.ACCSetup.Model.Condition;
import com.ipme.poec.ACCSetup.Model.Track;
import com.ipme.poec.ACCSetup.Service.SessionService;
import com.ipme.poec.ACCSetup.Service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ConditionController {

    @Autowired
    private SetupService setupService;

    @GetMapping("conditions")
    public List<Condition> getConditions(){
        return setupService.findAllConditions();
    }

}
