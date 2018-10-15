package com.foodhomie.cook.controllers;

import com.foodhomie.cook.models.Cook;
import com.foodhomie.cook.models.requests.CookReq;
import com.foodhomie.cook.services.CookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class CookController {

    @Autowired
    private CookService cookService;
    // Get A Cook
    @GetMapping(value= "/v1/cooks/{id}", produces = "application/json")
    @CrossOrigin(origins = "http://localhost:8012") // Allow access from this entry point
    //public Optional<Cook> getCook(@PathVariable int id){
    public Cook getCook(@PathVariable int id){
                return cookService.getCook(id);
    }

    // Get All Cooks
   // @CrossOrigin(origins = "http://localhost:8012") // Allow access from this entry point
    @GetMapping("/v1/cooks")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public List<Cook> getAllCooks(){
        return cookService.getAllCooks();
    }

    // Add A Cook
    @CrossOrigin(origins = "http://localhost:8012") // Allow access from this entry point
    @PostMapping("/v1/cooks")
    public ResponseEntity<?> addCook(@RequestBody CookReq cookReq){
        boolean emailFound=false;
     //   List<Cook> allCooks = new ArrayList<>();
        //boolean patternMatch = cookController.emailPattern(cookReq.getEmail());
        //boolean contactNumberLength = cookController.checkContact(cookReq.getContact());
            System.out.print("********************** Before Try - Inside addCook");
        try {
            List<Cook> allCooks = cookService.getAllCooks();

            for(Cook next: allCooks){
                 emailFound = next.getEmail().equals(cookReq.getEmail());
            }

          //  if (cookController.getAllCooks().contains(cookReq.getEmail())) {
            if(emailFound){
                System.out.print("********************** Inside If Email Exist - Inside addCook");
                return new ResponseEntity<String>("Email Id already exists, please use the another email id.", HttpStatus.BAD_REQUEST);
                //throw new emailNotFoundException();
            }/* else if (!patternMatch) {
                return new ResponseEntity<String>("Email Id is not in correct format. Please correct the format.", HttpStatus.UNPROCESSABLE_ENTITY);
            } else if(!contactNumberLength){
                return new ResponseEntity<String>("Contact number is not in correct format. Please enter correct contact number.", HttpStatus.UNPROCESSABLE_ENTITY);
            }*/

            System.out.print("********************** Before addCook Method - Inside addCook");
            cookService.addCook(cookReq);
            System.out.print("********************** Before OK Status - Inside addCook");
            return new ResponseEntity<String>("Succesfully added cook", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
       // cookService.addCook(cookReq);
    }





    // Update A Cook
   @RequestMapping(method = RequestMethod.PUT, value ="/v1/cooks/{id}")
    public void updateCook(@RequestBody CookReq cookReq, @PathVariable int id){
        cookService.updateCook(id, cookReq);
    }



    // Delete A Cook
    @RequestMapping(method = RequestMethod.DELETE, value = "v1/cooks/{id}")
    public void deleteCook(@PathVariable int id) {
        cookService.deleteCook(id);
    }

    public boolean checkEmailPattern(String email){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean checkContactNumber(String contactNumber){
        return true;
    }


}
