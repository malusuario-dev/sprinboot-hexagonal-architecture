package com.camilo.webdemo.common.util;


import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileUtils {
    public  String getUniqueFile(MultipartFile file) {
        String uniqueFile;

        try (InputStream inputStream = file.getInputStream()){
            String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            uniqueFile = UUID.randomUUID().toString().concat("-").concat(filename);
            Path path = Path.of("uploads/products/");
            if (!Files.exists(path)){
                Files.createDirectories(path);
            }
            Files.copy(inputStream, path.resolve(uniqueFile), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Error al subir la imagen");
        }
        return uniqueFile;
    }
}
