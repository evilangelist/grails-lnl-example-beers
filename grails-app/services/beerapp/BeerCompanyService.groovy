package beerapp

class BeerCompanyService {

    static transactional = true

    def saveCompany(BeerCompany company) {
        if(company.hops) {
            if(company.hops < 100000) {
                company.rating = 1
            }
            else if(company.hops > 100000 && company.hops < 400000) {
                company.rating = 2
            }
            else if(company.hops > 400000 && company.hops < 600000) {
                company.rating = 3
            }
            else if(company.hops > 600000 && company.hops < 900000) {
                company.rating = 4
            }
            else if(company.hops > 900000) {
                company.rating = 5
            }
        }
        return company.save()
    }
}
