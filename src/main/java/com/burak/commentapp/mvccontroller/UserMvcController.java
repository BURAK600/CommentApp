package com.burak.commentapp.mvccontroller;


import com.burak.commentapp.dto.request.UserCreateRequestDto;
import com.burak.commentapp.repository.entity.User;
import com.burak.commentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/usermvc")
@RequiredArgsConstructor
public class UserMvcController {

   private final UserService userService;

    @GetMapping("/info")
    public ModelAndView getInfo(UserCreateRequestDto userCreateRequestDto){ //şöyle düşün hepsini tek tek yazıyorduk ya
        // buraya onun yerine bir sınıf yazdık metoda urlden gelen
        // aynı isimli yerleri bu sınıfa setliyoruz

        userService.saveWithRequestDto(userCreateRequestDto);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("info");
        modelAndView.addObject("user", userCreateRequestDto);

        return  modelAndView;

    }

    @GetMapping("/registerpage")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;

    }

    @PostMapping("/doregister")
    public ModelAndView doregister(User user){

        userService.save(user);

        return new ModelAndView("redirect:registerpage");

    }

    @GetMapping("/loginpage")
    public ModelAndView login(){

        String email= "Your Email";
        String password = "Your Password";

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        modelAndView.addObject("emaillbl", email);
        modelAndView.addObject("passwordlbl", password);

        return modelAndView;
    }
    @PostMapping("/dologin")
    public ModelAndView dologin(String txteEmail, String txtPassword){

        if(userService.isExistUser(txteEmail,txtPassword)){
            System.out.println("Giris başarılı.");
        }else{
            System.out.println("Kullanıcı adı veya şifre hatalı");
        }
        return null;
    }







}
