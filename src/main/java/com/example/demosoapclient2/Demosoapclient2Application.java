package com.example.demosoapclient2;

import countries.wsdl.Country;

import countries.wsdl.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demosoapclient2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demosoapclient2Application.class, args);
	}

	@Bean
	CommandLineRunner lookup(CountryClient quoteClient) {
		return args -> {
			String ticker = "Spain";

			if (args.length > 0) {
				ticker = args[0];
				System.out.print(" Response not null");
			}

			GetCountryResponse response = quoteClient.getCountry(ticker);
			Country country = response.getCountry();



			System.err.println( country.getName() +"\n"
								+ country.getCapital() + "\n"
								+ country.getCurrency()+ "\n"
								+ country.getPopulation()+ "\n");
			//GetQuoteResponse response = quoteClient.getQuote(ticker);

		};
	}
}
