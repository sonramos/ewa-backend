package br.edu.ifpb.sonramos.api.controller;

import br.edu.ifpb.sonramos.api.model.Company;
import br.edu.ifpb.sonramos.api.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }

    @GetMapping("/companies/{id}")
    public Company getCompanyById(@PathVariable("id") Long idCompany){
        return this.companyService.getCompanyById(idCompany);
    }

    @PostMapping("/companies")
    public Company addCompany(@RequestBody Company company){
        return this.companyService.addOrUpdate(company);
    }

    @PutMapping("/companies/{id}")
    public Company updateCompany(@RequestBody Company company){
        return this.companyService.addOrUpdate(company);
    }

    @DeleteMapping("/companies/{id}")
    public void deleteCompany(@PathVariable("id") Long idCompany){
        this.companyService.delete(idCompany);
    }
}
