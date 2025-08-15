package com.qms.backend.training.Conference;

import com.qms.backend.userActivity.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/training/conference")
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private UserActivityService userActivityService;

    @GetMapping
    public ResponseEntity<List<ConferenceDTO>> getAllConference() {
        List<ConferenceDTO> conference = conferenceService.getAllConferences();
        return new ResponseEntity<>(conference, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConferenceDTO> getConferenceById(@PathVariable int id) {
        ConferenceDTO conference = conferenceService.getConferenceById(id);
        return new ResponseEntity<>(conference, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ConferenceDTO> createConference(@RequestBody ConferenceDTO conferenceDTO) {
        ConferenceDTO createdConference = conferenceService.createConference(conferenceDTO);
        return new ResponseEntity<>(createdConference, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConferenceDTO> updateConference(@PathVariable int id, @RequestBody ConferenceDTO conferenceDTO) {
        ConferenceDTO updatedConference = conferenceService.updateConference(id, conferenceDTO);
        return new ResponseEntity<>(updatedConference, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConference(@PathVariable int id) {
        conferenceService.deleteConference(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}