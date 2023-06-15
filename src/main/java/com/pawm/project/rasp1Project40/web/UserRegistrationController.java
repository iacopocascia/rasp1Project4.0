package com.pawm.project.rasp1Project40.web;

import com.pawm.project.rasp1Project40.service.UserService;
import com.pawm.project.rasp1Project40.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    @ResponseBody
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping()
    public String showRegistrationForm() {
        return "registration.html";
    }

    @PostMapping()
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        System.out.println("CREDENTIALS= "+registrationDto.getFirstName()+" "+registrationDto.getLastName()+" "+registrationDto.getEmail()+" "+registrationDto.getPassword());
        return "redirect:/registration?success";
    }
}
