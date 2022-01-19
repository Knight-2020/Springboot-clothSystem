package com.demo.clothSystem.controller;

import com.demo.clothSystem.common.Response;
import com.demo.clothSystem.common.UploadResponse;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

@RestController
public class StaticResourceController {
    private final Path path = Paths.get("upload");

    @PostMapping("/upload")
    public Response<UploadResponse> upload(@RequestParam MultipartFile file) {
        try {
            if (!Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
                Files.createDirectory(path);
            }

            Files.copy(file.getInputStream(), this.path.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Could not store the file", e);
        }

        UploadResponse response = new UploadResponse();
        response.setUrl("http://localhost:8081/download?fileName=" + file.getOriginalFilename());
        response.setFileName(file.getOriginalFilename());
        return Response.ok(response);
    }

    @GetMapping("/download")
    public ResponseEntity<Object> download(@RequestParam String fileName) throws FileNotFoundException {
        File file = new File("upload/" + fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", String.format("attachment;fileName=%s",
        new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1)));
        headers.add("Cache-Control", "no-cache,no-store,must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity.ok()
        .headers(headers)
        .contentLength(file.length())
        .contentType(MediaType.parseMediaType("application/octet-stream"))
        .body(resource);
    }
}
