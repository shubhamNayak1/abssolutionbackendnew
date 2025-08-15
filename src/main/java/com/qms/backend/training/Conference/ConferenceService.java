package com.qms.backend.training.Conference;

import com.qms.backend.training.Location.Location;
import com.qms.backend.training.Location.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConferenceService {

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private LocationRepository locationRepository;

    public List<ConferenceDTO> getAllConferences() {
        List<Conference> conferences = conferenceRepository.findAllWithLocationName();
        return conferences.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ConferenceDTO getConferenceById(int id) {
        Conference conference = conferenceRepository.findByIdWithLocationName(id)
                .orElseThrow(() -> new RuntimeException("Conference not found with id " + id));
        return convertToDTO(conference);
    }

    public ConferenceDTO createConference(ConferenceDTO conferenceDTO) {
        Conference conference = new Conference();
        mapDtoToEntity(conferenceDTO, conference);
        Conference savedConference = conferenceRepository.save(conference);
        return convertToDTO(savedConference);
    }

    public ConferenceDTO updateConference(int id, ConferenceDTO conferenceDTO) {
        Conference conference = conferenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conference not found with id " + id));
        mapDtoToEntity(conferenceDTO, conference);
        Conference updatedConference = conferenceRepository.save(conference);
        return convertToDTO(updatedConference);
    }

    public void deleteConference(int id) {
        Conference conference = conferenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conference not found with id " + id));
        conferenceRepository.delete(conference);
    }

    private void mapDtoToEntity(ConferenceDTO conferenceDTO, Conference conference) {
        conference.setName(conferenceDTO.getName());
        conference.setAddress(conferenceDTO.getAddress());
        conference.setSeatingCapacity(conferenceDTO.getSeatingCapacity());

        Location location = locationRepository.findById(conferenceDTO.getLocationId())
                .orElseThrow(() -> new RuntimeException("Location not found with id " + conferenceDTO.getLocationId()));
        conference.setLocation(location);
    }

    private ConferenceDTO convertToDTO(Conference conference) {
        ConferenceDTO dto = new ConferenceDTO();
        dto.setId(conference.getId());
        dto.setName(conference.getName());
        dto.setAddress(conference.getAddress());
        dto.setSeatingCapacity(conference.getSeatingCapacity());
        dto.setLocationId(conference.getLocation().getId());
        dto.setLocationName(conference.getLocation().getName());
        return dto;
    }
}
