package com.task.project4.controller;

import com.task.project4.model.Developer;
import com.task.project4.model.DeveloperInfo;
import com.task.project4.model.Investment;
import com.task.project4.model.Offer;
import com.task.project4.repository.DeveloperInfoRepository;
import com.task.project4.repository.DeveloperRepository;
import com.task.project4.repository.InvestmentRepository;
import com.task.project4.repository.OfferRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private DeveloperRepository developerRepository;
    private DeveloperInfoRepository developerInfoRepository;
    private InvestmentRepository investmentRepository;
    private OfferRepository offerRepository;


    public HomeController(DeveloperRepository developerRepository,
                          DeveloperInfoRepository developerInfoRepository,
                          InvestmentRepository investmentRepository,
                          OfferRepository offerRepository) {
        this.developerRepository = developerRepository;
        this.developerInfoRepository = developerInfoRepository;
        this.investmentRepository = investmentRepository;
        this.offerRepository = offerRepository;
    }


    @GetMapping("/")
    public String list(Model model) {
        List<Developer> developers = developerRepository.findAll();
        model.addAttribute("developers", developers);

        List<Offer> offers = offerRepository.findPromoted();
        model.addAttribute("offers", offers);

        return "index";
    }


    @GetMapping("/developer")
    public String developer(@RequestParam Long id, Model model) {
        Optional<Developer> optionalDeveloper = developerRepository.findById(id);
        Optional<DeveloperInfo> optionalDeveloperInfo = developerInfoRepository.findById(id);
        if(optionalDeveloper.isPresent() && optionalDeveloperInfo.isPresent()){ //if(developer!=null && developerInfo!=null)
            Developer developer = optionalDeveloper.get();
            DeveloperInfo developerInfo = optionalDeveloperInfo.get();
            model.addAttribute("developer", developer );
            model.addAttribute("developerInfo", developerInfo );

            List<Investment> investments = investmentRepository.findByDeveloper(id);
//            //LUB 2:
//            List<Investment> investments = investmentRepository.findByDeveloper(developer);
//            //LUB 3:
//            List<Investment> investments = investmentRepository.findByDeveloperId(id);
//            //LUB 4:
//            List<Investment> investments = new ArrayList<>();
//            for(Investment investment: developer.getInvestmentList()){
//                investments.add(investment);
//            }

            model.addAttribute("investments", investments );
        }

        return "developerInfo";
    }


    @GetMapping("/investment")
    public String investment(@RequestParam Long id, Model model) {
        Optional<Investment> optionalInvestment = investmentRepository.findById(id);
        if(optionalInvestment.isPresent()){
            Investment investment = optionalInvestment.get();
            model.addAttribute("investment", investment );

            List<Offer> offers = offerRepository.findByInvestment(id);
//            //LUB 2:
//            List<Offer> offers = offerRepository.findByInvestment(investment);
//            //LUB 3:
//            List<Offer> offers = offerRepository.findByInvestmentId(id);
//            //LUB 4:
//            List<Offer> offers = new ArrayList<>();
//            for(Offer offer: investment.getOfferList()){
//                offers.add(offer);
//            }

            model.addAttribute("offers", offers );

        }

        return "investmentInfo";
    }


    @GetMapping("/offer")
    public String offer(@RequestParam Long id, Model model) {
        Optional<Offer> optionalOffer = offerRepository.findById(id);
        if(optionalOffer.isPresent()){
            Offer offer = optionalOffer.get();
            model.addAttribute("offer", offer);
        }

        return "offerInfo";
    }


    @GetMapping("/wyszukaj")
    public String wyszukaj(){

        return "search";
    }


    @GetMapping("/find")
    public String find(@RequestParam Double meterage1, @RequestParam Double meterage2,
                       @RequestParam Double price1, @RequestParam Double price2,
                       @RequestParam String city, //LUB:  @RequestParam (defaultValue = "") String city,
                       @RequestParam(defaultValue = "price") String column,
                       @RequestParam(defaultValue = "asc") String order,
                       Model model){
        if(meterage1 == null){
            meterage1 = Double.MIN_VALUE;
        }
        if(meterage2 == null) {
            meterage2 = Double.MAX_VALUE;
        }
        if(price1 == null) {
            price1 = Double.MIN_VALUE;;
        }
        if(price2 == null) {
            price2 = Double.MAX_VALUE;
        }
        if(city == null){ //LUB:  @RequestParam (defaultValue = "") String city,
            city = "";
        }

        List<Offer> offers = null;
        if(column.equals("price") && order.equals("asc"))
            offers = offerRepository.findPriceAsc(meterage1,meterage2,price1,price2,city);
        else if(column.equals("price") && order.equals("desc"))
            offers = offerRepository.findPriceDesc(meterage1,meterage2,price1,price2,city);
        else if(column.equals("meterage") && order.equals("asc"))
            offers = offerRepository.findMetAsc(meterage1,meterage2,price1,price2,city);
        else if(column.equals("meterage") && order.equals("desc"))
            offers = offerRepository.findMetDesc(meterage1,meterage2,price1,price2,city);

        model.addAttribute("offers", offers);

        return "offersInfo";
    }
}
