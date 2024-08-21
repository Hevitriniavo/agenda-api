package com.fresh.coding.agendaapi.controllers;

import com.fresh.coding.agendaapi.services.StudentLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/students/levels")
public class StudentLevelController {

    private final StudentLevelService studentLevelService;
}
