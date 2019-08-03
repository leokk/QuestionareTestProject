package com.social.services;

import com.social.dao.WorkerRepository;
import com.social.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    private final
    WorkerRepository workerRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }
    public List<Worker> findAllWorkers(){
        List<Worker> w =workerRepository.findAll();
        return workerRepository.findAll();
    }

    public List<Worker> updateAll(List<Worker> newWorker) {
        for (Worker w:newWorker) {
            Worker old = workerRepository.findById(w.getId());
            if(old!=null){
                old.updateWorker(w);
                workerRepository.save(old);
            }
            else
                workerRepository.save(w);
        }
        return workerRepository.findAll();
    }

    public  Worker findOne(Long id){
        return workerRepository.findById(id);
    }

    public boolean isEmployee(Worker worker){
       return (workerRepository.findByPhone(worker.getPhone())==null);
    }
    public Worker save(Worker worker){
        return  workerRepository.saveAndFlush(worker);
    }
    public void saveAll(List<Worker> worker){
        workerRepository.save(worker);
    }
    public Worker update(Worker worker){
        return workerRepository.save(worker);
    }


    public void delete(long id) {
        workerRepository.delete(id);
    }

}
