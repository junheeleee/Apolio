package com.ssafy.apolio.service;

import com.ssafy.apolio.domain.Portfolio;
import com.ssafy.apolio.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    @Transactional
    public Long portfolio(String title, String content, String img){
        Portfolio portfolio = new Portfolio();
        portfolio.setTitle(title);
        portfolio.setContent(content);
        portfolio.setImg(img);
        portfolioRepository.save(portfolio);
        return portfolio.getId();
    }

    @Transactional
    public Long portfolioWithFile(String title, String content, String img, String filename){
        Portfolio portfolio = new Portfolio();
        portfolio.setTitle(title);
        portfolio.setContent(content);
        portfolio.setImg(img);
        portfolio.setFile_name(filename);
        portfolioRepository.save(portfolio);
        return portfolio.getId();
    }

    public List<Portfolio> searchAll(){
        return portfolioRepository.findPortfolioAll();
    }

    public Portfolio searchPortfolio(Long id){
        return portfolioRepository.findOne(id);
    }

    @Transactional
    public int updatePortfolio(Portfolio portfolio){
        return portfolioRepository.updatePortfolioById(portfolio);
    }

    @Transactional
    public int deletePortfolio(Long id){
        return portfolioRepository.deletePortfolioById(id);
    }
}
