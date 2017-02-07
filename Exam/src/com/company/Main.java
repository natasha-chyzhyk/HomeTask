package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        State s = new StateImpl("Virginia", new BigDecimal(110785), 8382993L);
        State s1 = new StateImpl("Alabama", new BigDecimal(135765), 4802740L);
        State s2 = new StateImpl("Kansas", new BigDecimal(213096), 2871238L);
        State s3 = new StateImpl("Washington", new BigDecimal(184827), 6830038L);
        State s4 = new StateImpl("Indiana", new BigDecimal(94321), 6516922L);
        State s5 = new StateImpl("California", new BigDecimal(423970), 37691912L);

        Country CoutryUSA = new CountryImpl("USA", s,s1,s2,s3,s4,s5);

        State c = new StateImpl("Toronto", new BigDecimal(1076395), 12851821L);
        State c1 = new StateImpl("Quebec", new BigDecimal(1542056), 7903001L);
        State c2 = new StateImpl("Alberta", new BigDecimal(661848), 3645257L);
        State c3 = new StateImpl("British Columbia", new BigDecimal(944735), 4400057L);
        State c4 = new StateImpl("Manitoba", new BigDecimal(647797), 1208268L);
        State c5 = new StateImpl("Nova Scotia", new BigDecimal(55284), 921727L);

        Country CoutryCanada = new CountryImpl("Canada", c,c1,c2,c3,c4,c5);

        State u = new StateImpl("Kyiv oblast", new BigDecimal(28121), 2887974L);
        State u1 = new StateImpl("Kharkiv oblast", new BigDecimal(25321), 2731302L);
        State u2 = new StateImpl("Sumy oblast", new BigDecimal(23832), 1123448L);
        State u3 = new StateImpl("Lviv oblast", new BigDecimal(21831), 2537799L);
        State u4 = new StateImpl("Dnipropetrovsk oblast", new BigDecimal(31923), 3276637L);
        State u5 = new StateImpl("Odesa oblast", new BigDecimal(33314), 2396442L);

        Country CoutryUkraine = new CountryImpl("Ukraine", u,u1,u2,u3,u4,u5);

        Set<Country> countries = new HashSet<>();
        countries.add(CoutryUSA);
        countries.add(CoutryCanada);
        countries.add(CoutryUkraine);
        Service serv = new ServiceImpl(countries);

        System.out.println(serv.getCountryPopulation("USA"));

        System.out.println(serv.getBiggestState("Canada"));
        System.out.println(serv.getCountrySquare("Ukraine"));
        System.out.println(serv.getOvercrowdedState("Canada"));
        System.out.println(serv.getOvercrowdedCountry());
        System.out.println(serv.getAverageDensityOfPeopleByStates("Ukraine"));
        System.out.println(serv.getTotalDensityOfPeople("Canada"));

    }
}
