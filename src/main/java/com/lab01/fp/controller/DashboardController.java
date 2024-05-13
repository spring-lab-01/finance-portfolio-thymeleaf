package com.lab01.fp.controller;

import com.lab01.fp.model.Portfolio;
import com.lab01.fp.model.PortfolioDashboardDto;
import com.lab01.fp.service.PortfolioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class DashboardController {

    private final PortfolioService portfolioService;

    public DashboardController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping
    public ModelAndView getPortfolio() {
        ModelAndView mav = new ModelAndView("index");
        Set<PortfolioDashboardDto> portfolioDashboardDtoList = portfolioService.getPortfolios()
                .stream()
                .collect(Collectors.groupingBy(Portfolio::getCurrency))
                .entrySet().stream().map(e -> {
                    PortfolioDashboardDto dto = new PortfolioDashboardDto();
                    dto.setCurrency(e.getKey());
                    dto.setTotalValue(e.getValue().stream().map(Portfolio::getTotalValue).reduce(Double::sum).orElse(0.0));
                    return dto;
                }).collect(Collectors.toSet());

        mav.addObject("portfolioDashboardDtoList", portfolioDashboardDtoList );
        return mav;
    }


}
