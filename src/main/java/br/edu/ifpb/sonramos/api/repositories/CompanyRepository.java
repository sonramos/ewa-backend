package br.edu.ifpb.sonramos.api.repositories;

import br.edu.ifpb.sonramos.api.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Long> {

    @Query("SELECT c FROM Company c WHERE c.status = true")
    public List<Company> getActiveCompanies();
}
