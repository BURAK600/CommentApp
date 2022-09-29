package com.burak.commentapp.mvccontroller;


import com.burak.commentapp.dto.request.LoginUserRequestDto;
import com.burak.commentapp.repository.entity.EUserType;
import com.burak.commentapp.repository.entity.User;
import com.burak.commentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class LoginMvcController {

    private final UserService userService;


    @GetMapping("/registerpage")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }
    @PostMapping("/doregister")
    public ModelAndView doregister(User user) {
        userService.save(user);
        return new ModelAndView("redirect:registerpage");
    }

    @GetMapping("/loginpage")
    public ModelAndView login() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        return modelAndView;
    }

    @PostMapping("/dologin")
    public ModelAndView dologin(LoginUserRequestDto loginUserRequestDto) {

        ModelAndView modelAndView = new ModelAndView();
        Optional<User> user = userService.login(loginUserRequestDto.getEmail(), loginUserRequestDto.getPassword());
        if (user.isPresent()) {
            if (user.get().getEUserType().equals(EUserType.ADMIN)) {
                List<User> users =  userService.findAll();
                modelAndView.addObject("users", users);
                modelAndView.setViewName("admin");
            } else {
                modelAndView.setViewName("home");
            }
        } else {

            return new ModelAndView("redirect:login");
        }
        return modelAndView;
    }

/*

 @GetMapping("/admin")
    public ModelAndView admin(){

        ModelAndView modelAndView = new ModelAndView();

      List<User> users =  userService.findAll();
      modelAndView.addObject("users", users);
      modelAndView.setViewName("admin");
      return modelAndView;

    }

    */



}
