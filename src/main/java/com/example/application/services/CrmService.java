package com.example.application.services;


import com.example.application.data.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrmService {


    private final ContactRepository contactRepository;
    private final CompanyRepository companyRepository;
    private final StatusRepository statusRepository;

    CrmService(ContactRepository contactRepository, CompanyRepository companyRepository, StatusRepository statusRepository) {

        this.contactRepository = contactRepository;
        this.companyRepository = companyRepository;
        this.statusRepository = statusRepository;
    }


    public List<Contact> findAllContact(String filterText) {

        if (filterText == null || filterText.isEmpty()) {
            return contactRepository.findAll();
        } else {

            return contactRepository.search(filterText);
        }
    }



     public Long countContact()
     {
         return contactRepository.count();
     }


     public void deleteContact(Contact contact)
     {
          contactRepository.delete(contact);
     }

public void saveContact(Contact contact)
{
    if(contact==null)
    {
        System.err.println("Contact is null");
    }
    else {
        contactRepository.save(contact);
    }

}




public List<Company> findAllCompanies()
{
    return companyRepository.findAll();
}
public List<Status> findAllStatus()
{
    return statusRepository.findAll();
}


}
