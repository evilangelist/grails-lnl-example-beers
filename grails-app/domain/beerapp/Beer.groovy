package beerapp

class Beer {

    String name
    Float alcoholVolume
    String description

    static belongsTo = [
        company: BeerCompany
    ]

    static mapping = {
        sort "name"
        description column: 'desc'
    }

    static constraints = {
        name(size:1..30, blank:false, unique:true)
        description(nullable: true)
    }

    Map toMap() {
        return [
                id: id,
                name: name,
                alcoholVolume: alcoholVolume,
                description: description,
                company: company.name
        ]
    }
}
