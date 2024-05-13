package com.lab01.fp.service;

import com.lab01.fp.model.Account;
import com.lab01.fp.model.Portfolio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PortfolioService {
    private List<Portfolio> portfolios = new ArrayList<Portfolio>();

    public List<Portfolio> getPortfolios() {
        if(portfolios.isEmpty()){
            List<Account> accounts = new ArrayList<>();
            accounts.add(new Account(1, "HDFC", 40000, 3));

            portfolios.add(new Portfolio(1, "US Social Scheme", 0, "USD", Collections.emptyList()));
            portfolios.add(new Portfolio(2, "India Social Scheme", 0, "INR", Collections.emptyList()));
            portfolios.add(new Portfolio(3, "India Bank Accounts", 40000, "INR", accounts));
            portfolios.add(new Portfolio(4, "India Mutual Funds", 0, "INR", Collections.emptyList()));
        }
        return portfolios;
    }

    public Portfolio getPortfolioById(long index) {
        return getPortfolios().stream().filter(p-> p.getId() == index).findFirst().orElse(null);
    }

    public void saveAccount(Account account) {
        account.setId(Double.valueOf(Math.random()*50).intValue());
        Portfolio portfolio =getPortfolioById(Integer.parseInt(""+account.getPortfolioId()));
        if(portfolio != null){
            portfolio.addAccount(account);
        }
    }

    public void deletePortfolio(Integer index) {
        Portfolio portfolio = getPortfolioById(index);
        if(portfolio != null){
            portfolios.remove(portfolio);
        }
    }
}
