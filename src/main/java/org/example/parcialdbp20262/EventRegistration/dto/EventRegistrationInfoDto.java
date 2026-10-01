package org.example.parcialdbp20262.EventRegistration.dto;

import org.example.parcialdbp20262.EventRegistration.domain.Status;

import java.util.Date;

public record EventRegistrationInfoDto(Long eventId, Long ticketTypeId,
                                       Long atendeeId, Date registeredAt,
                                       Status status) {
}