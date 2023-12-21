package br.edu.ifpb.sonramos.api.service;

import br.edu.ifpb.sonramos.api.model.Company;
import br.edu.ifpb.sonramos.api.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getCompanies(){
        return this.companyRepository.findAll();
    }

    public Company getCompanyById(Long id){
        return this.companyRepository.findById(id).orElse(null);
    }

    @Transactional
    public Company addOrUpdate (Company company){
        Company currentCompany = this.companyRepository.save(company);
        if (company.getName() == null){
            throw new RuntimeException("A Company must have name");
        } else if (company.getPhone() == null) {
            throw new RuntimeException("A Company must have phone");
        } else if (company.getAddress() == null) {
            throw new RuntimeException("A Company must have address");
        }
        return currentCompany;
    }

    public void delete(Long id){
        this.companyRepository.deleteById(id);
    }
}
