package com.loveapp.controller;

import com.loveapp.model.Memory;
import com.loveapp.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/memories")
public class MemoryController {
    
    @Autowired
    private MemoryService memoryService;
    
    @GetMapping
    public String listMemories(Model model) {
        model.addAttribute("memories", memoryService.getAllMemories());
        model.addAttribute("memory", new Memory());
        return "memories";
    }
    
    @PostMapping
    public String createMemory(@Valid @ModelAttribute Memory memory,
                            BindingResult result,
                            @RequestParam("imageFile") MultipartFile imageFile,
                            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "memories";
        }
        
        try {
            memoryService.saveMemory(memory, imageFile);
            redirectAttributes.addFlashAttribute("success", "Recuerdo guardado exitosamente!");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("error", "Error al guardar la imagen");
        }
        
        return "redirect:/memories";
    }
    @PostMapping("/guardar-recuerdo")
    public String guardarRecuerdo(@ModelAttribute Memory memory) {
        memoryService.save(memory);
            return "redirect:/";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteMemory(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            memoryService.deleteMemory(id);
            redirectAttributes.addFlashAttribute("success", "Recuerdo eliminado exitosamente!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar el recuerdo");
        }
        return "redirect:/memories";
    }
    
    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Optional<Memory> memory = memoryService.getMemoryById(id);
        
        if (memory.isPresent() && memory.get().getImage() != null) {
            byte[] image = memory.get().getImage();
            String contentType = memory.get().getImageContentType();
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(contentType));
            headers.setContentLength(image.length);
            
            return new ResponseEntity<>(image, headers, HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}