package com.gcts.api.Service;

import com.gcts.api.Repositary.APIRepository;
import com.gcts.api.exception.ResourceNotFoundException;
import com.gcts.api.model.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chamodi Sandeepani on 2/22/2020.
 */

@Service
public class APIService {

    @Autowired
    APIRepository apiRepository;

    // Get All API
    public List<API> getAllAPIs() {
        return apiRepository.findAll();
    }

    // Create a new API
    public API createAPI(API api) {
        return apiRepository.save(api);
    }

    // Get a Single API
    public API getAPIById(Integer aid) {
        return apiRepository.findById(aid)
                .orElseThrow(() -> new ResourceNotFoundException("API", "aid", aid));
    }

    // Update a API
    public API updateAPI( Integer aid, API apiDetails) {

        API api = apiRepository.findById(aid)
                .orElseThrow(() -> new ResourceNotFoundException("API", "aid", aid));

        api.setType(apiDetails.getType());
        api.setCreatedAt(apiDetails.getCreatedAt());
        api.setUpdatedAt(apiDetails.getUpdatedAt());

        API updatedAPI = apiRepository.save(api);
        return updatedAPI;
    }

    // Delete a API
    public ResponseEntity<?> deleteAPI( Integer id) {
        API api = apiRepository.findById(pid)
                .orElseThrow(() -> new ResourceNotFoundException("API", "id", id));

        apiRepository.delete(api);

        return ResponseEntity.ok().build();
    }
}
