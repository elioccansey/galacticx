package com.eli.galacticx.exception;

public class SatelliteNotFoundException extends RuntimeException {
    public SatelliteNotFoundException(String message) {
        super(message);
    }
}
