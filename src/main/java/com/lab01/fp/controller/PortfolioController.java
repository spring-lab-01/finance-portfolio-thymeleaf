package com.lab01.fp.controller;

import com.lab01.fp.model.Account;
import com.lab01.fp.model.Portfolio;
import com.lab01.fp.service.PortfolioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping("/portfolios")
    public ModelAndView getPortfolio() {
        ModelAndView mav = new ModelAndView("portfolios");
        mav.addObject("portfolios", portfolioService.getPortfolios());
        mav.addObject("selectedPortfolio", new Portfolio());
        return mav;
    }
    @PostMapping(value = "/portfolios", params = {"edit"})
    public ModelAndView getPortfolio(final HttpServletRequest request) {
        final Integer index = Integer.valueOf(request.getParameter("edit"));
        ModelAndView mav = new ModelAndView("portfolios");
        mav.addObject("portfolios", portfolioService.getPortfolios());
        mav.addObject("selectedPortfolio", portfolioService.getPortfolioById(index));
        return mav;
    }

    @PostMapping(value = "/portfolios", params = {"delete"})
    public String deletePortfolio(final HttpServletRequest request) {
        final Integer index = Integer.valueOf(request.getParameter("delete"));
        portfolioService.deletePortfolio(index);
        return "redirect:/portfolios";
    }

    @RequestMapping(value = "/accounts", params = {"addrow"})
    public ModelAndView addAccountRow(final HttpServletRequest request) {
        final Integer index = Integer.valueOf(request.getParameter("addrow"));
        ModelAndView mav = new ModelAndView("addAccountView");
        Portfolio  portfolio = portfolioService.getPortfolioById(index);
        mav.addObject("selectedPortfolio", portfolio);
        Account account = new Account();
        account.setPortfolioId(portfolio.getId());
        mav.addObject("account", account);
        return mav;
    }

    @PostMapping(value = "/portfolios", params = {"editView"})
    public ModelAndView editPortfolio(final HttpServletRequest request) {
        final Integer index = Integer.valueOf(request.getParameter("editView"));
        ModelAndView mav = new ModelAndView("editportfolio");
        mav.addObject("selectedPortfolio", portfolioService.getPortfolioById(index));
        return mav;
    }

    @RequestMapping(value = "/accounts", params = {"save"})
    public ModelAndView saveAccount(final Account account, final BindingResult bindingResult) {
        portfolioService.saveAccount(account);
        ModelAndView mav = new ModelAndView("portfolios");
        mav.addObject("portfolios", portfolioService.getPortfolios());
        mav.addObject("selectedPortfolio", portfolioService.getPortfolioById(account.getPortfolioId()));
        return mav;
    }
}
