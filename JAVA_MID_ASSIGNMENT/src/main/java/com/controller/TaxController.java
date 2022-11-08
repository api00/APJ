package com.controller;


import com.domain.User;
import com.domain.taxLiability;
import com.repository.TaxRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("/incomeTax")
public class TaxController {
    private TaxRepository taxRepository;

    public TaxController(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    @RequestMapping("/form")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @RequestMapping("/list")
    public String list(Model model) throws SQLException {

        return "list";
    }

    @RequestMapping("/create")
    public String store(Model model,@Valid @ModelAttribute("user") User user, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "department/create";
        }
        taxRepository.create(user);
        taxRepository.createBreakdown(user);
        taxRepository.TaxCalculation(user);
        User arr = taxRepository.get();


        taxLiability tx = new taxLiability();
        ArrayList<Integer> value =tx.Tax(user);
        int result =0;
        for(int i=0;i< value.size();i++){
           result = result + value.get(i);
        }
        int MTPaybale = result/12;
        model.addAttribute("annual",result);
        model.addAttribute("monthly",MTPaybale);
        model.addAttribute("gender", arr.getGender());
        model.addAttribute("name", arr.getName());
        model.addAttribute("desig", arr.getDesignation());
        model.addAttribute("gsal", arr.getGSal());




        return "list";
    }
}
