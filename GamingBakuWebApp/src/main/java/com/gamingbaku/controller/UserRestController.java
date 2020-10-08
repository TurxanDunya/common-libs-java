package com.gamingbaku.controller;

import com.gamingbaku.dto.ResponseDTO;
import com.gamingbaku.dto.UserDTO;
import com.gamingbaku.entity.User;
import com.gamingbaku.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@ComponentScan(basePackages = "com.gamingbaku")
public class UserRestController {

    @Autowired
    private UserServiceInter userServiceInter;

    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> getUsers(
            @RequestParam(name="name", required = false) String name,
            @RequestParam(name="surname", required = false) String surname
    ){
        List<User> users = userServiceInter.getAll(name, surname);
        List<UserDTO> userDTOS = new ArrayList<>();

        for (int i = 0; i<users.size(); i++){
            User u = users.get(i);
            userDTOS.add(new UserDTO(u));
        }

        return ResponseEntity.ok(ResponseDTO.of(userDTOS));
    }

    @GetMapping("/login")
    public String index() {
        return "Salam";
    }
}
