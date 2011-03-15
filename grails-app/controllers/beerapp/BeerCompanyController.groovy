package beerapp

class BeerCompanyController {
    static scaffold = BeerCompany

    def beerCompanyService

    def index = {
        def beerCompanies = BeerCompany.list()
        render(view: 'list', model: [beerCompanyInstanceList: beerCompanies, beerCompanyInstanceTotal: beerCompanies.size()])
    }

    def save = {
        BeerCompany company = new BeerCompany(params)
        if(!beerCompanyService.saveCompany(company)) {
            render(view: 'create', model: [beerCompanyInstance: company])
            return
        }
        index()
    }
}
