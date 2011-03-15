package beerapp.api

import beerapp.Beer
import grails.converters.JSON
import grails.converters.XML
import beerapp.BeerCompany

class BeerApiController {

    def fetch = {
        if(params.id) {
            def beer = Beer.get(params.getLong('id'))

            render(beer as JSON)
//            render(beer as XML)
        }
        else {
            def beers = Beer.list()

            render(beers*.toMap() as JSON)
        }
    }

    def fetchByCompany = {
        def company = BeerCompany.get(params.getLong('id'))
        render(Beer.findAllByCompany(company) as JSON)
    }
}
