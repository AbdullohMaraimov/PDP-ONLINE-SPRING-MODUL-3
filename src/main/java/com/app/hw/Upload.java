package com.app.hw;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Upload {
    private String originalName;
    private String generatedName;
    private long size;
    private String mimeType;
    private String uploadedPath;
}
