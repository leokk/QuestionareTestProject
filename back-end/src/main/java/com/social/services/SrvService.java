package com.social.services;

import com.social.dao.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SrvService {
    private final
    ServiceRepository serviceRepository;

    @Autowired
    public SrvService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public void delete(Long id) {
        serviceRepository.delete(id);
    }
    public com.social.entities.Service find(Long id){
       return this.serviceRepository.findById(id);
    }

    public List<com.social.entities.Service> findAllServices(){
//        List<com.social.entities.Service> w =serviceRepository.findAll();
        return serviceRepository.findAll();
    }

    public List<com.social.entities.Service> updateAll(List<com.social.entities.Service> newService) {
        for (com.social.entities.Service w:newService) {
            com.social.entities.Service old = serviceRepository.findById(w.getId());
            if(old!=null){
                old.updateService(w);
                serviceRepository.save(old);
            }
            else
                serviceRepository.save(w);
        }
        return serviceRepository.findAll();
    }

}
