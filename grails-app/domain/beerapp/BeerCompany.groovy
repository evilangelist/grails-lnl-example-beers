package beerapp

class BeerCompany {

    String name
    Long hops
    Integer rating

    static hasMany = [
        beers : Beer
    ]

    static constraints = {
        name(size:1..30, blank:false, unique:true)
        rating(range: 1..5, nullable: true)
        hops(nullable: true)
    }
}
