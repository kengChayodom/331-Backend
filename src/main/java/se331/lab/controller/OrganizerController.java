package se331.lab.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.server.ResponseStatusException;
import se331.lab.entity.Event;
import se331.lab.entity.Organization;
import se331.lab.service.OrganizeService;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class OrganizerController {
    final OrganizeService organizeService;
    @GetMapping("organizers")
    public ResponseEntity<?> getOrganizeLists(@RequestParam(value = "_limit", required = false ) Integer perPage, @RequestParam(value = "_page", required = false ) Integer page) {
        List<Organization> output = null;
        Integer OrganizeSize = organizeService.getOrganizeSize();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-total-count",String.valueOf(OrganizeSize));
        try {
            output = organizeService.getOrganizes(perPage, page);
            return new ResponseEntity<>(output, responseHeaders, HttpStatus.OK);
        }catch (IndexOutOfBoundsException ex){
            return new ResponseEntity<>(output,responseHeaders,HttpStatus.OK);
        }


    }

    @GetMapping("organizers/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Organization output = organizeService.getOrganize(id);
        if (output != null) {
            return ResponseEntity.ok(output);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }
}
