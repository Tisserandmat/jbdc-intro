package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import repository.CrudDao;

@Controller
public class PersonController {

    @Autowired
    private CrudDao repository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("person", repository.findAll());

        return "index";
    }




}
