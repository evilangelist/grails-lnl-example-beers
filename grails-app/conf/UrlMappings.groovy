class UrlMappings {

	static mappings = {

        name beerApi: "/api/beers/$id?" (controller: "beerApi") {
            action = [GET: "fetch"]
        }
        name beerCompanyApi: "/api/beer-companies/$id/beers" (controller: "beerApi") {
            action = [GET: "fetchByCompany"]
        }


		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
