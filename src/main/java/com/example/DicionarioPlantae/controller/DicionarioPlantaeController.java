package com.example.DicionarioPlantae.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
@CrossOrigin("*")
public class DicionarioPlantaeController {

    @GetMapping("/")
    public String root(){
        return "forward:index.html";
    }

    @GetMapping("/static/download/dicionarioplantae.apk")
    public ResponseEntity<Resource> downloadApk() throws IOException {
        Resource resource = new ClassPathResource("static/download/dicionarioplantae.apk");

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=DicionarioPlantae.apk");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(resource.contentLength())
                .body(resource);
    }

}
