package com.gcts.api.Controller;

import com.gcts.api.Service.APIService;
import com.gcts.api.model.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Chamodi Sandeepani on 2/22/2020.
 */

@RestController
@RequestMapping("/api")
public class APIController {
    @Autowired
    APIService apiService;

    // Get All APIs
    @GetMapping("/apiDetails")
    public List<API> getAllAPIs() {
        return apiService.getAllAPIs();
    }

    // Create a new API
    @PostMapping("/apiDetails")
    public API createAPI(@Valid @RequestBody API plan) {
        return apiService.createPlan(plan);
    }

    // Get a Single API
    @GetMapping("/apiDetails/{aid}")
    public API getAPIById(@PathVariable(value = "aid") Integer aid) {
        return apiService.getAPIById(aid);
    }

    // Update a API
    @PutMapping("/apiDetails/{aid}")
    public API updateAPI(@PathVariable(value = "aid") Integer aid, @Valid @RequestBody API apiDetails) {
        return apiService.updateAPI(aid, apiDetails);
    }

    //Delete a API
    @DeleteMapping("/apiDetails/{aid}")
    public ResponseEntity<?>  deleteAPI(@PathVariable(value = "aid") Integer aid ) {
        return apiService.deleteAPI(aid);
    }
}
