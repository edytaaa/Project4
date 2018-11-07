package com.task.project4.controller;

import com.task.project4.model.*;
import com.task.project4.repository.DeveloperInfoRepository;
import com.task.project4.repository.DeveloperRepository;
import com.task.project4.repository.InvestmentRepository;
import com.task.project4.repository.OfferRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class DeveloperController {

    DeveloperRepository developerRepository;
    DeveloperInfoRepository developerInfoRepository;
    InvestmentRepository investmentRepository;
    OfferRepository offerRepository;


    public DeveloperController(DeveloperRepository developerRepository,
                               DeveloperInfoRepository developerInfoRepository,
                               InvestmentRepository investmentRepository,
                               OfferRepository offerRepository) {
        this.developerRepository = developerRepository;
        this.developerInfoRepository = developerInfoRepository;
        this.investmentRepository = investmentRepository;
        this.offerRepository = offerRepository;
    }


    @GetMapping("/dodajDevelopera")
    public String dodajDevelopera(Model model) {
        model.addAttribute("developerAll", new DeveloperAll());

        return "addDeveloperForm";
    }


    @PostMapping("/addDeveloper")
    public String addDeveloper(DeveloperAll developerAll) {
        developerRepository.save(developerAll.getDeveloper());
        developerInfoRepository.save(developerAll.getDeveloperInfo());

        return "redirect:/";
    }


    @GetMapping("/dodajInwestycje")
    public String addInvestment(@RequestParam Long id, Model model) {
        Optional<Developer> optionalDeveloper = developerRepository.findById(id);
        if(optionalDeveloper.isPresent()){
            Developer developer = optionalDeveloper.get();
            Investment investment = new Investment();
            investment.setDeveloper(developer);
            model.addAttribute("investment", investment);
        }

        return "addInvestmentForm";
    }


    @PostMapping("/addInvestment")
    public String addInvestment(Investment investment) {
        investmentRepository.save(investment);

        return "redirect:/developer?id=" + investment.getDeveloper().getId();
    }


    @GetMapping("/dodajOferte")
    public String dodajOferte(@RequestParam Long id, Model model) {
        Optional<Investment> optionalInvestment = investmentRepository.findById(id);
        if(optionalInvestment.isPresent()){
            Investment investment = optionalInvestment.get();
            Offer offer = new Offer();
            offer.setInvestment(investment);
            model.addAttribute("offer",offer);
            model.addAttribute("states", OfferState.values());
        }

        return "addOfferForm";
    }


    @PostMapping("/addOffer")
    public String addOffer(Offer offer) {
        offerRepository.save(offer);

        return "redirect:/investment?id=" + offer.getInvestment().getId();
    }
}
