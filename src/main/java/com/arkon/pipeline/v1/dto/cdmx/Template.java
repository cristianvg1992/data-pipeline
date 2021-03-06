package com.arkon.pipeline.v1.dto.cdmx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * La clase Template representa toda la información que se recibe de la API de la Ciudad de México.
 * Cada variable de esta clase representa la llave del json recibido, y tienen como único objetivo
 * representar la información.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Template {
    private String help;
    private boolean success;
    private Results result;
}
