package com.eli.galacticx.exception;

import java.time.Instant;

public record ApiError(
        Instant timestamp,
        int status,
        String error,
        Object message,
        String path
) {}
