package com.foodhomie.cook.services;

import com.foodhomie.cook.models.Cook;
import com.foodhomie.cook.models.CookProfile;
import com.foodhomie.cook.models.requests.CookReq;
import com.foodhomie.cook.repositories.CookProfileRepository;
import com.foodhomie.cook.repositories.CookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CookService {

    @Autowired
    private CookRepository cookRepository;

    @Autowired
    private CookProfileRepository cookProfileRepository;



    // Find One Cook
    public Cook getCook(int id) {
       // if(cookRepository.existsById(id))
            //Throw Exception

        return cookRepository.findById(id).get();
    }

    // Find all cooks
    public List<Cook> getAllCooks() {
        List<Cook> cooks = new ArrayList<>();
        cookRepository.findAll().forEach(cooks::add);
        return cooks;
    }


    // Insert new cook
    public void addCook(CookReq cookReq) {
        //if(cookRepository.existsById())
        Cook cook = new Cook(cookReq);
        CookProfile cookProfile = new CookProfile(cookReq);

        cook.setCookProfile(cookProfile);
        cookProfile.setCook(cook);

        cookRepository.save(cook);
        //cookProfileRepository.save(cookProfile);
    }



    public void updateCook(int id, CookReq cookReq) {
        if(cookRepository.existsById(id)){
           Cook cookUpdate = cookRepository.findById(id).get();
           CookProfile cookProfileUpdate = cookUpdate.getCookProfile();

           Cook ck = new Cook(cookUpdate);
           CookProfile cp = new CookProfile(cookProfileUpdate);

           ck.setCookProfile(cp);
           cp.setCook(ck);

           cookRepository.save(ck);

        }
    }

    public void deleteCook(int id) {
        if(cookRepository.existsById(id)){
            cookRepository.deleteById(id);
        }
    }


  /*  public void updateCookStatus(String id, String status) {
        if(cookRepository.existsById(id)) {
            Cook updateCook = cookRepository.findById(id).get();

            updateCook.
        }
    }*/

}
