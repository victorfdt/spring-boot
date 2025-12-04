package nl.elros.exception;

import java.time.LocalDateTime;

public record ResponseException(LocalDateTime timestamp, String message, String details) {
}
