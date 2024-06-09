package lk.ijse.gdse65.AAD_Course_Work.controller;

import lk.ijse.gdse65.AAD_Course_Work.dto.SaleDTO;
import lk.ijse.gdse65.AAD_Course_Work.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sale")
@RequiredArgsConstructor
@CrossOrigin
public class Sale {
    private final SaleService saleService;

    @GetMapping("/health")
    public String healthTest(){
        return "Sales Ok";
    }

    @PostMapping
    public ResponseEntity<Void> createSale(@RequestBody SaleDTO saleDTO) {
        saleService.createSale(saleDTO);
        return ResponseEntity.ok().build();
    }
}

