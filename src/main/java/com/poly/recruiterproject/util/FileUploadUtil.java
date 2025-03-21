package com.poly.recruiterproject.util;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;

public class FileUploadUtil {
    public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        // Log thư mục lưu file
        System.out.println("Upload directory: " + uploadPath.toAbsolutePath());

        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectories(uploadPath);
                System.out.println("Created directory: " + uploadPath.toAbsolutePath());
            } catch (IOException e) {
                System.out.println("Could not create directory: " + uploadPath);
                throw e;
            }
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);

            // Log đường dẫn đầy đủ của file
            System.out.println("Saving file to: " + filePath.toAbsolutePath());

            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
            throw new IOException("Could not save file " + fileName, e);
        }
    }
}
