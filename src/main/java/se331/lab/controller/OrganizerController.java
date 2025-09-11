package se331.lab.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;
import se331.lab.entity.Event;
import se331.lab.entity.Organization;
import se331.lab.service.OrganizeService;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class OrganizerController {
    final OrganizeService organizeService;
    @GetMapping("organizes")
    public ResponseEntity<?> getOrganizeLists(@RequestParam(value = "_limit", required = false ) Integer perPage, @RequestParam(value = "_page", required = false ) Integer page) {
        Page<Organization> pageOutput = organizeService.getOrganizes(perPage, page);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-total-count",String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(pageOutput.getContent(), responseHeaders, HttpStatus.OK);

    }

    @GetMapping("organizes/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Organization output = organizeService.getOrganize(id);
        if (output != null) {
            return ResponseEntity.ok(output);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @PostMapping("/organizes")
    public ResponseEntity<?> addOrganize(@RequestBody Organization organization){
        Organization output = organizeService.save(organization);
        return ResponseEntity.ok(output);
    }
}
