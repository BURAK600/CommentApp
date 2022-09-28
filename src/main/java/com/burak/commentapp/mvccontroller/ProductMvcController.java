package com.burak.commentapp.mvccontroller;

import com.burak.commentapp.dto.request.ProductCreateRequestDto;
import com.burak.commentapp.repository.entity.Product;
import com.burak.commentapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("/productmvc")
@RequiredArgsConstructor
public class ProductMvcController {

    private final ProductService productService;

    @GetMapping("/savepage")
    public ModelAndView save(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("saveProduct");
        return modelAndView;
    }
    @PostMapping("savemvc")
    public ModelAndView doSave(ProductCreateRequestDto productCreateRequestDto){

        ModelAndView modelAndView = new ModelAndView();
        productService.saveWithRequestDto(productCreateRequestDto);
        modelAndView.setViewName("redirect:savepage");

        return modelAndView;

    }
}
